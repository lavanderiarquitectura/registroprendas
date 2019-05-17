package com.laundry.clothsregisterrest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tipo_lavado")
public class TipoTela {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_tipo_tela;

    private String tipo_tela;


    public TipoTela(Integer id_tipo_tela, String tipo_tela) {
        this.id_tipo_tela = id_tipo_tela;
        this.tipo_tela = tipo_tela;
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
}
