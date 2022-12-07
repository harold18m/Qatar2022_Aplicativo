package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String URL = "jdbc:mysql://localhost:3306/qatar_2022?useSSL=false";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";
	
	public static Connection conectar(){
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
		}catch(SQLException e) {
			System.out.println("Error en la conexion a la base de datos!"+ e.getMessage());
		}
		return conexion;
	}
	
}
