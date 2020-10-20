package com.example.calendariodevacinacao.modelo;

import java.io.Serializable;
import java.util.Date;

public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date data_registro;
    private Long id_registro;

    @Override
    public String toString() {
        return "Registro{" +
                "data_registro=" + data_registro +
                '}';
    }

    public Long getId_registro() {
        return id_registro;
    }

    public void setId_registro(Long id_registro) {
        this.id_registro = id_registro;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getData_registro() {
        return data_registro;
    }

    public void setData_registro(Date data_registro) {
        this.data_registro = data_registro;
    }
}
