package br.com.PadawansDevelopers.eventdash.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.PadawansDevelopers.eventdash.dao.UsuarioDAO;
import br.com.PadawansDevelopers.eventdash.model.NovaSenhaDTO;
import br.com.PadawansDevelopers.eventdash.model.usuario;

@CrossOrigin("*")
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ArrayList<usuario> recuperarTodos(){
		ArrayList<usuario> lista;
		lista = (ArrayList<usuario>)dao.findAll();
		return lista;
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<usuario> fazerLogin(@RequestBody usuario dados){
		usuario resultado = dao.findByEmailOrRacf(dados.getEmail(), dados.getRacf());
		if(resultado != null) {
			if(resultado.getSenha().equals(dados.getSenha())) {
				resultado.setSenha("***********");
				return ResponseEntity.ok(resultado);
			}
			return ResponseEntity.status(401).build();
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping("/novousuario")
	public ResponseEntity<usuario> cadastrar(@RequestBody usuario novo){
		usuario temp = dao.findByEmailOrRacf(novo.getEmail(), novo.getRacf());
		if(temp != null) {
			return ResponseEntity.status(400).build();
		}
		dao.save(novo);
		return ResponseEntity.status(201).body(novo);
	 }
	
	@PostMapping("/trocarsenha")
	public ResponseEntity<usuario> trocarsenha(@RequestBody NovaSenhaDTO alter){	
		usuario resultado = dao.findByEmailOrRacf(null, alter.getRacf());
		if(resultado != null) {
			if(resultado.getSenha().equals(alter.getSenhaantiga())){
				resultado.setSenha(alter.getSenhanova());
				dao.save(resultado);
				return ResponseEntity.status(200).body(resultado);
			}
		return ResponseEntity.status(403).build();
		}
		return ResponseEntity.notFound().build();
	}

}
