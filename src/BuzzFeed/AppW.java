package BuzzFeed;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Game.GameWriteable;

public class AppW implements GameWriteable {
    public static String winner = " ";
    public static void main(String[] args) throws Exception {
        (new AppW()).play();
    }

    public void play() {
        
        category miku = new category("Miku", "FJSDFSDf");
        category teto = new category("Teto", "FJSDFSDf");
        category kaito = new category("Kaito", "FJSDFSDf");
        category len = new category("Len", "FJSDFSDf");
        answer q11= new answer("Light Blue",miku);
        answer q12= new answer("Red",teto);
        answer q13= new answer("Yellow",len);
        answer q14= new answer("Deep Blue",kaito);
        answer q21= new answer("Propeller Hat",teto);
        answer q22= new answer("Tie",len);
        answer q23= new answer("Scarf",kaito);
        answer q24= new answer("Skirt",miku);
        answer q31= new answer("Banana",len);
        answer q32= new answer("Ice Cream",kaito);
        answer q33= new answer("Leek",miku);
        answer q34= new answer("Bread",teto);
        answer q41= new answer("Cool, calm, and collected",kaito);
        answer q42= new answer("Pretty Princess",miku);
        answer q43= new answer("Evil",teto);
        answer q44= new answer("Energetic",len);
        answer q51= new answer("Every Job in the World",miku);
        answer q52= new answer("Leader of a Cult",teto);
        answer q53= new answer("Cafe Employee",len);
        answer q54= new answer("Carnival Manager",kaito);
        answer q61= new answer("Violin",kaito);
        answer q62= new answer("Trumpet",len);
        answer q63= new answer("Guitar",teto);
        answer q64= new answer("Flute",miku);
        answer q71= new answer("Math",len);
        answer q72= new answer("None",teto);
        answer q73= new answer("Music",miku);
        answer q74= new answer("P.E.",kaito);
        answer q81= new answer("Bird",len);
        answer q82= new answer("Mole",teto);
        answer q83= new answer("Cat",miku);
        answer q84= new answer("Dog",kaito);
        Scanner scanner= new Scanner(System.in);
        answer[] question1Answers= {q11,q12,q13,q14};
        answer[] question2Answers= {q21,q22,q23,q24};
        answer[] question3Answers= {q31,q32,q33,q34};
        answer[] question4Answers= {q41,q42,q43,q44};
        answer[] question5Answers= {q51,q52,q53,q54};
        answer[] question6Answers= {q61,q62,q63,q64};
        answer[] question7Answers= {q71,q72,q73,q74};
        answer[] question8Answers= {q81,q82,q83,q84};
        question q1 = new question("What's your favorite color?",question1Answers);
        question q2 = new question("What would you wear to look cool?",question2Answers);
        question q3 = new question("What's your favorite food?",question3Answers);
        question q4 = new question("How would you describe yourself?",question4Answers);
        question q5 = new question("What job would you want to have?",question5Answers);
        question q6 = new question("What is your favorite instrument?",question6Answers);
        question q7 = new question("What is your favorite subject?",question7Answers);
        question q8 = new question("What is your favorite animal?",question8Answers);
        System.out.println("This quiz will tell you what vocaloid you are!");
        System.out.println("Make sure you input all answers three times, so you can be sure of you choice!");
        System.out.println("Let's do this!");
        q1.ask(scanner);
        q2.ask(scanner);
        q3.ask(scanner);
        q4.ask(scanner);
        q5.ask(scanner);
        q6.ask(scanner);
        q7.ask(scanner);
        q8.ask(scanner);
        System.out.println(points(miku,teto,len,kaito));
        
    }  
    static String points(category miku, category teto, category len, category kaito){
   //String winner = " ";
   Scanner scanner= new Scanner(System.in);

    //Miku Section
   if(miku.points==teto.points && miku.points!=0){
    if(mikuTie(scanner)==1){
        winner= "Miku";
    } else if(mikuTie(scanner)==2){
        winner= "Teto";
    } else {
        mikuTie(scanner);
    }
   }
   if(miku.points==len.points && miku.points!=0){
    if(mikuTie(scanner)==1){
        winner= "Miku";
    } else if(mikuTie(scanner)==2){
        winner= "Len";
    } else {
        mikuTie(scanner);
    }
   }
   if(miku.points==kaito.points && miku.points!=0){
    if(mikuTie(scanner)==1){
        winner= "Miku";
    } else if(mikuTie(scanner)==2){
        winner= "Kaito";
    } else {
        mikuTie(scanner);
    }
   }

    // Miku Section

    //Teto Section
   if(teto.points==len.points && teto.points !=0){
    if(tetoTie(scanner)==1){
        winner= "Teto";
    } else if(tetoTie(scanner)==2){
        winner= "Len";
    } else{
        tetoTie(scanner);
    }
   }
   if(teto.points==kaito.points && teto.points!=0){
    if(tetoTie(scanner)==1){
        winner= "Teto";
    } else if(tetoTie(scanner)==2){
        winner= "Kaito";
    } else{
        tetoTie(scanner);
    }
   }
    //Teto Section

    //Len Section
if(len.points==kaito.points && len.points !=0){
    if(lenTie(scanner)==1){
        winner= "Len";
    }else if(lenTie(scanner)==2){
        winner= "Kaito";
    } else{
        lenTie(scanner);
    }
   }
    //Len Section

    //Kaito Section
    //Kaito Section

    // Overall Section
     if(miku.points> teto.points){
        if(miku.points> len.points){
        if(miku.points>kaito.points){
         winner="Miku";
    }
    }
    } 
    if(teto.points> miku.points){
        if(teto.points> len.points){
        if(teto.points> kaito.points){
         winner="Teto";
    }
    }
    } 
    if(kaito.points> teto.points){
        if(kaito.points> len.points){
        if(kaito.points> miku.points){
         winner="Kaito";
    }
    }
    } 
    if(len.points> teto.points){
        if(len.points> miku.points){
        if(len.points> kaito.points){
         winner="Len";
    }
    }
    } 
    //Overall Section
    return winner;
   }

   static int mikuTie(Scanner sc){
     System.out.println("Do you like music?");
     System.out.println("[1]Yes");
     System.out.println("[2]No");
    int ans = sc.nextInt();
    return ans;
   }
   static int tetoTie(Scanner sc){
     System.out.println("Do you like drills?");
     System.out.println("[1]Yes");
     System.out.println("[2]No");
    int ans = sc.nextInt();
    return ans;
   }
   static int lenTie(Scanner sc){
     System.out.println("Are you happy?");
     System.out.println("[1]Yes");
     System.out.println("[2]No");
    int ans = sc.nextInt();
    return ans;
   }
   static int kaitoTie(Scanner sc){
     System.out.println("Are you cool?");
     System.out.println("[1]Yes");
     System.out.println("[2]No");
    int ans = sc.nextInt();
    return ans;
   }


    public boolean isHighScore(String score, String currentHighScore){
        return true;
    }

    public void writeHighScore(File f) {
        // get the current score of this game, compare it with the current highScore
        // (getBestScore) using isHighScore
        // and if it is a high score, replace that line of the file with the new high
        // score.
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

    public String getGameName(){
        return "BuzzFeed";
    }

    public String getScore(){
        return winner;
    }
     

}
