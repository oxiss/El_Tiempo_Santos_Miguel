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

	// http://www.mkyong.com/java/json-simple-example-read-and-write-json/
	Weather time;

	/**
	 * 
	 * @param ciudad la ciudad que queramos buscar en la conexion
	 * @return string con el fichero json para procesarlo
	 */
	public String connection(String ciudad) {
		String responsedata = null;

		URL url;

		try {
			url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + ciudad
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
	 * @param mistr
	 *            JSON parseado a String
	 * @param ciudaDeseada
	 * 
	 * @method Metodo que escribe en un fichero de nombre "WeatherComplex" el
	 *         JSON completo
	 */
	public void JsonWriterComplex(String mistr, String ciudaDeseada) {

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject;

		try {
			jsonObject = (JSONObject) jsonParser.parse(mistr);
			FileWriter file = new FileWriter("./WeatherComplex" + ciudaDeseada);
			file.write(jsonObject.toJSONString());
			file.flush();
			file.close();
			System.out.print("Se ha creado el fichero WeatherComplex" + ciudaDeseada + " de forma correcta \n");
		} catch (ParseException e) {
			System.err.println("Error al parsear");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @method Este método escribe en un archivo "Actual" (ej. WeatherMadriES)
	 *         el tiempo resumido de una ciudad dada
	 */
	public void JSONWriterSimple(String ciudad) {

		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject;
			FileReader filereader = new FileReader("./WeatherComplex" + ciudad);
			jsonObject = (JSONObject) jsonParser.parse(filereader);
			String city = (String) jsonObject.get("name");
			JSONObject name = (JSONObject) jsonObject.get("main");
			Double temp = (Double) name.get("temp");

			FileWriter file = new FileWriter("./Weather" + ciudad);
			file.write("En la ciudad de " + city + " hace una temperatura de " + temp + " Fº");
			file.flush();
			file.close();

			System.out.println("Se ha creado correctamente el fichero Weather" + ciudad + "\n");

		} catch (IOException e) {
			System.out.println("error al crear archivo");
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	/**
	 * @method Metodo no funcional por ahora
	 * @param ciudad la ciudad que deseamos mostrar en xml
	 * @param jsonstr el JSON en String
	 */
	public void XMLWriter(String ciudad, String jsonstr) {

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject;
		FileReader filereader;
		try {
			filereader = new FileReader("WeatherComplex" + ciudad);
			jsonObject = (JSONObject) jsonParser.parse(filereader);

			XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
			xstream.alias("Weather", Weather.class);
			String misstr = xstream.toXML(jsonstr);
			System.out.println(misstr);

			BufferedWriter bw = new BufferedWriter(new FileWriter("./xml" + ciudad + ".html"));
			bw.write(misstr);
			bw.close();

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
