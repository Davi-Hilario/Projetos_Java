package org.example;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.Rede;

import java.util.ArrayList;
import java.util.List;

public class CapturaDados {
    public Processador getProcessador(){
        Looca lucas = new Looca();
        return lucas.getProcessador();
    }

    public DiscoGrupo getGrupoDeDiscos(){
        Looca lucas = new Looca();
        return lucas.getGrupoDeDiscos();
    }

    public String getMemoria(){
        Looca lucas = new Looca();
        return lucas.getMemoria().toString();
    }

    public Rede getRede(){
        Looca lucas = new Looca();
        return lucas.getRede();
    }
}
