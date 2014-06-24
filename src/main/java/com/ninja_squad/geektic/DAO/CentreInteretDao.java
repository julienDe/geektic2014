package com.ninja_squad.geektic.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.beans.CentreInteret;

@Repository
public class CentreInteretDao {

	@PersistenceContext
	protected EntityManager em;

	public CentreInteretDao() {
	}

	public CentreInteret findById(Long id) {
		return em.find(CentreInteret.class, id);
	}

	public void persist(CentreInteret s) {
		em.persist(s);
		em.flush();
	}

	public List<CentreInteret> findAll() {
		String jpql = "select s from CentreInteret as s";
		TypedQuery<CentreInteret> query = em.createQuery(jpql,
				CentreInteret.class);
		return query.getResultList();
	}

}
