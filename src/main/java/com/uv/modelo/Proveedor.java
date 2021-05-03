package com.uv.modelo;

import javax.persistence.*;
import java.util.List;

@Entity (name = "proveedores")
public class Proveedor {

    @Id
    @Column(name = "idProveedor")
    @GeneratedValue
    private Long id;

    @Column(name = "empresa", nullable = false)
    private String empresa;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "proveedores")
    private List<Producto> productos;

    public Proveedor(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
