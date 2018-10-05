package com.cletus.facturacion.service.impl;

import com.cletus.facturacion.model.dao.IClienteDao;
import com.cletus.facturacion.model.dao.IFacturaDao;
import com.cletus.facturacion.model.dao.IProductoDao;
import com.cletus.facturacion.model.entity.Cliente;
import com.cletus.facturacion.model.entity.Factura;
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

    @Autowired
    private IClienteDao clienteDao;
    @Autowired
    private IProductoDao productoDao;
    @Autowired
    private IFacturaDao facturaDao;

    @Override
    @Transactional
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
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
        if (opt.isPresent()) {
            cliente = opt.get();
        }

        return cliente;
    }

    @Override
    public Cliente fetchByIdWithFac(Long id) {
        return clienteDao.fetchByIdWithFactura(id);
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

    @Override
    public void saveFactura(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    public Optional<Producto> findProductoById(Long id) {
        return productoDao.findById(id);
    }

    @Override
    public Optional<Factura> findFacturaById(Long id) {
        return facturaDao.findById(id);
    }

    @Override
    public void deleteFactura(Long id) {
        facturaDao.deleteById(id);
    }

    @Override
    public Factura fetchFacturaById(Long id) {
        return facturaDao.fetchByIdWithClienteWithItemFacturaWithProducto(id);
    }
}
