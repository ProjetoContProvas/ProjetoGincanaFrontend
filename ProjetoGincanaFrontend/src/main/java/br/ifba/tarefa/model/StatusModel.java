package br.ifba.tarefa.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusModel {
	private Integer id_status;
	private String situacao_status;
	public Integer getId_status() {
		return id_status;
	}
	public void setId_status(Integer id_status) {
		this.id_status = id_status;
	}
	public String getSituacao_status() {
		return situacao_status;
	}
	public void setSituacao_status(String situacao_status) {
		this.situacao_status = situacao_status;
	}
	
	

	
	
}