package com.microservices.app.commons.service;

import java.util.Optional;


// --------------------------------------------------------
// <E> --> Generic Value
// --------------------------------------------------------
public interface CommonService<E>{

    public Iterable<E> findAll();

    public Optional<E> findById(Long id);

    public E save(E entity);

    public void deleteByID(Long id);
    
}