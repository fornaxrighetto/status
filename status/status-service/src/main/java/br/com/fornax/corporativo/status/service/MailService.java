package br.com.fornax.corporativo.status.service;

import br.com.fornax.corporativo.status.model.Maquina;


public interface MailService {
	public void enviaEmailConexaoFora(Maquina servico);
	public void enviaEmailConexaoEstabelecida(Maquina servico);
}
