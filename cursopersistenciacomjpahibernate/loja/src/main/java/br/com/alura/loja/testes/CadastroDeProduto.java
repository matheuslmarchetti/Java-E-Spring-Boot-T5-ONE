package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("8gb de RAM");
		celular.setPreco(new BigDecimal("800"));
		
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("loja_virtual_jpahibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(celular);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
