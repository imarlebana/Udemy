package com.cletus.facturacion.model.dao;

import com.cletus.facturacion.model.entity.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura,Long> {

    @Query(value = "Select f from Factura f join fetch f.cliente c join fetch f.itemFactura l join fetch l.producto where f.id= ?1 ")
    Factura fetchByIdWithClienteWithItemFacturaWithProducto(Long id);
}
