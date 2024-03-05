package br.dcx.ufpb.meuguia;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ProgramaAtrativo {
    public static void main(String[] args) {
        AtrativosBD atrativosBD = new AtrativosBD();

        try {
            // Abrir conexão
            JOptionPane.showMessageDialog(null, "Abrindo conexão...");
            atrativosBD.abrirConexao();

            // Criar base de dados
            JOptionPane.showMessageDialog(null, "Criando base de dados...");
            atrativosBD.criarTabelas();

            // Cadastrar atrativo
            JOptionPane.showMessageDialog(null, "Cadastrando atrativo...");
            int codigoAtrativo = atrativosBD.cadastrarAtrativo(new AtrativoTuristico());
            JOptionPane.showMessageDialog(null, "Atrativo cadastrado com código: " + codigoAtrativo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        } finally {
            String nome = JOptionPane.showInputDialog("Digite o nome do atrativo");
            System.out.println(nome);

            String municipio = JOptionPane.showInputDialog("Digite o nome do municipio do atrativo");
            System.out.println(municipio);

            String tipo = JOptionPane.showInputDialog("Digite o tipo do atrativo");
            System.out.println(tipo);

            AtrativoTuristico atrativoTuristico = new AtrativoTuristico(2, nome, municipio, tipo);
            System.out.println(atrativoTuristico.toString());

            // Fechar conexão
            JOptionPane.showMessageDialog(null, "Fechando conexão...");
            atrativosBD.fecharConexao();
        }
    }
}
