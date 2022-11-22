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

import br.edu.ifba.frontend.model.ImagemModel;
import br.edu.ifba.frontend.service.ImagemService;

@Controller
@RequestMapping("/imagem")
public class ImagemController {
	@Autowired
	private ImagemService service;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("imagem_lista - init");
		List<ImagemModel> list = this.service.getListImagem();
		model.addAttribute("imagem", list);
		return "imagem/index";
	}

	@GetMapping("/adicionar_form")
	public String adicionar_form() {
		return "imagem/adicionar_form";
	}
	
	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute ImagemModel imagemModel, Model model) {
		ImagemModel sm = new ImagemModel();
		sm.setURL_Imagem(imagemModel.getURL_Imagem());
		service.insert(sm);
		return "redirect:/imagem/";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		Boolean boo = this.service.deleteTarefa(id);
		return "redirect:/imagem/";
	}
	
	@GetMapping("/editar_form/{id}")
	public String editar_form(@PathVariable("id") Integer id, Model model) {
		ImagemModel sm = this.service.getImagem(id);
		model.addAttribute("id_Imagem", sm.getId_Imagem());
		model.addAttribute("URL_Imagem", sm.getURL_Imagem());
		return "imagem/editar_form";
	}
	
	@PostMapping("/editar")
	public String editar(@ModelAttribute ImagemModel imagemModel, Model model) {
		ImagemModel sm = this.service.getImagem(imagemModel.getId_Imagem());
		sm.setURL_Imagem( imagemModel.getURL_Imagem() );
		service.update(sm);
		return "redirect:/imagem/";
	}
	
}
