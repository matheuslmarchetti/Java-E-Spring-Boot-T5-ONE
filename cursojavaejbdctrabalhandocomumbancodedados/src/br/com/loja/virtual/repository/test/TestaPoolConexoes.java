package br.com.loja.virtual.repository.test;

import java.sql.SQLException;

import br.com.loja.virtual.repository.conexao.ConnectionFactory;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for (int i = 0; i < 20; i++) {
			connectionFactory.recuperarConexao();
			System.out.println("Conexão de número: " + i);
		}

	}

}
