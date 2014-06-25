package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.DAO.GeeksDao;
import com.ninja_squad.geektic.beans.Geek;

@RestController
@Transactional
@RequestMapping("/api/afficherTousLesGeeks")
public class AfficherTousLesGeeksService {

	@Autowired
	protected GeeksDao gd;

	@RequestMapping(method = GET)
	public List<Geek> afficherLesgeeks() {
		List<Geek> geeks = new ArrayList<Geek>();

		geeks = gd.findAll();

		return geeks;
	}

}
