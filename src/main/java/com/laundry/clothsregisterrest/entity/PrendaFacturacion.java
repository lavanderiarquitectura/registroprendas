package com.laundry.clothsregisterrest.entity;

import org.bson.types.ObjectId;

import java.util.Date;

public class PrendaFacturacion {

    private String fecha_ingreso;
    private Integer id_operacion;
    private String id_prenda;

    public PrendaFacturacion() {
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Integer getId_operacion() {
        return id_operacion;
    }

    public void setId_operacion(Integer id_operacion) {
        this.id_operacion = id_operacion;
    }

    public String getId_prenda() {
        return id_prenda;
    }

    public void setId_prenda(String id_prenda) {
        this.id_prenda = id_prenda;
    }
}
