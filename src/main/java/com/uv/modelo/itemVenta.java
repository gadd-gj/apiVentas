package com.uv.modelo;

import javax.persistence.*;

@Entity(name = "itemVenta")
public class itemVenta {

    @Id
    @Column(name = "idItem")
    @GeneratedValue
    private Long idItem;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precioUnitario", nullable = false)
    private double precioUnitario;

    @Column(name = "total",nullable = false)
    private double total;

    @ManyToOne()
    private Producto producto;

}
