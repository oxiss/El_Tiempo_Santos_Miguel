package eltiempo;

import java.io.Serializable;
import java.util.ArrayList;


public class Weather implements Serializable {

	private double lon;
	private double lat;
	private double temp_max;
	private long hum;
	private long press;
	private String name;
	private String city;
	private String coord;

	public Weather() {
		super();
	}

	public long getHum() {
		return hum;
	}

	public void setHum(long hum) {
		this.hum = hum;
	}

	public long getPress() {
		return press;
	}

	public void setPress(long press) {
		this.press = press;
	}

	public Weather(double lon, double lat, double temp_max, long hum, long press, String name, String city,
			String coord) {
		super();
		this.lon = lon;
		this.lat = lat;
		this.temp_max = temp_max;
		this.hum = hum;
		this.press = press;
		this.name = name;
		this.city = city;
		this.coord = coord;
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

}
