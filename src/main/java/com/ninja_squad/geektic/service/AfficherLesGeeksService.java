package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.DAO.GeeksDao;
import com.ninja_squad.geektic.beans.Geek;

@RestController
@Transactional
@RequestMapping("/api/afficherLesGeeks")
public class AfficherLesGeeksService {

	@Autowired
	protected GeeksDao gd;

	@RequestMapping(method = GET)
	public List<Geek> afficherLesgeeks(@RequestParam("nom") String nom,
			@RequestParam("sexe") String sexe) {
		System.out.println(nom);
		List<Geek> geeks = new ArrayList<Geek>();

		/*
		 * geeks = gd.findAll();
		 * 
		 * geeks = gd.finByNom(nom);
		 */
		geeks = gd.findBysexe(sexe);

		System.out.println(sexe + "sexe");

		return geeks;
	}

	/*
	 * @RequestMapping(method = GET) public List<Geek> afficherLesgeeks() {
	 * 
	 * List<Geek> geeks = new ArrayList<Geek>(); geeks = gd.findAll(); for (Geek
	 * geek : geeks) { System.out.println(geek.getNom()); } return geeks; }
	 */

}
