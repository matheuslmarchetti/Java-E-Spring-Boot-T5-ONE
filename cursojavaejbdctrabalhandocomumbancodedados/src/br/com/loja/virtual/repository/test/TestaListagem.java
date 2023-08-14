package br.com.loja.virtual.repository.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.loja.virtual.repository.factory.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
	
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		boolean resultado = preparedStatement.execute();
	
		System.out.println(resultado);
		
		ResultSet resultSet = preparedStatement.getResultSet();
		
		System.out.println(resultSet);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("ID");
			System.out.print(id);
			String nome = resultSet.getString("NOME");
			System.out.print(" " + nome);
			String descricao = resultSet.getString("DESCRICAO");
			System.out.print(" " + descricao);
			System.out.println();
		}
	
		connection.close();

	}

}
