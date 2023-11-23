package org.example.terminal;

import org.example.dao.ComponenteMedidaDAO;
import org.example.dao.ComponenteServidorDAO;
import org.example.dao.ServidorDAO;
import com.github.britooo.looca.api.core.Looca;
import org.example.enumerators.ComponentesMonitorados;
import org.example.looca.rede.Rede;

import java.util.ArrayList;
import java.util.List;

public class NewDevice extends Terminal{
    public void cadastrarServidor(Integer fkEmpresa) {

        System.out.println("Esse servidor ainda não está cadastrado!");
        String resposta;

        do {
            System.out.print("Prosseguir com instalação? [S/N] -> ");
            resposta = inputString.nextLine();

            if (resposta.equalsIgnoreCase("N")) {
                break;
            } else if (resposta.equalsIgnoreCase("S")) {
                coletarDados(fkEmpresa);
            }

        } while (!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N"));

        System.out.println("Finalizando!");
    }

    public void coletarDados (Integer fkEmpresa) {

        String resposta;
        String nomeServer;
        String localServer;
        String descricaoServer;

        do {
            System.out.print("Nome do Servidor -> ");
            nomeServer = inputString.nextLine();

            System.out.print("Local do Servidor -> ");
            localServer = inputString.nextLine();

            System.out.print("Descrição do Servidor -> ");
            descricaoServer = inputString.nextLine();

            System.out.print("Confirmar Dados? [S/N] -> ");
            resposta = inputString.nextLine();

        } while (!resposta.equalsIgnoreCase("S"));

        ServidorDAO.inserirServidor
                (
                        fkEmpresa,
                        nomeServer,
                        localServer,
                        Rede.getIpv6(),
                        Rede.getMacAddress(),
                        new Looca().getSistema().getSistemaOperacional(),
                        descricaoServer
                );

        inserirComponentes(ServidorDAO.consultarServidor(Rede.getMacAddress(),fkEmpresa).get(0).getIdServidor());

    }

    public void inserirComponentes(Integer idServer) {

        List<ComponentesMonitorados> componentesMonitorados = new ArrayList<>(List.of(ComponentesMonitorados.values()));
        List<ComponentesMonitorados> componentesSelecionados = new ArrayList<>();

        System.out.println("\nSelecione os componentes que seja monitorar:");

        int i;
        int resposta;

        do {
            for (i = 0; i < componentesMonitorados.size(); i++) {
                System.out.printf("%d - %s%n", i + 1, componentesMonitorados.get(i).getNome());
            }

            i++;
            System.out.printf("%d - Finalizar%n", i);

            resposta = inputNumber.nextInt();

            if (resposta == i) {
                break;
            }

            componentesSelecionados.add(componentesMonitorados.get(resposta - 1));
            componentesMonitorados.remove(componentesMonitorados.get(resposta - 1));

        } while (true);

        componentesSelecionados.forEach(item -> {
            ComponenteServidorDAO.inserirComponenteServidor(idServer, ComponenteMedidaDAO.coletarId(item.name()).get(0).getIdComponenteMedida());
        });

    }
}
