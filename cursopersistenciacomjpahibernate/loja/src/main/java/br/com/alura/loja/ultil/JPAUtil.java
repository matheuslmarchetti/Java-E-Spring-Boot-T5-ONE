package br.com.alura.loja.ultil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = 
			Persistence.createEntityManagerFactory("loja_virtual_jpahibernate");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
