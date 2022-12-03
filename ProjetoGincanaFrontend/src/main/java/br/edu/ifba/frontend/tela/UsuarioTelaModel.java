package br.edu.ifba.frontend.tela;

import lombok.Data;

@Data
public class UsuarioTelaModel {

	private Integer id_Usuario;
	private String nome_Usuario;
	private String email_Usuario;
	private String senha_Usuario;
	private String sexo_Usuario;
	private Integer gincana;
	private Integer perfil;

	public UsuarioTelaModel() {
		super();
	}

	public UsuarioTelaModel(Integer id_Usuario, String nome_Usuario, String email_Usuario, String senha_Usuario,
			String sexo_Usuario, Integer gincana, Integer perfil) {
		super();
		this.id_Usuario = id_Usuario;
		this.nome_Usuario = nome_Usuario;
		this.email_Usuario = email_Usuario;
		this.senha_Usuario = senha_Usuario;
		this.sexo_Usuario = sexo_Usuario;
		this.gincana = gincana;
		this.perfil = perfil;
	}

	public Integer getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(Integer id_Usuario) {
		this.id_Usuario = id_Usuario;
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

	public Integer getGincana() {
		return gincana;
	}

	public void setGincana(Integer gincana) {
		this.gincana = gincana;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "UsuarioTelaModel [id_Usuario=" + id_Usuario + ", nome_Usuario=" + nome_Usuario + ", email_Usuario="
				+ email_Usuario + ", senha_Usuario=" + senha_Usuario + ", sexo_Usuario=" + sexo_Usuario + ", gincana="
				+ gincana + ", perfil=" + perfil + "]";
	}

}
