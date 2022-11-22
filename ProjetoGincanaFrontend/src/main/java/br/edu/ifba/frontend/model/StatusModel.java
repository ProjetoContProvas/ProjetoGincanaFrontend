package br.edu.ifba.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

	@Override
	public String toString() {
		return "StatusModel [id_status=" + id_status + ", situacao_status=" + situacao_status + "]";
	}

}