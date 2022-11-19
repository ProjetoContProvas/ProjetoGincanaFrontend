package br.ifba.frontend.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioModel {
	
	private Integer id_Usuario;
	private Integer id_Gincana;
	private String nome_Usuario;
	private String email_Usuario;
	private String senha_Usuario;
	private String sexo_Usuario;
	private Date data_cadastro_Usuario;
	
	
	public Integer getId_Usuario() {
		return id_Usuario;
	}
	public void setId_Usuario(Integer id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	public Integer getId_Gincana() {
		return id_Gincana;
	}
	public void setId_Gincana(Integer id_Gincana) {
		this.id_Gincana = id_Gincana;
	}
	public String getNome_Usuario() {
		return nome_Usuario;
	}
	public void setNome_Usuario(String nome_Usuario) {
		this.nome_Usuario = nome_Usuario;
	}
	public String getEmail_Usuario() {
		return email_Usuario;
	}
	public void setEmail_Usuario(String email_Usuario) {
		this.email_Usuario = email_Usuario;
	}
	public String getSenha_Usuario() {
		return senha_Usuario;
	}
	public void setSenha_Usuario(String senha_Usuario) {
		this.senha_Usuario = senha_Usuario;
	}
	public String getSexo_Usuario() {
		return sexo_Usuario;
	}
	public void setSexo_Usuario(String sexo_Usuario) {
		this.sexo_Usuario = sexo_Usuario;
	}
	public Date getData_cadastro_Usuario() {
		return data_cadastro_Usuario;
	}
	public void setData_cadastro_Usuario(Date data_cadastro_Usuario) {
		this.data_cadastro_Usuario = data_cadastro_Usuario;
	}
	
	@Override
	public String toString() {
		return "GincanaModel [id_Usuario=" + id_Usuario + ", id_Gincana=" + id_Gincana + ", nome_Usuario="
				+ nome_Usuario + ", email_Usuario=" + email_Usuario + ", senha_Usuario=" + senha_Usuario
				+ ", sexo_Usuario=" + sexo_Usuario + ", data_cadastro_Usuario=" + data_cadastro_Usuario + "]";
	}	
}