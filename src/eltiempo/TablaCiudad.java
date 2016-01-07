package eltiempo;

public abstract class TablaCiudad {

	public static final String TABLE_NAME = "Ciudad";
	public static final String COLUMN_CITY_NO = "City_no";
	public static final String COLUMN_CNOMBRE = "Cityname";

	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( " + COLUMN_CITY_NO
			+ " INTEGER NOT NULL PRIMARY KEY," + COLUMN_CNOMBRE + " TEXT NOT NULL," +

	");";
}