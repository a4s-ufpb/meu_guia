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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getURL_site() {
        return URL_site;
    }

    public void setURL_site(String URL_site) {
        this.URL_site = URL_site;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getURL_foto() {
        return URL_foto;
    }

    public void setURL_foto(String URL_foto) {
        this.URL_foto = URL_foto;
    }

    public String getLegenda_Foto() {
        return legenda_Foto;
    }

    public void setLegenda_Foto(String legenda_Foto) {
        this.legenda_Foto = legenda_Foto;
    }

    public String getLink_mapa() {
        return link_mapa;
    }

    public void setLink_mapa(String link_mapa) {
        this.link_mapa = link_mapa;
    }

    public String getFonte1_informacoes() {
        return fonte1_informacoes;
    }

    public void setFonte1_informacoes(String fonte1_informacoes) {
        this.fonte1_informacoes = fonte1_informacoes;
    }

    public String getLink_fonte1() {
        return link_fonte1;
    }

    public void setLink_fonte1(String link_fonte1) {
        this.link_fonte1 = link_fonte1;
    }

    public String getFonte2_informacoes() {
        return fonte2_informacoes;
    }

    public void setFonte2_informacoes(String fonte2_informacoes) {
        this.fonte2_informacoes = fonte2_informacoes;
    }

    public String getLinkFonte2() {
        return LinkFonte2;
    }

    public void setLinkFonte2(String linkFonte2) {
        LinkFonte2 = linkFonte2;
    }

    public String getFonte3Informacoes() {
        return Fonte3Informacoes;
    }

    public void setFonte3Informacoes(String fonte3Informacoes) {
        Fonte3Informacoes = fonte3Informacoes;
    }

    public String getLinkFonte3() {
        return LinkFonte3;
    }

    public void setLinkFonte3(String linkFonte3) {
        LinkFonte3 = linkFonte3;
    }

    public String getFonte4Informacoes() {
        return Fonte4Informacoes;
    }

    public void setFonte4Informacoes(String fonte4Informacoes) {
        Fonte4Informacoes = fonte4Informacoes;
    }

    public String getLinkFonte4() {
        return LinkFonte4;
    }

    public void setLinkFonte4(String linkFonte4) {
        LinkFonte4 = linkFonte4;
    }

    public String getMaisInformacoes1() {
        return MaisInformacoes1;
    }

    public void setMaisInformacoes1(String maisInformacoes1) {
        MaisInformacoes1 = maisInformacoes1;
    }

    public String getLinkMaisInformacoes1() {
        return LinkMaisInformacoes1;
    }

    public void setLinkMaisInformacoes1(String linkMaisInformacoes1) {
        LinkMaisInformacoes1 = linkMaisInformacoes1;
    }

    public String getMaisInformacoes2() {
        return MaisInformacoes2;
    }

    public void setMaisInformacoes2(String maisInformacoes2) {
        MaisInformacoes2 = maisInformacoes2;
    }

    public String getLinkMaisInformacoes2() {
        return LinkMaisInformacoes2;
    }

    public void setLinkMaisInformacoes2(String linkMaisInformacoes2) {
        LinkMaisInformacoes2 = linkMaisInformacoes2;
    }

    public String getMaisInformacoes3() {
        return MaisInformacoes3;
    }

    public void setMaisInformacoes3(String maisInformacoes3) {
        MaisInformacoes3 = maisInformacoes3;
    }

    public String getLinkMaisInformacoes3() {
        return LinkMaisInformacoes3;
    }

    public void setLinkMaisInformacoes3(String linkMaisInformacoes3) {
        LinkMaisInformacoes3 = linkMaisInformacoes3;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public TipoAtrativo getTipoAtrativo() {
        return tipoAtrativo;
    }

    public void setTipoAtrativo(TipoAtrativo tipoAtrativo) {
        this.tipoAtrativo = tipoAtrativo;
    }

    public List<SegmentacaoTuristica> getSegmentacoes() {
        return segmentacoes;
    }

    public void setSegmentacoes(List<SegmentacaoTuristica> segmentacoes) {
        this.segmentacoes = segmentacoes;
    }

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

