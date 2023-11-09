package org.example;

public class Componente {
    private String nome_componente;

    public String getNome_componente() {
        return nome_componente;
    }

    public void setNome_componente(String nome_componente) {
        this.nome_componente = nome_componente;
    }

    @Override
    public String toString() {
        return "Componente{" +
                "nome_componente='" + nome_componente + '\'' +
                '}';
    }
}
