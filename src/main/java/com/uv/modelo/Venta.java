package com.uv.modelo;

import javax.persistence.*;
import java.util.Date;

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
    private Date fecha;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "idVendedor")
    private Vendedor vendedor;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "idCorteCaja")
    private CorteCaja corteCaja;


    public Venta() {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
