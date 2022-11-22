package br.edu.ifba.frontend.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GincanaModel {

	private Integer id_Gincana;
	private String nome_Gincana;
	private String descricao_Gincana;
	private Date data_inicio_Gincana;
	private Date data_fim_Gincana;
	private StatusModel statusModel;

	public GincanaModel() {
		super();
	}

	public StatusModel getStatusModel() {
		return statusModel;
	}

	public void setStatusModel(StatusModel statusModel) {
		this.statusModel = statusModel;
	}

	public GincanaModel(Integer id_Gincana, String nome_Gincana, String descricao_Gincana, Date data_inicio_Gincana,
			Date data_fim_Gincana, StatusModel statusModel) {
		super();
		this.id_Gincana = id_Gincana;
		this.nome_Gincana = nome_Gincana;
		this.descricao_Gincana = descricao_Gincana;
		this.data_inicio_Gincana = data_inicio_Gincana;
		this.data_fim_Gincana = data_fim_Gincana;
		this.statusModel = statusModel;
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

	@Override
	public String toString() {
		return "GincanaModel [id_Gincana=" + id_Gincana + ", nome_Gincana=" + nome_Gincana + ", descricao_Gincana="
				+ descricao_Gincana + ", data_inicio_Gincana=" + data_inicio_Gincana + ", data_fim_Gincana="
				+ data_fim_Gincana + ", status=" + statusModel + "]";
	}

}
