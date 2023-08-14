package br.com.loja.virtual.repository.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.loja.virtual.repository.factory.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		preparedStatement.setInt(1, 2);
		boolean resultado = preparedStatement.execute();
		System.out.println(resultado);
		
		int linhasModificadas = preparedStatement.getUpdateCount();
		System.out.println("A quantidade de linhas modificadas foi: " + linhasModificadas);
		
	}

}
