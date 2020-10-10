# JavaComMySQL
 Acessar o banco de dados do MySQL com JAVA compilado pelo eclipse.
/**
 * @author Daniel Eloy
 */

public class Agenda {	
	public static void main(String[] args) {
		BancoDeDados bancoDeDados = new BancoDeDados();
		bancoDeDados.conectar();
		if(bancoDeDados.estaConectado()) {
			bancoDeDados.listarContatos();
			//bancoDeDados.inserirContato("Daniel", "(11)99187-9192");
			//bancoDeDados.editarContato("1", "Paulo", "9876-5432");
			//bancoDeDados.apagarContato("4");
			bancoDeDados.desconectar();
		} else {
			System.out.println("Não foi possível conectar ao banco de dados!");
		}
	}
}
