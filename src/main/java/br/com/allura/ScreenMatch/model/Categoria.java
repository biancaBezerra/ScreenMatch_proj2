package br.com.allura.ScreenMatch.model;

public enum Categoria {
    ACAO("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    CRIME("Crime"),
    TERROR("Horror"),
    DOCUMENTARIO("Documentary"),
    SUSPENSE("Thriller"),
    AVENTURA("Adventure");

    private String categoriaOmdb;

    Categoria(String categoriOmbd){
        this.categoriaOmdb = categoriOmbd;
    }


    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
