package org.example.business;

public class ComponenteMedida {
    private Integer idComponenteMedida;
    private String nomeComponenteMedida;
    private String tipo;
    private Integer fkComponente;
    private Integer fkMedida;

    public Integer getIdComponenteMedida() {
        return idComponenteMedida;
    }

    public void setIdComponenteMedida(Integer idComponenteMedida) {
        this.idComponenteMedida = idComponenteMedida;
    }

    public String getNomeComponenteMedida() {
        return nomeComponenteMedida;
    }

    public void setNomeComponenteMedida(String nomeComponenteMedida) {
        this.nomeComponenteMedida = nomeComponenteMedida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getFkComponente() {
        return fkComponente;
    }

    public void setFkComponente(Integer fkComponente) {
        this.fkComponente = fkComponente;
    }

    public Integer getFkMedida() {
        return fkMedida;
    }

    public void setFkMedida(Integer fkMedida) {
        this.fkMedida = fkMedida;
    }
}
