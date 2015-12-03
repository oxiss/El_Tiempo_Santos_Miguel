package eltiempo;

import java.io.Serializable;
import java.util.ArrayList;

public class Weather implements Serializable {

	    private double lon;
	    private double lat;
	    private double temp_max;
	    private String name;
	    private String city;
	    private String coord;
		
	    
		public Weather() {
			super();
		}

		public Weather(double lon, double lat, double temp_max, String name, String city, String coord) {
			super();
			this.lon = lon;
			this.lat = lat;
			this.temp_max = temp_max;
			this.name = name;
			this.city = city;
			this.coord= coord;
		}

		

	    public double getLon() {
			return lon;
		}

		public void setLon(double lon) {
			this.lon = lon;
		}

		public double getLat() {
			return lat;
		}

		public void setLat(double lat) {
			this.lat = lat;
		}

		public double getTemp_max() {
			return temp_max;
		}

		public void setTemp_max(double temp_max) {
			this.temp_max = temp_max;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCoord() {
			return coord;
		}

		public void setCoord(String coord) {
			this.coord = coord;
		}

		public String toString(){
			 
	    	return null;
	    	
	    }
		
	}


	
	

