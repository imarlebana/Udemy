package com.cletus.springbootdatajpa.service;

import com.cletus.springbootdatajpa.model.dao.IClienteDao;
import com.cletus.springbootdatajpa.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements  IClienteService {


    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional
    public List<Cliente> findAll() {
        return (List<Cliente>)clienteDao.findAll();
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
}
