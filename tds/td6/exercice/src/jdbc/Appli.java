package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Appli {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url, user;
		url = "jdbc:mysql://localhost:3306/aero";
		user = "root";

		Class.forName("com.mysql.cj.jdbc.Driver"); //Chargement du driver (optionnel car automatique grâce au JRE)

		Connection connection = DriverManager.getConnection(url, user,"");

		Statement req1 = connection.createStatement();
		ResultSet resultSet = req1.executeQuery("select * from avion");
		ResultSetMetaData rsmd = resultSet.getMetaData ( );


		PreparedStatement ps = connection.prepareStatement("UPDATE avion SET Entrepot = ? WHERE Capacite = ?"); //Requêts pré-compilées (requêtes prêtes customisables
		ps.setString (1, "Paris");
		ps.setInt (2, 2);
		ps.executeUpdate();


		//Afficher tous les noms de colonnes grâce aux méta-données
		int nbCol = rsmd.getColumnCount();
		String[] columnsNames = new String[nbCol];
		
		for (int i=0;i<nbCol;i++) //Affichage méta-données
		{
			columnsNames[i]=rsmd.getColumnName(i+1); //La méthodes getColumnName commence à 1
			System.out.print(columnsNames[i]+" ");
		}
		System.out.println();

		while(resultSet.next()) //Affichage données (sans la Maj de prepared statemnt car le result set est déclaré plus tôt)
		{
			for(int i=0; i<nbCol;i++)
			{
				System.out.print(resultSet.getString(columnsNames[i])+" ");
			}
			System.out.println(" ");	
		}

		//Fermeture des flux de la DB
		connection.close ( );
		req1.close ( );
		resultSet.close ( );
	}
}