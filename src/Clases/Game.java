package Clases;

import java.util.ArrayList;

public class Game {

    private ArrayList<Pokemon> pokemons;
    private int lives;

    public Game() {
        lives = 5;
        pokemons = new ArrayList<>();
    }

    public int determineGeneration(int generation){
        int indice = 0;
        if(generation == 1){
            indice = (int)(Math.random()*(151-0+1)+0);
        } else if (generation == 2) {
            indice = (int)(Math.random()*(251-150+1)+150);
        }else if (generation == 3) {
            indice = (int)(Math.random()*(386-250+1)+250);
        }else if (generation == 4) {
            indice = (int)(Math.random()*(493-385+1)+385);
        }else if (generation == 5) {
            indice = (int)(Math.random()*(649-492+1)+492);
        }else if (generation == 6) {
            indice = (int)(Math.random()*(721-648+1)+648);
        }else if (generation == 7) {
            indice = (int)(Math.random()*(809-720+1)+720);
        }else if (generation == 8) {
            indice = (int)(Math.random()*(905-808+1)+808);
        }else if (generation == 9) {
            indice = (int)(Math.random()*(1009-904+1)+904);
        }

        return indice;
    }



    public boolean gameEvaluation(Pokemon pokemon, String nombre){
        boolean evaluation = false;
        if(pokemon.getName().equalsIgnoreCase(nombre)){
            evaluation = true;
        }
        if(evaluation  == false){
            lives--;
        }

        return  evaluation;
    }


    public void gameFunction(Pokedex pokedex){
        System.out.println("");
    }



}
