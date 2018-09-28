package com.cletus.facturacion.model.dao;

import com.cletus.facturacion.model.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura,Long> {
}
