package org.example;

import org.example.business.ComponenteMedida;
import org.example.business.ViewComponenteServidor;
import org.example.dao.ViewComponenteServidorDAO;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String macAddress = "09:11:44:1F:3A:A9";
        List<String> metodosEncontrados = new ArrayList<>();

        List<ViewComponenteServidor> listaComponentesServidor = ViewComponenteServidorDAO.consultarComponenteMedida(macAddress);
        List<ComponenteMedida> listaComponentesMedida = new ArrayList<>();

        listaComponentesServidor.forEach(item -> {
            System.out.println(item);
            listaComponentesMedida.add(new ComponenteMedida(
                    item.getComponente(), item.getMedida()
            ));
        });

        listaComponentesMedida.forEach(System.out::println);

    }
}