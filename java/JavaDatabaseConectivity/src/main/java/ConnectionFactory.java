import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionFactory {
	private String database;
	private String url;
	private String user;
	private String password;
	private Connection conexao;

	
	public ConnectionFactory(String database, String url, String user, String password) {
		this.database = database;
		this.url = url + this.database;
		this.user = user;
		this.password = password;
		
		try {
			this.conexao = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro na conexao com o banco de dados MySQL: " + e.getMessage());
		}
	}
	
	
	public ConnectionFactory() {
		this("estoque", "jdbc:mysql://localhost:3306/", "root", "123456789");
	}
	
	public Connection getConexao() {
		return this.conexao;
	}
	
	public static void checkSearch(ArrayList<Produto> result) throws EmptyQueryException { // TO DO: mudar o tipo generico para <T>, a fim de tornar a classe genérica. 
		if (result.isEmpty()) {
			throw new EmptyQueryException();
		}
	}
	
}