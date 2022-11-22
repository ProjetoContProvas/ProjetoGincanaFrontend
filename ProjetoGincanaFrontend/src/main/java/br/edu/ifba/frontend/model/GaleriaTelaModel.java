package br.edu.ifba.frontend.model;

public class GaleriaTelaModel {
	private int id_Galeria;
	private String nome_Galeria ;
	private String descricao_Galeria;
	private GaleriaModel galeria;
	
	public GaleriaTelaModel() {
		
	}

	public GaleriaTelaModel(int id_Galeria, String nome_Galeria, String descricao_Galeria, GaleriaModel galeria) {
		this.id_Galeria = id_Galeria;
		this.nome_Galeria = nome_Galeria;
		this.descricao_Galeria = descricao_Galeria;
		this.galeria = galeria;
	}

	public int getId_Galeria() {
		return id_Galeria;
	}

	public void setId_Galeria(int id_Galeria) {
		this.id_Galeria = id_Galeria;
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

	public GaleriaModel getGaleria() {
		return galeria;
	}

	public void setGaleria(GaleriaModel galeria) {
		this.galeria = galeria;
	}

	@Override
	public String toString() {
		return "GincanaTelaModel [id_Galeria=" + id_Galeria + ", nome_Galeria=" + nome_Galeria + ", descricao_Galeria="
				+ descricao_Galeria + ", galeria=" + galeria + "]";
	}
	


}
