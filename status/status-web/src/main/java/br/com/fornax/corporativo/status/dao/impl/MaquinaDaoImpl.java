package br.com.fornax.corporativo.status.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.corporativo.status.dao.MaquinaDAO;
import br.com.fornax.corporativo.status.dao.entity.MaquinaEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class MaquinaDaoImpl implements MaquinaDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrar(MaquinaEntity maquina) {
		em.persist(maquina);
	}

	@Override
	public void editar(MaquinaEntity maquina) {
		em.merge(maquina);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MaquinaEntity> listarMaquinas() {
		Query query = em.createQuery("select q from MaquinaEntity q");
		return query.getResultList();
	}

	@Override
	public void deletar(MaquinaEntity maquina) {
		em.remove(maquina);
	}

	@Override
	public MaquinaEntity buscarMaquinaPorId(long id) {
		Query query = em.createQuery("select u from MaquinaEntity u where u.id = :id");
		query.setParameter("id", id);
		if (!query.getResultList().isEmpty()) {
			return (MaquinaEntity) query.getSingleResult();
		}
		return null;
	}

}
