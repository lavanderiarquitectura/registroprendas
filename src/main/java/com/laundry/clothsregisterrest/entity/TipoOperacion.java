package com.laundry.clothsregisterrest.entity;

import org.springframework.data.annotation.Id;


public class TipoOperacion {


    @Id
    private Integer id_tipo_operacion;
    private String descripcion;

    public TipoOperacion(Integer id_tipo_operacion, String descripcion) {
        this.id_tipo_operacion = id_tipo_operacion;
        this.descripcion = descripcion;
    }

    public TipoOperacion() {
    }


    public Integer getId_tipo_operacion() {
        return id_tipo_operacion;
    }

    public void setId_tipo_operacion(Integer id_tipo_operacion) {
        this.id_tipo_operacion = id_tipo_operacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
