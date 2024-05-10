package br.com.allura.ScreenMatch.repository;

import br.com.allura.ScreenMatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

//essa interface vai fazer a opreação de salvar coisas no bancos de dados.
// ela vai herdar do jparepository que ja abstrai todos os métodos que vamos precisa
// para fazer operações básicas no banco.Temos que falar para ele quem é a entidade
// que iremos persistir, ou seja, quem ele vai manipular, nesse caso a tabela Series da classe Serie
// o segundo parametro é o tipo do id, de que tipo é a chave primaria dessa entidade, nesse caso Long.

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
