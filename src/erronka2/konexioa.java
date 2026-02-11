package erronka2;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class konexioa {
 
	private static final String CONTROLADOREA="com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://192.168.115.171/erronka_2taldea";
	private static final String ERABILTZAILEA="erabiltzaile";
	private static final String PASAHITZA="2TALDEA";
	
	static {
		try {
			Class.forName(CONTROLADOREA);
		}catch(ClassNotFoundException e) {
			System.out.println("Kontroladorea kargatzean errorea");
			e.printStackTrace();
		}
	}
	public static Connection konektatu() {
		Connection conexion = null;
		try {
			
			conexion=DriverManager.getConnection(URL,ERABILTZAILEA, PASAHITZA);
			System.out.println();
		
		}catch (SQLException e) {
			System.out.println("Errorea konexioan");
			e.printStackTrace();
		}
			return conexion;
	}
}