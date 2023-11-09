package org.example;

public class Servidor {
    private String componentes;


    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public String getComponentes() {
        return componentes;
    }

    @Override
    public String toString() {
        return "Servidor{" +
                "componentes='" + componentes + '\'' +
                '}';
    }
}
