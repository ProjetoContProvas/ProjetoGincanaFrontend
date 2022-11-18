package br.ifba.tarefa.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EquipeModel {
	
	private Integer id_Equipe ;
	private String nome_Equipe ;
	private Integer id_Gincana ;
	private Integer id_Curso ;
	private Integer id_Usuario ;
	
	public Integer getId_Equipe() {
		return id_Equipe;
	}
	public void setId_Equipe(Integer id_Equipe) {
		this.id_Equipe = id_Equipe;
	}
	public String getNome_Equipe() {
		return nome_Equipe;
	}
	public void setNome_Equipe(String nome_Equipe) {
		this.nome_Equipe = nome_Equipe;
	}
	public Integer getId_Gincana() {
		return id_Gincana;
	}
	public void setId_Gincana(Integer id_Gincana) {
		this.id_Gincana = id_Gincana;
	}
	public Integer getId_Curso() {
		return id_Curso;
	}
	public void setId_Curso(Integer id_Curso) {
		this.id_Curso = id_Curso;
	}
	public Integer getId_Usuario() {
		return id_Usuario;
	}
	public void setId_Usuario(Integer id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	
	
	@Override
	public String toString() {
		return "EquipeModel [id_Equipe=" + id_Equipe + ", nome_Equipe=" + nome_Equipe + ", id_Gincana=" + id_Gincana
				+ ", id_Curso=" + id_Curso + ", id_Usuario=" + id_Usuario + "]";
	}
	
	
}