package org.example.business;

public class ViewComponenteServidor {
    private String empresa;
    private String servidor;
    private String sistemaOperacional;
    private String macAddress;
    private String local;
    private String componente;
    private String medida;
    private String comandoJava;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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

    public String getComandoJava() {
        return comandoJava;
    }

    public void setComandoJava(String comandoJava) {
        this.comandoJava = comandoJava;
    }

    @Override
    public String toString() {
        return """
                {
                    Empresa: '%s'
                    Servidor: '%s'
                    Sistema Operacional: '%s'
                    Mac Address: '%s'
                    Local: '%s'
                    Componente: '%s'
                    Medida: '%s'
                    Comando Java: '%s'
                }
                """
                .formatted
                (
                    getEmpresa(),
                    getServidor(),
                    getSistemaOperacional(),
                    getMacAddress(),
                    getLocal(),
                    getComponente(),
                    getMedida(),
                    getComandoJava()
                );
    }
}
