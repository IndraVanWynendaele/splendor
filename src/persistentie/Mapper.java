package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mapper {
	try(Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)){
		
	}
}