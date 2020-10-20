package com.example.calendariodevacinacao.modelo;

import java.io.Serializable;

public class Crianca implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id_crianca;
    private String nome;
    private String data_nasc;
    private String periodo;
    private byte [] foto;

    public Crianca() {
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getId_crianca() {
        return id_crianca;
    }

    public void setId_crianca(String id_crianca) {
        this.id_crianca = id_crianca;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
