package Clases;

import Interfaces.IJson;
import Json.ConsumApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Pokedex implements IJson {

    private HashMap<Integer, Pokemon> pokemonsID;
     private HashMap<String, Pokemon> pokemonsName;
    private int pokemonsLength;
    public Pokedex() {
        pokemonsID = new HashMap<>();
        pokemonsName = new HashMap<>();
        pokemonsLength = 0;
    }


    @Override
    public void fromJson(JSONObject jsonObject) throws JSONException {
        JSONArray jsonArray =  jsonObject.getJSONArray("pokemons");
        setPokemonsLength(jsonObject.getInt("pokemonsLength"));
        for(int i =0; i< jsonArray.length(); i++){
            Pokemon pokemon = new Pokemon();
            JSONObject jsonPokemon = jsonArray.getJSONObject(i);
            pokemon.fromJson(jsonPokemon);
            agregarPokemon(pokemon);
        }

    }

    @Override
    public JSONObject toJson() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pokemonsLength", getPokemonsLength());
        JSONArray jsonArray = new JSONArray();
        Iterator it= pokemonsID.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, Pokemon> pokemon = (Map.Entry<Integer, Pokemon>) it.next();
            jsonArray.put(pokemon.getValue().toJson());
        }
        jsonObject.put("pokemons", jsonArray);

        return jsonObject;
    }



    public void fromJsonAPI(JSONObject jsonObject) throws JSONException {
        setPokemonsLength(1010);
        String link = "";
        Integer aux = 0;
        String numString = "";



        for(int i = 1 ; i<pokemonsLength ;i++){
            Pokemon pokemon = new Pokemon();

            aux = i;
            numString = aux.toString();
            System.out.println(numString);
            link = ConsumApi.getInfo("https://pokeapi.co/api/v2/pokemon/"+ numString+"/");

            JSONObject jsonPokemon = new JSONObject(link);
            pokemon.fromJsonAPI(jsonPokemon);
            System.out.println(pokemon.toString());
            agregarPokemon(pokemon);

        }

    }

    public void agregarPokemon(Pokemon pokemon){

        pokemonsName.put(pokemon.getName(), pokemon);
        pokemonsID.put(pokemon.getId(), pokemon);
    }


    @Override
    public String toString() {
        String content = pokemonsID.toString().replace(",", "\n");
        return "Pokedex{" +
                content + "\n" +
                ", pokemonsLength=" + pokemonsLength +
                '}';
    }

    public String toStringLista() {
        Iterator it = pokemonsID.entrySet().iterator();
        String lista = "";

        while (it.hasNext()) {
            Map.Entry<Integer, Pokemon> pokemon = (Map.Entry<Integer, Pokemon>) it.next();
            lista.concat(pokemon.getValue().toString());
            lista.concat("\n");
        }
        return lista;
    }

    public String pokemonNombre(String name){
        return pokemonsName.get(name).toString();
    }


    public Pokemon buscarPokemonID(Integer id){
        return pokemonsID.get(id);
    }

    private void setPokemonsLength(int pokemonsLength) {
        this.pokemonsLength = pokemonsLength;
    }

    public int getPokemonsLength() {
        return pokemonsLength;
    }

    public void printGeneration(int  generation){
        String generationaux = "";
        Iterator it = pokemonsName.entrySet().iterator();
        int id = 0;

        if(generation == 1){
           generationaux = "generation-i";
        } else if (generation == 2) {
            generationaux = "generation-ii";
        } else if (generation == 3) {
            generationaux = "generation-iii";
        } else if (generation == 4) {
            generationaux = "generation-iv";
        } else if (generation == 5) {
            generationaux = "generation-v";
        } else if (generation == 6) {
            generationaux = "generation-vi";
        }else if (generation == 7) {
            generationaux = "generation-vii";
        }else if (generation == 8) {
            generationaux = "generation-viii";
        }else if (generation == 9) {
            generationaux = "generation-ix";
        }

        while (it.hasNext()) {
            Map.Entry<String, Pokemon> pokemon = (Map.Entry<String, Pokemon>) it.next();



            if((pokemon.getValue().getGeneration().equalsIgnoreCase(generationaux))){

                if(pokemon.getValue().getId()>id){
                    id = pokemon.getValue().getId();
                }
                //System.out.println(pokemon.getValue().getId() + " "+ pokemon.getValue().getName());
            }
        }
        System.out.println(id);

    }


}

    