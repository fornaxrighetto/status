package br.com.fornax.corporativo.status.dao.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MAQUINA")
public class MaquinaEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "IP")
	private String ip;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "URL")
	private String url;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_INICIO")
	private Calendar dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_FIM")
	private Calendar dataFim;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CADASTRO")
	private Calendar dataCadastro;
	
	@Column(name = "STARTED")
	private Boolean started = false;
	
	@Column(name = "ENVIAR_EMAIL")
	private Boolean enviarEmail;
	
	@Column(name = "TEMPO_DE_CONEXAO")
	private long tempoDeConexao;
	
	@Column(name = "QTD_ERROS")
	private int qtdErros;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
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
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Boolean getStarted() {
		return started;
	}
	public void setStarted(Boolean started) {
		this.started = started;
	}
	public Boolean getEnviarEmail() {
		return enviarEmail;
	}
	public void setEnviarEmail(Boolean enviaEmail) {
		this.enviarEmail = enviaEmail;
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
