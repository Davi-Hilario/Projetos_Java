package org.example.enumerators;

import org.example.interfaces.Executavel;
import org.example.looca.cpu.CpuFrequencia;
import org.example.looca.cpu.CpuUso;
import org.example.looca.disco.DiscoUso;
import org.example.looca.memoria.MemoriaUso;
import org.example.looca.rede.RedeBytesEnviados;
import org.example.looca.rede.RedeBytesRecebidos;

public enum ComponentesMonitorados {

    usoCpuPorcentagem(1,"Uso da CPU (%)", new CpuUso()),
    frequenciaCpu(2,"Frequência da CPU (Htz)", new CpuFrequencia()),
    usoMemoriaPorcentagem(3,"Uso da Memória (%)", new MemoriaUso()),
    usoDiscoPorcentagem(4, "Uso do Disco (%)", new DiscoUso()),
    bytesEnviadosRede(5, "Bytes Enviados", new RedeBytesEnviados()),
    bytesRecebidosRede(6, "Bytes Recebidos", new RedeBytesRecebidos());

    private final Integer id;
    private final String nome;
    private final Executavel metodo;

    ComponentesMonitorados(Integer id, String nome, Executavel metodo) {
        this.id = id;
        this.nome = nome;
        this.metodo = metodo;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Executavel getMetodo() {
        return metodo;
    }
}
