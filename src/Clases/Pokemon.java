package Clases;

import Interfaces.IJson;
import Json.ConsumApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pokemon implements IJson {

    private int id;
    private String name;
    private String generation;
    private String firstForm;
    private ArrayList<String> secondForm;
    private ArrayList<String> thirdForm;
    private String spriteNormal;
    private String spriteShiny;
    private String spriteFirstForm;
    private ArrayList<String> spriteSecondForm;
    private ArrayList<String> spriteThirdForm;
    private int height;
    private int weight;
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    private ArrayList<String> types;

    public Pokemon() {
        id = 0;
        name = "";
        generation = "";
        firstForm = "";
        secondForm = new ArrayList<>();
        thirdForm = new ArrayList<>();

        spriteNormal = "";
        spriteShiny = "";
        spriteFirstForm = "";
        spriteSecondForm = new ArrayList<>();
        spriteThirdForm = new ArrayList<>();

        height = 0;
        weight = 0;
        hp = 0;
        attack = 0;
        defense = 0;
        specialAttack = 0;
        specialDefense = 0;
        speed = 0;
        types = new ArrayList<>();

    }

    public Pokemon(int id, String name, String generation, String spriteNormal,String firstForm, String spriteShiny, String spriteFirstForm, int height, int weight, int hp, int attack, int defense, int specialAttack, int specialDefense, int speed) {
        this.id = id;
        this.name = name;
        this.generation = generation;
        this.firstForm = firstForm;
        secondForm = new ArrayList<>();
        thirdForm = new ArrayList<>();
        this.spriteNormal = spriteNormal;
        this.spriteShiny = spriteShiny;
        this.spriteFirstForm = spriteFirstForm;
        this.spriteSecondForm = new ArrayList<>();
        this.spriteThirdForm = new ArrayList<>();
        this.height = height;
        this.weight = weight;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        types = new ArrayList<>();
    }



    @Override
    public void fromJson(JSONObject jsonObject) throws JSONException {
        setId(jsonObject.getInt("id"));
        setName(jsonObject.getString("name"));
        setGeneration(jsonObject.getString("generation"));
        setFirstForm(jsonObject.getString("firstForm"));

        JSONArray jsonSecondForm = jsonObject.getJSONArray("secondForm");
        for(int i = 0; i<jsonSecondForm.length();i++){
            setSecondForm(jsonSecondForm.getString(i));
        }

        JSONArray jsonThirdForm = jsonObject.getJSONArray("thirdForm");
        for(int i = 0; i<jsonThirdForm.length();i++){
            setSecondForm(jsonThirdForm.getString(i));
        }

        setSpriteNormal(jsonObject.getString("spriteNormal"));
        setSpriteShiny(jsonObject.getString("spriteShiny"));
        setSpriteFirstForm(jsonObject.getString("spriteFirstForm"));

        JSONArray jsonSpriteSecodForm = jsonObject.getJSONArray("spriteSecondForm");
        for(int i = 0; i<jsonSpriteSecodForm.length();i++){
            setSpriteSecondForm(jsonSpriteSecodForm.getString(i));
        }

        JSONArray jsonSpriteThirdForm = jsonObject.getJSONArray("spriteThirdForm");
        for(int i = 0; i<jsonSpriteThirdForm.length();i++){
            setSpriteThirdForm(jsonSpriteThirdForm.getString(i));
        }


        setHeight(jsonObject.getInt("height"));
        setWeight(jsonObject.getInt("weight"));
        setHp(jsonObject.getInt("hp"));
        setAttack(jsonObject.getInt("attack"));
        setDefense(jsonObject.getInt("defense"));
        setSpecialAttack(jsonObject.getInt("specialAttack"));
        setSpecialDefense(jsonObject.getInt("specialDefense"));
        setSpeed(jsonObject.getInt("speed"));
        JSONArray jsonArray = jsonObject.getJSONArray("types");

        for(int i = 0; i<jsonArray.length(); i++){
            types.add(jsonArray.getString(i));
        }
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject pokemon = new JSONObject();
        pokemon.put("id", getId());
        pokemon.put("name", getName());
        pokemon.put("generation", getGeneration());
        pokemon.put("firstForm", getFirstForm());
        JSONArray jsonSecondForm = new JSONArray();

        for(int i = 0; i<secondForm.size() ;i++){
            jsonSecondForm.put(secondForm.get(i));
        }
        pokemon.put("secondForm", jsonSecondForm);

        JSONArray jsonThirdForm = new JSONArray();
        for(int i = 0; i<thirdForm.size() ;i++){
            jsonThirdForm.put(thirdForm.get(i));
        }
        pokemon.put("thirdForm", jsonThirdForm);

        JSONArray jsonSpriteSecondForm = new JSONArray();
        for(int i = 0; i<spriteSecondForm.size() ;i++){
            jsonSpriteSecondForm.put(spriteSecondForm.get(i));
        }
        pokemon.put("spriteSecondForm", jsonSpriteSecondForm);

        JSONArray jsonSpriteThirdForm = new JSONArray();
        for(int i = 0; i<spriteThirdForm.size() ;i++){
            jsonSpriteThirdForm.put(spriteThirdForm.get(i));
        }
        pokemon.put("spriteThirdForm", jsonSpriteThirdForm);

        pokemon.put("spriteNormal", getSpriteNormal());
        pokemon.put("spriteShiny", getSpriteShiny());
        pokemon.put("spriteFirstForm", getSpriteFirstForm());
        pokemon.put("height", getHeight());
        pokemon.put("weight", getWeight());
        pokemon.put("hp", getHp());
        pokemon.put("attack", getAttack());
        pokemon.put("defense", getDefense());
        pokemon.put("specialAttack", getSpecialAttack());
        pokemon.put("specialDefense", getSpecialDefense());
        pokemon.put("speed", getSpeed());

        JSONArray jsonArray = new JSONArray();
        for(int i = 0; i<types.size();i++){
            jsonArray.put(types.get(i));
        }
        pokemon.put("types", jsonArray);

        return pokemon;
    }

    @Override
    public void fromJsonAPI(JSONObject jsonObject) throws JSONException {
        setId(jsonObject.getInt("id"));

        setName(jsonObject.getString("name"));

        /*if(!jsonObject.getString("name").equalsIgnoreCase("deoxys-normal") && !jsonObject.getString("name").equalsIgnoreCase("wormadam-plant") && !jsonObject.getString("name").equalsIgnoreCase("giratina-altered") && !jsonObject.getString("name").equalsIgnoreCase("shaymin-land") && !jsonObject.getString("name").equalsIgnoreCase("basculin-red-striped") && !jsonObject.getString("name").equalsIgnoreCase("tornadus-incarnate") &&!jsonObject.getString("name").equalsIgnoreCase("thundurus-incarnate") && !jsonObject.getString("name").equalsIgnoreCase("landorus-incarnate") && jsonObject.getString("name").equalsIgnoreCase("keldeo-ordinary") ){

        } else if (jsonObject.getString("name").equalsIgnoreCase("deoxys-normal")) {
            setName("deoxys");
        } else if (jsonObject.getString("name").equalsIgnoreCase("wormadam-plant")) {
            setName("wormadam");
        } else if (jsonObject.getString("name").equalsIgnoreCase("giratina-altered")) {
            setName("giratina");
        } else if (jsonObject.getString("name").equalsIgnoreCase("shaymin-land")) {
            setName("shaymin");
        } else if (jsonObject.getString("name").equalsIgnoreCase("basculin-red-striped")) {
            setName("basculin");
        } else if (jsonObject.getString("name").equalsIgnoreCase("tornadus-incarnate")) {
            setName("tornadus");
        } else if (jsonObject.getString("name").equalsIgnoreCase("thundurus-incarnate")) {
            setName("thundurus");
        }else if (jsonObject.getString("name").equalsIgnoreCase("landorus-incarnate")) {
            setName("landorus");
        }else if (jsonObject.getString("name").equalsIgnoreCase("keldeo-ordinary")) {
            setName("keldeo");
        }else if (jsonObject.getString("name").equalsIgnoreCase("keldeo-ordinary")) {
            setName("keldeo");
        }*/

        JSONObject species = jsonObject.getJSONObject("species"); //JsonObject para tener el link de la generación
        String linkGeneration = species.getString("url");
        String urlAux1 = ConsumApi.getInfo(linkGeneration);
        JSONObject jsonSpecies = new JSONObject(urlAux1);
        JSONObject jsonGeneration = jsonSpecies.getJSONObject("generation");
        setGeneration(jsonGeneration.getString("name"));

        JSONObject jsonEvolutionChain = jsonSpecies.getJSONObject("evolution_chain");
        String linkEvolutionChain = jsonEvolutionChain.getString("url");
        String urlAux2 = ConsumApi.getInfo(linkEvolutionChain);
        JSONObject jsonEvolution_Chain = new JSONObject(urlAux2);  // hasta aca se accede al link de las evoluciones

        JSONObject jsonChain = jsonEvolution_Chain.getJSONObject("chain");

        JSONObject jsonFirsForm = jsonChain.getJSONObject("species");  //Primera evolucion
        setFirstForm(jsonFirsForm.getString("name"));
        String linkFirstForm = "";

        String linkNum = jsonFirsForm.getString("url"); //Encontrar sprites a partir de la url de la evolcion
        String stringnum = ConsumApi.getInfo(linkNum);
        JSONObject jsonObject1 = new JSONObject(stringnum);
        Integer num = jsonObject1.getInt("id");
        linkFirstForm = "https://pokeapi.co/api/v2/pokemon/"+ num.toString();

        // if(!firstForm.equalsIgnoreCase("deoxys") && !firstForm.equalsIgnoreCase("giratina") && !firstForm.equalsIgnoreCase("shaymin" ) && !firstForm.equalsIgnoreCase("basculin" ) && !firstForm.equalsIgnoreCase("tornadus") && !firstForm.equalsIgnoreCase("thundurus") && !firstForm.equalsIgnoreCase("landorus") && !firstForm.equalsIgnoreCase("keldeo")){

        /*}else if(firstForm.equalsIgnoreCase("deoxys")){
             linkFirstForm = "https://pokeapi.co/api/v2/pokemon/"+"deoxys-normal";
        } else if (firstForm.equalsIgnoreCase("giratina")) {
            linkFirstForm = "https://pokeapi.co/api/v2/pokemon/"+"giratina-altered";
        }else if(firstForm.equalsIgnoreCase("shaymin" )){
            linkFirstForm = "https://pokeapi.co/api/v2/pokemon/"+ "shaymin-land/";
        } else if (firstForm.equalsIgnoreCase("basculin")) {
            linkFirstForm = "https://pokeapi.co/api/v2/pokemon/"+ "basculin-red-striped/";
        }else if (firstForm.equalsIgnoreCase("tornadus")) {
            linkFirstForm = "https://pokeapi.co/api/v2/pokemon/"+ "tornadus-incarnate/";
        } else if (firstForm.equalsIgnoreCase("thundurus")) {
            linkFirstForm = "https://pokeapi.co/api/v2/pokemon/"+ "thundurus-incarnate/";
        }else if (firstForm.equalsIgnoreCase("landorus")){
            linkFirstForm = "https://pokeapi.co/api/v2/pokemon/"+ "landorus-incarnate/";
        } else if (firstForm.equalsIgnoreCase("keldeo")) {
            linkFirstForm = "https://pokeapi.co/api/v2/pokemon/"+ "keldeo-ordinary/";
        }*/


        String stringFirstForm = ConsumApi.getInfo(linkFirstForm);
        JSONObject jsonFirstForm = new JSONObject(stringFirstForm);
        JSONObject jsonSpritesFistForm = jsonFirstForm.getJSONObject("sprites");
        JSONObject jsonSpritesOthersFirstForm = jsonSpritesFistForm.getJSONObject("other");
        JSONObject jsonSpritesHomeFirstForm = jsonSpritesOthersFirstForm.getJSONObject("official-artwork");
        setSpriteFirstForm(jsonSpritesHomeFirstForm.getString("front_default"));



        JSONArray arrayEvolvesTo = jsonChain.getJSONArray("evolves_to");

        if(arrayEvolvesTo.length()>0){

            for(int i = 0; i< arrayEvolvesTo.length();i++) {

                JSONObject jsonEvolution = arrayEvolvesTo.getJSONObject(i); //Segunda evolucion

                JSONObject jsonSecondEvolution = jsonEvolution.getJSONObject("species");
                setSecondForm(jsonSecondEvolution.getString("name"));


                String linkNum2 = jsonSecondEvolution.getString("url"); //Encontrar sprites a partir de la url de la evolcion
                String stringnum2 = ConsumApi.getInfo(linkNum2);
                JSONObject jsonObject2 = new JSONObject(stringnum2);
                Integer num2 = jsonObject2.getInt("id");
                String linkSecondForm = "https://pokeapi.co/api/v2/pokemon/" + num2.toString();

                /*
                if(!secondFormAux.equalsIgnoreCase("wormadam") && !secondFormAux.equalsIgnoreCase("basculegion") && !secondFormAux.equalsIgnoreCase("darmanitan")){

                }else if(secondFormAux.equalsIgnoreCase("wormadam")){
                     linkSecondForm = "https://pokeapi.co/api/v2/pokemon/" + "wormadam-plant";
                } else if (secondFormAux.equalsIgnoreCase("basculegion")) {
                    linkSecondForm = "https://pokeapi.co/api/v2/pokemon/" + "basculegion-male";
                } else if (secondFormAux.equalsIgnoreCase("darmanitan")) {
                    linkSecondForm = "https://pokeapi.co/api/v2/pokemon/" + "darmanitan-standard";
                }*/


                String stringSecondForm = ConsumApi.getInfo(linkSecondForm);
                JSONObject jsonSecondForm = new JSONObject(stringSecondForm);

                JSONObject jsonSpritesSecondForm = jsonSecondForm.getJSONObject("sprites");
                JSONObject jsonSpritesOthersSecondForm = jsonSpritesSecondForm.getJSONObject("other");
                JSONObject jsonSpritesHomeSecondForm = jsonSpritesOthersSecondForm.getJSONObject("official-artwork");
                setSpriteSecondForm(jsonSpritesHomeSecondForm.getString("front_default"));

                JSONArray arrayFinalEvolution = jsonEvolution.getJSONArray("evolves_to");
                if (arrayFinalEvolution.length() > 0) {
                    for( int b = 0; b<arrayFinalEvolution.length();b++){
                        JSONObject jsonFinalEvolution = arrayFinalEvolution.getJSONObject(b);
                        JSONObject jsonThirdEvolution = jsonFinalEvolution.getJSONObject("species");
                        setThirdForm(jsonThirdEvolution.getString("name"));  //tercera evolucion


                        String linkNum3 = jsonThirdEvolution.getString("url"); //Encontrar sprites a partir de la url de la evolcion
                        String stringnum3 = ConsumApi.getInfo(linkNum3);
                        JSONObject jsonObject3 = new JSONObject(stringnum3);
                        Integer num3 = jsonObject3.getInt("id");
                        String linkThirdForm = "https://pokeapi.co/api/v2/pokemon/" + num3.toString();

                        String stringThirdForm = ConsumApi.getInfo(linkThirdForm);
                        JSONObject jsonThirdForm = new JSONObject(stringThirdForm);
                        JSONObject jsonSpritesThirdForm = jsonThirdForm.getJSONObject("sprites");
                        JSONObject jsonSpritesOthersThirdForm = jsonSpritesThirdForm.getJSONObject("other");
                        JSONObject jsonSpritesHomeThirdForm = jsonSpritesOthersThirdForm.getJSONObject("official-artwork");
                        setSpriteThirdForm(jsonSpritesHomeThirdForm.getString("front_default"));
                    }


                }
            }

        }

        JSONObject jsonSprites = jsonObject.getJSONObject("sprites");
        JSONObject jsonSpritesOthers = jsonSprites.getJSONObject("other");
        JSONObject jsonSpritesHome = jsonSpritesOthers.getJSONObject("official-artwork");
        setSpriteNormal(jsonSpritesHome.getString("front_default"));

        if(jsonSpritesHome.isNull("front_shiny")){
            spriteShiny = "";
        }else{
            setSpriteShiny(jsonSpritesHome.getString("front_shiny")); //Sprite del pokemon normal
        }


        setHeight(jsonObject.getInt("height"));
        setWeight(jsonObject.getInt("weight"));

        JSONArray stats = jsonObject.getJSONArray("stats");
        JSONObject jsonHp = stats.getJSONObject(0);
        setHp(jsonHp.getInt("base_stat"));

        JSONObject jsonAttack = stats.getJSONObject(1);
        setAttack(jsonAttack.getInt("base_stat"));

        JSONObject jsonDefense = stats.getJSONObject(2);
        setDefense(jsonDefense.getInt("base_stat"));

        JSONObject jsonSpecialAttack = stats.getJSONObject(3);
        setSpecialAttack(jsonSpecialAttack.getInt("base_stat"));

        JSONObject jsonSpecialDefense = stats.getJSONObject(4);
        setSpecialDefense(jsonSpecialDefense.getInt("base_stat"));

        JSONObject jsonSpeed = stats.getJSONObject(5);
        setSpeed(jsonSpeed.getInt("base_stat"));


        JSONArray arrayTypes = jsonObject.getJSONArray("types");
        JSONObject type = new JSONObject();
        JSONObject typeAux = new JSONObject();
        for(int i = 0; i<arrayTypes.length();i++){
            type = arrayTypes.getJSONObject(i);
            typeAux = type.getJSONObject("type");
            setType(typeAux.getString("name"));
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGeneration() {
        return generation;
    }

    public String getFirstForm() {
        return firstForm;
    }

    public String getSecondForm(int i) {
        return secondForm.get(i);
    }

    public String getThirdForm(int i) {
        return thirdForm.get(i);
    }

    public String getSpriteNormal() {
        return spriteNormal;
    }

    public String getSpriteShiny() {
        return spriteShiny;
    }

    public String getSpriteFirstForm() {
        return spriteFirstForm;
    }

    public String getSpriteSecondForm(int  i) {
        return spriteSecondForm.get(i);
    }

    public String getSpriteThirdForm(int i) {
        return spriteThirdForm.get(i);
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public int getSpeed() {
        return speed;
    }


    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setGeneration(String generation) {
        this.generation = generation;
    }

    private void setFirstForm(String firstForm) {
        this.firstForm = firstForm;
    }

    private void setSecondForm(String secondForm) {
        this.secondForm.add(secondForm);
    }

    private void setThirdForm(String thirdForm) {
        this.thirdForm .add(thirdForm);
    }

    private void setSpriteNormal(String spriteNormal) {
        this.spriteNormal = spriteNormal;
    }

    private void setSpriteShiny(String spriteShiny) {
        this.spriteShiny = spriteShiny;
    }

    private void setSpriteFirstForm(String spriteFirstForm) {
        this.spriteFirstForm = spriteFirstForm;
    }

    private void setSpriteSecondForm(String spriteSecondForm) {
        this.spriteSecondForm.add(spriteSecondForm);
    }

    public void setSpriteThirdForm(String spriteThirdForm) {
        this.spriteThirdForm.add(spriteThirdForm);
    }

    private void setHeight(int height) {
        this.height = height;
    }

    private void setWeight(int weight) {
        this.weight = weight;
    }

    private void setHp(int hp) {
        this.hp = hp;
    }

    private void setAttack(int attack) {
        this.attack = attack;
    }

    private void setDefense(int defense) {
        this.defense = defense;
    }

    private void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    private void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    private void setType(String type){
        types.add(type);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id + "\n" +
                ", name='" + name + "\n"  +
                ", generation='" + generation + "\n" +
                ", firstForm='" + firstForm + "\n" +
                ", secondForm='" + secondForm + "\n" +
                ", thirdForm='" + thirdForm + "\n" +
                ", spriteNormal='" + spriteNormal + "\n" +
                ", spriteShiny='" + spriteShiny + "\n" +
                ", spriteFirstForm='" + spriteFirstForm + "\n" +
                ", spriteSecondForm='" + spriteSecondForm + "\n" +
                ", spriteThirdForm='" + spriteThirdForm + "\n" +
                ", height=" + height + "\n" +
                ", weight=" + weight + "\n" +
                ", hp=" + hp + "\n" +
                ", attack=" + attack + "\n" +
                ", defense=" + defense + "\n" +
                ", specialAttack=" + specialAttack + "\n" +
                ", specialDefense=" + specialDefense + "\n" +
                ", speed=" + speed + "\n" +
                ", types=" + types + "\n" +
                '}';
    }


}
