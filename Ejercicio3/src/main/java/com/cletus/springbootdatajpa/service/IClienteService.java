package com.cletus.springbootdatajpa.service;
import org.springframework.data.domain.Pageable;
import com.cletus.springbootdatajpa.model.entity.Cliente;
import org.springframework.data.domain.Page;
import java.util.List;

public interface IClienteService {

    List<Cliente> findAll();

    Page<Cliente> findAll(Pageable pageable);

    void save(Cliente cliente);

    Cliente findOne(Long id);

    void delete(Long id);
}
