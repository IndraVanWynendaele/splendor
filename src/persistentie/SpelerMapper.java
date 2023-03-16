package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domein.Speler;

public class SpelerMapper {
	
	public SpelerMapper() {
		
	}
		
	public Speler geefSpeler(String gebruikersnaam,int geboortejaar) {
		try(Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)){
			 PreparedStatement query = conn.prepareStatement("SELECT * FROM ID399.Speler");
		}catch(SQLException exception) {
			throw new RuntimeException(exception);
		}
	
	}
}
