import Clases.Game;
import Clases.Pokemon;
import Json.ConsumApi;
import Clases.Pokedex;
import Json.JsonUtiles;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {

        String link = ConsumApi.getInfo("https://pokeapi.co/api/v2/pokemon/");


        try {
            Pokedex pokedex = new Pokedex();
            String arch = JsonUtiles.leer("pokedex");
            JSONObject jsonObject = new JSONObject(arch);
            pokedex.fromJson(jsonObject);


            pokedex.printGeneration(9);
            //System.out.println(pokedex.toString());

            /*JSONObject jsonObject = new JSONObject(link);
            Pokedex pokedex = new Pokedex();
            pokedex.fromJsonAPI(jsonObject);
            JsonUtiles.grabar(pokedex.toJson(), "pokedex");*/


            /*String pokemon = ConsumApi.getInfo("https://pokeapi.co/api/v2/pokemon/388/");
            JSONObject jsonObject1 = new JSONObject(pokemon);
            Pokemon rattata = new Pokemon();
            rattata.fromJsonAPI(jsonObject1);
            System.out.println(rattata.toString());*/


        } catch (JSONException e) {
            System.out.println(e);
        }

    }
}