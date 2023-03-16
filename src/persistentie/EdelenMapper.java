package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;

public class EdelenMapper {
	try(Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)){
		
	}
}