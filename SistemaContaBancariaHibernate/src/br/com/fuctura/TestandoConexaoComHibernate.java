package br.com.fuctura;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fuctura.entidade.Usuario;
import br.com.fuctura.repository.UsuarioRepository;

public class TestandoConexaoComHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Fuctura-PU");
		EntityManager em = fabrica.createEntityManager();

		Usuario novoUsuario = new Usuario();
		novoUsuario.setNome("Tom Miguel");
		novoUsuario.setIdade(80);
		novoUsuario.setEmail("2025@gmail.com");

		UsuarioRepository usuRepo = new UsuarioRepository();
				
		usuRepo.incluir(novoUsuario);		
		

		Usuario usuarioDaBase = em.find(Usuario.class, "egmail");

		if (usuarioDaBase != null) {
			System.out.println("Nome: " + usuarioDaBase.getNome());
		}

		List<Usuario> resultado = consultar(em);

		em.close();
		fabrica.close();
	}

	public static List<Usuario> consultar(EntityManager em) {
		return em.createQuery("SELECT u " + "FROM Usuario u " + "WHERE u.nome like :nome")
				.setParameter("nome", "Tom Miguel")
				.getResultList();
	}

}
