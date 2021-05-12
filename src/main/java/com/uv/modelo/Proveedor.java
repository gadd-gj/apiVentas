package com.uv.modelo;

import javax.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;


@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @Column(name = "idProveedor")
    @GeneratedValue
    private Long idProveedor;

    @Column(name = "empresa", nullable = false)
    private String empresa;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "activo", nullable = false, columnDefinition="Integer default '1'")
    private int activo;

    public Proveedor(){
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    
}
