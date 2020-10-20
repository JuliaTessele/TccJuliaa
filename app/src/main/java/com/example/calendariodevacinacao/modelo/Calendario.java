package com.example.calendariodevacinacao.modelo;

import java.io.Serializable;
import java.util.Date;

public class Calendario implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id_calendario;
    private Date data_vacina;

    @Override
    public String toString() {
        return "Calendario{" +
                "id_calendario=" + id_calendario +
                ", data_vacina=" + data_vacina +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId_calendario() {
        return id_calendario;
    }

    public void setId_calendario(Long id_calendario) {
        this.id_calendario = id_calendario;
    }

    public Date getData_vacina() {
        return data_vacina;
    }

    public void setData_vacina(Date data_vacina) {
        this.data_vacina = data_vacina;
    }
}
