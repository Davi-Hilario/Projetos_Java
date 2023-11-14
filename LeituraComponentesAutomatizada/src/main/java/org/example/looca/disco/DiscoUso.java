package org.example.looca.disco;

import com.github.britooo.looca.api.group.discos.Volume;
import org.example.interfaces.Executavel;

public class DiscoUso extends Disco implements Executavel {
    @Override
    public void executar() {
        Long totalDisco = super.lucas.getTamanhoTotal();
        Long discoDisponivel = (long) 0;

        for(Volume v : super.lucas.getVolumes()) {
            discoDisponivel += v.getDisponivel();
        }

        System.out.println(discoDisponivel);
    }
}
