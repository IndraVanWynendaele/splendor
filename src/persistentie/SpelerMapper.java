package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import domein.Speler;

public class SpelerMapper {
	
	public SpelerMapper() {
		try(Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)){
			
		}catch(SQLException exception) {
			throw new RuntimeException(exception);
		}
	}
	public Speler geefSpeler(String gebruikersnaam,int geboortejaar) {
		
	}
}
