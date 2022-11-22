package br.edu.ifba.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusModel {
	private Integer id_status;
	private String situacao_Status;

	public StatusModel() {
		super();
	}

	public StatusModel(Integer id_status, String situacao_Status) {
		super();
		this.id_status = id_status;
		this.situacao_Status = situacao_Status;
	}

	public Integer getId_status() {
		return id_status;
	}

	public void setId_status(Integer id_status) {
		this.id_status = id_status;
	}

	public String getSituacao_Status() {
		return situacao_Status;
	}

	public void setSituacao_Status(String situacao_Status) {
		this.situacao_Status = situacao_Status;
	}

	@Override
	public String toString() {
		return "StatusModel [id_status=" + id_status + ", situacao_Status=" + situacao_Status + "]";
	}

}