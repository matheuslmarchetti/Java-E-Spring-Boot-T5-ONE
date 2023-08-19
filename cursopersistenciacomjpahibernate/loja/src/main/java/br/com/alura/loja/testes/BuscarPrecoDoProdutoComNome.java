package br.com.alura.loja.testes;

import java.math.BigDecimal;
import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.ultil.JPAUtil;

public class BuscarPrecoDoProdutoComNome {

	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		
		BigDecimal precodoProduto = produtoDao.buscarPrecoDoProdutoComNome("Samsung Galaxy S");
		System.out.println("Preço do Produto: " + precodoProduto);
	}
}
