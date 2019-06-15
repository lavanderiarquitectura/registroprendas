package com.laundry.clothsregisterrest.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Cuarto {


    @Id
    private ObjectId _id;

    private Integer id_cuarto;

    private String descripcion;

    private String serie;

    public Cuarto(){

    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Integer getId_cuarto() {
        return id_cuarto;
    }

    public void setId_cuarto(Integer id_cuarto) {
        this.id_cuarto = id_cuarto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
}
