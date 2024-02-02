package br.dcx.ufpb.meuguia;

import java.sql.*;

public class ConexaoMySQL {

        public static void main(String[] args) {
            // Informações de conexão com o banco de dados
            String url = "jdbc:mysql://localhost:3306/cadastroatrativosturisticos?serverTimezone=UTC";
            String usuario = "root";
            String senha = "konoha505";

            try {
                // Carregando o driver JDBC
               // Class.forName("com.mysql.jdbc.Driver");

                // Estabelecendo a conexão com o banco de dados
                Connection conexao = DriverManager.getConnection(url, usuario, senha);

                System.out.println("entrou ");


                // Realize as operações no banco de dados aqui

                // Fechando a conexão quando terminar
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conexao = DriverManager.getConnection(url, usuario, senha);

                // Criando uma tabela
                Statement statement = conexao.createStatement();
                String createTableSQL = "CREATE TABLE exemplo (" +
                        "id INT PRIMARY KEY AUTO_INCREMENT," +
                        "nome VARCHAR(255)," +
                        "idade INT)";
                statement.executeUpdate(createTableSQL);

                // Inserindo dados na tabela
                String insertDataSQL = "INSERT INTO exemplo (nome, idade) VALUES ('João', 25)";
                statement.executeUpdate(insertDataSQL);

                insertDataSQL = "INSERT INTO exemplo (nome, idade) VALUES ('Maria', 30)";
                statement.executeUpdate(insertDataSQL);

                // Fechando a conexão
                statement.close();
                conexao.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conexao = DriverManager.getConnection(url, usuario, senha);

                // Realizando um SELECT na tabela
                Statement statement = conexao.createStatement();
                String selectSQL = "SELECT * FROM exemplo";
                ResultSet resultSet = statement.executeQuery(selectSQL);

                // Processando os resultados
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    int idade = resultSet.getInt("idade");

                    // Faça o que desejar com os dados, por exemplo, imprimi" +r no console
                            System.out.println("ID: " + id + ", Nome: " + nome + ", Idade:  idade);
                }

                // Fechando a conexão
                resultSet.close();
                statement.close();
                conexao.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();}


        }
    }

