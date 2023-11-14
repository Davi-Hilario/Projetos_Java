package org.example.rowmapper;

import org.example.business.ComponenteMedida;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComponenteMedidaRowMapper implements RowMapper<ComponenteMedida> {
    @Override
    public ComponenteMedida mapRow(ResultSet resultSet, int i) throws SQLException {
        ComponenteMedida componenteMedida = new ComponenteMedida();
        componenteMedida.setIdComponenteMedida(resultSet.getInt("id_componente_medida"));
        componenteMedida.setNomeComponenteMedida(resultSet.getString("nome_componente_medida"));
        componenteMedida.setFkComponente(resultSet.getInt("fk_componente"));
        componenteMedida.setFkMedida(resultSet.getInt("fk_medida"));
        componenteMedida.setFkComando(resultSet.getInt("fk_comando"));
        return componenteMedida;
    }
}
