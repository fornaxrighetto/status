package br.com.fornax.corporativo.status.service;

import java.util.List;

import br.com.fornax.corporativo.status.model.Maquina;

public interface MaquinaService {
	public void cadastrar(Maquina maquina);
	
	public void editar(Maquina maquina);
	
	public List<Maquina> listarMaquinas();
	
	public void deletar(Maquina maquina);

	List<Maquina> status();

	void verificaConexao();

	Maquina statusConexao(String servico);

	void setMaquina(List<Maquina> maquina);
	
	public Maquina buscarMaquinaPorId(long id);
}
