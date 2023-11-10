package org.example.dao;

import org.example.business.ViewComponenteServidor;
import org.example.database.Conexao;
import org.example.rowmapper.ViewComponenteServidorRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ViewComponenteServidorDAO {

    private static final JdbcTemplate conexao = new Conexao().getConexaoDoBanco();
    public static List<ViewComponenteServidor> consultarComponenteMedida(String macAddress) {
        String query = "SELECT * FROM Eyes_On_Server.view_componentes_servidores WHERE `macAddress` = ?;";
        return conexao.query(query, new ViewComponenteServidorRowMapper(), macAddress);
    }

}
