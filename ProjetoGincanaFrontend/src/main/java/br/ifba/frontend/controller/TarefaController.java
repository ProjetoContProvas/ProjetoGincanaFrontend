package br.ifba.frontend.controller;

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

import br.ifba.frontend.model.TarefaModel;
import br.ifba.frontend.service.TarefaService;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {
	@Autowired
	private TarefaService tarefaService;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("tarefas_lista - init");
		List<TarefaModel> list = this.tarefaService.getTarefas();
		model.addAttribute("tarefas", list);
		return "tarefa/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form() {
		return "tarefa/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute TarefaModel tarefaModel, Model model) {
		System.out.println("insert: " + tarefaModel.getDescricao());
		TarefaModel tm = new TarefaModel();
		tm.setData_criacao( new Date(System.currentTimeMillis()) );
		tm.setDescricao( tarefaModel.getDescricao() );
		tm.setStatus(false);
		tarefaService.insert(tm);
		return "redirect:/tarefa/";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") long id) {
		Boolean boo = this.tarefaService.deleteTarefa(id);
		return "redirect:/tarefa/";
	}
	
	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") long id, Model model) {
		TarefaModel tm = this.tarefaService.getTarefa(id);
		model.addAttribute("id", tm.getId());
		model.addAttribute("descricao", tm.getDescricao());
		model.addAttribute("readonly", true);
		return "tarefa/editar_form";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute TarefaModel tarefaModel, Model model) {
		TarefaModel tm = this.tarefaService.getTarefa(tarefaModel.getId());
		tm.setDescricao( tarefaModel.getDescricao() );
		tarefaService.update(tm);
		return "redirect:/tarefa/";
	}
	
	@GetMapping("/modificar_status/{id}")
	public String modificar_status(@PathVariable("id") long id) {
		TarefaModel tm = this.tarefaService.getTarefa(id);
		if (!tm.getStatus()) {
			tm.setData_conclusao( new Date(System.currentTimeMillis()) );
		}
		else {
			tm.setData_conclusao( null );
		}
		tm.setStatus( !tm.getStatus() );
		tarefaService.update(tm);
		return "redirect:/tarefa/";
	}
}
