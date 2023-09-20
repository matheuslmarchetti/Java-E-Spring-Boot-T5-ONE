package one.alura.hotel.br;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaDelecao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexao = factory.criaConexao();

	}

}
