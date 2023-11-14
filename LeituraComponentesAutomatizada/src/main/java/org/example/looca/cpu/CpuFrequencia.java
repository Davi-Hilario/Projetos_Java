package org.example.looca.cpu;

import org.example.interfaces.Executavel;

public class CpuFrequencia extends Cpu implements Executavel {
    @Override
    public void executar() {
        System.out.println(super.lucas.getFrequencia());
    }
}
