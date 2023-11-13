package org.example.looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;


public class DiscoLooca {

    private static final DiscoGrupo lucas = new Looca().getGrupoDeDiscos();

    public static Double getDiskUsage(){

        Long totalDisco = lucas.getTamanhoTotal();
        Long discoDisponivel = (long) 0;

        for(Volume v : lucas.getVolumes()) {
            discoDisponivel += v.getDisponivel();
        }

        return (double) Math.round((double) discoDisponivel / (double) totalDisco * 100);
    }
}
