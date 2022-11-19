package br.ifba.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImagemModel {
	private Integer id_Imagem;
	private String URL_Imagem;
	private Integer Galeria_id_Galeria;
	
	public Integer getId_Imagem() {
		return id_Imagem;
	}
	public void setId_Imagem(Integer id_Imagem) {
		this.id_Imagem = id_Imagem;
	}
	public String getURL_Imagem() {
		return URL_Imagem;
	}
	public void setURL_Imagem(String URL_Imagem) {
		this.URL_Imagem = URL_Imagem;
	}
	
	public Integer getGaleria_id_Galeria() {
		return Galeria_id_Galeria;
	}
	public void setGaleria_id_Galeria(Integer Galeria_id_Galeria) {
		this.Galeria_id_Galeria = Galeria_id_Galeria;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId_Imagem() + " - " + getURL_Imagem() + " - " + getGaleria_id_Galeria();  
	}
}

