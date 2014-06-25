package com.ninja_squad.geektic.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.DAO.CentreInteretDao;
import com.ninja_squad.geektic.DAO.GeeksDao;
import com.ninja_squad.geektic.beans.Geek;

/**
 * This is example code for a DAO test.
 * 
 * @author JB Nizet
 */
public class GeeksDaoTest extends BaseDaoTest {

	// You can autowire the DAO to test here. For example:
	@Autowired
	private GeeksDao geeksDao;

	@Autowired
	private CentreInteretDao centreInteretDao;

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

	@Test
	public void finAlltest() {
		Assert.assertEquals(2, geeksDao.findAll().size());
	}

	@Test
	public void finAlltestEchec() {
		Assert.assertNotEquals(3, geeksDao.findAll().size());
	}

	@Test
	public void finByNomtest() {
		List<Geek> geeks = geeksDao.finByNom("deydier");
		Assert.assertEquals(1, geeks.size());
		Assert.assertEquals(geeks.get(0).getNom().toLowerCase(), "deydier");
	}

	@Test
	public void finByNomtestEchec() {
		List<Geek> geeks = geeksDao.finByNom("deydier");
		Assert.assertNotEquals(2, geeks.size());
		Assert.assertNotEquals(geeks.get(0).getNom().toLowerCase(), "ddeydier");
	}

	@Test
	public void finByCentreInteret() {

		List<Geek> geeks = geeksDao.findByCentreInteret(centreInteretDao
				.findById(2L));
		for (Geek geek : geeks) {
			System.out.println(geek.getNom());
		}
		Assert.assertEquals(1, geeks.size());
		Assert.assertEquals(geeks.get(0).getNom().toLowerCase(), "deydier");
	}
}
