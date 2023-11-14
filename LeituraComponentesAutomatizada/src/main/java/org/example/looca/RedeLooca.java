package org.example.looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;

import java.util.List;


public class RedeLooca {

    private static final com.github.britooo.looca.api.group.rede.Rede lucas = new Looca().getRede();

    public static String getIpv4(){

        String ipv4 = "";

        for(RedeInterface i : lucas.getGrupoDeInterfaces().getInterfaces()) {
            if (!i.getEnderecoIpv4().isEmpty()) {
                ipv4 = i.getEnderecoIpv4().get(0);
                break;
            }
        }

        return ipv4;

    }

    public static String getIpv6(){

        String ipv6 = "";

        for(RedeInterface i : lucas.getGrupoDeInterfaces().getInterfaces()) {
            if (!i.getEnderecoIpv4().isEmpty()) {
                ipv6 = i.getEnderecoIpv6().get(0);
                break;
            }
        }

        return ipv6;

    }

    public static String getMacAddress(){

        String macAddress = "";

        for(RedeInterface i : lucas.getGrupoDeInterfaces().getInterfaces()) {
            if (!i.getEnderecoIpv4().isEmpty()) {
                macAddress = i.getEnderecoMac();
                break;
            }
        }

        return macAddress;

    }

    public static Long getSentBytes(){

        Long sentBytes = (long) 0;

        for(RedeInterface i : lucas.getGrupoDeInterfaces().getInterfaces()) {
            if (!i.getEnderecoIpv4().isEmpty()) {
                sentBytes = i.getBytesEnviados();
                break;
            }
        }

        return sentBytes;

    }

    public static Long getReceivedBytes(){

        Long receivedBytes = (long) 0;

        for(RedeInterface i : lucas.getGrupoDeInterfaces().getInterfaces()) {
            if (!i.getEnderecoIpv4().isEmpty()) {
                receivedBytes = i.getBytesRecebidos();
                break;
            }
        }

        return receivedBytes;

    }
}
