package eltiempo;

public abstract class TablaTiempo {

	public static final String TABLE_NAME = "Tiempo";
	public static final String COLUMN_CITY_NO = "City_no";
	public static final String COLUMN_TEMP_MAX = "temp_max";

	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( " + COLUMN_CITY_NO
			+ " INTEGER PRIMARY KEY," + COLUMN_TEMP_MAX + "TEXT NOT NULL" + ")";

}