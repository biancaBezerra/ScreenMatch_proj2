package br.com.allura.ScreenMatch.repository;

import br.com.allura.ScreenMatch.model.Categoria;
import br.com.allura.ScreenMatch.model.Episodio;
import br.com.allura.ScreenMatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//essa interface vai fazer a opreação de salvar coisas no bancos de dados.
// ela vai herdar do jparepository que ja abstrai todos os métodos que vamos precisa
// para fazer operações básicas no banco.Temos que falar para ele quem é a entidade
// que iremos persistir, ou seja, quem ele vai manipular, nesse caso a tabela Series da classe Serie
// o segundo parametro é o tipo do id, de que tipo é a chave primaria dessa entidade, nesse caso Long.

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie>findByTituloContainingIgnoreCase(String nomeSerie);

    List<Serie> findByAtoresContainingIgnoreCase(String nomeAtor);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie>findByGenero(Categoria categoria);

    //List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int totalTemporadas, double avaliacao);
    //isso aqui ^ virou a JPQL
    //JPQL - Linguagem de consulta da JPA
    @Query("select s from Serie s WHERE s.totalTemporadas <= :totalTemporadas AND s.avaliacao >= :avaliacao")
    List<Serie> seriesPorTemporadaAvaliacao(int totalTemporadas, double avaliacao);

    @Query("SELECT e from Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:trechoEpisodio%")
    List<Episodio> episodiosPorTrecho(String trechoEpisodio);

    @Query("SELECT e from Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.avaliacao DESC LIMIT 5")
    List<Episodio> topEpisodiosPorSerie(Serie serie);

    @Query("SELECT e from Serie s JOIN s.episodios e WHERE s = :serie AND YEAR(e.dataLancamento) >= :anoLancamento")
    List<Episodio> episodiosPorSerieAno(Serie serie, int anoLancamento);

//    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, Double avaliacao);
}
