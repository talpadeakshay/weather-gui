package com.akshay.weather.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {

	public static List<JSONObject> getJsonListFromFile(String filePath)
			throws Exception {
		Stream<String> fileLines = null;
		List<JSONObject> lstJsonObjects = new ArrayList<JSONObject>();
		try {
			JSONParser parser = new JSONParser();
			fileLines = Files.lines(Paths.get(filePath));
			Iterator<String> itrJsonFile = fileLines.iterator();
			while (itrJsonFile.hasNext()) {
				String json = (String) itrJsonFile.next();
				JSONObject jsonObj = (JSONObject) parser.parse(json);
				lstJsonObjects.add(jsonObj);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileLines != null) {
				fileLines.close();
			}
		}
		JSONArray jsonAraay = new JSONArray(lstJsonObjects);
		return lstJsonObjects;

	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static org.json.JSONObject readJsonFromUrl(String url)
			throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			org.json.JSONObject json = new org.json.JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static void main(String[] args) throws IOException, JSONException {
		org.json.JSONObject json = readJsonFromUrl("http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID=816150473629483737aadaf7fa40c57e");
		System.out.println(json.toString());
		//System.out.println(json.get("city"));

		/*
		 * try { String json = readJsonFromUrl(
		 * "http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID=816150473629483737aadaf7fa40c57e"
		 * ); System.out.println(json.toString()); //
		 * System.out.println(((JSONObject)json.get("city")).get("name"));
		 * JsonReader .getJsonListFromFile(
		 * "C:/QuartetFS/Git/weather-gui/weatherreport/src/main/resources/weather/city.list.json"
		 * ); } catch (Exception e) { e.printStackTrace(); }
		 */
	}

}