package org.example.looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;


public class CpuLooca {

    private static final Processador lucas = new Looca().getProcessador();

    public static Double getCpuUsage(){
        return lucas.getUso();
    }

    public static Long getCpuFrequency(){
        return lucas.getFrequencia();
    }


}
