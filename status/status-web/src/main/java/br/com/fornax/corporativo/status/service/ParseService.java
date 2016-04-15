package br.com.fornax.corporativo.status.service;

import br.com.fornax.corporativo.status.dao.entity.MaquinaEntity;
import br.com.fornax.corporativo.status.model.Maquina;

public interface ParseService {
	MaquinaEntity parseToEntity(Maquina maquina);
	
	Maquina parseToModel(MaquinaEntity entity);
}
