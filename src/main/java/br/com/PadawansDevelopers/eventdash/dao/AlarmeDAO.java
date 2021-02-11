package br.com.PadawansDevelopers.eventdash.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.PadawansDevelopers.eventdash.model.Alarme;

public interface AlarmeDAO extends CrudRepository<Alarme, Integer> {
	
}
