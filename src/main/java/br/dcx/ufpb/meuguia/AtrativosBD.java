package br.dcx.ufpb.meuguia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AtrativosBD {
    private static final String URL = "jdbc:mysql://localhost:3306/cadastroatrativosturisticos?serverTimezone=UTC";
    private static final String USUARIO_BANCO = "root";
    private static final String SENHA = "konoha505";

    private Connection conexao;

    public void abrirConexao() throws SQLException {
        try {
            conexao = DriverManager.getConnection(URL, USUARIO_BANCO, SENHA);
            System.out.println("Conexão estabelecida com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao abrir a conexão com o banco de dados: " + e.getMessage());
            throw e;
        }
    }

    public void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
}

