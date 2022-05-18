package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AfspraakRepository extends CrudRepository<Afspraak, Integer> {
    Optional<Afspraak> findById(Integer id);

}
