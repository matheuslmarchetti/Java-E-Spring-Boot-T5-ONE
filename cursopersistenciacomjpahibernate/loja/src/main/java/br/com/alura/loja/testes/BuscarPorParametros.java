package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.ultil.JPAUtil;

public class BuscarPorParametros {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		produtoDao.buscarPorParametros("PS5",null ,null);
		

	}

}
