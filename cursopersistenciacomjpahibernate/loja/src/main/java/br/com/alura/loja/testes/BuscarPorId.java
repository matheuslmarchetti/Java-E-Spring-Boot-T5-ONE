package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.ultil.JPAUtil;

public class BuscarPorId {

	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		
		Produto produto = produtoDao.buscarPorId(9l);
		System.out.println(produto.getNome() + " " + produto.getPreco());
	}
}
