package br.com.alura.loja.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.ultil.JPAUtil;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

public class BuscarRelatorioDeVendas {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		PedidoDao pedidoDao = new PedidoDao(entityManager);
		List<RelatorioDeVendasVo> relatorioDeVendas = pedidoDao.relatorioDeVendas();
		relatorioDeVendas.forEach(System.out::println);

	}

}
