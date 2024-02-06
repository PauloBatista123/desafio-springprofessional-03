package com.springprofessional.desafio3.desafio3.config;

import com.springprofessional.desafio3.desafio3.domain.Client;
import com.springprofessional.desafio3.desafio3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        Client c1 = new Client(
                1L,
                "João Silva",
                "123.456.789-10",
                5000.00,
                LocalDate.of(1980, 5, 15),
                2
        );

        Client c2 = new Client(
                2L,
                "Maria Souza",
                "987.654.321-01",
                9000.00,
                LocalDate.of(1992, 9, 20),
                1
        );

        Client c3 = new Client(
                3L,
                "Lucas Oliveira",
                "456.789.123-45",
                6000.00,
                LocalDate.of(2000, 3, 8),
                0
        );

        Client c4 = new Client(
                4L,
                "Ana Li",
                "789.123.456-78",
                5500.00,
                LocalDate.of(1988, 12, 10),
                0
        );

        Client c5 = new Client(
                5L,
                "Pedro Santos",
                "111.222.333-44",
                4500.00,
                LocalDate.of(1995, 6, 25),
                2
        );

        Client c6 = new Client(
                6L,
                "Carla Lima",
                "555.444.333-22",
                3000.00,
                LocalDate.of(1983, 10, 5),
                4
        );


        Client c7 = new Client(
                7L,
                "José Costa",
                "666.777.888-99",
                6200.00,
                LocalDate.of(1970, 8, 12),
                5
        );

        Client c8 = new Client(
                9L,
                "Ana Silva",
                "222.333.444-55",
                5300.00,
                LocalDate.of(1987, 7, 3),
                3
        );

        Client c9 = new Client(
                10L,
                "Gabriel Almeida",
                "111.222.333-44",
                7000.00,
                LocalDate.of(1985, 4, 17),
                2
        );

        Client c10 = new Client(
                11L,
                "Paulo Batista",
                "654.987.233-44",
                5000.00,
                LocalDate.of(1996, 4, 17),
                1
        );

        this.clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));

    }
}
