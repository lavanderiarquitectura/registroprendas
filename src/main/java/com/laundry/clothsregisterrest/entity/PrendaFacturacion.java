package com.laundry.clothsregisterrest.entity;

import java.util.Date;

public class PrendaFacturacion {

    private Integer id_prenda;
    private Integer id_cuarto;
    private String serie_cuarto;
    private Date fecha_ingreso;
    private Date fecha_entrega;
    private Integer id_tipo_tela;
    private String tipo_tela;
    private Float recargo_tela;
    private Integer id_tipo_operacion;
    private String descripcion_operacion;
    private Float recargo_operacion;

    public PrendaFacturacion(Integer id_prenda, Integer id_cuarto, String serie_cuarto, Date fecha_ingreso,
                             Date fecha_entrega, Integer id_tipo_tela, String tipo_tela, Float recargo_tela,
                             Integer id_tipo_operacion, String descripcion_operacion, Float recargo_operacion) {
        this.id_prenda = id_prenda;
        this.id_cuarto = id_cuarto;
        this.serie_cuarto = serie_cuarto;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_entrega = fecha_entrega;
        this.id_tipo_tela = id_tipo_tela;
        this.tipo_tela = tipo_tela;
        this.recargo_tela = recargo_tela;
        this.id_tipo_operacion = id_tipo_operacion;
        this.descripcion_operacion = descripcion_operacion;
        this.recargo_operacion = recargo_operacion;
    }

    public PrendaFacturacion(){

    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Integer getId_prenda() {
        return id_prenda;
    }

    public void setId_prenda(Integer id_prenda) {
        this.id_prenda = id_prenda;
    }

    public Integer getId_cuarto() {
        return id_cuarto;
    }

    public void setId_cuarto(Integer id_cuarto) {
        this.id_cuarto = id_cuarto;
    }

    public String getSerie_cuarto() {
        return serie_cuarto;
    }

    public void setSerie_cuarto(String serie_cuarto) {
        this.serie_cuarto = serie_cuarto;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Integer getId_tipo_tela() {
        return id_tipo_tela;
    }

    public void setId_tipo_tela(Integer id_tipo_tela) {
        this.id_tipo_tela = id_tipo_tela;
    }

    public String getTipo_tela() {
        return tipo_tela;
    }

    public void setTipo_tela(String tipo_tela) {
        this.tipo_tela = tipo_tela;
    }

    public Float getRecargo_tela() {
        return recargo_tela;
    }

    public void setRecargo_tela(Float recargo_tela) {
        this.recargo_tela = recargo_tela;
    }

    public Integer getId_tipo_operacion() {
        return id_tipo_operacion;
    }

    public void setId_tipo_operacion(Integer id_tipo_operacion) {
        this.id_tipo_operacion = id_tipo_operacion;
    }

    public String getDescripcion_operacion() {
        return descripcion_operacion;
    }

    public void setDescripcion_operacion(String descripcion_operacion) {
        this.descripcion_operacion = descripcion_operacion;
    }

    public Float getRecargo_operacion() {
        return recargo_operacion;
    }

    public void setRecargo_operacion(Float recargo_operacion) {
        this.recargo_operacion = recargo_operacion;
    }
}
