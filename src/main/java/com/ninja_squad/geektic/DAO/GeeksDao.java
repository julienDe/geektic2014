package com.ninja_squad.geektic.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.beans.CentreInteret;
import com.ninja_squad.geektic.beans.Geek;

@Repository
public class GeeksDao {

	@PersistenceContext
	protected EntityManager em;

	public List<Geek> findAll() {
		String jpql = "select s from Geek as s";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		return query.getResultList();
	}

	public List<Geek> finByNom(String nom) {
		String jpql = "select s from Geek as s where lower(s.nom)=:nom";

		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		return query.setParameter("nom", nom.toLowerCase()).getResultList();
	}

	public List<Geek> findByCentreInteret(CentreInteret centreInteret) {
		String jpql = "select distinct g from Geek as g left join fetch g.centresInteret inner join g.centresInteret as ci where ci=:centreInteret";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		return query.setParameter("centreInteret", centreInteret)
				.getResultList();
	}

	public List<Geek> findBysexe(String sexe) {
		String jpql = "select s from Geek as s where lower(s.sexe)=:sexe";

		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		return query.setParameter("sexe", sexe.toLowerCase()).getResultList();
	}

	public List<Geek> findById(Long id) {
		String jpql = "select s from Geek as s where s.id=:id";

		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		return query.setParameter("id", id).getResultList();
	}

}
