package br.ifba.tarefa.controller;

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

import br.ifba.tarefa.model.StatusModel;
import br.ifba.tarefa.service.StatusService;
import br.ifba.tarefa.service.TarefaService;

@Controller
@RequestMapping("/status")
public class StatusController {
	@Autowired
	private StatusService statusService;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("status_lista - init");
		List<StatusModel> list = this.statusService.getStatus();
		model.addAttribute("status", list);
		return "status/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form() {
		return "status/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute StatusModel statusModel, Model model) {
		System.out.println("insert: " + statusModel.getSituacao_status());
		StatusModel sm = new StatusModel();
		sm.setSituacao_status(statusModel.getSituacao_status());
		statusService.insert(sm);
		return "redirect:/status/";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.statusService.deleteStatus(id);
		return "redirect:/status/";
	}
	
	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		StatusModel sm = this.statusService.getStatus(id);
		model.addAttribute("id", sm.getId_status());
		model.addAttribute("situacao", sm.getSituacao_status());
		model.addAttribute("readonly", true);
		return "status/editar_form";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute StatusModel statusModel, Model model) {
		StatusModel sm = this.statusService.getStatus(statusModel.getId_status());
		sm.setSituacao_status( statusModel.getSituacao_status());
		statusService.update(sm);
		return "redirect:/status/";
	}
	
	/*
	@GetMapping("/modificar_status/{id}")
	public String modificar_status(@PathVariable("id") long id) {
		StatusModel sm = this.statusService.getStatus(id);
		if (!sm.getStatus()) {
			sm.setData_conclusao( new Date(System.currentTimeMillis()) );
		}
		else {
			sm.setData_conclusao( null );
		}
		sm.setStatus( !tm.getStatus() );
		statusService.update(sm);
		return "redirect:/status/";
	}
	*/
}
	
