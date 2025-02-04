import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class BlackJack
{   

   static Random randInt = new Random();
   static int totalValue = 0;
   static int playerFinal = 0;
   static int dealerFinal = 0;
   static String ans = "";
   static String randomCardValue = "";
   static String randomSuit = "";
   static String randomCardValue2 = "";
   static String randomSuit2 = "";   
   static ArrayList<String> cardValues = new ArrayList<String>();
   static ArrayList<String> sutheir = new ArrayList<String>();
   
   static boolean playerTurn = true;
   static boolean playerBust = false;
   static boolean dealerBust = false;
   
   
   static Scanner input = new Scanner(System.in);

   public static void runAGameOfBlackJack()
   {
      fillArrayC(cardValues);
      fillArrayS(sutheir);
      
      if(getHandValue() != 21)
      {
         System.out.println("Your opening hand is " + openingHand() + "\nWhich makes your starting value: " + getHandValue());
         System.out.println("Do you want to hit or stand?");
         
         ans = input.nextLine();
         
         
        while(getHandValue() <= 21)
        { 
         if(getHandValue() == 21)
         {
            System.out.println("You hit 21, meaning you got a blackjack!\nNow it's the dealer's turn");
            break;
         }
         playerTurn = true;
         if(!ans.equals("hit") && !ans.equals("stand"))
         {
            while(!ans.equals("hit") && !ans.equals("stand"))
            {
             System.out.println("Sorry, that's not an option, would you like to hit or stand?");
             ans = input.nextLine();
             if(ans.equals("hit") || ans.equals("stand"))
               break;
            }
         }
         else if(ans.equals("stand"))
         {
            System.out.println("You stand at " + getHandValue() + ", let's see if the dealer can beat your current hand");       
            break;
         }
         else if(ans.equals("hit"))
         {
            hit();
            if(getHandValue() == 21)
            {
               System.out.println("You hit 21, meaning you got a blackjack!\nNow it's the dealer's turn");
               break;
            }
            if(getHandValue() > 21)
            {
             System.out.println("Oh no, your hand's total card value is now " + getHandValue() + " which is over 21, meaning you busted :(\nLet's see if the dealer busts too");
             playerBust = true;
             playerFinal = 0;
             break;
            }
            else
            {
               System.out.println("Do you want to hit or stand?");  
               ans = input.nextLine();
            }
         }
        } 
     }
     if(playerBust == false)
       playerFinal = getHandValue();
     totalValue = 0;
     playerTurn = false;
     System.out.println("The dealer's opening hand is " + openingHand() + "\nWhich makes their starting value: " + getHandValue());
   
      while(getHandValue() <= 21 && playerTurn == false)
      {         
         if(getHandValue() > 21)
         {
            System.out.println("Oh no! The dealer's total hand value is " + getHandValue() + " which is over 21, meaning they busted");
            dealerBust = true;
         }
         else if(getHandValue() == 21)
         {
            System.out.println("The dealer got a blackjack!");
            playerTurn = true;
         }
         else if(getHandValue() >= 17)
         {
            System.out.println("The dealer stands with a " + getHandValue());  
            playerTurn = true;
         }        
         else if(getHandValue() <= 15)
         {
            hit();
            if(getHandValue() > 21)
            {
               System.out.println("Oh no! The dealer's total hand value is " + getHandValue() + " which is over 21, meaning they busted");
               dealerBust = true;
               dealerFinal = 0;
               playerTurn = true;
            }             
            if(getHandValue() == 21)
            {
               System.out.println("The dealer got a blackjack!");
               playerTurn = true;
            }            
            else if(getHandValue() >= 17 && getHandValue() < 21)
            {
               System.out.println("The dealer stands with a " + getHandValue());
               playerTurn = true;
            }   
            else if(getHandValue() <= 14)
            {
               if(coinFlip() == true)
               {
                  hit();
                  if(getHandValue() > 21)
                  {
                     System.out.println("Oh no! The dealer's total hand value is " + getHandValue() + " which is over 21, meaning they busted");
                     dealerBust = true;
                     dealerFinal = 0;
                     playerTurn = true;
                  }                     
                  else if(getHandValue() >= 18)
                  {
                     System.out.println("The dealer stands with a " + getHandValue());    
                     playerTurn = true;
                  }
                }
                else
                {
                  if(getHandValue() > 21)
                  {
                     System.out.println("Oh no! The dealer's total hand value is " + getHandValue() + " which is over 21, meaning they busted");
                     dealerBust = true;
                     dealerFinal = 0;
                     playerTurn = true;
                  } 
                  else
                  {
                    System.out.println("The dealer stands with a " + getHandValue()); 
                    playerTurn = true;  
                  }
                }                
            } 
          }
          else
          {
            System.out.println("The dealer stands with a " + getHandValue());  
            playerTurn = true;
          }  
     }
     if(dealerBust == false)
      dealerFinal = getHandValue();
     
     if(playerBust == true && dealerBust == true)
      System.out.println("No contest, both you and the dealer busted this round");
     else if(playerBust == true && dealerBust == false)
      System.out.println("Since you busted while the dealer did not, the dealer wins this round");
     else if(playerBust == false && dealerBust == true)
      System.out.println("Since the dealer busted while you didn't bust, you won this round!");
     if(playerBust == false && dealerBust == false && playerFinal > dealerFinal)
      System.out.println("Congrats! You beat the dealer with your hand of " + playerFinal + " while the dealer only had a hand of " + dealerFinal);   
     else if(playerBust == false && dealerBust == false && playerFinal < dealerFinal)
      System.out.println("Well, that's unfortunate. You lost to the dealer with your hand of " + playerFinal + " while the dealer had the better hand of " + dealerFinal);   
     else if(playerBust == false && dealerBust == false && playerFinal == dealerFinal)
     {
      System.out.println("Oh? Is that a tie? Well, we shall flip a coin to see who wins this game! Heads or tails?");
      ans = input.nextLine();
      while(!ans.toUpperCase().equals("HEADS") && !ans.toUpperCase().equals("TAILS"))
      {
         System.out.println("Sorry, only heads or tails is an available");
         ans = input.nextLine();
      }
      if(coinFlip() == true)
         System.out.println("And the coin landed on " + ans + ", you won!");
      else
         System.out.println("Tough luck, the coin didn't land on " + ans + " so, you lost"); 
     }
    totalValue = 0;
    playerFinal = 0;
    dealerFinal = 0;
    ans = "";
    randomCardValue = "";
    randomSuit = "";
    randomCardValue2 = "";
    randomSuit2 = "";     
    playerTurn = true;
    playerBust = false;
    dealerBust = false;      
   }
   
   public static ArrayList<String> fillArrayC(ArrayList<String> c)
   {
      for(int k = 2; k < 11;k++)
         c.add(k+"");
      c.add("Jack");
      c.add("Queen");
      c.add("King");
      c.add("Ace");
      
      return c;
   }
   
   public static ArrayList<String> fillArrayS(ArrayList<String> s)
   {      
      s.add("Clubs");
      s.add("Diamonds");
      s.add("Hearts");
      s.add("Spades");
      
      return s;
   }
   
   public static String openingHand()
   {
      randomCardValue = cardValues.get(randInt.nextInt(13));
      randomSuit = sutheir.get(randInt.nextInt(4));
      cardHandValue(randomCardValue);
      
      randomCardValue2 = cardValues.get(randInt.nextInt(13));
      randomSuit2 = sutheir.get(randInt.nextInt(4));
      cardHandValue(randomCardValue2);
      
      if(playerTurn == true)
         return "Your opening hand is the " + randomCardValue + " of " + randomSuit + " and the " + randomCardValue2 + " of " + randomSuit2;
      else
         return "The dealer's opening hand is the " + randomCardValue + " of " + randomSuit + " and the " + randomCardValue2 + " of " + randomSuit2;

    }
    
    public static void cardHandValue(String card)
    {      
      if(card.equals("Jack")|| card.equals("Queen") || card.equals("King"))
         totalValue+=10;      
      else if(card.equals("Ace"))
      {
         if(playerTurn == true)
         {
            System.out.println("Lucky! You got an Ace! Do you want your Ace to have a value of 1 or 11?");
            ans = input.nextLine();
            if(ans.equals("1"))
               totalValue += 1;
            else if(ans.equals("11"))
               totalValue += 11;
            else
            {
               while(!ans.equals("1") && !ans.equals("11"))
               {
                  System.out.println("Sorry, please enter either 1 or 11 for your value of the ace");
                  ans = input.nextLine();
               }
               if(ans.equals("1"))
                  totalValue += 1;
               else if(ans.equals("11"))
                  totalValue += 11;  
            }          
         } 
         else
            if(getHandValue() <= 10)
               totalValue+=11;
            else
               totalValue+=1;                              
      }
      else
         totalValue += Integer.parseInt(card);
    }
    
    public static void hit()
    {
      randomCardValue = cardValues.get(randInt.nextInt(11));
      randomSuit = sutheir.get(randInt.nextInt(4));
      cardHandValue(randomCardValue);
      
      if(playerTurn == true)
         System.out.println("You hit and drew the " + randomCardValue + " of " + randomSuit + "\nWhich brings your total hand value to " + getHandValue());
      else
         System.out.println("The dealer hit and drew the " + randomCardValue + " of " + randomSuit + "\nWhich brings their total hand value to " + getHandValue());
    }
    
    public static int getHandValue()
    {
      return totalValue;
    }
    
    public static boolean coinFlip()
    {
       int num = randInt.nextInt(2);
       
       if(num == 1)
         return false;
       else
         return true;
    }
}
