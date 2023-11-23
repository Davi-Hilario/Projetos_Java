package org.example;

import org.example.business.ViewComponenteServidor;

import org.example.dao.ServidorDAO;
import org.example.dao.ViewComponenteServidorDAO;
import org.example.enumerators.ComponentesMonitorados;
import org.example.interfaces.Executavel;
import org.example.looca.rede.Rede;
import org.example.terminal.Login;
import org.example.terminal.NewDevice;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Login promptLogin = new Login();
        NewDevice promptNewDevice = new NewDevice();

        Integer fkEmpresa = promptLogin.loginForm().get(0).getIdEmpresa();
        String macAddress = Rede.getMacAddress();

        if (ServidorDAO.consultarServidor(macAddress, fkEmpresa).isEmpty()) {
            promptNewDevice.cadastrarServidor(fkEmpresa);
        }

        System.out.println("Iniciando leitura dos dados!");

        List<ComponentesMonitorados> componentesMonitorados = new ArrayList<>(List.of(ComponentesMonitorados.values()));
        List<ViewComponenteServidor> listaComponentesServidor = ViewComponenteServidorDAO.consultarComponenteServidor(macAddress);
        List<Executavel> executaveis = new ArrayList<>();

        for (ComponentesMonitorados comp : componentesMonitorados) {
            for (ViewComponenteServidor compServidor : listaComponentesServidor) {
                if (comp.getId().equals(compServidor.getIdComponenteMedida())) {
                    executaveis.add(comp.getMetodo());
                    break;
                }
            }
        }

        executaveis.forEach(Executavel::executar);

    }
}