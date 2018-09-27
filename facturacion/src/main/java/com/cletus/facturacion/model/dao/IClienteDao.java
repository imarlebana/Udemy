package com.cletus.facturacion.model.dao;

import com.cletus.facturacion.model.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {

}
