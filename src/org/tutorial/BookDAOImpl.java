package org.tutorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO{

	@Override
	public List<Book> findByAll() {
		//Récupérer une connexion de type java.sql.Connection par la méthode : 
		Connection connexion = DBManager.getInstance().getConnection();
		
		
		List<Book> books = new ArrayList<>();
		int compteur = 1;
		
		//Créer un java.sql.Statement à partir de cette connexion en utilisant: 
		try(Statement stmt = connexion.createStatement()){
			//  Exécuter la requête SQL  et récupérer un java.sql.ResultSet
			ResultSet rs = stmt.executeQuery("select * from books");
			
			// Itérer sur le resultSet : 
			while (rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				books.add(new Book(compteur,title,author));
				compteur +=1;
				
			}
			
		}catch(SQLException e) {
			System.out.println(e);
			
		}
		
		
		return books;
	}

	@Override
	public List<Book> findByTitle(String searchText) {
		//Récupérer une connexion de type java.sql.Connection par la méthode : 
				System.out.println(DBManager.getInstance().getConnection());
				Connection connexion = DBManager.getInstance().getConnection();
				
				
				List<Book> books = new ArrayList<>();
				int compteur = 1;
				
				//Créer un java.sql.Statement à partir de cette connexion en utilisant: 
				try(Statement stmt = connexion.createStatement()){
					//  Exécuter la requête SQL  et récupérer un java.sql.ResultSet
					
					String query = "select * from books where title='"+searchText+"'";
					ResultSet rs = stmt.executeQuery(query);
					
					// Itérer sur le resultSet : 
					while (rs.next()) {
						String title = rs.getString("title");
						String author = rs.getString("author");
						books.add(new Book(compteur,title,author));
						compteur +=1;
						
					}
					
				}catch(SQLException e) {
					System.out.println(e);
					
				}
				
				
				return books;
	}

}
