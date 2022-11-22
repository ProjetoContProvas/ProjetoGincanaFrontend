package br.edu.ifba.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GaleriaModel {

	private Integer id_Galeria;
	private String nome_Galeria;
	private String descricao_Galeria;
	private GincanaModel gincana;

	public Integer getId() {
		return id_Galeria;
	}

	public void setId(Integer id) {
		this.id_Galeria = id;
	}

	public String getNome_Galeria() {
		return nome_Galeria;
	}

	public void setNome_Galeria(String nome_Galeria) {
		this.nome_Galeria = nome_Galeria;
	}

	public String getDescricao_Galeria() {
		return descricao_Galeria;
	}

	public void setDescricao_Galeria(String descricao_Galeria) {
		this.descricao_Galeria = descricao_Galeria;
	}

	public GincanaModel getGincana() {
		return gincana;
	}

	public void setGincana(GincanaModel gincana) {
		this.gincana = gincana;
	}

	@Override
	public String toString() {
		return "GaleriaModel [id=" + id_Galeria + ", nome_Galeria=" + nome_Galeria + ", descricao_Galeria=" + descricao_Galeria
				+ ", gincana=" + gincana + "]";
	}

}
