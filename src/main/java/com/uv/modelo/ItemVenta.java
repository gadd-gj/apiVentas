package com.uv.modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;

@Entity
@Table(name = "itemVenta")
public class ItemVenta {

    @Id
    @Column(name = "idItemVenta")
    @GeneratedValue
    private Long idItem;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precioUnitario", nullable = false)
    private double precioUnitario;

    @Column(name = "total", nullable = false)
    private double total;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "idVenta")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idVenta")
    @JsonIdentityReference(alwaysAsId = true)
    private Venta venta;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "idProducto")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProducto")
    @JsonIdentityReference(alwaysAsId = true)
    private Producto producto;

    public ItemVenta() {
        //Esta vacio solo para poder crear el objeto
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
    
}
