package br.dcx.ufpb.meuguia;

import java.sql.SQLException;

public class ProgramaAtrativo {
    public static void main(String[] args) throws SQLException {
        AtrativosBD atrativosBD = new AtrativosBD();

        // Abrir conexão
        System.out.println("Abrindo conexão...");
        atrativosBD.abrirConexao();

        // Fechar conexão
        System.out.println("Fechando conexão...");
        atrativosBD.fecharConexao();

        // Criar base de dados
        System.out.println("Criando base de dados...");
        atrativosBD.criarTabelas();
    }
}

