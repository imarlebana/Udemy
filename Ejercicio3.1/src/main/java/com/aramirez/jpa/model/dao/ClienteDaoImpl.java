package com.aramirez.jpa.model.dao;

import com.aramirez.jpa.model.entity.Cliente;
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
        return entityManager.createQuery(" FROM Cliente").getResultList();
    }

    @Override
    @Transactional()
    public void save(Cliente cliente) {
        entityManager.persist(cliente);
    }
}
