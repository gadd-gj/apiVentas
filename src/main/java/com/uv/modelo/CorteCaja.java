package com.uv.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "corteCaja")
public class CorteCaja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCorteCaja")
    private Long idCorteCaja;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "fecha", nullable = true)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String fecha;

    public CorteCaja() {
        //Esta vacio solo para poder crear el objeto
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
