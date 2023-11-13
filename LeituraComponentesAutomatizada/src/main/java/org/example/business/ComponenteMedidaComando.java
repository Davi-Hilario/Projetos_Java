package org.example.business;

public class ComponenteMedidaComando {
    private String componente;
    private String medida;
    private String comando;

    public ComponenteMedidaComando(String componente, String medida, String comando) {
        this.componente = componente;
        this.medida = medida;
        this.comando = comando;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    @Override
    public String toString() {
        return "[%s,%s,%s]".formatted(getComponente(), getMedida(), getComando());
    }
}
