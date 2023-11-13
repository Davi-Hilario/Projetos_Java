package org.example.looca;

import com.github.britooo.looca.api.core.Looca;


public class MemoriaLooca {

    private static final com.github.britooo.looca.api.group.memoria.Memoria lucas = new Looca().getMemoria();

    public static Double getMemoryUsage() {
        return (double) ((lucas.getEmUso() / lucas.getTotal()) * 100);
    }

}
