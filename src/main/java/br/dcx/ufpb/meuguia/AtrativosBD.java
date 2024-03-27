package br.dcx.ufpb.meuguia;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            String createTableTiposSQL = "CREATE TABLE IF NOT EXISTS tipos (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(255))";
            statement.executeUpdate(createTableTiposSQL);
            System.out.println("Tabela tipos criada com sucesso.");

            // Criando a tabela de segmentações
            String createTableSegmentacoesSQL = "CREATE TABLE IF NOT EXISTS segmentacoes (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(255))";
            statement.executeUpdate(createTableSegmentacoesSQL);
            System.out.println("Tabela segmentacoes criada com sucesso.");

            // Criando a tabela de atrativo
            String createTableAtrativoSQL = "CREATE TABLE IF NOT EXISTS atrativo (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(255)," +
                    "municipio VARCHAR(255)," +
                    "tipo VARCHAR(255)," +
                    "URL_site VARCHAR(255)," +
                    "descricao TEXT," +
                    "URL_foto VARCHAR(255)," +
                    "legenda_Foto TEXT," +
                    "link_mapa VARCHAR(255)," +
                    "fonte1_informacoes TEXT," +
                    "link_fonte1 VARCHAR(255)," +
                    "Mais_Informacoes1 TEXT," +
                    "Link_Mais_Informacoes1 VARCHAR(255)," +
                    "latitude DECIMAL(10, 8)," +
                    "longitude DECIMAL(10, 8)," +
                    "tipoAtrativo VARCHAR(255)," +
                    "segmentacoes VARCHAR(255))";
            statement.executeUpdate(createTableAtrativoSQL);
            System.out.println("Tabela atrativo criada com sucesso.");

            // Criando a tabela de ligação segmentacao-atrativo
            String createTableSegmentacaoAtrativoSQL = "CREATE TABLE IF NOT EXISTS segmentacao_atrativo (" +
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

    public int cadastrarAtrativo(AtrativoTuristico atrativo) {
        int codigoAtrativo = -1; // Código de retorno padrão

        try {
            abrirConexao();

            String sql = "INSERT INTO atrativo (nome, municipio, tipo, URL_site, descricao, URL_foto, " +
                    "legenda_foto, link_mapa, fonte1_informacoes, link_fonte1, " +
                    "mais_informacoes1, link_mais_informacoes1, " +
                    " latitude, longitude) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, atrativo.getNome());
            preparedStatement.setString(2, atrativo.getMunicipio());
            preparedStatement.setString(3, atrativo.getTipo());
            preparedStatement.setString(4, atrativo.getURL_site());
            preparedStatement.setString(5, atrativo.getDescricao());
            preparedStatement.setString(6, atrativo.getURL_foto());
            preparedStatement.setString(7, atrativo.getLegenda_Foto());
            preparedStatement.setString(8, atrativo.getLink_mapa());
            preparedStatement.setString(9, atrativo.getFonte1_informacoes());
            preparedStatement.setString(10, atrativo.getLink_fonte1());
            preparedStatement.setString(11, atrativo.getMaisInformacoes1());
            preparedStatement.setString(12, atrativo.getLinkMaisInformacoes1());
            preparedStatement.setBigDecimal(13, atrativo.getLatitude());
            preparedStatement.setBigDecimal(14, atrativo.getLongitude());

            int linhasAfetadas = preparedStatement.executeUpdate();
            if (linhasAfetadas == 1) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    codigoAtrativo = rs.getInt(1); // Obtem o código gerado automaticamente
                }
            }

            System.out.println("Atrativo cadastrado com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar atrativo: " + e.getMessage());
        } finally {
            fecharConexao();
        }

        return codigoAtrativo;
    }

    public AtrativoTuristico pesquisarAtrativo(String nomeAtrativo) throws SQLException {
        AtrativoTuristico atrativo = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            abrirConexao();

            String query = "SELECT * FROM atrativo WHERE nome = ?";
            statement = conexao.prepareStatement(query);
            statement.setString(1, nomeAtrativo);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String municipio = resultSet.getString("municipio");
                String tipo = resultSet.getString("tipo");
                String URL_site = resultSet.getString("URL_site");
                String descricao = resultSet.getString("descricao");
                String URL_foto = resultSet.getString("URL_foto");
                String legenda_Foto = resultSet.getString("legenda_Foto");
                String link_mapa = resultSet.getString("link_mapa");
                String fonte1_informacoes = resultSet.getString("fonte1_informacoes");
                String link_fonte1 = resultSet.getString("link_fonte1");
                String MaisInformacoes1 = resultSet.getString("MaisInformacoes1");
                String LinkMaisInformacoes1 = resultSet.getString("LinkMaisInformacoes1");
                BigDecimal latitude = resultSet.getBigDecimal("latitude");
                BigDecimal longitude = resultSet.getBigDecimal("longitude");
                TipoAtrativo tipoAtrativo = obterTipoAtrativo(resultSet); // Implemente a lógica para obter o TipoAtrativo
                List<SegmentacaoTuristica> segmentacoes = obterSegmentacoes(resultSet); // Implemente a lógica para obter as segmentações
                // TODO PEGAR OUTRAS INFORMAÇÕES QUE A TABELA PODE TER
                // Crie o objeto AtrativoTuristico com os dados lidos do banco de dados
                atrativo = new AtrativoTuristico(id, nomeAtrativo, municipio, tipo, URL_site, descricao, URL_foto,
                        legenda_Foto, link_mapa, fonte1_informacoes, link_fonte1, MaisInformacoes1, LinkMaisInformacoes1,
                        latitude, longitude, tipoAtrativo, segmentacoes);
            }

        } finally {
            // Fechar ResultSet, PreparedStatement e Connection
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conexao != null) {
                fecharConexao();
            }
        }

        return atrativo;
    }

    public List<AtrativoTuristico> listarAtrativos() throws SQLException {
        List<AtrativoTuristico> atrativos = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            abrirConexao();

            String query = "SELECT * FROM atrativos"; // Supondo que o nome da tabela seja 'atrativos'
            statement = conexao.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String municipio = resultSet.getString("municipio");
                String tipo = resultSet.getString("tipo");
                String URL_site = resultSet.getString("URL_site");
                String descricao = resultSet.getString("descricao");
                String URL_foto = resultSet.getString("URL_foto");
                String legenda_Foto = resultSet.getString("legenda_Foto");
                String link_mapa = resultSet.getString("link_mapa");
                String fonte1_informacoes = resultSet.getString("fonte1_informacoes");
                String link_fonte1 = resultSet.getString("link_fonte1");
                String MaisInformacoes1 = resultSet.getString("MaisInformacoes1");
                String LinkMaisInformacoes1 = resultSet.getString("LinkMaisInformacoes1");
                BigDecimal latitude = resultSet.getBigDecimal("latitude");
                BigDecimal longitude = resultSet.getBigDecimal("longitude");
                TipoAtrativo tipoAtrativo = obterTipoAtrativo(resultSet); // Implemente a lógica para obter o TipoAtrativo
                List<SegmentacaoTuristica> segmentacoes = obterSegmentacoes(resultSet); // Implemente a lógica para obter as segmentações
                // TODO PEGAR OUTRAS INFORMAÇÕES QUE A TABELA PODE TER
                // Crie o objeto AtrativoTuristico com os dados lidos do banco de dados
                AtrativoTuristico atrativo = new AtrativoTuristico(id, nome, municipio, tipo, URL_site, descricao, URL_foto,
                        legenda_Foto, link_mapa, fonte1_informacoes, link_fonte1, MaisInformacoes1, LinkMaisInformacoes1,
                        latitude, longitude, tipoAtrativo, segmentacoes);

                atrativos.add(atrativo);
            }

        } finally {
            // Fechar ResultSet, PreparedStatement e Connection
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conexao != null) {
                fecharConexao();
            }
        }

        return atrativos;
    }

    private List<SegmentacaoTuristica> obterSegmentacoes(ResultSet resultSet) {
        // TODO IMPLEMENTAR
        return new ArrayList<>();
    }

    private TipoAtrativo obterTipoAtrativo(ResultSet resultSet) {
        // TODO IMPLEMENTAR
        return new TipoAtrativo(1, "aldeia", "aldeia indigena");
    }

}

