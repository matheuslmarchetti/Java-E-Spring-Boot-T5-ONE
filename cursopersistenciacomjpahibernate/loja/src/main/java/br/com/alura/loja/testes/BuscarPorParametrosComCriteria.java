package br.com.alura.loja.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.ultil.JPAUtil;

public class BuscarPorParametrosComCriteria {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		List<Produto> buscarPorParametrosComCriteria = produtoDao.buscarPorParametrosComCriteria("PS5", null, null);
		System.out.println(buscarPorParametrosComCriteria);

	}

}
