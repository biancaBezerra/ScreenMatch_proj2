package br.com.allura.ScreenMatch.dto;

import br.com.allura.ScreenMatch.model.Categoria;

public record SerieDto(Long id,
                       String titulo,
                       Integer totalTemporadas,
                       Double avaliacao,
                       Categoria genero,
                       String atores,
                       String poster,
                       String sinopse) {
}
