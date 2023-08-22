package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.ultil.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		ClienteDao clienteDao = new ClienteDao(entityManager);
		Produto produto = produtoDao.buscarPorId(3l);
		Cliente cliente = clienteDao.buscarPorId(1l);
		
		entityManager.getTransaction().begin();
		
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		
		PedidoDao pedidoDao = new PedidoDao(entityManager);
		pedidoDao.cadastrar(pedido);
		
		entityManager.getTransaction().commit();
	}
	
	private static void popularBancoDeDados() {
		Cliente cliente = new Cliente("Matheus", "12345678");
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ClienteDao clienteDao = new ClienteDao(entityManager);
		
		entityManager.getTransaction().begin();
		clienteDao.cadastrar(cliente);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
