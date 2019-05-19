package com.laundry.clothsregisterrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "tipo_operacion")
public class TipoOperacion {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_tipo_lavado;

    private String descripcion;
    private Float tarifa;

    public TipoOperacion(Integer id_tipo_lavado, String descripcion, Float tarifa) {
        this.id_tipo_lavado = id_tipo_lavado;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
    }

    public Integer getId_tipo_lavado() {
        return id_tipo_lavado;
    }

    public void setId_tipo_lavado(Integer id_tipo_lavado) {
        this.id_tipo_lavado = id_tipo_lavado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getTarifa() {
        return tarifa;
    }

    public void setTarifa(Float tarifa) {
        this.tarifa = tarifa;
    }
}
