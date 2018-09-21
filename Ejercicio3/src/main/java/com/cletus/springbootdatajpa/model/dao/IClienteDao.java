package com.cletus.springbootdatajpa.model.dao;

import com.cletus.springbootdatajpa.model.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {

}
