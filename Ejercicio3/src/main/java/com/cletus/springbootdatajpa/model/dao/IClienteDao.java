package com.cletus.springbootdatajpa.model.dao;

import com.cletus.springbootdatajpa.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
