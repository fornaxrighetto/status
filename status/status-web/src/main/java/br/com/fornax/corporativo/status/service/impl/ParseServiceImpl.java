package br.com.fornax.corporativo.status.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.corporativo.status.dao.entity.MaquinaEntity;
import br.com.fornax.corporativo.status.model.Maquina;
import br.com.fornax.corporativo.status.service.ParseService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ParseServiceImpl implements ParseService {

	@Override
	public MaquinaEntity parseToEntity(Maquina maquina) {
		MaquinaEntity maquinaEn = null;
		if(maquina != null){
			maquinaEn = new MaquinaEntity();
			maquinaEn.setId(maquina.getId());
			maquinaEn.setNome(maquina.getNome());
			maquinaEn.setIp(maquina.getIp());
			maquinaEn.setStatus(maquina.getStatus());
			maquinaEn.setUrl(maquina.getUrl());
			maquinaEn.setDataInicio(maquina.getDataInicio());
			maquinaEn.setDataFim(maquina.getDataFim());
			maquinaEn.setDataCadastro(maquina.getDataCadastro());
			maquinaEn.setStarted(maquina.getStarted());
			maquinaEn.setEnviarEmail(maquina.getEnviarEmail());
			maquinaEn.setTempoDeConexao(maquina.getTempoDeConexao());
			maquinaEn.setQtdErros(maquina.getQtdErros());
		}
		return maquinaEn;
	}

	@Override
	public Maquina parseToModel(MaquinaEntity entity) {
		Maquina maquina = null;
		if(entity != null){
			maquina = new Maquina();
			maquina.setId(entity.getId());
			maquina.setNome(entity.getNome());
			maquina.setIp(entity.getIp());
			maquina.setStatus(entity.getStatus());
			maquina.setUrl(entity.getUrl());
			maquina.setDataInicio(entity.getDataInicio());
			maquina.setDataFim(entity.getDataFim());
			maquina.setDataCadastro(entity.getDataCadastro());
			maquina.setStarted(entity.getStarted());
			maquina.setEnviarEmail(entity.getEnviarEmail());
			maquina.setTempoDeConexao(entity.getTempoDeConexao());
			maquina.setQtdErros(entity.getQtdErros());
		}
		return maquina;
	}

}
