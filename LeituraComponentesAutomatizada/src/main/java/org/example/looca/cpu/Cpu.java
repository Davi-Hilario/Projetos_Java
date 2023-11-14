package org.example.looca.cpu;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;

public abstract class Cpu {
    protected final Processador lucas = new Looca().getProcessador();
}
