package br.com.fornax.corporativo.status.service;

import java.util.List;

import br.com.fornax.corporativo.status.model.Maquina;

public interface StatusService {
	Maquina statusConexao(String servico);
	
	public List<Maquina> status();
}
