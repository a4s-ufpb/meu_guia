package br.dcx.ufpb.meuguia;

public class AtrativoTuristicoAccessor {
    public static int getId(AtrativoTuristico atrativo) {
        return atrativo.id;
    }

    public static void setId(AtrativoTuristico atrativo, int id) {
        atrativo.id = id;
    }

    public static String getNome(AtrativoTuristico atrativo) {
        return atrativo.nome;
    }

    public static void setNome(AtrativoTuristico atrativo, String nome) {
        atrativo.nome = nome;
    }

    // Implemente os métodos getters e setters para os outros campos
}
