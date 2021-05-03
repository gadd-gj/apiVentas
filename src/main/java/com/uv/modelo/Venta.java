package com.uv.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ventas")
public class Venta {

    @Id
    @Column(name = "idVenta")
    @GeneratedValue
    private Long idVenta;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "idVendedor")
    private Vendedor vendedor;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "idCorteCaja")
    private CorteCaja corteCaja;



}
