package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.DAO.CentreInteretDao;
import com.ninja_squad.geektic.beans.CentreInteret;

@RestController
@Transactional
@RequestMapping("/api/afficherCentreInteret")
public class AfficherCentresInteretsService {

	@Autowired
	protected CentreInteretDao cid;

	@RequestMapping(method = GET)
	public List<CentreInteret> sayHello() {

		List<CentreInteret> centreInterets = new ArrayList<CentreInteret>();

		centreInterets = cid.findAll();
		System.out.println("test");

		for (CentreInteret centreInteret : centreInterets) {
			System.out.println(centreInteret.getNom());
		}
		return centreInterets;
	}
}
