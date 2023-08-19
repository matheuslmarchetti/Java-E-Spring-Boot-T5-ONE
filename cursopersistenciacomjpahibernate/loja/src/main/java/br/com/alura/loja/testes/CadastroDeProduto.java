package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.ultil.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		cadastrarProduto();
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		
		Produto produto = produtoDao.buscarPorId(1l);
		System.out.println(produto.getPreco());
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(p -> System.out.println(p.getNome()));
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "12gb de RAM", new BigDecimal("1200"), celulares);
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		CategoriaDao categoriaDao = new CategoriaDao(entityManager);
		
		entityManager.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
