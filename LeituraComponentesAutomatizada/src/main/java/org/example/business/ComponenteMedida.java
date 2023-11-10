package org.example.business;

public class ComponenteMedida {
    private String componente;
    private String medida;

    public ComponenteMedida(String componente, String medida) {
        this.componente = componente;
        this.medida = medida;
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

    @Override
    public String toString() {
        return "[%s,%s]".formatted(getComponente(), getMedida());
    }
}
