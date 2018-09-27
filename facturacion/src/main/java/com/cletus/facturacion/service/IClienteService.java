package com.cletus.facturacion.service;

import com.cletus.facturacion.model.entity.Cliente;
import com.cletus.facturacion.model.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClienteService {

    List<Cliente> findAll();

    Page<Cliente> findAll(Pageable pageable);

    void save(Cliente cliente);

    Cliente findOne(Long id);

    void delete(Long id);

    List<Producto> findByNombre(String term);
}
