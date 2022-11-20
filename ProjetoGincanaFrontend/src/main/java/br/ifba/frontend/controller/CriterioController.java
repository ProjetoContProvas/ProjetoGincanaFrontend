package br.ifba.frontend.controller;

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

import br.ifba.frontend.model.CriterioModel;
import br.ifba.frontend.service.CriterioService;

@Controller
@RequestMapping("/criterio")
public class CriterioController {
	@Autowired
	private CriterioService criterioService;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("tarefas_lista - init");
		List<CriterioModel> list = this.criterioService.getCriterios();
		model.addAttribute("criterios", list);
		return "criterio/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form() {
		return "criterio/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute CriterioModel criterioModel, Model model) {
		System.out.println("insert: " + criterioModel.getNome_Criterio());
		CriterioModel tm = new CriterioModel();
		tm.setNome_Criterio(criterioModel.getNome_Criterio());
		tm.setPontuacao_min_Criterio(criterioModel.getPontuacao_min_Criterio());
		tm.setPontuacao_max_Criterio(criterioModel.getPontuacao_max_Criterio());
		criterioService.insert(tm);
		return "redirect:/criterio/";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.criterioService.deleteCriterio(id);
		return "redirect:/criterio/";
	}
	
	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		CriterioModel tm = this.criterioService.getCriterio(id);
		model.addAttribute("id_Criterio", tm.getId_Criterio());
		model.addAttribute("nome_Criterio", tm.getNome_Criterio());
		model.addAttribute("pontuacao_min_max", tm.getPontuacao_min_Criterio());
		model.addAttribute("getPontuacao_max_Criterio", tm.getPontuacao_max_Criterio());
		model.addAttribute("readonly", true);
		return "criterio/editar_form";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute CriterioModel criterioModel, Model model) {
		CriterioModel tm = this.criterioService.getCriterio(criterioModel.getId_Criterio());
		tm.setNome_Criterio(criterioModel.getNome_Criterio());
		tm.setPontuacao_min_Criterio(criterioModel.getPontuacao_min_Criterio());
		tm.setPontuacao_max_Criterio(criterioModel.getPontuacao_max_Criterio());
		criterioService.update(tm);
		return "redirect:/criterio/";
	}
	
	
	
}
