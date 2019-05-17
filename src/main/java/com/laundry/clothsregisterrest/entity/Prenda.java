package com.laundry.clothsregisterrest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Prenda")
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_prenda;

    private  String  color;

    private String cuarto;


    @Temporal(TemporalType.DATE)
    private Date fecha_ingreso;

    @Temporal(TemporalType.DATE)
    private Date fecha_entrega;

    private Integer id_tipo_tela;

    private Integer id_tipo_lavado;


    public Prenda(Integer id_prenda, String color, String cuarto, Date fecha_ingreso, Date fecha_entrega, Integer id_tipo_tela, Integer id_tipo_lavado) {
        this.id_prenda = id_prenda;
        this.color = color;
        this.cuarto = cuarto;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_entrega = fecha_entrega;
        this.id_tipo_tela = id_tipo_tela;
        this.id_tipo_lavado = id_tipo_lavado;
    }
    public Prenda(){

    }

    public void setId_prenda(Integer id_prenda) {
        this.id_prenda = id_prenda;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCuarto(String cuarto) {
        this.cuarto = cuarto;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public void setId_tipo_tela(Integer id_tipo_tela) {
        this.id_tipo_tela = id_tipo_tela;
    }

    public void setId_tipo_lavado(Integer id_tipo_lavado) {
        this.id_tipo_lavado = id_tipo_lavado;
    }



    public Integer getId_prenda() {
        return id_prenda;
    }

    public String getColor() {
        return color;
    }

    public String getCuarto() {
        return cuarto;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public Integer getId_tipo_tela() {
        return id_tipo_tela;
    }

    public Integer getId_tipo_lavado() {
        return id_tipo_lavado;
    }
}
