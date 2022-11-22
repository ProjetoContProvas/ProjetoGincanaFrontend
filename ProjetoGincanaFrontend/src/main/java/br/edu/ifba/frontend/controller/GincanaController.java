package br.edu.ifba.frontend.controller;

import java.sql.Date;
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

import br.edu.ifba.frontend.model.GincanaModel;
import br.edu.ifba.frontend.service.GincanaService;


@Controller
@RequestMapping(value = "/gincana")
public class GincanaController {
	
	@Autowired
	private GincanaService gincanaService;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("gincanas_lista - init");
		List<GincanaModel> list = this.gincanaService.getGincanas();
		System.out.println(list);
		model.addAttribute("gincanas", list);
		return "gincana/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form() {
		return "gincana/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute GincanaModel gincanaModel, Model model) {
		System.out.println("insert: " + gincanaModel.getDescricao_Gincana());
		GincanaModel gm = new GincanaModel();
		gm.setNome_Gincana(gincanaModel.getNome_Gincana());
		gm.setDescricao_Gincana(gincanaModel.getDescricao_Gincana());
		gm.setData_inicio_Gincana(new Date(System.currentTimeMillis()));
		gm.setData_fim_Gincana(new Date(System.currentTimeMillis()));
		gm.setStatusModel(gincanaModel.getStatusModel());
		gincanaService.insert(gm);
		return "redirect:/gincana/";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.gincanaService.deleteGincana(id);
		return "redirect:/gincana/";
	}
	
	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		GincanaModel gm = this.gincanaService.getGincana(id);
		model.addAttribute("id_gincana", gm.getId_Gincana());
		model.addAttribute("nome_Gincana", gm.getNome_Gincana());
		model.addAttribute("descricao_Gincana", gm.getData_inicio_Gincana());
		model.addAttribute("data_inicio_Gincana", gm.getData_fim_Gincana());
		model.addAttribute("readonly", true);
		return "tarefa/editar_form";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute GincanaModel gincanaModel, Model model) {
		GincanaModel gm = this.gincanaService.getGincana(gincanaModel.getId_Gincana());
		gm.setNome_Gincana(gincanaModel.getNome_Gincana());
		gm.setDescricao_Gincana(gincanaModel.getDescricao_Gincana());
		gm.setData_inicio_Gincana(gincanaModel.getData_inicio_Gincana());
		gm.setData_fim_Gincana(gincanaModel.getData_fim_Gincana());
		gm.setStatusModel(gincanaModel.getStatusModel());
		gincanaService.update(gm);
		return "redirect:/tarefa/";
	}
	
	/*@PostMapping("/editar_status")
	public String editar(@ModelAttribute GincanaTelaModel tarefaTelaModel, Model model) {
		System.out.println("Tarefa - modificar - insert: " + tarefaTelaModel);
		StatusModel sm = new StatusModel();
		sm.setId_status(tarefaTelaModel.getId_status());
		
		TarefaModel tm = this.tarefaService.getTarefa(tarefaTelaModel.getId());
		tm.setDescricao( tarefaTelaModel.getDescricao() );
		tm.setStatus( sm );
		tarefaService.update(tm);
		return "redirect:/tarefa/";
	}*/

}
