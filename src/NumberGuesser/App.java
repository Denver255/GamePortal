package NumberGuesser;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

// Task 0: Make the NumberGuessGame work in Game.java
// Optional: 
// Task 1: Get getNumGuesses() to work correctly for each Game, and call getBestGame() here in App.java
// Task 2: Be forgiving to players - tell them they already guessed a number if they have, and do not add it to numGuesses.

public class App {
    static int minGame= 0;
    static boolean played=false;
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the Number Guess Game!");
        // See Game for pseudocode you need to fill out
        // Create a new Game that sets a number within the user's specified number range
        ArrayList<NumGame> games = new ArrayList<>();
        HashMap<Integer,Integer> hg=new HashMap<>();
        Scanner sc = new Scanner(System.in);
        getBestGame(games);
        System.out.println("To play a game, press 'y'. If you want to stop playing, type anything other than 'y'.");
        while (sc.hasNext() && sc.next().equals("y")) {
            NumGame g = new NumGame(1, 2);
            g.play();
            games.add(g);
            getBestGame(games);
            System.out.println("press 'y' to play another game.");
            //int val = hg.get(g.getNumGuesses());
            if(hg.containsKey(g.getNumGuesses())){
            hg.put(g.getNumGuesses(),hg.get(g.getNumGuesses())+1);
            }else{
                hg.put(g.getNumGuesses(),1);
            }
            System.out.println(hg);
        }

    }

    public static void getBestGame(ArrayList<NumGame> games) {
        // best game
        for (NumGame g : games) {
            if(played==false){
                minGame=g.getNumGuesses();
            }
            if (g.getNumGuesses() < minGame && played==true) {
                minGame = g.getNumGuesses();
            }
            played=true;
        }
        System.out.println("min game is: " + minGame);
    }
}
