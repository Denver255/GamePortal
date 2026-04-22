package cards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import Game.GameWriteable;
import processing.core.PApplet;

public class AppRW extends PApplet implements GameWriteable {

    CardGame cardGame = new War();
    private int timer;
    CountDownLatch latch;

    public static void main(String[] args) {
          PApplet.main("App");
    }
    
    public void play(){
        String[] args = {"W","A","R"};
        PApplet.runSketch(new String[] { "Your Game Name" }, this); // “this” allows the sketch to use this one instance’s fields and functions, instead of creating a second instance, which would also be a problem if you launched processing using PApplet.main(). 
        latch = new CountDownLatch(1); 
       try {
         latch.await(); // to make this line of code finish, you call latch.countDown() somewhere else in your processing code :) 
       } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       }

    }

    @Override
    public void settings() {
        size(600, 600);   
    }

    @Override
    public void draw() {
        background(255);
        // Draw player hands
        cardGame.playerOneHand.draw(this);
        // Draw computer hand
        cardGame.playerTwoHand.draw(this);
        
        // Draw draw button
        fill(200);
        cardGame.drawButton.draw(this);
        fill(0);
        textAlign(CENTER, CENTER);
        if(cardGame.loser==false && cardGame.winner==false){
        text("Play", cardGame.drawButton.x + cardGame.drawButton.width / 2, cardGame.drawButton.y + cardGame.drawButton.height / 2);
        }
        if(cardGame.loser==true || cardGame.winner==true){
        text("Reset", cardGame.drawButton.x + cardGame.drawButton.width / 2, cardGame.drawButton.y + cardGame.drawButton.height / 2);
        }
        // Display current player
        fill(0);
        textSize(16);
        if(cardGame.winner==false && cardGame.loser==false){
        text("Current Player: " + cardGame.getCurrentPlayer(), width / 2, 20);
        }
        text("Backup:"+ cardGame.backup,50,250);
        // text("Nuke:"+ cardGame.nuke,50,280);
        // Display deck size
       // text("Deck Size: " + cardGame.getDeckSize(), width / 2,
        //       height - 20);
        // Display last played card
        if (cardGame.getLastPlayedCard() != null) {
            cardGame.getLastPlayedCard().setPosition(width / 2 - 40, height / 2 - 60, 80, 120);
            cardGame.getLastPlayedCard().draw(this);
        }
        if (cardGame.getCurrentPlayer() == "Player Two") {
            fill(0);
            textSize(16);
            cardGame.showP2Card();
            text("Computer is thinking...", width / 2, height / 2 + 80);
            timer++;
            if (timer == 100) {
                cardGame.handleComputerTurn();
                timer = 0;
            }
        }
        if(CardGame.winner==true){
            fill(0);
            textSize(16);
            text("You Won!!! " , width / 2, 20);
            latch.countDown();
        }
         if(CardGame.loser==true){
            fill(0);
            textSize(16);
            text("You Lost... " , width / 2, 20);
            latch.countDown();
        }


        cardGame.drawChoices(this);
    }

    
    @Override
    public void mousePressed() {
        cardGame.handleDrawButtonClick(mouseX, mouseY);
       // cardGame.handleCardClick(mouseX, mouseY);
    }

     public boolean isHighScore(String score, String currentHighScore){
        return true;
     }

    public void writeHighScore(File f) {
       
    }

    // get the best score for a specific game, from a file. returns null if no score. 

    public String getBestScore(File highscoreFile) {
       return "bleh";
    }

     public String getGameName(){
        return "War";
     }


    public String getScore(){
        return "bleh";
    }

   

}
