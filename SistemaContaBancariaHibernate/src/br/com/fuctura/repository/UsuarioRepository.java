package br.com.fuctura.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.fuctura.entidade.Usuario;

public class UsuarioRepository {
	
	public void incluir(Usuario novoUsuario) {
		
		EntityTransaction transacao = em.getTransaction();

		transacao.begin();
		em.persist(novoUsuario);
		transacao.commit();
	}
	
	//incluir usuario
	//consultar 1 usuario
	//consultar todos os usuarios
	//alterar 1 usuario
	//excluir 1 usuario
}
