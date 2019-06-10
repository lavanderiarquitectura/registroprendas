package com.laundry.clothsregisterrest.entity;

import org.springframework.data.annotation.Id;
import java.util.List;

public class TipoTela {

    @Id
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
