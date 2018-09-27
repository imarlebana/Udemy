package com.cletus.facturacion.service.impl;

import com.cletus.facturacion.model.dao.IClienteDao;
import com.cletus.facturacion.model.dao.IProductoDao;
import com.cletus.facturacion.model.entity.Cliente;
import com.cletus.facturacion.model.entity.Producto;
import com.cletus.facturacion.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {


    @Autowired private IClienteDao clienteDao;
    @Autowired private IProductoDao productoDao;

    @Override
    @Transactional
    public List<Cliente> findAll() {
        return (List<Cliente>)clienteDao.findAll();
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public Cliente findOne(Long id) {
        Optional<Cliente> opt = clienteDao.findById(id);
        Cliente cliente = new Cliente();
        if (opt.isPresent()){
            cliente = opt.get();
        }

        return cliente;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    public List<Producto> findByNombre(String term) {
        return productoDao.findByNombre(term);
    }
}
