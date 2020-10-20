package com.example.calendariodevacinacao.modelo;

import java.io.Serializable;
import java.sql.Date;

public class Vacina implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id_vacina;
    private String descricao;
    private boolean selo;
    private Date tempo;

    @Override
    public String toString() {
        return descricao;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId_vacina() {
        return id_vacina;
    }

    public void setId_vacina(String id_vacina) {
        this.id_vacina = id_vacina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isSelo() {
        return selo;
    }

    public void setSelo(boolean selo) {
        this.selo = selo;
    }

    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }
}
