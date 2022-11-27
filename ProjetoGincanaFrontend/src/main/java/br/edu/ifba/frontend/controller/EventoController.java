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

import br.edu.ifba.frontend.model.EventoModel;
import br.edu.ifba.frontend.model.GincanaModel;
import br.edu.ifba.frontend.model.StatusModel;
import br.edu.ifba.frontend.service.EventoService;
import br.edu.ifba.frontend.service.GincanaService;
import br.edu.ifba.frontend.service.StatusService;
import br.edu.ifba.frontend.tela.EventoTelaModel;

@Controller
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private GincanaService gincanaService;
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("eventos_lista - init");
		List<EventoModel> list = this.eventoService.getEventos();
		model.addAttribute("eventos", list);
		return "evento/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form(Model model, Model model2) {
		GincanaService gincanaService = new GincanaService();
		List<GincanaModel> list = this.gincanaService.getGincanas();
		model.addAttribute("list_gincana", list);
		StatusService statusService = new StatusService();
		List<StatusModel> list2 = this.statusService.getListStatus();
		model2.addAttribute("list_status",list2);
		return "evento/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute EventoTelaModel eventoTelaModel, Model model, Model model2) {
		System.out.println("insert: " + eventoTelaModel.getNome_Evento());
		
		GincanaModel gm = new GincanaModel();
		gm.setId_Gincana(eventoTelaModel.getGincana());
		
		StatusModel sm = new StatusModel();
		sm.setId_Status(eventoTelaModel.getStatus());
		
	
		EventoModel em = new EventoModel();
		em.setNome_Evento(eventoTelaModel.getNome_Evento());
		em.setDescricao_Evento(eventoTelaModel.getDescricao_Evento());
		em.setTipo_Evento(eventoTelaModel.getTipo_Evento());
		em.setData_Evento(eventoTelaModel.getData_Evento());
		em.setHorario_Evento(eventoTelaModel.getHorario_Evento());
		em.setLocal_Evento(eventoTelaModel.getLocal_Evento());
		em.setGincana(gm);
		em.setStatus(sm);
		eventoService.insert(em);
		return "redirect:/evento/";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.eventoService.deleteEvento(id);
		return "redirect:/evento/";
	}
	
	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		EventoModel em = this.eventoService.getEvento(id);
		model.addAttribute("id", em.getId_Evento());
		model.addAttribute("descricao", em.getNome_Evento());
		model.addAttribute("descricao", em.getDescricao_Evento());
		model.addAttribute("descricao", em.getTipo_Evento());
		model.addAttribute("descricao", em.getData_Evento());
		model.addAttribute("descricao", em.getHorario_Evento());
		model.addAttribute("descricao", em.getLocal_Evento());
		model.addAttribute("readonly", true);
		return "tarefa/editar_form";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute EventoModel eventoModel, Model model) {
		EventoModel em = this.eventoService.getEvento(eventoModel.getId_Evento());
		em.setNome_Evento( eventoModel.getNome_Evento());
		em.setDescricao_Evento( eventoModel.getDescricao_Evento());
		em.setTipo_Evento( eventoModel.getTipo_Evento());
		em.setData_Evento( eventoModel.getData_Evento());
		em.setHorario_Evento( eventoModel.getHorario_Evento());
		em.setLocal_Evento( eventoModel.getLocal_Evento());
		eventoService.update(em);
		return "redirect:/evento/";
	}
	
	/*
	@GetMapping("/modificar_status/{id}")
	public String modificar_status(@PathVariable("id") Integer id) {
		EventoModel em = this.eventoService.getEvento(id);
		if (!.getStatus()) {
			tm.setData_conclusao( new Date(System.currentTimeMillis()) );
		}
		else {
			tm.setData_conclusao( null );
		}
		tm.setStatus( !tm.getStatus() );
		tarefaService.update(tm);
		return "redirect:/tarefa/";
	}
	*/
}
