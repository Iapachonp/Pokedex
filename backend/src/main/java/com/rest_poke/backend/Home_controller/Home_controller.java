
package com.rest_poke.backend.Home_controller;

import java.io.IOException;
import java.util.ArrayList;

import com.rest_poke.backend.Parse_Json;
import com.rest_poke.backend.Pokemon_class;
import com.rest_poke.backend.StackQuery;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
public class Home_controller {

    @GetMapping(value = "/")
    public ArrayList<Pokemon_class> getMethodName(@RequestParam (defaultValue = "0") String off) throws IOException {

        final StackQuery query = new StackQuery();
        final Parse_Json Json = new Parse_Json();
        
		ArrayList<Pokemon_class> pokeArr = new ArrayList<Pokemon_class>();
		ArrayList<Pokemon_class> pokeArr_2 = new ArrayList<Pokemon_class>();
		
		query.setpokemonid(20);
		query.setpokemonoffset(Integer.parseInt(off));

		//Json Pokemon page (20 pokemon list)
		Json.setJson(query.execute("no", null));

		pokeArr = Parse_Json.handle_2();

		int i; 
        
		for (i = 0; i < pokeArr.size(); i++) { 
  
			//Json Pokemon individuals 
			Json.setJson(query.execute("yes", pokeArr.get(i).url));

            pokeArr_2.add(i, Parse_Json.handle_pokemon_stats());
            
		} 

        return pokeArr_2;
    }
    
    
}