package br.com.loja.virtual.repository.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.loja.virtual.repository.conexao.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
	
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
	
		System.out.println(resultado);
		
		ResultSet resultSet = statement.getResultSet();
		
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
