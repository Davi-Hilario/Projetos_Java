package org.example;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.github.britooo.looca.api.core.Looca;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        java.lang.reflect.Method method;

        Conexao con = new Conexao();
        JdbcTemplate conexao = con.getConexaoDoBanco();
        List<String> metodosEncontrados = new ArrayList<>();

        Servidor server =
                conexao.queryForObject("SELECT componentes from Eyes_On_Server.Servidor where mac_address = ?",
                        new BeanPropertyRowMapper<>(Servidor.class), "09:11:44:1F:3A:A9");

        List<String> listaIndices = List.of(server.getComponentes().split(","));
        System.out.println(listaIndices);

        List<String> listaComponentes = new ArrayList<>();
        for (String index: listaIndices){
            Componente comp = conexao.queryForObject("SELECT nome_componente from Eyes_On_Server.Componente where id_componente = ?",
                    new BeanPropertyRowMapper<>(Componente.class), Integer.parseInt(index));

            if (comp.getNome_componente().equalsIgnoreCase("cpu")){
                listaComponentes.add("Processador");
            }else{
                listaComponentes.add(comp.getNome_componente());
            }
        }

        System.out.println(listaComponentes);

        try {
            Class classeLooca = Looca.class;
            Method[] allMethods = classeLooca.getDeclaredMethods();

            for (String componente:listaComponentes){
                for (int i = 0; i < allMethods.length; i++) {
                    if(allMethods[i].toString().contains(componente)){

                        List<String> metodosSeparadosPorEspaco = List.of(allMethods[i].toString().split(" "));

                        List<String> metodosSeparadosPorPonto = List.of(metodosSeparadosPorEspaco.get(2).split("\\."));
                        metodosEncontrados.add(metodosSeparadosPorPonto.get(metodosSeparadosPorPonto.size()-1));

                    }
                }
            }
        } catch (Throwable e) {
            System.err.println(e);
        }

        System.out.println(metodosEncontrados);

        for (String metodo: metodosEncontrados) {
            metodo =  metodo.replace("()","");
            try {
                Class<?> cls = Class.forName("org.example.CapturaDados");
                Method metodoClasse = cls.getMethod(metodo);
                Object obj = cls.newInstance();
                Object result = metodoClasse.invoke(obj);
                System.out.println(result);
            }

            catch (SecurityException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            }
        }


    }
}