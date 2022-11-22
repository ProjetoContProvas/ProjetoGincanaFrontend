package br.edu.ifba.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagemModel {
	private Integer id_Imagem;
	private String URL_Imagem;
	private GaleriaModel galeria;

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

	public GaleriaModel getGaleria() {
		return galeria;
	}

	public void setGaleria(GaleriaModel galeria) {
		this.galeria = galeria;
	}

	@Override
	public String toString() {
		return "ImagemModel [id_Imagem=" + id_Imagem + ", URL_Imagem=" + URL_Imagem + ", galeria=" + galeria + "]";
	}

}
