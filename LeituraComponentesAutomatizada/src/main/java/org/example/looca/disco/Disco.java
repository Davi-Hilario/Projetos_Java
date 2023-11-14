package org.example.looca.disco;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;

public abstract class Disco {

    protected final DiscoGrupo lucas = new Looca().getGrupoDeDiscos();

}
