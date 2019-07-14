package com.laundry.clothsregisterrest.entity;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;

public class Peticion {

    @Id
    private ObjectId _id;
    private Integer id_room;

    public Peticion() {
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Integer getId_room() {
        return id_room;
    }

    public void setId_room(Integer id_room) {
        this.id_room = id_room;
    }
}
