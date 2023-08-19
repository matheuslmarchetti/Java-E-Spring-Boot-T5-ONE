package br.com.alura.loja.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.ultil.JPAUtil;

public class BuscarTodos {

	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(produto -> System.out.println(produto.getNome()));
	}
}
