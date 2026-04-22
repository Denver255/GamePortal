package BuzzFeed;

 import java.util.Scanner;
 
public class question {
    boolean hi= false;
    String label;
    answer[] possibleanswers = new answer[4];

    question(String label, answer[] possibleanswers){
        this.label=label;
        this.possibleanswers= possibleanswers;
    }

    int ask(Scanner sc){
        hi=false;
        System.out.println(this.label);
        for(int i=0; i<this.possibleanswers.length; i++ ){
            String choice = Integer.toString(i+1);
           System.out.println("[" + choice + "]:" +
               this.possibleanswers[i].label);

        }
          int ans = 0;
          if(sc.hasNextInt()){
            ans= sc.nextInt();
            hi=true;
          }
          if(hi==true){
          if(sc.nextInt()<=4 && sc.nextInt()>=1){
            possibleanswers[ans-1].cat.points =possibleanswers[ans-1].cat.points + 1 ;
            return ans;
          }
        }
          System.out.println("Bro, go again!");
          sc.next();
          return ask(sc);
    //     while(sc.hasNextInt()==false){
    //         sc.next();
    //         ans = sc.nextInt();
    //     }
    //    while(ans>4 || ans<1){
    //         ans = sc.nextInt();
    //   }


       
    }
   
}
