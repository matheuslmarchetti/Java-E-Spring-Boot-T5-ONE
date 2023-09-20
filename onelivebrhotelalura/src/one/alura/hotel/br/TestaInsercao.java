package one.alura.hotel.br;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexao = factory.criaConexao();
		
		PreparedStatement preparedStatement = conexao.prepareStatement
				("INSERT INTO reserva (dataentrada, datasaida, valor, formapagamento) "
						+ "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		Date dataentrada = Date.valueOf("2023-08-20");
		Date datasaida = Date.valueOf("2023-09-15");
		
		preparedStatement.setDate(1, dataentrada);
		preparedStatement.setDate(2, datasaida);
		preparedStatement.setString(3, "500");
		preparedStatement.setString(4, "cartão");
		
		preparedStatement.execute();
		
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		
		conexao.close();
	}

}