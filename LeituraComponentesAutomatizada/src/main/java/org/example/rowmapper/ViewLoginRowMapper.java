package org.example.rowmapper;

import org.example.business.ViewLogin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewLoginRowMapper implements RowMapper<ViewLogin> {
    @Override
    public ViewLogin mapRow(ResultSet resultSet, int i) throws SQLException {
        ViewLogin viewLogin = new ViewLogin();
        viewLogin.setNomeUsuario(resultSet.getString("nome"));
        viewLogin.setIdEmpresa(resultSet.getInt("id_empresa"));
        viewLogin.setLogin(resultSet.getString("login"));
        viewLogin.setSenha(resultSet.getString("senha"));
        return viewLogin;
    }
}
