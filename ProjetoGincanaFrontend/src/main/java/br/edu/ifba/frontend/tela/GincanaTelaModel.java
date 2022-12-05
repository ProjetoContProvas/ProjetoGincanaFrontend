package br.edu.ifba.frontend.tela;

import java.sql.Date;

import lombok.Data;

@Data
public class GincanaTelaModel {

	private Integer id_Gincana;
	private String nome_Gincana;
	private String descricao_Gincana;
	private Date data_inicio_Gincana;
	private Date data_fim_Gincana;
	private Integer id_Status;

	public GincanaTelaModel() {
		super();
	}

	public GincanaTelaModel(Integer id_Gincana, String nome_Gincana, String descricao_Gincana, Date data_inicio_Gincana,
			Date data_fim_Gincana, Integer id_Status) {
		super();
		this.id_Gincana = id_Gincana;
		this.nome_Gincana = nome_Gincana;
		this.descricao_Gincana = descricao_Gincana;
		this.data_inicio_Gincana = data_inicio_Gincana;
		this.data_fim_Gincana = data_fim_Gincana;
		this.id_Status = id_Status;
	}

	public Integer getId_Gincana() {
		return id_Gincana;
	}

	public void setId_Gincana(Integer id_Gincana) {
		this.id_Gincana = id_Gincana;
	}

	public String getNome_Gincana() {
		return nome_Gincana;
	}

	public void setNome_Gincana(String nome_Gincana) {
		this.nome_Gincana = nome_Gincana;
	}

	public String getDescricao_Gincana() {
		return descricao_Gincana;
	}

	public void setDescricao_Gincana(String descricao_Gincana) {
		this.descricao_Gincana = descricao_Gincana;
	}

	public Date getData_inicio_Gincana() {
		return data_inicio_Gincana;
	}

	public void setData_inicio_Gincana(Date data_inicio_Gincana) {
		this.data_inicio_Gincana = data_inicio_Gincana;
	}

	public Date getData_fim_Gincana() {
		return data_fim_Gincana;
	}

	public void setData_fim_Gincana(Date data_fim_Gincana) {
		this.data_fim_Gincana = data_fim_Gincana;
	}



	public Integer getId_Status() {
		return id_Status;
	}

	public void setId_Status(Integer id_Status) {
		this.id_Status = id_Status;
	}

	@Override
	public String toString() {
		return "GincanaTelaModel [id_Gincana=" + id_Gincana + ", nome_Gincana=" + nome_Gincana + ", descricao_Gincana="
				+ descricao_Gincana + ", data_inicio_Gincana=" + data_inicio_Gincana + ", data_fim_Gincana="
				+ data_fim_Gincana + ", id_Status=" + id_Status + "]";
	}

}
