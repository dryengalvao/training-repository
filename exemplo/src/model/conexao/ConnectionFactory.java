package model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	public static Connection getConnection() throws SQLException{
		
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			return DriverManager.getConnection("jdbc:jtds:sqlserver://localhost/EXEMPLO","sa","");
		}catch (ClassNotFoundException e){
			throw new SQLException(e.getMessage());
		}		
	};
	
	
	public static void main(String[] args) {
		Connection connection;
		try {
			connection = ConnectionFactory.getConnection();
			connection.close();
			
			System.out.println("Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
