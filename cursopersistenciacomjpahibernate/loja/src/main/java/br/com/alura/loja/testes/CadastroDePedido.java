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
		Produto produto10 = produtoDao.buscarPorId(10l);
		Produto produto11 = produtoDao.buscarPorId(11l);
		Produto produto12 = produtoDao.buscarPorId(12l);
		Cliente cliente = clienteDao.buscarPorId(3l);
		
		entityManager.getTransaction().begin();
		
		
		Pedido pedido3 = new Pedido(cliente);
		pedido3.adicionarItem(new ItemPedido(10, pedido3, produto10));
		pedido3.adicionarItem(new ItemPedido(20, pedido3, produto11));
		
		Pedido pedido4 = new Pedido(cliente);
		pedido4.adicionarItem(new ItemPedido(2, pedido3, produto12));
		
		PedidoDao pedidoDao = new PedidoDao(entityManager);
		pedidoDao.cadastrar(pedido3);
		pedidoDao.cadastrar(pedido4);
		
		entityManager.getTransaction().commit();
	}
	
	private static void popularBancoDeDados() {
		Cliente cliente = new Cliente("MMarchetti", "12345678");
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ClienteDao clienteDao = new ClienteDao(entityManager);
		
		entityManager.getTransaction().begin();
		clienteDao.cadastrar(cliente);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
