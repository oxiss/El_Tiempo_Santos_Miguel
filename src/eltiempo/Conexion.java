package eltiempo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conexion;
	
	Conexion(String driver,String URL){
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection("jdbc:sqlite:C:Users/Santos/git/El_Tiempo_Santos_Miguel/mibbddtiempo.db");		
		} catch (ClassNotFoundException e) {
			System.err.println("driver no encontrado");
		} catch (SQLException e) {
			System.err.println("error al conectar");
		}
	}
	public static Connection getConexion() {
		return conexion;
	}



}