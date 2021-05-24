package com.uv.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDateTime;
import javax.persistence.*;


@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @Column(name = "idVenta")
    @GeneratedValue
    private Long idVenta;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "fecha", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fecha;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "idVendedor")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idVendedor")
    @JsonIdentityReference(alwaysAsId = true)
    private Vendedor vendedor;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "idCorteCaja")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCorteCaja")
    @JsonIdentityReference(alwaysAsId = true)
    private CorteCaja corteCaja;


    public Venta() {
        //Esta vacio solo para poder crear el objeto
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public CorteCaja getCorteCaja() {
        return corteCaja;
    }

    public void setCorteCaja(CorteCaja corteCaja) {
        this.corteCaja = corteCaja;
    }
}
