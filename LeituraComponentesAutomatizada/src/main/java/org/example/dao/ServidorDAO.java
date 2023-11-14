package org.example.dao;

import org.example.business.Servidor;
import org.example.database.Conexao;
import org.example.rowmapper.ServidorRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ServidorDAO {

    private final JdbcTemplate conexao = new Conexao().getConexaoDoBanco();

    public List<Servidor> consultarServidor(String macAddress, Integer fkEmpresa) {
        String query = "SELECT * FROM Eyes_On_Server.Servidor WHERE mac_address = ? AND fk_empresa = ?;";
        return conexao.query(query, new ServidorRowMapper(), macAddress, fkEmpresa);
    }

    public void inserirServidor
            (
                Integer fkServer,
                String nomeServer,
                String localServer,
                String ipv6Server,
                String macAddress,
                String soServer,
                String descServer
            )
    {
        String query = """
                INSERT INTO Eyes_On_Server.Servidor VALUES
                (NULL,?,?,?,?,?,?,?);
                """;
        conexao.update
                (
                        query,
                        fkServer,
                        nomeServer,
                        localServer,
                        ipv6Server,
                        macAddress,
                        soServer,
                        descServer
                );
    }
}
