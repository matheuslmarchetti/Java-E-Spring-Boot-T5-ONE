package br.com.loja.virtual.repository.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.loja.virtual.repository.factory.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try(Connection connection = connectionFactory.recuperarConexao()){
			connection.setAutoCommit(false);
	
			try(PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao)" + "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)){
				adicionarVariavel("SmartTV", "45 Polegadas", preparedStatement);
				adicionarVariavel("Rádio", "Rádio de Bateria", preparedStatement);
	
				connection.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement preparedStatement)
			throws SQLException {
		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, descricao);

		
		 if(nome.equals("Rádio")) { 
			 throw new RuntimeException("Não foi possível adicionar o produto"); 
		}
		 

		preparedStatement.execute();

		try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
	}
}
