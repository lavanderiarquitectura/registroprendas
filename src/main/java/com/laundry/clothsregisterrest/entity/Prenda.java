package com.laundry.clothsregisterrest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prenda")
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_prenda;

    private  String  color;

    private Integer id_cuarto;

    private String marca;

    @Temporal(TemporalType.DATE)
    private Date fecha_ingreso;

    @Temporal(TemporalType.DATE)
    private Date fecha_entrega;

    private Integer tipo_tela_id_tipo_tela;

    private Integer tipo_operacion_id_tipo_operacion;


    public Prenda(Integer id_prenda, String color, Integer id_cuarto, String marca, Date fecha_ingreso, Date fecha_entrega, Integer tipo_tela_id_tipo_tela, Integer tipo_operacion_id_tipo_operacion) {
        super();
        this.id_prenda = id_prenda;
        this.color = color;
        this.id_cuarto = id_cuarto;
        this.marca = marca;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_entrega = fecha_entrega;
        this.tipo_tela_id_tipo_tela = tipo_tela_id_tipo_tela;
        this.tipo_operacion_id_tipo_operacion = tipo_operacion_id_tipo_operacion;
    }

    public Prenda(){
    }

    public void setId_prenda(Integer id_prenda) {
        this.id_prenda = id_prenda;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setId_cuarto(Integer id_cuarto) {
        this.id_cuarto = id_cuarto;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public void setTipo_tela_id_tipo_tela(Integer tipo_tela_id_tipo_tela) {
        this.tipo_tela_id_tipo_tela = tipo_tela_id_tipo_tela;
    }

    public void setTipo_operacion_id_tipo_operacion(Integer tipo_operacion_id_tipo_operacion) {
        this.tipo_operacion_id_tipo_operacion = tipo_operacion_id_tipo_operacion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }



    public Integer getId_prenda() {
        return id_prenda;
    }

    public String getColor() {
        return color;
    }

    public Integer getId_cuarto() {
        return id_cuarto;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public Integer getTipo_tela_id_tipo_tela() {
        return tipo_tela_id_tipo_tela;
    }

    public Integer getTipo_operacion_id_tipo_operacion() {
        return tipo_operacion_id_tipo_operacion;
    }

    public String getMarca() {
        return marca;
    }

}
