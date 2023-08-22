package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.ultil.JPAUtil;

public class BuscarValorTotalVendido {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		PedidoDao pedidoDao = new PedidoDao(entityManager);
		BigDecimal totalvendido = pedidoDao.valorTotalVendido();
		System.out.println("Valor Total: " + totalvendido);

	}

}
