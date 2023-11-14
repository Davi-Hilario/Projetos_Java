package org.example;

import org.example.business.ComponenteMedidaComando;
import org.example.business.ViewComponenteServidor;

import org.example.dao.ServidorDAO;
import org.example.dao.ViewComponenteServidorDAO;
import org.example.interfaces.Executavel;
import org.example.looca.rede.Rede;
import org.example.terminal.Login;
import org.example.terminal.NewDevice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

        List<ViewComponenteServidor> listaComponentesServidor = ViewComponenteServidorDAO.consultarComponenteServidor(macAddress);
        List<ComponenteMedidaComando> listaComponentesMedida = new ArrayList<>();

        listaComponentesServidor.forEach(item -> {
            System.out.println(item);
            listaComponentesMedida.add(new ComponenteMedidaComando(
                    item.getComponente(), item.getMedida(), item.getComandoJava()
            ));
        });


        List<Executavel> componentesExecutaveis = new ArrayList<>();

        listaComponentesMedida.forEach(item -> {

            Class<?> classe = null;
            try {
                classe = Class.forName(item.getComando());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Constructor<?> construtor = null;
            try {
                construtor = classe.getConstructor();
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            Object instancia;
            try {
                instancia = construtor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            componentesExecutaveis.add((Executavel) instancia);
        });

        while (true) {
            componentesExecutaveis.forEach(Executavel::executar);
        }

    }
}