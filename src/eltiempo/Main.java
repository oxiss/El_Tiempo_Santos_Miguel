package eltiempo;

import java.io.FileNotFoundException;
/**
 * 
 * @author Santos Garcia & Miguel A. Nuñez
 *
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		FileWeather ppalobject = new FileWeather();
		// ELEGIMOS CIUDAD Y PAIS CON FORMATO Madrid,ES
		String selectedcity = "Sevilla,ES";

		// ***********************************************
		// Para leer y escribir a un fichero "WeatherComplexCiudadES" todo el json de una ciudad dada
		ppalobject.JsonWriterComplex(ppalobject.connection(selectedcity), selectedcity);
		// ***********************************************

		// ***********************************************
		// Para escribir un archivo "WeatherCiudadES" la ciudad con su
		// tempertaura actual
		ppalobject.connection(selectedcity);
		ppalobject.JSONWriterSimple(selectedcity);
		// ***********************************************

		// ***********************************************
		//Para leer por consola el informe completo de una ciudad en json
		ApiWeather Objetosecundario = new ApiWeather();
		Objetosecundario.JsonReader(selectedcity);
		// ***********************************************
		
		
		ppalobject.XMLWriter(selectedcity, ppalobject.connection(selectedcity));

	}

}

// http://api.openweathermap.org/data/2.5/weather?q=Madrid,es&appid=2de143494c0b295cca9337e1e96b00e0