import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;



public class Craps
{
   static int roll1 = 0;
   static int roll2 = 0;
   static int currentRoll = 0;
   static int tempRoll = 0;
   static int rolls = 0;
   
   static String ans = "";
   
   static boolean gameWin = false;
   static boolean gameLoss = false;
   
   static Scanner input = new Scanner(System.in);
   static Random randInt = new Random();
   
   public static void runAGameOfCraps()
   {
   
      System.out.println("Here's the rules for Craps:\nYou have 2 choices:\n1) Choose Win meaning you predict you're going to win\n2) Not Win meaning you predict a loss\n\nTo win a game of craps, you either roll a 7 or an 11 or if you roll a 4,5,6,8,9,10, roll that same number again with three rolls or you lose.\nTo lose you either roll a 2,3,12 or if you roll a 4,5,6,8,9,10, fail to roll that same number within the next three rolls\n");
      System.out.println("Do you bet Win (W) or Not Win (NW) this round?");
      ans = input.nextLine();
      while(!ans.toUpperCase().equals("W") && !ans.toUpperCase().equals("NW"))
      {
         System.out.println("Sorry, please either type N or NW");
         ans = input.nextLine();
      }
   
      currentRoll = roll();
      
      if(ans.toUpperCase().equals("W"))
      {
         if(currentRoll == 7 || currentRoll == 11)
         {
            System.out.println("You win with a " + currentRoll);
         }
         else if(currentRoll == 4 || currentRoll == 5 || currentRoll == 6 || currentRoll == 8 || currentRoll == 9 || currentRoll == 10)
         {
            System.out.println("\nYou rolled a " + currentRoll + "\n");
            while(rolls <= 3 && gameWin == false)
            {
               System.out.println("Since you didn't roll a 2,3,7,11, or 12, " + currentRoll + " is your point, meaning you have to roll a " + currentRoll + " again within your next 3 rolls to win");
               for(int k = 0; k < 3;k++)
               {
                  tempRoll = roll();
                  System.out.println("You rerolled and got a " + tempRoll + "\n");
                  if(tempRoll == currentRoll)
                  {
                     System.out.println("You rolled your point value, meaning you win!");
                     gameWin = true;
                     break;
                  }
                  else
                  {
                     rolls++;
                     System.out.println("You know have " + (3-rolls) + " rolls left to roll a " + currentRoll);
                  }
               }
               if(rolls == 3 && gameWin == false)
               {
                  System.out.println("Oh well, you didn't win this session of craps");
                  break;
               }
           }
       }   
      else
      {
         System.out.println("Ahh, you rolled a " + currentRoll + " which is a losing roll");
      }            
    }
    else
    {
         if(currentRoll == 2|| currentRoll == 3 || currentRoll == 12)
         {
            System.out.println("You won with a " + currentRoll);
         }
         else if(currentRoll == 4 || currentRoll == 5 || currentRoll == 6 || currentRoll == 8 || currentRoll == 9 || currentRoll == 10)
         {
            while(rolls <= 3 && gameLoss == false)
            {
               System.out.println("Since you didn't roll a 2,3,7,11, or 12, " + currentRoll + " is your point, meaning you avoid rolling a " + currentRoll + " within your next 3 rolls to win");
               for(int k = 0; k < 3;k++)
               {
                  tempRoll = roll();
                  System.out.println("You rerolled and got a " + tempRoll);
                  if(tempRoll == currentRoll)
                  {
                     System.out.println("You rolled your point value, meaning you lose!");
                     gameLoss = true;
                     break;
                  }
                  else
                  {
                     rolls++;
                     System.out.println("You know have " + (3-rolls) + " rolls left");
                  }
               }
               if(rolls == 3 && gameLoss == false)
               {
                  System.out.println("Congrats! You won this session of craps!");
                  break;
               }
           }
       }   
      else
      {
         System.out.println("Ahh, you rolled a " + currentRoll + " which is a losing roll");
      }            
    }    
    
    roll1 = 0;
    roll2 = 0;
    currentRoll = 0;
    tempRoll = 0;
    rolls = 0;
   
    ans = "";
   
    gameWin = false;
    gameLoss = false;    
    
   }
   public static int roll()
   {
      roll1 = randInt.nextInt(6) + 1;
      roll2 = randInt.nextInt(6) + 1;
      
      return roll1+roll2;
   }
}