package br.com.allura.ScreenMatch.controller;

import br.com.allura.ScreenMatch.dto.SerieDto;
import br.com.allura.ScreenMatch.model.Serie;
import br.com.allura.ScreenMatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SerieController {

    @Autowired
    private SerieRepository repository;

    @GetMapping("/series")
    public List<SerieDto> obterSeries() {

        return repository.findAll()
                .stream()
                .map(s -> new SerieDto(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(), s.getAtores(), s.getPoster(), s.getSinopse()))
                .collect(Collectors.toList());


    }

    @GetMapping("/inicio")
    public String retornaInicio(){
        return "Bem vindo ao Screen Match!";
    }

}
