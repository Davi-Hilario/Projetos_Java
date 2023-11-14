package org.example.dao;

import org.example.business.ViewLogin;
import org.example.database.Conexao;
import org.example.rowmapper.ViewLoginRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ViewLoginDAO {

    private final JdbcTemplate conexao = new Conexao().getConexaoDoBanco();

    public List<ViewLogin> login(String login, String senha) {
        String query = "SELECT * FROM View_Login WHERE login = ? AND senha = ?;";
        return conexao.query(query, new ViewLoginRowMapper(), login, senha);
    }
}
