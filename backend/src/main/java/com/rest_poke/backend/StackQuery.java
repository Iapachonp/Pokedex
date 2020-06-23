
package com.rest_poke.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class StackQuery {

	private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon";
	private static final String OFFSET = "?offset="; 
	private static final String Limit = "&limit="; 


	private int pokemon_id = 20;
	private int pokemon_offset = 0;
	
	public String execute(String custom, String custom_url) throws IOException {
		// create a URL
		URL url;
		
		if (custom.equals("yes") ){
			url = build_custom_url(custom_url);

		}else {

			url = buildUrl();
		}
		
		
		// connect to a server
		
		StringBuilder sb = new StringBuilder();
		try ( BufferedReader reader = new BufferedReader(
				new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)) ) {
			char[] buffer = new char[2048];
			int size = 0;
			while ((size = reader.read(buffer)) > 0) {
				sb.append(buffer, 0, size);
			}
		}
		
		// get information back
		// return data
		return sb.toString();
	}
	
	
	
	public URL buildUrl() throws MalformedURLException {
		StringBuilder urlString = new StringBuilder();
		urlString.append(BASE_URL);
		urlString.append(OFFSET); 
		urlString.append(this.pokemon_offset); 
		urlString.append(Limit); 
		//urlString.append(PARAM_SITE).append(this.pokemon_name);
		urlString.append(this.pokemon_id);
		
		URL url = new URL(urlString.toString());
		return url;
	}

	public URL build_custom_url (String custom_url) throws MalformedURLException {
		StringBuilder urlString = new StringBuilder();
		//urlString.append("https://pokeapi.co/api/v2/pokemon/type/");
		urlString.append(custom_url);
		//urlString.append("type/");
		URL url = new URL(urlString.toString());
		return url;
	}
	
	

	public void setpokemonid(int pokemon_id) {
		this.pokemon_id = pokemon_id;
	}

	public void setpokemonoffset(int pokemon_offset) {
		this.pokemon_offset= pokemon_offset;
	}
	

		
}
