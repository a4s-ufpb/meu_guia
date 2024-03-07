package br.dcx.ufpb.meuguia;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.SQLException;

public class ProgramaAtrativo {
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

            // Cadastrar atrativo
            while (continuar) {
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
                BigDecimal latitude;
                if (latitudeStr.equals("")) {
                    latitude = new BigDecimal("0");

                } else {
                    latitude = new BigDecimal(latitudeStr);
                }
                String longitudeStr = JOptionPane.showInputDialog("Digite a longitude do atrativo");
                BigDecimal longitude;
                if (longitudeStr.equals("" +
                        "")) {
                    longitude = new BigDecimal("0");

                } else {
                    longitude = new BigDecimal(longitudeStr);
                }


                // Crie o objeto AtrativoTuristico com os dados fornecidos
                AtrativoTuristico atrativo = new AtrativoTuristico(nome, municipio, tipo, URL_site, descricao,
                        URL_foto, legenda_Foto, link_mapa, fonte1_informacoes, link_fonte1, MaisInformacoes1,
                        LinkMaisInformacoes1, latitude, longitude);

                JOptionPane.showMessageDialog(null, "Cadastrando atrativo...");
                atrativosBD.cadastrarAtrativo(atrativo);
                String reposta = JOptionPane.showInputDialog("Deseja cadastrar outro Atrativo ?\n digite Sim " +
                        "ou Nao");
                if ( reposta.equals("Sim".toLowerCase().trim()) || reposta.equals("S".toLowerCase().trim())) {
                    continuar = false; //quandofor false ele parao programa
                }
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

