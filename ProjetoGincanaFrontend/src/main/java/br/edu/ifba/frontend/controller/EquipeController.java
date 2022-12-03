package br.edu.ifba.frontend.controller;

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

import br.edu.ifba.frontend.model.CursoModel;
import br.edu.ifba.frontend.model.EquipeModel;
import br.edu.ifba.frontend.model.GincanaModel;
import br.edu.ifba.frontend.model.UsuarioModel;
import br.edu.ifba.frontend.service.CursoService;
import br.edu.ifba.frontend.service.EquipeService;
import br.edu.ifba.frontend.service.GincanaService;
import br.edu.ifba.frontend.service.UsuarioService;
import br.edu.ifba.frontend.tela.EquipeTelaModel;

@Controller
@RequestMapping("/equipe")
public class EquipeController {
	
	@Autowired
	private EquipeService equipeService;

	@Autowired
	private GincanaService gincanaService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("equipes_lista - init");
		List<EquipeModel> list = this.equipeService.getEquipes();
		model.addAttribute("equipes", list);
		return "equipe/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form(Model model) {
		List<GincanaModel> list = this.gincanaService.getGincanas();
		List<CursoModel> list1 = this.cursoService.getCursos();
		List<UsuarioModel> list2 = this.usuarioService.getUsuarios();
		model.addAttribute("gincanas",list);
		model.addAttribute("cursos", list1);
		model.addAttribute("usuarios", list2);
		return "equipe/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute EquipeTelaModel equipeTelaModel, Model model) {
		GincanaModel gm = new GincanaModel();
		gm.setId_Gincana(equipeTelaModel.getGincana());
		
		CursoModel cm = new CursoModel();
		cm.setId_Curso(equipeTelaModel.getCurso());
		
		UsuarioModel um = new UsuarioModel();
		um.setId_Usuario(equipeTelaModel.getUsuario());
		
		
		EquipeModel em = new EquipeModel();
		em.setNome_Equipe( equipeTelaModel.getNome_Equipe() );
		em.setDescricao_Equipe(equipeTelaModel.getDescricao_Equipe());
		em.setGincana(gm);
		em.setCurso(cm);
		em.setUsuario(um);
		equipeService.insert(em);
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
	
	@GetMapping("/dashboard_equipe")
	public String dashboard_equipe() {
		return "/equipe/dashboard_equipe";
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
