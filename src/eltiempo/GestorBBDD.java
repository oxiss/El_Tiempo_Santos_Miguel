package eltiempo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBBDD extends Conexion {

	
	private final static String DRIVER ="org.sqlite.JDBC";
	private final static String DB_NAME = "ejemplo.db";
	private final static  String URL="jdbc:sqlite:db/"+DB_NAME;
	
	private final static String INSERT_CIUDAD =
			"INSERT INTO "+TablaCiudad.TABLE_NAME+" VALUES (?,?)";
	
	private final static String SELECT_TIEMPO =
			"SELECT * FROM "+TablaCiudad.TABLE_NAME+" WHERE "+TablaCiudad.COLUMN_CITY_NO+" = ?";

	
	GestorBBDD() {
		super(DRIVER, URL);	
		createTable(TablaCiudad.CREATE_TABLE);
		createTable(TablaTiempo.CREATE_TABLE);

	}

    public void insertCiudad(Weather wea){
    	try {
			PreparedStatement sentencia = getConexion().prepareStatement(INSERT_CIUDAD);
		    sentencia.setLong(1, wea.getHum());
		    sentencia.setString(2, wea.getCity());
			sentencia.executeUpdate();
		} catch (SQLException e) {
			System.err.println("error al insertar la ciudad "+wea.getCity());
			System.err.println(e.getMessage());
		}
    }
    
    public Weather getWeather(int num){
    	Weather weat = new Weather();
    	try {
    		PreparedStatement sentencia = getConexion().prepareStatement(SELECT_TIEMPO);
    		sentencia.setInt(1, num);
		ResultSet result = sentencia.executeQuery();
		if(result.next()){
			weat.setNum(num);
			weat.setName(result.getString(TablaCiudad.COLUMN_CNOMBRE));
			weat.setCnum(result.getString(TablaCiudad.COLUMN_CITY_NO));
		}
		} catch (SQLException e) {
			System.err.println("error al buscar el el tiempo "+num);
			System.err.println(e.getMessage());
		}
    	return weat;
    }
	
	
	private void createTable(String sql) {
		try {
			Statement sentencia = getConexion().createStatement();
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(TablaTiempo.CREATE_TABLE);
			System.err.println(e.getMessage());
			
			
		}
	}
	
	
	
	
	
	
	
}