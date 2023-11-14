package org.example.terminal;

import org.example.dao.ServidorDAO;
import org.example.looca.RedeLooca;
import com.github.britooo.looca.api.core.Looca;

import java.util.Scanner;

public class NewDevice extends Terminal{
    public void cadastrarServidor(Integer fkEmpresa) {

        System.out.println("Esse servidor ainda não está cadastrado!");
        String resposta;

        do {
            System.out.println("Prosseguir com instalação?");
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

        ServidorDAO server = new ServidorDAO();
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

        server.inserirServidor
                (
                        fkEmpresa,
                        nomeServer,
                        localServer,
                        RedeLooca.getIpv6(),
                        RedeLooca.getMacAddress(),
                        new Looca().getSistema().getSistemaOperacional(),
                        descricaoServer
                );

        inserirComponentes();

    }

    public void inserirComponentes() {

    }
}
