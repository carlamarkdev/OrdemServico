package com.carla.os.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import com.carla.os.domain.enuns.Prioridade;
import ch.qos.logback.core.status.Status;

public class OS {
	private Integer id;
	private LocalDateTime dataAbertura;
	private LocalDateTime dataFechamento;
	private Prioridade prioridade;
	private String observacoes;
	private Status status;
	private Tecnico tecnico;
	private Cliente cliente;
	
	public OS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OS(Integer id, LocalDateTime dataAbertura, LocalDateTime dataFechamento, Prioridade prioridade,
			String observacoes, Status status, Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.prioridade = prioridade;
		this.observacoes = observacoes;
		this.status = status;
		this.tecnico = tecnico;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OS other = (OS) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
