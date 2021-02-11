package br.com.PadawansDevelopers.eventdash.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.PadawansDevelopers.eventdash.model.Evento;

public interface EventoDAO extends CrudRepository<Evento,Integer>{
		public ArrayList<Evento> findAllByDataEventoBetween(LocalDate inicio,LocalDate fim);
		
}
