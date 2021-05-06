package com.uv.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDateTime;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "corteCaja")
public class CorteCaja {

    @Id
    @Column(name = "idCorteCaja")
    private Long idCorteCaja;

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
}
