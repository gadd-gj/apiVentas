package com.uv.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @Column(name = "idVenta")
    @GeneratedValue
    private Long idVenta;

    @Column(name = "total", nullable = true)
    private double total;

    @Column(name = "fecha", nullable = true)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String fecha;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "idVendedor")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idVendedor")
    @JsonIdentityReference(alwaysAsId = true)
    private Vendedor vendedor;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "idCorteCaja")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCorteCaja")
    @JsonIdentityReference(alwaysAsId = true)
    private CorteCaja corteCaja;

    public Venta() {
        //Esta vacio solo para poder crear el objeto
    }

    public Venta(Long idVenta) {
        this.idVenta = idVenta;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", total=" + total + ", fecha=" + fecha + ", vendedor=" + vendedor + ", corteCaja=" + corteCaja + '}';
    }

}
