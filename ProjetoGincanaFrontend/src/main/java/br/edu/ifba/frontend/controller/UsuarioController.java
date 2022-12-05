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
import br.edu.ifba.frontend.model.PerfilModel;
import br.edu.ifba.frontend.model.UsuarioModel;
import br.edu.ifba.frontend.service.GincanaService;
import br.edu.ifba.frontend.service.PerfilService;
import br.edu.ifba.frontend.service.UsuarioService;
import br.edu.ifba.frontend.tela.GincanaTelaModel;
import br.edu.ifba.frontend.tela.UsuarioTelaModel;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private GincanaService gincanaService;

	@Autowired
	private PerfilService perfilService;

	@GetMapping("/")
	public String index(Model model) {
		System.out.println("usuarios_lista - init");
		List<UsuarioModel> list = this.usuarioService.getUsuarios();
		model.addAttribute("usuarios", list);
		return "usuario/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form(Model model) {
		List<GincanaModel> list = this.gincanaService.getGincanas();
		model.addAttribute("gincanas", list);
		List<PerfilModel> list2 = this.perfilService.getPerfis();
		model.addAttribute("perfis", list2);
		return "usuario/adicionar_form";
	}

	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute UsuarioTelaModel usuarioTelaModel, Model model) {

		GincanaModel gm = new GincanaModel();
		gm.setId_Gincana(usuarioTelaModel.getGincana());

		PerfilModel pm = new PerfilModel();
		pm.setId_Perfil(usuarioTelaModel.getPerfil());

		UsuarioModel tm = new UsuarioModel();

		tm.setNome_Usuario(usuarioTelaModel.getNome_Usuario());
		tm.setEmail_Usuario(usuarioTelaModel.getEmail_Usuario());
		tm.setSenha_Usuario(usuarioTelaModel.getSenha_Usuario());
		tm.setSexo_Usuario(usuarioTelaModel.getSexo_Usuario());
		tm.setData_cadastro_Usuario(new Date(System.currentTimeMillis()));
		tm.setGincana(gm);
		tm.setPerfil(pm);
		usuarioService.insert(tm);
		return "redirect:/usuario/";
	}

	@RequestMapping(value = "/deletar/{id_Usuario}", method = RequestMethod.GET)
	public String delete(@PathVariable("id_Usuario") Integer id_Usuario) {
		Boolean boo = this.usuarioService.deleteUsuario(id_Usuario);
		return "redirect:/usuario/";
	}

	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		
		
		UsuarioModel tm = this.usuarioService.getUsuario(id);
		
		
		
		model.addAttribute("id_Usuario", tm.getId_Usuario());
		model.addAttribute("nome_Usuario", tm.getNome_Usuario());
		model.addAttribute("email_Usuario", tm.getEmail_Usuario());
		model.addAttribute("senha_Usuario", tm.getSenha_Usuario());
		model.addAttribute("readonly", true);
		return "usuario/editar_form";
	}

	@PostMapping("/editar")
	public String editar(@ModelAttribute UsuarioTelaModel usuarioTelaModel, Model model) {
		PerfilModel pm = new PerfilModel();
		pm.setId_Perfil(usuarioTelaModel.getPerfil());
		GincanaModel gm = new GincanaModel();
		gm.setId_Gincana(usuarioTelaModel.getGincana());
		
		UsuarioModel um = new UsuarioModel();
		um.setNome_Usuario(usuarioTelaModel.getNome_Usuario());
		um.setEmail_Usuario(usuarioTelaModel.getEmail_Usuario());
		um.setSexo_Usuario(usuarioTelaModel.getSexo_Usuario());
		um.setSenha_Usuario(usuarioTelaModel.getSexo_Usuario());
		um.setPerfil(pm);
		um.setGincana(gm);
		
		usuarioService.update(um);
		return "redirect:/usuario/";
	}

	/*
	 * @GetMapping("/modificar_status/{id}") public String
	 * modificar_status(@PathVariable("id") Integer id) { UsuarioModel tm =
	 * this.usuarioService.getTarefa(id); if (!tm.getStatus()) {
	 * tm.setData_conclusao( new Date(System.currentTimeMillis()) ); } else {
	 * tm.setData_conclusao( null ); } tm.setStatus( !tm.getStatus() );
	 * usuarioService.update(tm); return "redirect:/tarefa/";
	 */
}
