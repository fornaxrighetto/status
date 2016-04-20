package br.com.fornax.corporativo.status.dao;

import java.util.List;

import br.com.fornax.corporativo.status.dao.entity.MaquinaEntity;

public interface StatusDAO {
	public List<MaquinaEntity> listarMaquinas();
}
