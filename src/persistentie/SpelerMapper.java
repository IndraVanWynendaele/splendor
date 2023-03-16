package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domein.Speler;

public class SpelerMapper {
	
	/*public SpelerMapper() {
		//geen idee
	}
	*/
	public Speler geefSpeler(String gn,int gj) {
		Speler speler = null;
		try(Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)){
			 PreparedStatement query = conn.prepareStatement("SELECT * FROM ID399796_g050.Speler WHERE gebruikersnaam = ? AND geboorteDatum = ?");
			 query.setString(1, gn);
			 query.setInt(2,gj);
			 try (ResultSet rs = query.executeQuery()) {
	                if (rs.next()) {
	                    String gebruikersnaam = rs.getString("gebruikersnaam");
	                    int geboortejaar = rs.getInt("geboortejaar");
	                    speler = new Speler(gebruikersnaam,geboortejaar);
	                }
			 }
		}catch(SQLException exception) {
			throw new RuntimeException(exception);
		}
			 return speler;
		
	}
}
