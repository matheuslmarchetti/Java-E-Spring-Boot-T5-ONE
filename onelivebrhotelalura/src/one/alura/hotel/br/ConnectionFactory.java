package one.alura.hotel.br;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection criaConexao() throws SQLException {
		Connection conexao = DriverManager.getConnection(
				"jdbc:mysql://localhost/hotel_alura?useTimezone=true&serverTimezone=UTC", "mysql", "mysql");
		System.out.println("Testando conexão!");
		return conexao;
	}

}
