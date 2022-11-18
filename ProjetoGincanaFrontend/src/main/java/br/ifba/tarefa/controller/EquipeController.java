package br.ifba.tarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ifba.tarefa.model.EquipeModel;
import br.ifba.tarefa.service.EquipeService;

@Controller
@RequestMapping("/equipe")
public class EquipeController {
	@Autowired
	private EquipeService equipeService;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("equipes_lista - init");
		List<EquipeModel> list = this.equipeService.getEquipes();
		model.addAttribute("equipes", list);
		return "equipe/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form() {
		return "equipe/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute EquipeModel equipeModel, Model model) {
		System.out.println("insert: " + equipeModel.getNome_Equipe());
		EquipeModel tm = new EquipeModel();
		tm.setNome_Equipe( equipeModel.getNome_Equipe() );
		equipeService.insert(tm);
		return "redirect:/equipe/";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.equipeService.deleteEquipe(id);
		return "redirect:/equipe/";
	}
	
	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		EquipeModel tm = this.equipeService.getEquipes(id);
		model.addAttribute("id", tm.getId_Equipe());
		model.addAttribute("nome", tm.getNome_Equipe());
		model.addAttribute("readonly", true);
		return "equipe/editar_form";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute EquipeModel equipeModel, Model model) {
		EquipeModel tm = this.equipeService.getEquipes(equipeModel.getId_Equipe());
		tm.setNome_Equipe( equipeModel.getNome_Equipe() );
		equipeService.update(tm);
		return "redirect:/equipe/";
	}
	
	/*@GetMapping("/modificar_status/{id}")
	public String modificar_status(@PathVariable("id") Integer id) {
		EquipeModel tm = this.equipeService.getEquipe(id);
		if (!tm.getStatus()) {
			tm.setData_conclusao( new Date(System.currentTimeMillis()) );
		}
		else {
			tm.setData_conclusao( null );
		}
		tm.setStatus( !tm.getStatus() );
		equipeService.update(tm);
		return "redirect:/equipe/";
	}*/
}
