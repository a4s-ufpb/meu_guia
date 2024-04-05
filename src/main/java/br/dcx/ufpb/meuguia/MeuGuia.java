package br.dcx.ufpb.meuguia;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;


public class MeuGuia {

    public static void main(String[] args) throws SQLException {
        AtrativosBD atrativosBD = new AtrativosBD();

        try {
            boolean continuar = true;


            // Abrir conexão
            JOptionPane.showMessageDialog(null, "Abrindo conexão...");
            atrativosBD.abrirConexao();

            // Criar base de dados
            JOptionPane.showMessageDialog(null, "Criando base de dados...");
            atrativosBD.criarTabelas();

            //Menu de Opções


            // Menu de seleção de ação
            int selectedOption = JOptionPane.showOptionDialog(null,
                    "Selecione a ação desejada:\n1 - Cadastrar Atrativo\n2 - Pesquisar Atrativo\n3 - Listar Atrativos\n4 - Fechar Programa",
                    "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    new String[]{"Cadastrar Atrativo", "Pesquisar Atrativo", "Listar Atrativos" ,"Fechar Programa"}, "Cadastrar Atrativo");

            switch (selectedOption) {
                case 0:
                    // Cadastrar atrativo
                    while (continuar) {
                        // Solicitar dados do atrativo
                        String nome = JOptionPane.showInputDialog("Digite o nome do atrativo");
                        String municipio = JOptionPane.showInputDialog("Digite o nome do município do atrativo");
                        String tipo = JOptionPane.showInputDialog("Digite o tipo do atrativo");
                        String URL_site = JOptionPane.showInputDialog("Digite a URL do site do atrativo");
                        String descricao = JOptionPane.showInputDialog("Digite a descrição do atrativo");
                        String URL_foto = JOptionPane.showInputDialog("Digite a URL da foto do atrativo");
                        String legenda_Foto = JOptionPane.showInputDialog("Digite a legenda da foto do atrativo");
                        String link_mapa = JOptionPane.showInputDialog("Digite o link do mapa do atrativo");
                        String fonte1_informacoes = JOptionPane.showInputDialog("Digite a fonte das informações 1");
                        String link_fonte1 = JOptionPane.showInputDialog("Digite o link da fonte 1");
                        String MaisInformacoes1 = JOptionPane.showInputDialog("Digite mais informações 1");
                        String LinkMaisInformacoes1 = JOptionPane.showInputDialog("Digite o link das mais informações 1");
                        String latitudeStr = JOptionPane.showInputDialog("Digite a latitude do atrativo");
                        BigDecimal latitude = latitudeStr.isEmpty() ? BigDecimal.ZERO : new BigDecimal(latitudeStr);
                        String longitudeStr = JOptionPane.showInputDialog("Digite a longitude do atrativo");
                        BigDecimal longitude = longitudeStr.isEmpty() ? BigDecimal.ZERO : new BigDecimal(longitudeStr);

                        // Criar objeto AtrativoTuristico com os dados fornecidos
                        AtrativoTuristico atrativo = new AtrativoTuristico(nome, municipio, tipo, URL_site, descricao,
                                URL_foto, legenda_Foto, link_mapa, fonte1_informacoes, link_fonte1, MaisInformacoes1,
                                LinkMaisInformacoes1, latitude, longitude);

                        // Cadastrar atrativo
                        JOptionPane.showMessageDialog(null, "Cadastrando atrativo...");
                        atrativosBD.cadastrarAtrativo(atrativo);

                        // Verificar se o usuário deseja cadastrar outro atrativo
                        String resposta = JOptionPane.showInputDialog("Deseja cadastrar outro Atrativo?\nDigite 'Não' ou 'Nao'");
                        if (resposta != null && (resposta.equalsIgnoreCase("Não") || resposta.equalsIgnoreCase("Nao"))) {
                            continuar = false;
                        }
                    }
                    break;

                case 1:
                    // Pesquisar atrativo
                    String nomeAtrativo = JOptionPane.showInputDialog("Digite o nome do atrativo a ser pesquisado:");
                    try {
                        AtrativoTuristico atrativoPesquisado = atrativosBD.pesquisarAtrativo(nomeAtrativo);
                        if (atrativoPesquisado != null) {
                            JOptionPane.showMessageDialog(null, "Atrativo encontrado:\n" + atrativoPesquisado.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Atrativo não encontrado.");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao pesquisar atrativo: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Listar atrativos
                    try {
                        // Abrir conexão antes de chamar o método listarAtrativos
                        List<AtrativoTuristico> listaAtrativos = atrativosBD.listarAtrativos();
                        if (!listaAtrativos.isEmpty()) {
                            // Criar um JTextArea para exibir os atrativos
                            JTextArea textArea = new JTextArea(20, 40);
                            textArea.setEditable(false);

                            // Preencher o JTextArea com os atrativos
                            for (AtrativoTuristico atrativo : listaAtrativos) {
                                textArea.append(atrativo.toString() + "\n\n");
                            }

                            // Colocar o JTextArea em um JScrollPane
                            JScrollPane scrollPane = new JScrollPane(textArea);

                            // Mostrar o JOptionPane com o JScrollPane
                            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Atrativos", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhum atrativo cadastrado.");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao listar atrativos: " + e.getMessage());
                    } finally {
                        // Fechar conexão após listar os atrativos
                        atrativosBD.fecharConexao();
                    }
                    break;



                case 3:
                    // Fechar programa
                    continuar = false;
                    break;
                default:
                    // Opção inválida
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        } finally {
            // Fechar conexão
            JOptionPane.showMessageDialog(null, "Fechando conexão...");
            atrativosBD.fecharConexao();
        }
    }

}

