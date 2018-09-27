package com.cletus.facturacion.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="facturas")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String observacion;

    @Temporal(TemporalType.DATE)
    @Column(name="create_at")
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @OneToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="factura_id")
    private List<ItemFactura> itemFactura;

    public Factura() { this.itemFactura = new ArrayList<>(); }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }

    public Date getCreateAt() { return createAt; }
    public void setCreateAt(Date createAt) { this.createAt = createAt; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<ItemFactura> getItemFactura() { return itemFactura; }
    public void setItemFactura(List<ItemFactura> itemFactura) { this.itemFactura = itemFactura; }

    public void addItemFactura(ItemFactura itemFactura){ this.itemFactura.add(itemFactura); }

    public Double getTotal(){
        Double total = 0.0;
        for (ItemFactura item : itemFactura) {
            total += item.calcularImporte();
        }
        return total;
    }



    @PrePersist
    public void prePersist(){ createAt = new Date(); }
}
