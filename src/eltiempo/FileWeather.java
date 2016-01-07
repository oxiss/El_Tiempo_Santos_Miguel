package eltiempo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class FileWeather {

	Weather time;

	/**
	 * 
	 * @param city city want in connection
	 * @return string with JSON for process
	 * @author Miguel
	 */
	public String connection(String city) {
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
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responsedata;

	}

	/**
	 * 
	 * @param mistr JSON parsed to String
	 * @author Santos G      
	 * @param choosencity
	 * @method Write in "WeatherComplex" the root JSON 
	 */
	public void JsonWriterComplex(String mistr, String choosencity) {

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject;

		try {
			jsonObject = (JSONObject) jsonParser.parse(mistr);
			FileWriter file = new FileWriter("./WeatherComplex" + choosencity);
			file.write(jsonObject.toJSONString());
			file.flush();
			file.close();
			System.out.print("You have successfully created the file WeatherComplex" + choosencity + "\n");
		} catch (ParseException e) {
			System.err.println("Error parsing");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param Este método escribe en un archivo "Actual" (ej. WeatherMadriES)
	 *         el tiempo resumido de una ciudad dada
	 *         @author Santos
	 */
	public void JSONWriterSimple(String city) {

		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject;
			FileReader filereader = new FileReader("./WeatherComplex" + city);
			jsonObject = (JSONObject) jsonParser.parse(filereader);
			String citie = (String) jsonObject.get("name");
			JSONObject name = (JSONObject) jsonObject.get("main");
			Double temp = (Double) name.get("temp");

			FileWriter file = new FileWriter("./Weather" + citie);
			file.write("The city of " + citie + " has a temperature of " + temp + " Fº");
			file.flush();
			file.close();

			System.out.println("You have successfully created the file Weather" + citie + "\n");

		} catch (IOException e) {
			System.out.println("Error creating file");
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	/**
	 * @param method does not work
	 * @param city the city that we want to show in xml
	 * @param jsonstr JSON in String
	 */
	public void XMLWriter(String city, String jsonstr) {

		try {

			XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
			xstream.alias("Weather", Weather.class);
			String misstr = xstream.toXML(jsonstr);
			System.out.println(misstr);

			BufferedWriter bw = new BufferedWriter(new FileWriter("./xml" + city + ".html"));
			bw.write(misstr);
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
