package br.dcx.ufpb.meuguia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void criarTabelas() {
        try {
            abrirConexao();

            // Criando a tabela de tipos
            Statement statement = conexao.createStatement();
            String createTableTiposSQL = "CREATE TABLE tipos (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(255))";
            statement.executeUpdate(createTableTiposSQL);
            System.out.println("Tabela tipos criada com sucesso.");

            // Criando a tabela de segmentações
            String createTableSegmentacoesSQL = "CREATE TABLE segmentacoes (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(255))";
            statement.executeUpdate(createTableSegmentacoesSQL);
            System.out.println("Tabela segmentacoes criada com sucesso.");

            // Criando a tabela de atrativo
            String createTableAtrativoSQL = "CREATE TABLE atrativo (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(255)," +
                    "descricao TEXT)";
            statement.executeUpdate(createTableAtrativoSQL);
            System.out.println("Tabela atrativo criada com sucesso.");

            // Criando a tabela de ligação segmentacao-atrativo
            String createTableSegmentacaoAtrativoSQL = "CREATE TABLE segmentacao_atrativo (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "id_segmentacao INT," +
                    "id_atrativo INT," +
                    "FOREIGN KEY (id_segmentacao) REFERENCES segmentacoes(id)," +
                    "FOREIGN KEY (id_atrativo) REFERENCES atrativo(id))";
            statement.executeUpdate(createTableSegmentacaoAtrativoSQL);
            System.out.println("Tabela segmentacao_atrativo criada com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao criar as tabelas: " + e.getMessage());
        } finally {
            fecharConexao();
        }
    }

    public void apagarTabela(String nomeTabela) {
        try {
            abrirConexao();
            Statement statement = conexao.createStatement();
            String sql = "DROP TABLE IF EXISTS " + nomeTabela;
            statement.executeUpdate(sql);
            System.out.println("Tabela " + nomeTabela + " apagada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao apagar a tabela " + nomeTabela + ": " + e.getMessage());
        } finally {
            fecharConexao();
        }
    }
}

