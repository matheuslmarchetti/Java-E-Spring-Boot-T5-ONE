package br.com.loja.virtual.repository.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.loja.virtual.repository.conexao.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("INSERT INTO PRODUTO (nome, descricao)"
				+ "VALUES ('MOUSE', 'MOUSE SEM FIO LENOVO')",
				Statement.RETURN_GENERATED_KEYS);
		System.out.println(resultado);
		
		ResultSet resultSet = statement.getGeneratedKeys();
		
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
	}
	
}
