package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.ultil.JPAUtil;

public class PerformanceConsultas {

	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		PedidoDao pedidoDao = new PedidoDao(entityManager);
		Pedido pedido = pedidoDao.buscarPedidoComCliente(1l);
		//Pedido pedido = entityManager.find(Pedido.class, 1l);
		entityManager.close();
		System.out.println(pedido.getCliente().getNome());
	}

}
