package br.com.loja.virtual.repository.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.loja.virtual.repository.conexao.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		String nome = "Teclado'";
		String descricao = "Teclado Sem Fio): delete;";
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao)"
				+ "VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, descricao);
		
		preparedStatement.execute();
		
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
	}

}
