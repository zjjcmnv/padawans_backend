package br.com.PadawansDevelopers.eventdash.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.PadawansDevelopers.eventdash.model.usuario;

public interface UsuarioDAO extends CrudRepository<usuario, Integer>{

	public usuario findByEmailOrRacf(String email, String racf);
	
}
