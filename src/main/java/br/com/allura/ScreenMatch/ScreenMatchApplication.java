package br.com.allura.ScreenMatch;

import br.com.allura.ScreenMatch.Principal.Principal;
import br.com.allura.ScreenMatch.model.DadosTemporada;
import br.com.allura.ScreenMatch.model.Exemplos;
import br.com.allura.ScreenMatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenMatchApplication{

	public static void main(String[] args) {
		
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

}
