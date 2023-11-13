package org.example;

import com.github.britooo.looca.api.group.rede.Rede;
import org.example.business.ComponenteMedida;
import org.example.business.ViewComponenteServidor;

import org.example.dao.ViewComponenteServidorDAO;

import org.example.looca.CpuLooca;
import org.example.looca.MemoriaLooca;
import org.example.looca.DiscoLooca;
import org.example.looca.RedeLooca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String macAddress = "09:11:44:1F:3A:A9";

        List<ViewComponenteServidor> listaComponentesServidor = ViewComponenteServidorDAO.consultarComponenteMedida(macAddress);
        List<ComponenteMedida> listaComponentesMedida = new ArrayList<>();

        listaComponentesServidor.forEach(item -> {
            System.out.println(item);
            listaComponentesMedida.add(new ComponenteMedida(
                    item.getComponente(), item.getMedida(), item.getComandoJava()
            ));
        });

        listaComponentesMedida.forEach(System.out::println);

    }
}