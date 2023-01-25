import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TesteJDBC {
	private static String schema = "estoque";
	private static String url = "jdbc:mysql://localhost:3306/" + schema;
	private static String user = "root";
	private static String password = "123456789";
	
	public static void main(String[] args) {
		try {
			//Class.forName("com.mysql.jdbc.Driver"); não precisa mais usar desde o java 6 (1.6), mas servia pra "carregar" a classe no programa.
			Connection conexao = DriverManager.getConnection(url, user, password);
			ResultSet dadosRes = conexao.createStatement().executeQuery("SELECT * FROM produtos WHERE preco < 20;"); // IMPORTANTE: o metodo executeQuery() somente retorna dados e pode somente fazer select. Para manipular o banco(insert, create, update), é preciso usar execute()      
			ResultSetMetaData metaD = dadosRes.getMetaData(); // Mas, no caso de usar PreparedStatement, use executeUpdate().
			
			int col = metaD.getColumnCount();
			while (dadosRes.next()) {
				for (int i = 1; i <= col; i++) {
					System.out.print(dadosRes.getSQLXML(i).getString() + "    -    ");
				}
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro na conexao com o banco de dados MySQL: " + e.getMessage());
		}
		
		System.out.println("FIM DO PROG");
	}
}
