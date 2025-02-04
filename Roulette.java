import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Roulette
{
   static Scanner input = new Scanner(System.in);
   static Random randInt = new Random();
   
   static ArrayList<Integer> red = new ArrayList<Integer>();
   static ArrayList<Integer> black = new ArrayList<Integer>();   
   static ArrayList<String> nums = new ArrayList<String>();
      
   public static void runAGameOfRoulette()
   {
      System.out.println("Welcome to Roulette, before we start here are some notes\n");
      System.out.println("Red are the numbers (1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36)\nBlack are the numbers (2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35)\nEven Numbers are divisable by 2\nOdd Numbers are not divisable by 2\n1-12 means a number between 1-12, including 1 and 12\n13-24 means a number between 13-24, including 13 and 24\n25-36 means a number between 25-36, including 25 and 36\nSingle means you bet on one single number");
      System.out.println("\nNow knowing the notes, what do you want to bet on??\nRed\nBlack\nEven\nOdd\n1-12\n13-24\n25-36\nSingle\n");
      
      String ans = input.nextLine();
      
      fillArrayR(red);
      fillArrayB(black);
      fillArrayN(nums);
      
      while((!ans.toUpperCase().equals("RED")) && !ans.toUpperCase().equals("BLACK") && !ans.toUpperCase().equals("EVEN") && !ans.toUpperCase().equals("ODD") && !ans.toUpperCase().equals("SINGLE") && !ans.equals("1-12") && !ans.equals("13-24") && !ans.equals("25-36"))
      {
         System.out.println("Sorry, please enter Red or Black or Even or Odd or 1-12 or 13-24 or 25-36 or Single");
         ans = input.nextLine();
      }
      
      int theRoll = roll();
      
      if(ans.toUpperCase().equals("RED"))
      {
        if(red.contains(theRoll))
         System.out.println("You bet on red and " + theRoll + " is on red, meaning you win!");
        else
         System.out.println("You bet on red but " + theRoll + " is on black, meaning you lose :(");
      }
      else if(ans.toUpperCase().equals("BLACK"))
      {
        if(black.contains(theRoll))
         System.out.println("You bet on black and " + theRoll + " is on black, meaning you win!");
        else
         System.out.println("You bet on black but " + theRoll + " is on red, meaning you lose :(");
      }
      else if(ans.toUpperCase().equals("EVEN"))
      {
        if(theRoll % 2 == 0)
         System.out.println("You bet on the roll even and " + theRoll + " is even, meaning you win!");
        else
         System.out.println("You bet on the roll even but " + theRoll + " is odd, meaning you lose :(");
      }
      else if(ans.toUpperCase().equals("ODD"))
      {
        if(theRoll % 2 == 1)
         System.out.println("You bet on the roll being odd and " + theRoll + " is odd, meaning you win!");
        else
         System.out.println("You bet on the roll being odd but " + theRoll + " is even, meaning you lose :(");
      } 
      if(ans.toUpperCase().equals("1-12"))
      {
        if(theRoll <= 12)
         System.out.println("You bet on the roll being between 1-12 and " + theRoll + " is between 1-12, meaning you win!");
        else
         System.out.println("You bet on the roll being between 1-12 but " + theRoll + " isn't between 1-12, meaning you lose :(");
      }
      if(ans.toUpperCase().equals("13-24"))
      {
        if(theRoll <= 24 && theRoll >= 13)
         System.out.println("You bet on the roll being between 13-24 and " + theRoll + " is between 13-24, meaning you win!");
        else
         System.out.println("You bet on the roll being between 13-24 but " + theRoll + " isn't between 13-24, meaning you lose :(");
      }        
      if(ans.toUpperCase().equals("25-36"))
      {
        if(theRoll >= 25)
         System.out.println("You bet on the roll being between 25-36 and " + theRoll + " is between 25-36, meaning you win!");
        else
         System.out.println("You bet on the roll being between 25-36 but " + theRoll + " isn't between 25-36, meaning you lose :(");
      }     
      if(ans.toUpperCase().equals("SINGLE"))
      {
        System.out.println("\nOh? risky aren't we? What number do you guess?");
        String guess = input.nextLine();
        while(!nums.contains(guess))
        {
          System.out.println("Sorry, that's not elligible guess since the guess isn't a number, please make sure it's a number under 36 and indeed a number");
          guess = input.nextLine();
        }
        if(theRoll == Integer.parseInt(guess))
         System.out.println("You bet on the roll being " + guess + " and the roll was indeed " + theRoll + ", meaning you win!");
        else
         System.out.println("You bet on the roll being " + guess + " but the roll was " + theRoll + ", meaning you lose :(");
      }                           
   }
   
   public static int roll()
   {
      return randInt.nextInt(36)+1;
   }
   
   public static void fillArrayR(ArrayList<Integer> arr)
   {
      arr.add(1);
      arr.add(3);
      arr.add(5);
      arr.add(7);
      arr.add(9);
      arr.add(12);
      arr.add(14);
      arr.add(16);
      arr.add(18);
      arr.add(19);
      arr.add(21);
      arr.add(23);
      arr.add(25);
      arr.add(27);
      arr.add(30);
      arr.add(32);
      arr.add(34);
      arr.add(36);
   }
  
   public static void fillArrayB(ArrayList<Integer> arr)
   {
      arr.add(2);
      arr.add(4);
      arr.add(6);
      arr.add(8);
      arr.add(10);
      arr.add(11);
      arr.add(13);
      arr.add(15);
      arr.add(17);
      arr.add(20);
      arr.add(22);
      arr.add(24);
      arr.add(26);
      arr.add(28);
      arr.add(29);
      arr.add(31);
      arr.add(33);
      arr.add(35);     
   }
   public static void fillArrayN(ArrayList<String> arr)
   {
      for(int k = 1; k < 37; k++)
         arr.add(k + "");    
   }
}
