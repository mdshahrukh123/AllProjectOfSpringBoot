package com.Geekster.weatherAPI_and_callAPI;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApiAndCallApiApplication {

	public static void main(String[] args) throws Exception {
//		** for any API  **
//		URL getUrl = new URL("https://catfact.ninja/fact");
//		 ** for weather API
		URL getUrl = new URL("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		if(responseCode == 200){
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer jsonResponseData = new StringBuffer();
			String readLine = null;

			while((readLine = in.readLine()) != null){
				jsonResponseData.append(readLine);
			}
			in.close();
			JSONObject masterData = new JSONObject(jsonResponseData.toString());

			System.out.println("Current  all weather " + masterData);
			System.out.println("Current elevation " + masterData.get("elevation"));
//
			JSONObject currentWeatherObj = (JSONObject) masterData.get("current_weather");
//
			System.out.println("Current weather " + currentWeatherObj);
			System.out.println("Current temperature " + currentWeatherObj.get("temperature"));
			System.out.println("Current windspeed " + currentWeatherObj.get("windspeed"));
//			** for call any API **
//			System.out.println(jsonResponseData.toString());
		}else {
			System.out.println("This is not valid URL " +responseCode);
		}
	}

}
