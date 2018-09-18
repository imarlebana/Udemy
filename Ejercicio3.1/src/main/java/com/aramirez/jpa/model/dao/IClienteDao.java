package com.aramirez.jpa.model.dao;

import com.aramirez.jpa.model.entity.Cliente;

import java.util.List;

public interface IClienteDao {

    List<Cliente> findAll();

    void save(Cliente cliente);

}
