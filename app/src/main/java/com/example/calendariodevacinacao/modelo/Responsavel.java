package com.example.calendariodevacinacao.modelo;

import java.io.Serializable;

public class Responsavel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id_responsavel;
    private String nome;
    private String email;
    private String senha;

    @Override
    public String toString() {
        return nome;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId_responsavel() {
        return id_responsavel;
    }

    public void setId_responsavel(Long id_responsavel) {
        this.id_responsavel = id_responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
