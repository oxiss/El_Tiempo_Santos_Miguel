package eltiempo;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileWeather {

	// http://www.mkyong.com/java/json-simple-example-read-and-write-json/

	public void JsonWriter() {
		// escribe el archivo en json
		String responsedata = null;

		URL url;
		try {
			url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + "Madrid,es"
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

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(responsedata);

			FileWriter file = new FileWriter("\test.json");
			file.write(jsonObject.toJSONString());
			file.flush();
			file.close();
			System.out.print(jsonObject);
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}

	public void XMLWriter() {
		// escribir el archivo en xml
	}

}
