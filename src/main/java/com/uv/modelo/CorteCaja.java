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

    public CorteCaja (){
    }

    public Long getIdCorteCaja() {
        return idCorteCaja;
    }

    public void setIdCorteCaja(Long idCorteCaja) {
        this.idCorteCaja = idCorteCaja;
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
}
