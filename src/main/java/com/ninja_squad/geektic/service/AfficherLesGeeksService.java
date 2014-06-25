package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.DAO.CentreInteretDao;
import com.ninja_squad.geektic.DAO.GeeksDao;
import com.ninja_squad.geektic.beans.CentreInteret;
import com.ninja_squad.geektic.beans.Geek;

@RestController
@Transactional
@RequestMapping("/api/afficherLesGeeks")
public class AfficherLesGeeksService {

	@Autowired
	protected GeeksDao gd;

	@Autowired
	protected CentreInteretDao cid;

	@RequestMapping(method = GET)
	public Set<Geek> afficherLesgeeks(
			@RequestParam(value = "nom", required = false) String nom,
			@RequestParam(value = "sexe", required = false) String sexe,
			@RequestParam(value = "centreInteret", required = false) Long centreInteret) {
		Set<Geek> geeks = new HashSet<Geek>();
		List<Geek> tmp = new ArrayList<Geek>();

		/*
		 * geeks = gd.findAll();
		 */
		System.out.println(sexe + nom);
		if (sexe != null && !sexe.isEmpty()) {
			tmp = gd.findBysexe(sexe);
			for (Geek geek : tmp) {
				geeks.add(geek);
			}
		}

		if (nom != null && !nom.isEmpty()) {
			tmp = gd.finByNom(nom);
			for (Geek geek : tmp) {
				geeks.add(geek);
			}
		}
		if (centreInteret != null) {
			CentreInteret ci = cid.findById(centreInteret);
			tmp = gd.findByCentreInteret(ci);
			for (Geek geek : tmp) {
				geeks.add(geek);
			}
		}
		return geeks;
	}
	/*
	 * @RequestMapping(method = GET) public List<Geek> afficherLesgeeks() {
	 * 
	 * List<Geek> geeks = new ArrayList<Geek>(); geeks = gd.findAll(); for (Geek
	 * geek : geeks) { System.out.println(geek.getNom()); } return geeks; }
	 */

}
