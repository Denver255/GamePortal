package NumberGuesser;

import java.util.Scanner;

import Game.Game;
import Game.GameWriteable;

import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class NumGame implements GameWriteable{
    int guesses;
    int numToGuess;
    static Scanner sc = new Scanner(System.in);
    static Random random =new Random();
    ArrayList<Integer> pguesses = new ArrayList<>();
    static boolean goodToGo=true;

   public NumGame(int low, int high) {
        guesses = 0;
        // TODO: setup.
        System.out.println("I'm thinking of a number + " + low + " to " + high);
        numToGuess= random.nextInt(low,high);
        // assign numToGuess to that random number.
    }

    public void play() {
        // you can remove these println statements, they are just here for you to
        // understand how we call this code.
        System.out.println("Guess a number!");
        int rguess=getGuess();
        // When user guesses incorrectly, says whether the number is higher or lower.
        if(goodToGo==true){
        if(rguess==numToGuess){
            System.out.println("You won! You had " + guesses +" guesses!");
        }else if(rguess>numToGuess){
            System.out.println("The number is lower. Try again.");
            play();
        }else if(rguess<numToGuess){
            System.out.println("The number is higher. Try again.");
            play();
        }
    }
         if(goodToGo==false){
           System.out.println("You already guessed that! :(");  
           play();
        }
        // When user guesses correctly, finishes the game and tells them how many
        // guesses they had.
    }

    int getGuess() {
        // get user input from a Scanner.
        int guess= sc.nextInt();
        guesses=guesses+1;
         for(int i=0; i<pguesses.size();i++){
            if(pguesses.get(i)==guess){
                goodToGo=false;
            }
        }
        pguesses.add(guess);
        return guess;
    }

    int getNumGuesses() {
        return guesses;
    }

    public void writeHighScore(){

    }
    
    public void getBestScore(){

    }

    public String getScore(){
        return Integer.toString(guesses);
    } 

    public void writeHighScore(File f){
          String score = getScore();
        String highScore = getBestScore(f);
        System.out.println("Thanks for playing! Your score was " + score);

        if (isHighScore(score, highScore)) {
            System.out.println("You got a new high score, which beats the previous high score of " + highScore);
            try {

                Scanner myReader = new Scanner(f);
                String newFile = "";
                while (myReader.hasNextLine()) {
                    // rewrite all lines except the line with the game name
                    String line = myReader.nextLine();
                    String[] data = line.split(",");
                    if (!data[0].equals(getGameName())) {
                        newFile += line + "\n";
                    }
                }
                // replace the Game's line with the new high score
                // puts it at the end of the file
                newFile += getGameName() + "," + score + "\n";
                // write the new file
                FileWriter myWriter = new FileWriter(f);
                myWriter.write(newFile);
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

     public boolean isHighScore(String score, String currentHighScore){
        if(currentHighScore==null){
            return true;
        }
        if(Integer.parseInt(score)<Integer.parseInt(currentHighScore)){
            return true;
        }
        return false;
     }

    public String getGameName(){

        return "NumGame";
    }
}
