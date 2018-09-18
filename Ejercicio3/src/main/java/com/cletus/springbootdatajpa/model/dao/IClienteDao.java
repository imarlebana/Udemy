package com.cletus.springbootdatajpa.model.dao;

import com.cletus.springbootdatajpa.model.entity.Cliente;

import java.util.List;

public interface IClienteDao {

    List<Cliente> findAll();

    void save(Cliente cliente);

}
