package org.example.looca.disco;

import com.github.britooo.looca.api.group.discos.Volume;

public class DiscoUso extends Disco  {
    @Override
    public Double executar() {
        Long totalDisco = super.lucas.getTamanhoTotal();
        Long discoDisponivel = 0L;

        for(Volume v : super.lucas.getVolumes()) {
            discoDisponivel += v.getDisponivel();
        }

        return discoDisponivel.doubleValue();
    }
}
