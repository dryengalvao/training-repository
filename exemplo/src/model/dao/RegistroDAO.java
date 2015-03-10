package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.conexao.ConnectionFactory;



public class RegistroDAO {
	private Connection connection;
	
	private static RegistroDAO dao = new RegistroDAO();

	public static RegistroDAO getInstancia() {
		return dao;
	}
	
	public void insert(String nome) throws SQLException {

		this.connection = ConnectionFactory.getConnection();

		PreparedStatement stmt;

		stmt = this.connection
				.prepareStatement("insert into registro (nome) values (?);");
		
		stmt.setString(1, nome);
		
		stmt.execute();
		
		stmt.close();
		connection.close();
	}
	
	public String pesquisa() throws SQLException {

		this.connection = ConnectionFactory.getConnection();

		PreparedStatement stmt;

		stmt = this.connection.prepareStatement("select * from registro");
		
		
		ResultSet rs = stmt.executeQuery();
			
		String nomes = "";
		while (rs.next()) {
			nomes = nomes + "ID: " +rs.getInt("id")+" | Nome: "+ rs.getString("nome")+"\n";
		}

		rs.close();
		stmt.close();
		connection.close();
		return nomes;
	}	
	
}
