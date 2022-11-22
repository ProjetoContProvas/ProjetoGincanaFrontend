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

import br.edu.ifba.frontend.model.UsuarioModel;
import br.edu.ifba.frontend.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("usuarios_lista - init");
		List<UsuarioModel> list = this.usuarioService.getUsuarios();
		model.addAttribute("usuario", list);
		return "usuario/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form() {
		return "usuario/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute UsuarioModel usuarioModel, Model model) {
		System.out.println("adicionar nome: " + usuarioModel.getNome_Usuario());
		System.out.println("adicionar e-mail: " + usuarioModel.getEmail_Usuario());
		System.out.println("adicioanr senha: " + usuarioModel.getSenha_Usuario());
		System.out.println("adicionar sexo: " + usuarioModel.getSexo_Usuario());	
		System.out.println("adicionar data de cadastro: " + usuarioModel.getData_cadastro_Usuario());
		UsuarioModel tm = new UsuarioModel();
	
		tm.setNome_Usuario(usuarioModel.getNome_Usuario());
		tm.setEmail_Usuario(usuarioModel.getEmail_Usuario());
		tm.setSenha_Usuario(usuarioModel.getSenha_Usuario());
		tm.setSexo_Usuario(usuarioModel.getSexo_Usuario());
		tm.setData_cadastro_Usuario( new Date(System.currentTimeMillis()) );
		
		usuarioService.insert(tm);
		return "redirect:/usuario/";
	}
	
	@RequestMapping(value="/deletar/{id_Usuario}", method=RequestMethod.GET)
	public String delete(@PathVariable("id_Usuario") Integer id_Usuario) {
		Boolean boo = this.usuarioService.deleteUsuario(id_Usuario);
		return "redirect:/usuario/";
	}
	
	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		UsuarioModel tm = this.usuarioService.getUsuario(id);
		model.addAttribute("Modificar id do usuário", tm.getId_Usuario());
		model.addAttribute("Modificar e-mail do usuário", tm.getEmail_Usuario());
		model.addAttribute("Modificar nome do usuário", tm.getNome_Usuario());
		model.addAttribute("Modificar senha do usuário", tm.getSenha_Usuario());
		model.addAttribute("readonly", true);
		return "usuario/editar_form";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute UsuarioModel usuarioModel, Model model) {
		UsuarioModel tm = this.usuarioService.getUsuario(usuarioModel.getId_Usuario());
		usuarioService.update(tm);
		return "redirect:/usuario/";
	}
	
	/*@GetMapping("/modificar_status/{id}")
	public String modificar_status(@PathVariable("id") Integer id) {
		UsuarioModel tm = this.usuarioService.getTarefa(id);
		if (!tm.getStatus()) {
			tm.setData_conclusao( new Date(System.currentTimeMillis()) );
		}
		else {
			tm.setData_conclusao( null );
		}
		tm.setStatus( !tm.getStatus() );
		usuarioService.update(tm);
		return "redirect:/tarefa/";
		*/
	}

