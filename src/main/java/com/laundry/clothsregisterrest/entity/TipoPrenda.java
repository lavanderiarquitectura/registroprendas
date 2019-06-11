package com.laundry.clothsregisterrest.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class TipoPrenda {

    @Id
    private ObjectId _id;

    private Integer id_tipo_prenda;

    private  String  descripcion;

    public TipoPrenda(){
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Integer getId_tipo_prenda() {
        return id_tipo_prenda;
    }

    public void setId_tipo_prenda(Integer id_tipo_prenda) {
        this.id_tipo_prenda = id_tipo_prenda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
