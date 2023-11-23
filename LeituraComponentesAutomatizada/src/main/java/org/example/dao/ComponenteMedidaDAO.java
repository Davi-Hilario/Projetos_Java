package org.example.dao;

import org.example.business.ComponenteMedida;
import org.example.database.Conexao;
import org.example.rowmapper.ComponenteMedidaRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ComponenteMedidaDAO {
    private static final JdbcTemplate conexao = new Conexao().getConexaoDoBanco();

    public static List<ComponenteMedida> coletarId(String tipo) {
        String query = "SELECT * FROM Eyes_On_Server.Componente_Medida WHERE tipo = ?;";
        return conexao.query(query, new ComponenteMedidaRowMapper(), tipo);
    }

}
