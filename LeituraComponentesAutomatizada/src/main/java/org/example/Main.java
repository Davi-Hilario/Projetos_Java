package org.example;

import org.example.business.ComponenteMedidaComando;
import org.example.business.ViewComponenteServidor;

import org.example.dao.ViewComponenteServidorDAO;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String macAddress = "09:11:44:1F:3A:A9";

        List<ViewComponenteServidor> listaComponentesServidor = ViewComponenteServidorDAO.consultarComponenteMedida(macAddress);
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