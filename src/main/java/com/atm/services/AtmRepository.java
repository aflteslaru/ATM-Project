package com.atm.services;

import com.atm.entities.Atm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service
public interface AtmRepository extends CrudRepository<Atm, Integer> {

    public Iterable<Atm> findAllByOrderByIdDesc();
}