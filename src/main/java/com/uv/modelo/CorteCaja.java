package com.uv.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "corteCaja")
public class CorteCaja {

    @Id
    @Column(name = "idCorteCaja")
    private Long idCorteCaja;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "idVendedor")
    private Vendedor vendedor;


}
