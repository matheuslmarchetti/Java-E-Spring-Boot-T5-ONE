package one.alura.hotel.br;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection conexao = DriverManager.getConnection(
				"jdbc:mysql://localhost/hotel_alura?useTimezone=true&serverTimezone=UTC", 
				"marchetticodes", 
				"marchetticodes");
		System.out.println("Testando conexão!");
		conexao.close();

	}

}
