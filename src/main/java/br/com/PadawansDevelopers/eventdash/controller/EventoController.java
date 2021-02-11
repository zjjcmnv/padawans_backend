package br.com.PadawansDevelopers.eventdash.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.PadawansDevelopers.eventdash.dao.EventoDAO;
import br.com.PadawansDevelopers.eventdash.model.Evento;

@RestController
@CrossOrigin("*")
public class EventoController {
	@Autowired
	private EventoDAO dao;
	@GetMapping("/eventos")
	public ArrayList<Evento> listartudo(){
		ArrayList<Evento> lista;
		lista = (ArrayList<Evento>) dao.findAll();
		return lista;
	}
	
	@GetMapping("/buscarpordata")
	public ArrayList<Evento> buscarPorData(@RequestParam(name="inicio") String dataIni,
											@RequestParam(name="fim")String dataFim){
		LocalDate dtIni = LocalDate.parse(dataIni);
		LocalDate dtFim = LocalDate.parse(dataFim);
		
		ArrayList<Evento> Lista = dao.findAllByDataEventoBetween(dtIni, dtFim);
		return Lista;
		
	}

}
