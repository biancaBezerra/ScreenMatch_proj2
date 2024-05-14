package br.com.allura.ScreenMatch.controller;

import br.com.allura.ScreenMatch.dto.EpisodioDto;
import br.com.allura.ScreenMatch.dto.SerieDto;
import br.com.allura.ScreenMatch.model.Episodio;
import br.com.allura.ScreenMatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService servico;

    @GetMapping
    public List<SerieDto> obterSeries() {
        return servico.obterTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDto> obterTop5Series(){
        return servico.obterTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDto> obterLancamentos(){

        return servico.obterLancamentos();
    }

    @GetMapping("/{id}")
    public SerieDto obterPorId(@PathVariable Long id){
        return servico.obterPorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDto> obterTodasTemporadas(@PathVariable Long id) {
        return servico.obterTodasAsTemporadas(id);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public List<EpisodioDto> obterTemporadasPorNumero(@PathVariable Long id, @PathVariable Long numero) {
        return servico.obterTemporadasPorNumero(id, numero);
    }

    @GetMapping("/categoria/{nomeCategoria}")
    public List<SerieDto> obterSeriePorCategoria(@PathVariable String nomeCategoria){
        return servico.obterSeriePorCategoria(nomeCategoria);
    }

}
