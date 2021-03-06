package br.com.fornax.corporativo.status.dao;

import java.util.List;

import br.com.fornax.corporativo.status.dao.entity.MaquinaEntity;

public interface MaquinaDAO {
	public void cadastrar(MaquinaEntity maquina);
	
	public void editar(MaquinaEntity maquina);
	
	public List<MaquinaEntity> listarMaquinas();
	
	public void deletar(MaquinaEntity maquina);
	
	public MaquinaEntity buscarMaquinaPorId(long id);
	
	public void deletarMaquinaPorId(MaquinaEntity maquina);
}
