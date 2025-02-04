import java.util.Scanner;

public class Casino
{
   public static void main(String args[])
   {
       Scanner input = new Scanner(System.in);
       
       System.out.println("Welcome to the Casino! We have a multitude of games, all that will tickle your fancy :) \nPlease choose between our options:\n1) Blackjack\n2) War\n3) Slots\n4) Craps\n5) Roulette\n6) Texas Hold'em\n7) Uno\n**Note: Once you pick a game, you CAN NOT choose another game afterwards, casino policy**");
       
       String answer = input.nextLine();
       
       while(!answer.equals("1") && !answer.equals("2") && !answer.equals("3")  && !answer.equals("4") && !answer.equals("5") && !answer.equals("6") && !answer.equals("7"))
       {
         System.out.println("Sorry, please enter the numerical value of the casino game you want to play Ex: 1");
         answer = input.nextLine();
       }
       if(answer.equals("1"))
       {
         System.out.println("Starting a game of Black Jack\n___________\n");
         BlackJack.runAGameOfBlackJack();
         System.out.println("\nWould you like to play again (Yes or No)");
         answer = input.nextLine();
         while(answer.toUpperCase().equals("YES"))
         {
            BlackJack.runAGameOfBlackJack();
            System.out.println("\nWould you like to play again (Yes or No)");            
            answer = input.nextLine();    
         }
         System.out.println("Thank you for coming to the casino! We hope to see you soon :)");
       }
       else if(answer.equals("2"))
       {
         System.out.println("Starting a game of War\n___________\n");
         War.runAGameOfWar();
         System.out.println("\nWould you like to play again (Yes or No)");
         answer = input.nextLine();
         while(answer.toUpperCase().equals("YES"))
         {
            War.runAGameOfWar();
            System.out.println("\nWould you like to play again (Yes or No)");            
            answer = input.nextLine();    
         }
         System.out.println("Thank you for coming to the casino! We hope to see you soon :)");
       }
       else if(answer.equals("3"))
       {
         System.out.println("Starting a game of Slots\n___________\n");
         Slots.runAGameOfSlots();
         System.out.println("\nWould you like to play again (Yes or No)");
         answer = input.nextLine();
         while(answer.toUpperCase().equals("YES"))
         {
            Slots.runAGameOfSlots();
            System.out.println("\nWould you like to play again (Yes or No)");            
            answer = input.nextLine();    
         }
         System.out.println("Thank you for coming to the casino! We hope to see you soon :)");
       }
       else if(answer.equals("4"))
       {
         System.out.println("Starting a game of Craps\n___________\n");
         Craps.runAGameOfCraps();
         System.out.println("\nWould you like to play again (Yes or No)");
         answer = input.nextLine();
         while(answer.toUpperCase().equals("YES"))
         {
            Craps.runAGameOfCraps();
            System.out.println("\nWould you like to play again (Yes or No)");            
            answer = input.nextLine();    
         }
         System.out.println("Thank you for coming to the casino! We hope to see you soon :)");
       }       
       else if(answer.equals("5"))
       {
         System.out.println("Starting a game of Roulette\n___________\n");
         Roulette.runAGameOfRoulette();
         System.out.println("\nWould you like to play again (Yes or No)");
         answer = input.nextLine();
         while(answer.toUpperCase().equals("YES"))
         {
            Roulette.runAGameOfRoulette();
            System.out.println("\nWould you like to play again (Yes or No)");            
            answer = input.nextLine();    
         }
         System.out.println("Thank you for coming to the casino! We hope to see you soon :)");
       }    
      else if(answer.equals("6"))
      {
         System.out.println("Starting a game of Texas Hold'em\n___________\n");
         TexasHoldEm.runAGameOfTexasHoldEm();
         System.out.println("\nWould you like to play again (Yes or No)");
         answer = input.nextLine();
         while(answer.toUpperCase().equals("YES"))
         {
            TexasHoldEm.runAGameOfTexasHoldEm();
            System.out.println("\nWould you like to play again (Yes or No)");            
            answer = input.nextLine();    
         }
         System.out.println("Thank you for coming to the casino! We hope to see you soon :)");
      }    
      else if(answer.equals("7"))
      {
         System.out.println("Starting a game of Uno\n___________\n");
         Uno.runAGameOfUno();
         System.out.println("\nWould you like to play again (Yes or No)");
         answer = input.nextLine();
         while(answer.toUpperCase().equals("YES"))
         {
            Uno.runAGameOfUno();
            System.out.println("\nWould you like to play again (Yes or No)");            
            answer = input.nextLine();    
         }
         System.out.println("Thank you for coming to the casino! We hope to see you soon :)");
      }          
          
   }
}
