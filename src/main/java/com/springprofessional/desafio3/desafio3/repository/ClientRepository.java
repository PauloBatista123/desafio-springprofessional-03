package com.springprofessional.desafio3.desafio3.repository;

import com.springprofessional.desafio3.desafio3.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
