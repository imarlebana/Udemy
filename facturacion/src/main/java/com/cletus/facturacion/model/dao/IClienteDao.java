package com.cletus.facturacion.model.dao;

import com.cletus.facturacion.model.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {

    @Query(value="Select c from Cliente c left join fetch c.facturas f where c.id=?1")
    Cliente fetchByIdWithFactura(Long id);

}
