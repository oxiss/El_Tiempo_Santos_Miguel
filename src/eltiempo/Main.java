package eltiempo;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		
	String json = "{\"longitud\":\"1\",\"latitud\":2}";

	Gson gson = new Gson();

	Weather weather = (Weather) gson.fromJson(json, Weather.class);
	
	System.out.println(weather.getLongitud());
	System.out.println(weather.getLatitud());
	

}

}

//http://api.openweathermap.org/data/2.5/weather?q=Madrid,es&appid=2de143494c0b295cca9337e1e96b00e0