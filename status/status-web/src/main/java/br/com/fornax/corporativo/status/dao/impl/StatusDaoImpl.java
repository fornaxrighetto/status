package br.com.fornax.corporativo.status.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.corporativo.status.dao.StatusDAO;
import br.com.fornax.corporativo.status.dao.entity.MaquinaEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class StatusDaoImpl implements StatusDAO {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<MaquinaEntity> listarMaquinas() {
		Query query = em.createQuery("select m from MaquinaEntity m");
		return query.getResultList();
	}

}
