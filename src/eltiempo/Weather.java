package eltiempo;

import java.io.Serializable;
import java.util.ArrayList;

public class Weather implements Serializable {

	    private float longitud;
	    private float latitud;
	    private float tempMax;
	    private String city;
	    private String weather;
		
	    public Weather(float longitud, float latitud, float tempMax, String city, String weather) {
			super();
			this.longitud = longitud;
			this.latitud = latitud;
			this.tempMax = tempMax;
			this.city = city;
			this.weather = weather;
		}

		public Weather() {

		}

		public float getLongitud() {
			return longitud;
		}

		public void setLongitud(float longitud) {
			this.longitud = longitud;
		}

		public float getLatitud() {
			return latitud;
		}

		public void setLatitud(float latitud) {
			this.latitud = latitud;
		}

		public float getTempMax() {
			return tempMax;
		}

		public void setTempMax(float tempMax) {
			this.tempMax = tempMax;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getWeather() {
			return weather;
		}

		public void setWeather(String weather) {
			this.weather = weather;
		}
	    
	    
		
	}


	
	

