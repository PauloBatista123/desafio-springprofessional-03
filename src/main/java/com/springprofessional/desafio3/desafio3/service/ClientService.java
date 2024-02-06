package com.springprofessional.desafio3.desafio3.service;

import com.springprofessional.desafio3.desafio3.domain.Client;
import com.springprofessional.desafio3.desafio3.dto.ClientDTO;
import com.springprofessional.desafio3.desafio3.repository.ClientRepository;
import com.springprofessional.desafio3.desafio3.service.exception.DatabaseException;
import com.springprofessional.desafio3.desafio3.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public ClientDTO create(ClientDTO clienteDto){
        Client newClient = this.clientRepository.save(clienteDto.toModel());

        return new ClientDTO(newClient);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = this.clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        return this.clientRepository.findAll(pageable).map(ClientDTO::new);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO){
        Client client = this.clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        client.setBirthDate(clientDTO.getBirthDate());
        client.setIncome(clientDTO.getIncome());
        client.setChildren(clientDTO.getChildren());
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());

        try {
            return new ClientDTO(this.clientRepository.save(client));
        }catch (Exception e){
            throw new DatabaseException("Erro ao alterar o produto");
        }

    }

    @Transactional
    public void delete(Long id){
        if(!clientRepository.existsById(id)){
            throw new ResourceNotFoundException("Registro não encontrado");
        }

        this.clientRepository.deleteById(id);
    }
}
