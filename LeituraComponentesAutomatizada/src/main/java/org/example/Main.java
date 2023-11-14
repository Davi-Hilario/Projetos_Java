package org.example;

import org.example.business.ComponenteMedidaComando;
import org.example.business.ViewComponenteServidor;

import org.example.dao.ServidorDAO;
import org.example.dao.ViewComponenteServidorDAO;
import org.example.looca.RedeLooca;
import org.example.terminal.Login;
import org.example.terminal.NewDevice;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Login promptLogin = new Login();
        NewDevice promptNewDevice = new NewDevice();

        Integer fkEmpresa = promptLogin.loginForm().get(0).getIdEmpresa();
        String macAddress = RedeLooca.getMacAddress();

        ServidorDAO servidorDAO = new ServidorDAO();

        if (servidorDAO.consultarServidor(macAddress, fkEmpresa).isEmpty()) {
            promptNewDevice.cadastrarServidor(fkEmpresa);
        }

        List<ViewComponenteServidor> listaComponentesServidor = ViewComponenteServidorDAO.consultarComponenteServidor(macAddress);
        List<ComponenteMedidaComando> listaComponentesMedida = new ArrayList<>();

        listaComponentesServidor.forEach(item -> {
            System.out.println(item);
            listaComponentesMedida.add(new ComponenteMedidaComando(
                    item.getComponente(), item.getMedida(), item.getComandoJava()
            ));
        });

        listaComponentesMedida.forEach(System.out::println);

    }
}