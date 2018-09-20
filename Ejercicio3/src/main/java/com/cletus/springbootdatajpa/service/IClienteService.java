package com.cletus.springbootdatajpa.service;

import com.cletus.springbootdatajpa.model.entity.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> findAll();

    void save(Cliente cliente);

    Cliente findOne(Long id);

    void delete(Long id);
}
