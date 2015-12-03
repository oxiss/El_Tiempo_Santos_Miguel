package eltiempo;

import java.io.Serializable;
import java.util.ArrayList;

public class Weather implements Serializable {

	    private int longitud;
	    private int latitud;
	    private float tempMax;
	    private String city;
	    private ArrayList weather;
	    private String base;
	    
		public Weather(int longitud, int latitud, ArrayList weather, String base) {
			super();
			this.longitud = longitud;
			this.latitud = latitud;
			this.weather = weather;
			this.base = base;
		}
		
		public Weather() {
			
		}
		
		public ArrayList getWeather() {
			return weather;
		}
		public void setWeather(ArrayList weather) {
			this.weather = weather;
		}
		public String getBase() {
			return base;
		}
		public void setBase(String base) {
			this.base = base;
		}
		public int getLongitud() {
			return longitud;
		}
		public void setLongitud(int longitud) {
			this.longitud = longitud;
		}
		public int getLatitud() {
			return latitud;
		}
		public void setLatitud(int latitud) {
			this.latitud = latitud;
		}

	    
	}


	
	

