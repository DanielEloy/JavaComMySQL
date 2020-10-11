import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Daniel Eloy
*/

public class BancoDeDados {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/agenda";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.cj.jdbc.Driver";//"com.mysql.jdbc.Driver"
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
	}
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		} else {
			return false;
		}
	}
	public void listarContatos() {
		try {
			String query = "SELECT * FROM contato ORDER BY id";
			this.resultset = this.statement.executeQuery(query);
			//this.statement = this.connection.createStatement();  excluir depois de codar
			while(this.resultset.next()) {
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " +this.resultset.getString("nome") + " - Telefone: " + this.resultset.getString("telefone"));
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void inserirContato(String nome, String telefone) {
		try {
			String query = "INSERT INTO contato (nome, telefone) VALUES ('" + nome + "', '" + telefone + "' );";
			//System.out.println(query);
			this.statement.executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void editarContato(String id, String nome, String telefone) {
		try {
			String query = "UPDATE contato SET nome = '" + nome + "', telefone = '" + telefone + "' WHERE id = " + id + ";";
			this.statement.executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} 
	}
	public void apagarContato(String id) {
		try {
			String query = "DELETE FROM contato WHERE id = " + id + ";";
			this.statement.executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void desconectar() {
		try {
			this.connection.close();
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
	
