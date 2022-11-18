package br.ifba.tarefa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PerfilModel {
	private Integer id_Perfil;
	private String cargo_Perfil;
	
	
	

	public Integer getId_Perfil() {
		return id_Perfil;
	}
	public void setId_Perfil(Integer id_Perfil) {
		this.id_Perfil = id_Perfil;
	}
	public String getCargo_Perfil() {
		return cargo_Perfil;
	}
	public void setCargo_Perfil(String cargo_Perfil) {
		this.cargo_Perfil = cargo_Perfil;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId_Perfil() + " - " + getCargo_Perfil();  
	}
}