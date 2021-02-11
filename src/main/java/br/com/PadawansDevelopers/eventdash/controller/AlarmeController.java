package br.com.PadawansDevelopers.eventdash.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.PadawansDevelopers.eventdash.dao.AlarmeDAO;
import br.com.PadawansDevelopers.eventdash.model.Alarme;

@RestController
@CrossOrigin("*")
public class AlarmeController {
	@Autowired
	private AlarmeDAO dao;
	
	@GetMapping("/alarme")
	public ArrayList<Alarme> listartudo(){
		ArrayList<Alarme> lista;
		lista = (ArrayList<Alarme>) dao.findAll();
		return lista;
	}
	
}
