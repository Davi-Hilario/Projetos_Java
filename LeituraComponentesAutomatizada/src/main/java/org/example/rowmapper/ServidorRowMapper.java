package org.example.rowmapper;

import org.example.business.Servidor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServidorRowMapper implements RowMapper<Servidor> {
    @Override
    public Servidor mapRow(ResultSet resultSet, int i) throws SQLException {
        Servidor servidor = new Servidor();
        servidor.setIdServidor(resultSet.getInt("id_servidor"));
        servidor.setFkEmpresa(resultSet.getInt("fk_empresa"));
        servidor.setNomeServidor(resultSet.getString("nome_servidor"));
        servidor.setLocalServidor(resultSet.getString("local_servidor"));
        servidor.setIpv6(resultSet.getString("ipv6_servidor"));
        servidor.setMacAddress(resultSet.getString("mac_address"));
        servidor.setSo(resultSet.getString("so_servidor"));
        servidor.setDescricao(resultSet.getString("descricao"));
        return servidor;
    }
}
