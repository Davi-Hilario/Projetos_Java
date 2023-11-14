package org.example.looca.memoria;

import org.example.interfaces.Executavel;

public class MemoriaUso extends Memoria implements Executavel {
    @Override
    public void executar() {
        Double memoriaEmUso = (double) ((super.lucas.getEmUso() / super.lucas.getTotal()) * 100);
        System.out.println(memoriaEmUso);
    }
}
