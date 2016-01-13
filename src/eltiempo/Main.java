package eltiempo;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		FileWeather ppalobject = new FileWeather();
		// ELEGIMOS CIUDAD Y PAIS CON FORMATO Madrid,ES
		String selectedcity = "Barcelona,ES";

		// ***********************************************
		// Para leer y escribir a un fichero "WeatherComplexCiudadES" todo el
		// json de una ciudad dada
		// ppalobject.JsonWriterComplex(ppalobject.connection(selectedcity),
		// selectedcity);
		// ***********************************************

		// ***********************************************
		// Para escribir un archivo "WeatherCiudadES" la ciudad con su
		// tempertaura actual
		// ppalobject.connection(selectedcity);
		// ppalobject.JSONWriterSimple(selectedcity);
		// ***********************************************

		// ***********************************************
		// Para leer por consola el informe completo de una ciudad en json
		// ApiWeather Objetosecundario = new ApiWeather();
		// Objetosecundario.JsonReader(selectedcity);
		// ***********************************************

		// ppalobject.XMLWriter(selectedcity,
		// ppalobject.connection(selectedcity));

		// ************************BBDD***********************
		
		GestorBBDD gestorDB = new GestorBBDD();
		Weather wea = new Weather(52.2,21.2, 40.0, 2566, 254, "paco", "madrid", "coordenadas", 1, "222");
		Weather wea2 = new Weather(52.2,21.2, 40.0, 252, 2542, "paco", "barcelona", "coordenadas", 2, "223");
		System.out.println(wea);

		gestorDB.insertCiudad(wea);
		gestorDB.insertCiudad(wea2);
		//Weather we2 = gestorDB.getWeather(1);
		//System.out.println(we2);

		// ***********************************************

	}

}

// http://api.openweathermap.org/data/2.5/weather?q=Madrid,es&appid=2de143494c0b295cca9337e1e96b00e0