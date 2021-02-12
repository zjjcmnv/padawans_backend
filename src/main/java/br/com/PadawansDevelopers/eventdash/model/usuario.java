package br.com.PadawansDevelopers.eventdash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* O objetivo desta classe é mapear a própria estrutura da classe Usuario
 * à estrutura da tabela itmn_usuario
 * Quais são os requisitos?
 * 		- a classe terá a mesma quantidade de atributos da tabela
 * 		- faremos a equivalência a cada um dos atributos
 */
@Entity  // a classe usuário é armazenável em banco
@Table(name="itmn_usuario") // especifico o nome da tabela

public class usuario {
	
	@Column(name="id_usuario")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome_usuario", length = 100, nullable = false)
	private String nome;
	
	@Column(name="email_usuario",length= 100, nullable = false, unique = true)
	private String email;
	
	@Column(name="racf_usuario", length = 7 , nullable = false, unique = true)
	private String racf;
	
	@Column(name="senha_usuario", length = 50, nullable = false)
	private String senha;
	
	@Column(name="ramal_usuario",length = 10)
	private String ramal;
	
	@Column(name="link_foto",length = 255)
	private String linkFoto;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	

}
