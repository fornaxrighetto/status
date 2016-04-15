package br.com.fornax.corporativo.status.model;

import java.util.Calendar;

public class Maquina {
	private long id;
	private String nome;
	private String ip;
	private String status;
	private String url;
	private Calendar dataInicio;
	private Calendar dataFim;
	private Calendar dataCadastro;
	private Boolean started = false;
	private Boolean enviarEmail;
	private long tempoDeConexao;
	private int qtdErros;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getEnviarEmail() {
		return enviarEmail;
	}

	public void setEnviarEmail(Boolean enviaEmail) {
		this.enviarEmail = enviaEmail;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public Boolean getStarted() {
		return started;
	}

	public void setStarted(Boolean started) {
		this.started = started;
	}

	public long getTempoDeConexao() {
		return tempoDeConexao;
	}

	public void setTempoDeConexao(long tempoDeConexao) {
		this.tempoDeConexao = tempoDeConexao;
	}

	public int getQtdErros() {
		return qtdErros;
	}

	public void setQtdErros(int qtdErros) {
		this.qtdErros = qtdErros;
	}

}