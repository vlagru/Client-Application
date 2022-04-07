package com.unicorn.hatchery.clientapp.repository;

import com.unicorn.hatchery.clientapp.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//repozitory
//vi, ze existuje db a co je to za dat, jak tam data dosta a jak je tam dostat
//umi mapovat z tabulek na java objekty, nema tuseni o klientovi, komunikuje pouze s db
/**
 * persistujeme nad tridou klient a pk bude long, proc crud a ne JPA
 * */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
