package br.dcx.ufpb.meuguia;

import java.math.BigDecimal;
import java.util.List;


public class AtrativoTuristico {
    int id;
    String nome;
    private String municipio;
    private String tipo;
    private String URL_site;
    private String descricao;
    private String URL_foto;
    private String legenda_Foto;
    private String link_mapa;
    private String fonte1_informacoes;
    private String link_fonte1;
    private String fonte2_informacoes;
    private String LinkFonte2;
    private String Fonte3Informacoes;
    private String LinkFonte3;
    private String Fonte4Informacoes;
    private String LinkFonte4;
    private String MaisInformacoes1;
    private String LinkMaisInformacoes1;
    private String MaisInformacoes2;
    private String LinkMaisInformacoes2;
    private String MaisInformacoes3;
    private String LinkMaisInformacoes3;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private TipoAtrativo tipoAtrativo;
    private List<SegmentacaoTuristica> segmentacoes;

    // Construtor
    public AtrativoTuristico(int id, String nome, String municipio, String tipo, String URL_site, String descricao,
                             String URL_foto, String legenda_Foto, String link_mapa, String fonte1_informacoes,
                             String link_fonte1, String fonte2_informacoes, String LinkFonte2,
                             String Fonte3Informacoes, String LinkFonte3, String Fonte4Informacoes,
                             String LinkFonte4, String MaisInformacoes1, String LinkMaisInformacoes1,
                             String MaisInformacoes2, String LinkMaisInformacoes2, String MaisInformacoes3,
                             String LinkMaisInformacoes3, BigDecimal latitude, BigDecimal longitude,
                                 TipoAtrativo tipoAtrativo, List<SegmentacaoTuristica> segmentacoes) {
        this.id = id;
        this.nome = nome;
        this.municipio = municipio;
        this.tipo = tipo;
        this.URL_site = URL_site;
        this.descricao = descricao;
        this.URL_foto = URL_foto;
        this.legenda_Foto = legenda_Foto;
        this.link_mapa = link_mapa;
        this.fonte1_informacoes = fonte1_informacoes;
        this.link_fonte1 = link_fonte1;
        this.fonte2_informacoes = fonte2_informacoes;
        this.LinkFonte2 = LinkFonte2;
        this.Fonte3Informacoes = Fonte3Informacoes;
        this.LinkFonte3 = LinkFonte3;
        this.Fonte4Informacoes = Fonte4Informacoes;
        this.LinkFonte4 = LinkFonte4;
        this.MaisInformacoes1 = MaisInformacoes1;
        this.LinkMaisInformacoes1 = LinkMaisInformacoes1;
        this.MaisInformacoes2 = MaisInformacoes2;
        this.LinkMaisInformacoes2 = LinkMaisInformacoes2;
        this.MaisInformacoes3 = MaisInformacoes3;
        this.LinkMaisInformacoes3 = LinkMaisInformacoes3;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tipoAtrativo = tipoAtrativo;
        this.segmentacoes = segmentacoes;
    }

    // Métodos Getters e Setters omitidos por brevidade
}

