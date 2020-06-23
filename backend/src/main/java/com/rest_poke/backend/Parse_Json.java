
package com.rest_poke.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;  
import org.json.simple.JSONValue;


public class Parse_Json  {
    

    public static String Json;

    public static Pokemom handle() throws IOException {
        /*
         * We suspect that this block of statement can throw exception so we handled it
         * by placing these statements inside try and handled the exception in catch
         * block
         */
        // Pokemom pagePokemom = objectMapper.readValue(Json, Pokemom.class);
        Object obj = JSONValue.parse(Json);
        JSONObject jsonObject = (JSONObject) obj;
        Pokemom pokepagPokemom = new Pokemom();
       
        pokepagPokemom.count = (Long) jsonObject.get("count");  
        pokepagPokemom.next = (String) jsonObject.get("next");  
        pokepagPokemom.previous = (String) jsonObject.get("previous");

        
        //System.out.println(jsonObject.get("count"));

        return pokepagPokemom;
     }

     public static ArrayList<Pokemon_class> handle_2() throws IOException {
        /*
         * We suspect that this block of statement can throw exception so we handled it
         * by placing these statements inside try and handled the exception in catch
         * block
         */
        // Pokemom pagePokemom = objectMapper.readValue(Json, Pokemom.class);
        Object obj = JSONValue.parse(Json);
        JSONObject jsonObject = (JSONObject) obj;

        JSONArray arrayContent = (JSONArray) jsonObject.get("results");
        Iterator i = arrayContent.iterator();

        ArrayList<Pokemon_class> pokeArr = new ArrayList<Pokemon_class>();

        while (i.hasNext()) {
            JSONObject slide = (JSONObject) i.next();
            pokeArr.add(new Pokemon_class((String)slide.get("name"), (String)slide.get("url") ));
        }

        
        //System.out.println(jsonObject.get("count"));

        return pokeArr;
     }

     public static Pokemon_class handle_pokemon_stats() throws IOException {
        /*
         * We suspect that this block of statement can throw exception so we handled it
         * by placing these statements inside try and handled the exception in catch
         * block
         */
        // Pokemom pagePokemom = objectMapper.readValue(Json, Pokemom.class);
        Object obj = JSONValue.parse(Json);
        JSONObject jsonObject = (JSONObject) obj;
        Pokemon_class pokemon = new Pokemon_class(null,null);
       
        pokemon.id = (long) jsonObject.get("id");  
        pokemon.name = (String) jsonObject.get("name"); 
        pokemon.order = (long) jsonObject.get("order");
        pokemon.height = (long) jsonObject.get("height");
        pokemon.weight = (long) jsonObject.get("weight");


        JSONArray typeContent = (JSONArray) jsonObject.get("types");

        pokemon.type = (String ) typeContent.get(0).toString();


        Object obj_typObject= JSONValue.parse(typeContent.get(0).toString());
        JSONObject jsonObject_types = (JSONObject) obj_typObject;
        JSONObject j_type = (JSONObject) jsonObject_types.get("type");
        pokemon.type = (String) j_type.get("name");


                
        //System.out.println(jsonObject.get("count"));

        return pokemon;
     }

    
     public void setJson(String json) {
         Json = json;   
     }

     public String getJson() {
         return Json;
     }

}

