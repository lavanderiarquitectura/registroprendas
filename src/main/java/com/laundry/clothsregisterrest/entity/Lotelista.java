package com.laundry.clothsregisterrest.entity;

import com.laundry.clothsregisterrest.entity.Lote;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Lotelista implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Lote> lotes = new ArrayList<Lote>();

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }
}
