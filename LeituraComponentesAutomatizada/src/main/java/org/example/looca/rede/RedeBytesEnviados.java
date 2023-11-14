package org.example.looca.rede;

import com.github.britooo.looca.api.group.rede.RedeInterface;
import org.example.interfaces.Executavel;

public class RedeBytesEnviados extends Rede implements Executavel {
    @Override
    public void executar() {
        Long sentBytes = (long) 0;

        for(RedeInterface i : lucas.getGrupoDeInterfaces().getInterfaces()) {
            if (!i.getEnderecoIpv4().isEmpty()) {
                sentBytes = i.getBytesEnviados();
                break;
            }
        }

        System.out.println(sentBytes);
    }
}
