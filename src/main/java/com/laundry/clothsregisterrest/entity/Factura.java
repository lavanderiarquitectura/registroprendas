package com.laundry.clothsregisterrest.entity;

import java.util.List;

public class Factura {

    private List<PrendaFacturacion> factura;
    private Integer id_cuarto;

    public Factura() {
    }

    public List<PrendaFacturacion> getFactura() {
        return factura;
    }

    public void setFactura(List<PrendaFacturacion> factura) {
        this.factura = factura;
    }

    public Integer getId_cuarto() {
        return id_cuarto;
    }

    public void setId_cuarto(Integer id_cuarto) {
        this.id_cuarto = id_cuarto;
    }
}
