package com.uv.modelo;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {


    @Id
    @Column(name = "idProducto")
    @GeneratedValue
    private Long idProducto;

    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private Long precio;

    @Column(name = "existencia", nullable = false)
    private int existencia;

    @Column(name = "activo", nullable = false)
    private int activo;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "idProveedor")
    private Proveedor proveedor;

    public Producto() {
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }


    public Long getIdProducto() {
        return idProducto;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public int getExistencia() { return existencia; }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }




}
