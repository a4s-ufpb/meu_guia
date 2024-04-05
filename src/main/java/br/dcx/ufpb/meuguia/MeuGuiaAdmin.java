package br.dcx.ufpb.meuguia;

import javax.swing.*;
import java.sql.SQLException;

public class MeuGuiaAdmin {
    public static void main(String[] args){
        AtrativosBD atrativosBD = new AtrativosBD();

        try {
            boolean continuar = true;


            // Abrir conexão
            JOptionPane.showMessageDialog(null, "Abrindo conexão...");
            atrativosBD.abrirConexao();

            // Criar base de dados
            JOptionPane.showMessageDialog(null, "Criando base de dados...");
            atrativosBD.criarTabelas();

            // Menu de seleção de ação
            int selectedOption = JOptionPane.showOptionDialog(null,
                    "Selecione a ação desejada:\n1 - Criar Tabelas\n2 - Apagar Tabelas\n3 - Fechar Programa",
                    "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    new String[]{"Criar Tabelas", "Apagar Tabelas" ,"Fechar Programa"}, "Cadastrar Atrativo");

            switch (selectedOption) {

                case 0:
                    // Criar tabelas
                    atrativosBD.criarTabelas();
                    JOptionPane.showMessageDialog(null, "Tabelas criadas com sucesso.");
                    break;


                case 1:
                    // Apagar tabela
                    String nomeTabelaApagar = JOptionPane.showInputDialog("Digite o nome da tabela que deseja apagar:");
                    if (nomeTabelaApagar != null && !nomeTabelaApagar.isEmpty()) {
                        atrativosBD.apagarTabela(nomeTabelaApagar);
                        JOptionPane.showMessageDialog(null, "Tabela " + nomeTabelaApagar + " apagada com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nome de tabela inválido.");
                    }
                    break;


                case 2:
                    // Fechar programa
                    continuar = false;
                    break;
                default:
                    // Opção inválida
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);


        }
    }
}
