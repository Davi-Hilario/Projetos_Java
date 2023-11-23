package org.example.rowmapper;

import org.example.business.ViewComponenteServidor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewComponenteServidorRowMapper implements RowMapper<ViewComponenteServidor> {
    @Override
    public ViewComponenteServidor mapRow(ResultSet resultSet, int i) throws SQLException {
        ViewComponenteServidor viewComponenteServidor = new ViewComponenteServidor();
        viewComponenteServidor.setEmpresa(resultSet.getString("empresa"));
        viewComponenteServidor.setServidor(resultSet.getString("servidor"));
        viewComponenteServidor.setSistemaOperacional(resultSet.getString("sistemaOperacional"));
        viewComponenteServidor.setMacAddress(resultSet.getString("macAddress"));
        viewComponenteServidor.setLocal(resultSet.getString("local"));
        viewComponenteServidor.setTipo(resultSet.getString("tipo"));
        viewComponenteServidor.setComponente(resultSet.getString("componente"));
        viewComponenteServidor.setMedida(resultSet.getString("medida"));
        return viewComponenteServidor;
    }
}
