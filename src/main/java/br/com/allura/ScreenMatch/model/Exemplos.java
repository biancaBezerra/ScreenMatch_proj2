package br.com.allura.ScreenMatch.model;

import java.util.*;
import java.util.stream.Collectors;

public class Exemplos {
    public void exibeExemplo(){
        // *************LAMBDA********

        //NÃO FAÇA ASSIM
//        for (int i = 0; i < dados.totalTemporadas(); i++){
//            List<DadosEpisodios> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size(); j++){
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }

        //FAÇA ASSIM
//        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
        //como queremos iterar sobre todas as temporadas, usamos o foreach.
        //Para toda temporada "t" eu vou pegar os espisódios dela e além disso vamos
        //Percorrer também esta lista de episódios "e" e imprimir o titulo de episodios "e".
        //Isso aqui é um LAMBDA, São funções anônimas que tem um parâmetro, geralmente declarados por
        //uma letra. São usados para iterar em uma coleção, no nosso caso, DadosTemporada


        //*************STREAM**************

        //É um fluxo de dados - essa lista nomes é um fluxo de dados
        //E com esse fluxo de dados podemos fazer um fluxo de operações encadeadas
        //E essa é a saca do stream, ele dá o pder de fazer várias operações encadeadas
        //Como ordenação, escolher quantos dados irão aparecer
        //Exemplo
//        List<String> nomes = Arrays.asList("Jacque", "Paulo", "Iasmin", "Rodrigo", "Nico");
//
//        nomes.stream()
//                .sorted()
//                .limit(3)
//                .filter( n -> n.startsWith("N"))
//                .map(n -> n.toUpperCase())
//                .forEach(System.out::println);

        //Tudo que gera um stream novo se chama de 'operação intermediária'
        //Tudo que faz alguma coisa com esse stream, tipo o forEach se chama 'operação final'

        //Ao usar um nextInt para fazer a leitura de inteiros, precisamos abaixo chamar o
        // leitura.nextLine, pois ao faer uma nova requisição evitará erros. veja:
        //        var ano = leitura.nextInt();
        //        leitura.nextLine();


        //ANTIGO EXIBE MENU COM DADOS ESTATISCOS E ETC

//        public void exibeMenu(){
//
//            System.out.println("Digite o nome da Série para busca: ");
//            var nomeSerie = leitura.nextLine();
//            var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
//
//            DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
//            System.out.println(dados);
//
//            List<DadosTemporada> temporadas = new ArrayList<>();
//
//            for (int temporada = 1; temporada <= dados.totalTemporadas(); temporada++){
//                json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") +
//                        "&season=" + temporada + API_KEY);
//                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
//                temporadas.add(dadosTemporada);
//            }

//		temporadas.forEach(System.out::println);
//
//        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

            //Vamos fazer uma lista de dados episódios, trazendo para dentro dessa lista a lista de
            // temporadas também - faremos isso com o stream
//            List<DadosEpisodios> dadosEpisodios = temporadas.stream()
//                    .flatMap(t -> t.episodios().stream())
//                    .collect(Collectors.toList());

//        System.out.println("\nTOP 10 EPISODIOS");
//        dadosEpisodios.stream()
//                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("Primeiro filtro (N/A) " + e))
//                .sorted(Comparator.comparing(DadosEpisodios::avaliacao).reversed())
//                .peek(e -> System.out.println("Ordenação " + e))
//                .limit(10)
//                .peek(e -> System.out.println("Limite de dados " + e))
//                .forEach(System.out::println);
//
//            List<Episodio> episodios = temporadas.stream()
//                    .flatMap(t -> t.episodios().stream()
//                            .map(d -> new Episodio(t.numero(), d))
//                    ).collect(Collectors.toList());
//            episodios.forEach(System.out::println);

//        System.out.println("Digite uma palavra que possa conter em um titulo de um episódio: ");
//        var trechoTitulo = leitura.nextLine();
//
//        Optional<Episodio> episodioBuscado = episodios.stream()
//                .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
//                .findFirst();
//        if (episodioBuscado.isPresent()){
//            System.out.println("Episodio encontrado");
//            System.out.println("Temporada: " + episodioBuscado.get());
//        } else{
//            System.out.println("Episodio não encontrado");
//        }
//
//        System.out.println("A partir de que ano você deseja ver os episódios? ");
//
//        var ano = leitura.nextInt();
//        leitura.nextLine();
//
//        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
//
//        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        episodios.stream()
//                .filter(e ->e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getTemporada() +
//                                " ** "+"Episódio: " + e.getTitulo() +
//                                " ** "+"Data de lançamento: " + e.getDataLancamento().format(formatoData)
//                ));
//
//            Map<Integer, Double> avaliacoesPorTemporada = episodios.stream()
//                    .filter(e -> e.getAvaliacao() > 0.0)
//                    .collect(Collectors.groupingBy(Episodio::getTemporada,
//                            Collectors.averagingDouble(Episodio::getAvaliacao)));
//            System.out.println(avaliacoesPorTemporada);
//
//            DoubleSummaryStatistics est = episodios.stream()
//                    .filter(e -> e.getAvaliacao() > 0.0)
//                    .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
//            System.out.println("\nMédia: " + est.getAverage() +
//                    "\nMelhor avaliação: " + est.getMax() +
//                    "\nPior avaliação: " + est.getMin()+
//                    "\nQuantidade: " + est.getCount());

        }
}
