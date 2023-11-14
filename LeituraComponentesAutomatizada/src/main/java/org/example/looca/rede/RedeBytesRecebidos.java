package org.example.looca.rede;

import com.github.britooo.looca.api.group.rede.RedeInterface;
import org.example.interfaces.Executavel;

public class RedeBytesRecebidos extends Rede implements Executavel {
    @Override
    public void executar() {
        Long receivedBytes = (long) 0;

        for(RedeInterface i : lucas.getGrupoDeInterfaces().getInterfaces()) {
            if (!i.getEnderecoIpv4().isEmpty()) {
                receivedBytes = i.getBytesRecebidos();
                break;
            }
        }

        System.out.println(receivedBytes);
    }
}
