import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Produto {
	private double preco;
	private String nome;
	
	public Produto(String nome, double preco) {
		this.preco = preco;
		this.nome = nome;
	}	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//System.out.println("Busque por aqui:");
		
		//Produto.searchQuery(scan.next()).stream().forEach(System.out::println);
		
		Produto.selectAll().stream().forEach(System.out::println);
		
		//Produto p = new Produto("batataaa", 4.59);
		//Produto.insert(p);
		
		//Produto.delete(p);
		
		//Produto.update(p.getNome(), new Produto(p.getNome(), 5.50));
		
		System.out.println("\nfim!");
		scan.close();
	}
	
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (this.nome == null) {
			if (other.nome != null)
				return false;
		} else if (!this.nome.equals(other.nome))
			return false;
		if (this.preco != other.preco)
			return false;
		return true;
	}
	
	public String toString() {
		return this.nome + " - preco: R$" + String.valueOf(this.preco);
	}
	

	/* Os métodos relacionados à manipulação de banco de dados são estáticos pois não dependem
	 * de nenhuma instância da classe: dependem apenas da conexão com o banco de dados. Também
	 * por esse motivo os métodos relativos ao uso do banco de dados são sobrecarregados com 
	 * versões que recebem uma conexão como parâmetro; além de tudo, desse modo, o reuso fica mais fácil. 
	 * 
	 * As versões dos métodos que não recebem ConnectionFactory como parâmetro utilizam o construtor
	 * genérico de ConnectionFactory.
	 */
	
	
	/*
	 * Usar a classe PreparedStatement previne sqlInjections e melhora MUITO a performance por já ser compilada antes.
	 *
	 * O método PrepareStatement.execute() é capaz de manipular o banco, além de só consultar, diferente do .executeQuery(). 
	 */
	public static boolean insert(Produto novoPr) {
		try {
			PreparedStatement prepSt = new ConnectionFactory().getConexao().prepareStatement("INSERT INTO produtos VALUES (?, ?)"); 
			prepSt.setString(1, String.valueOf(novoPr.getPreco()));
			prepSt.setString(2, novoPr.getNome());
			return prepSt.execute(); // Nunca colocar o sql aqui dentro, pois assim nao vai adiantar nada e a query preparada nao vai ser executada
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro na conexao com o banco de dados MySQL: " + e.getMessage() + "\n Inserção não concluída.");
			return false;
		}
	}
	
	public static boolean insert(Produto novoPr, ConnectionFactory conexao) {
		try {
			PreparedStatement prepSt = conexao.getConexao().prepareStatement("INSERT INTO produtos VALUES (?, ?)");
			prepSt.setString(1, String.valueOf(novoPr.getPreco()));
			prepSt.setString(2, novoPr.getNome());
			return	prepSt.execute(); 
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro na conexao com o banco de dados MySQL: " + e.getMessage() + "\n Inserção não concluída.");
			return false;
		}
	}
	
	
	/* 
	 * O ? simboliza a string que vai ser atribuída depois.
	 */
	public static boolean delete(Produto prod) {
		try {
			PreparedStatement prepSt = new ConnectionFactory().getConexao().prepareStatement("DELETE FROM produtos WHERE nome = ?");
			prepSt.setString(1, prod.getNome());
			return prepSt.execute();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro na conexao com o banco de dados MySQL: " + e.getMessage() + "\n Exclusão não concluída.");
			return false;
		}
	}
	
	public static boolean delete(Produto prod, ConnectionFactory conexao) {
		try {
			PreparedStatement prepSt = conexao.getConexao().prepareStatement("DELETE FROM produtos WHERE nome = ?"); 
			prepSt.setString(1, prod.getNome());
			return prepSt.execute();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro na conexao com o banco de dados MySQL: " + e.getMessage() + "\n Exclusão não concluída.");
			return false;
		}
	}
	
	
	/* A classe PreparedStatement dispensa o uso de aspas no uso de varchar nas querys, 
	 * para evitar qualquer sqlInjection.
	 * 
	 * O método PreparedStatement.executeQuery() pode lançar querys de consultas no bd, mas NÃO grava no mesmo.
	 */ 
	public static ArrayList<Produto> searchQuery(String nome){
		ArrayList<Produto> arrayRes = new ArrayList<>();
		try {
			PreparedStatement prepSt = new ConnectionFactory().getConexao().prepareStatement("SELECT * FROM produtos WHERE nome LIKE ?");
			prepSt.setString(1, "%" + nome + "%"); 
			ResultSet tuplasRes = prepSt.executeQuery(); 
			while (tuplasRes.next()) {
				arrayRes.add(new Produto(tuplasRes.getString("nome"), tuplasRes.getDouble("preco")));
			}
			ConnectionFactory.checkSearch(arrayRes);
			return arrayRes;
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro na execução da query de consulta: " + e.getMessage());
		} catch (EmptyQueryException e) {
			System.out.println("Houve uma exceção: " + e.getMessage());
		}			
		return arrayRes;
	}	
	
	public static ArrayList<Produto> searchQuery(String nome, ConnectionFactory conexao){
		ArrayList<Produto> arrayRes = new ArrayList<>();
		try {
			PreparedStatement prepSt = conexao.getConexao().prepareStatement("SELECT * FROM produtos WHERE nome LIKE ?");
			prepSt.setString(1, "%" + nome + "%"); 
			ResultSet tuplasRes = prepSt.executeQuery(); 
			while (tuplasRes.next()) {
				arrayRes.add(new Produto(tuplasRes.getString("nome"), tuplasRes.getDouble("preco")));
			}
			ConnectionFactory.checkSearch(arrayRes);
			return (arrayRes);
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro na execução da query de consulta: " + e.getMessage());
		} catch (EmptyQueryException e) {
			System.out.println("Houve uma exceção: " + e.getMessage());
		}	
		return arrayRes;
	}	
	
	/* NovoProd é idealmente instanciado na chamada do método, enquanto o nome é idealmente passado por getNome()
	 * de outro objeto Produto.
	 * O campo 'nome' é a chave-primária da tabela.
	 */
	public static boolean update(String modProdNome, Produto novoProd) {
		try {															
			PreparedStatement prepSt = new ConnectionFactory().getConexao().prepareStatement("UPDATE produtos SET preco = ?, nome = ? WHERE nome = ?");
			prepSt.setDouble(1, novoProd.getPreco());
			prepSt.setString(2, novoProd.getNome());
			prepSt.setString(3, modProdNome);
			return prepSt.execute();
		} catch (SQLException e) {
			System.out.println("Houve uma exceção de Produto.update(): " + e.getMessage());
			return false;
		}
	}
	
	public static boolean update(String modProdNome, Produto novoProd, ConnectionFactory conexao) {
		try {
			PreparedStatement prepSt = conexao.getConexao().prepareStatement("UPDATE produtos SET preco = ?, nome = ? WHERE nome = ?");
			prepSt.setDouble(1, novoProd.getPreco());
			prepSt.setString(2, novoProd.getNome());
			prepSt.setString(3, modProdNome);
			return prepSt.execute();
		} catch (SQLException e) {
			System.out.println("Houve uma exceção de Produto.update(): " + e.getMessage());
			return false;
		}
	}
	
	
	
	public static ArrayList<Produto> selectAll(){
		ArrayList<Produto> arrayRes = new ArrayList<>();
		try {
			PreparedStatement prepSt = new ConnectionFactory().getConexao().prepareStatement("SELECT * FROM produtos");
			ResultSet tuplasRes = prepSt.executeQuery(); 
			while (tuplasRes.next()) {
				arrayRes.add(new Produto(tuplasRes.getString("nome"), tuplasRes.getDouble("preco")));
			}
			ConnectionFactory.checkSearch(arrayRes);
			return (arrayRes);
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro na execução da query de consulta: " + e.getMessage());
		} catch (EmptyQueryException e) {
			System.out.println("Houve uma exceção: " + e.getMessage());
		}	
		return arrayRes;
	}	
	
	public static ArrayList<Produto> selectAll(ConnectionFactory conexao){
		ArrayList<Produto> arrayRes = new ArrayList<>();
		try {
			PreparedStatement prepSt = conexao.getConexao().prepareStatement("SELECT * FROM produtos");
			ResultSet tuplasRes = prepSt.executeQuery(); 
			while (tuplasRes.next()) {
				arrayRes.add(new Produto(tuplasRes.getString("nome"), tuplasRes.getDouble("preco")));
			}
			ConnectionFactory.checkSearch(arrayRes);
			return (arrayRes);
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro na execução da query de consulta: " + e.getMessage());
		} catch (EmptyQueryException e) {
			System.out.println("Houve uma exceção: " + e.getMessage());
		}	
		return arrayRes;
	}	
	
}