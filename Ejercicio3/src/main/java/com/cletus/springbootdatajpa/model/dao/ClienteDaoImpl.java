package com.cletus.springbootdatajpa.model.dao;

import com.cletus.springbootdatajpa.model.entity.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Transactional()
    @Override
    public List<Cliente> findAll() {
        return entityManager.createQuery(" Select c FROM Cliente c").getResultList();
    }
}
