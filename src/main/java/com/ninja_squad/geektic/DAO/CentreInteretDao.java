package com.ninja_squad.geektic.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.springframework.stereotype.Repository;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.beans.CentreInteret;
import com.ninja_squad.geektic.dao.BaseDaoTest;

@Repository
public class CentreInteretDao extends BaseDaoTest {

	@Before
	public void populateDatabase() {

		Operation operation = Operations.sequenceOf(); // TODO define your
														// operations here.
		Operations.deleteAllFrom("GEEK_CENTRE_INTERET");
		Operations.deleteAllFrom("GEEK");
		Operations.deleteAllFrom("CENTRE_INTERET");
		Operations
				.insertInto("geek")
				.columns("NOM", "PRENOM", "MAIL", "SEXE", "COULEURCHEVEUX",
						"COULEURYEUX", "TAILLE", "POIDS")
				.values("Jouve", "Julien", "juliendeydier@gmail.com", "M",
						"Brun", "Marron, Vert", 170, 60)
				.values("Deydier", "Julien", "juliendeydier@gmail.com", "M",
						"Brun", "Marron, Vert", 170, 60);
		Operations.insertInto("CENTRE_INTERET").columns("NOM").values("boxe")
				.values("tennis").values("java");
		Operations.insertInto("GEEK_CENTRE_INTERET")
				.columns("IDGEEK", "IDCENTREINTERET").values(0, 1).values(0, 2);
		DbSetup dbSetup = new DbSetup(destination, operation);
		dbSetup.launch();
	}

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
