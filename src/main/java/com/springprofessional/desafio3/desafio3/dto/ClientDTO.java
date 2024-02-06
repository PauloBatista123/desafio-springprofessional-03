package com.springprofessional.desafio3.desafio3.dto;

import com.springprofessional.desafio3.desafio3.domain.Client;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;

    @NotBlank(message = "Campo name obrigatório")
    private String name;

    @NotBlank(message = "Campo cpf obrigatório")
    private String cpf;

    @NotNull(message = "Campo salário obrigatório")
    @DecimalMin("1.0")
    private Double income;

    @NotNull(message = "Campo birthDate obrigatório")
    @PastOrPresent(message = "Informe uma data válida")
    private LocalDate birthDate;

    private Integer children;

    public ClientDTO(){

    }

    public ClientDTO(Client client){
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();
        this.id = client.getId();
    }

    public Client toModel(){
        Client client = new Client();
        client.setName(this.getName());
        client.setCpf(this.getCpf());
        client.setChildren(this.getChildren());
        client.setIncome(this.getIncome());
        client.setBirthDate(this.getBirthDate());

        return client;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
