package one.alura.hotel.br;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexao = factory.criaConexao();

		PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM reserva");

		preparedStatement.execute();

		ResultSet resultSet = preparedStatement.getResultSet();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			Date dataentrada = resultSet.getDate("dataentrada");
			Date datasaida = resultSet.getDate("datasaida");
			String valor = resultSet.getString("valor");
			String formapagamento = resultSet.getString("formapagamento");
			System.out.println(id);
			System.out.println(dataentrada);
			System.out.println(datasaida);
			System.out.println(valor);
			System.out.println(formapagamento);
		}
		conexao.close();
	}

}