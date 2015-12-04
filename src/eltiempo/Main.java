package eltiempo;


import java.io.FileNotFoundException;
import java.io.FileReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;



public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
	//ApiWeather miapp = new ApiWeather();
	//miapp.JsonReader();
	FileWeather miapp2 = new FileWeather();
	miapp2.JsonWriter();
	
	
	
		
	//String json = "{\"longitud\":\"1\",\"latitud\":2}";
	//Gson gson = new Gson();
	//Weather weather = (Weather) gson.fromJson(miapp.JsonReader(), Weather.class);
	//System.out.println(weather.getCity());
	//System.out.println(weather.getCoord());
	//System.out.println(weather.getDescription());
	//System.out.println(weather.getName());
	//System.out.println(weather.getMain());
	
//	XStream xstream = new XStream(new JsonHierarchicalStreamDriver());        
//    xstream.alias("eltiempo", Weather.class);
//    System.out.println(xstream.toXML(miapp));	
	
	//FileReader reader = new FileReader();
	

}

}

//http://api.openweathermap.org/data/2.5/weather?q=Madrid,es&appid=2de143494c0b295cca9337e1e96b00e0