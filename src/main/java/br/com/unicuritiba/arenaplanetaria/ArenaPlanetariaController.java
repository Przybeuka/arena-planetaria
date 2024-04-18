package br.com.unicuritiba.arenaplanetaria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.unicuritiba.arenaplanetaria.models.Planeta;
import br.com.unicuritiba.arenaplanetaria.repositories.PlanetaRepository;

@Controller
public class ArenaPlanetariaController {

	
	@Autowired
	private PlanetaRepository repositorio;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		List<Planeta> planetas = repositorio.findAll();
		
		ModelAndView view = new ModelAndView("index");
		view.addObject("planetas", planetas);
		
		return view;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView create() {
		
		ModelAndView view = new ModelAndView("create");
		view.addObject("model", new Planeta());
		
		return view;
	}
	
	@PostMapping("/cadastro")
	public String createFighter(
		Planeta planeta,
		Model model,
		BindingResult result) {
		
		repositorio.save(planeta);
		return "redirect:/";
	}
} 
