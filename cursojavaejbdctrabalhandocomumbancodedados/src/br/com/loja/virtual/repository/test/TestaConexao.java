package br.com.loja.virtual.repository.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", 
							"marchetticodes", "mysql@ubuntu@marchetti@codes");
		System.out.println("Fechando Conexão!!");
		
			connection.close();

	}

}
