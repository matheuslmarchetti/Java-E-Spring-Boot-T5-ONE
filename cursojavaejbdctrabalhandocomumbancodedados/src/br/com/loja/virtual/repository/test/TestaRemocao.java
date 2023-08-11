package br.com.loja.virtual.repository.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.loja.virtual.repository.conexao.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("DELETE FROM PRODUTO WHERE ID > 2");
		System.out.println(resultado);
		
		int linhasModificadas = statement.getUpdateCount();
		System.out.println("A quantidade de linhas modificadas foi: " + linhasModificadas);
		
	}

}
