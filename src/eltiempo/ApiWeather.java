package eltiempo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiWeather {

	/**
	 * @param city the city we want to show in the report
	 */
	public void JsonReader(String city) {

		String responsedata = null;

		URL url;
		try {
			url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city
					+ "&appid=2de143494c0b295cca9337e1e96b00e0");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			InputStream stream = connection.getInputStream();

			BufferedReader streamReader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			String inputStr;
			while ((inputStr = streamReader.readLine()) != null) {
				responseStrBuilder.append(inputStr);

				responsedata = responseStrBuilder.toString();
				// System.out.println(responsedata);

				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(responsedata);

				Weather weather = new Weather();
				// Ejemplo de carlos JSON Parse Text
				JSONObject coord = (JSONObject) jsonObject.get("coord");
				JSONObject mainn = (JSONObject) jsonObject.get("main");
				
				
				weather.setLon((Double)coord.get("lon"));
				weather.setLat((Double)coord.get("lat"));
				weather.setTemp_max((Double)mainn.get("temp_max"));
				weather.setPress((long) mainn.get("pressure"));
				weather.setHum((long)mainn.get("humidity"));
				
				System.out.println("******* COMPLETE REPORT FOR "+city +" *******");
				
				System.out.println("The city is located in: " + weather.getLat()+" Latitude" + " y "+ weather.getLon() + " Longitude" );
				System.out.println("Today the maximum temperature will be "+weather.getTemp_max() +" Farenheit");
				System.out.println("Relative humidity should be: "+ weather.getHum()+ "hr, y the pression: "+weather.getPress()+ " bars");
				
				System.out.println("******* REPORT ENDED *******");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

//	public String getJSON(String city, String metric) {
//
//		return null;
//	}
//
//	public String getJSON(String city) {
//
//		return null;
//	}
//
//	public Weather getWeather(String city) {
//		Weather weather = new Weather();
//
//		return weather;
//	}

//	public ArrayList <Weather> getWeatherWeek(String city) {
//		ArrayList<Weather> lWeather = new ArrayList<Weather>();
//		
//		return lWeather;
//	}

}
