import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class War
{
   
   static ArrayList<String> allCards = new ArrayList<String>();
   static ArrayList<String> halfDeck = new ArrayList<String>();
   static long startTime;
   static long endTime;
   static ArrayList<String> playersHand = new ArrayList<String>();
   static ArrayList<String> dealersHand = new ArrayList<String>();
   static Random randInt = new Random();
   static int temp = 0;
   static int turns = 0;
   static int totalTurns = 0;
   static int reshuffles = 0;
   
   static boolean gameFinished = false;
   
   public static void runAGameOfWar()
   {
      if(totalTurns == 0)
         startTime = System.nanoTime();
      setCardDeck(allCards);
      

      System.out.println("Welcome to War!\nLet's get your and the dealer's deck shuffled");
         
      dealersHand = scrambleDeck(splitDeck(allCards));
      playersHand = scrambleDeck(copyHalfDeck(halfDeck));
   
      System.out.println("Alright, you and the dealer's decks have been shuffled!");
      
      simulateRound();    
         
      allCards = new ArrayList<String>();
      halfDeck = new ArrayList<String>();
      
      playersHand = new ArrayList<String>();
      dealersHand = new ArrayList<String>();
      temp = 0;
      turns = 0;
      gameFinished = false;
          
   }
   
   public static ArrayList<String> setCardDeck(ArrayList<String> c)
   {
      for(int k = 2;k < 11;k++)
         c.add(k + " of Clubs");
      c.add("Jack of Clubs");
      c.add("Queen of Clubs");
      c.add("King of Clubs");
      c.add("Ace of Clubs");
      for(int k = 2;k < 11;k++)
         c.add(k + " of Diamonds");
      c.add("Jack of Diamonds");
      c.add("Queen of Diamonds");
      c.add("King of Diamonds");
      c.add("Ace of Diamonds");
      for(int k = 2;k < 11;k++)
         c.add(k + " of Hearts");
      c.add("Jack of Hearts");
      c.add("Queen of Hearts");
      c.add("King of Hearts");
      c.add("Ace of Hearts");
      for(int k = 2;k < 11;k++)
         c.add(k + " of Spades");
      c.add("Jack of Spades");
      c.add("Queen of Spades");
      c.add("King of Spades");
      c.add("Ace of Spades");                  
      
      return c;
   }
   
   public static void simulateRound()
   {
      String playerCurrentCard = "";
      String dealerCurrentCard = "";
      String tempWinner = "";
      
      while(playersHand.size() > 0 && dealersHand.size() > 0)
      {
         playerCurrentCard = playersHand.get(0);
         dealerCurrentCard = dealersHand.get(0);
         tempWinner = determineWin(playerCurrentCard,dealerCurrentCard);         
         
         if(tempWinner.equals("Player Wins"))
         {
            System.out.println("You won the battle with since " + playerCurrentCard + " beats " + dealerCurrentCard);
            playersHand.add(dealerCurrentCard);
            playersHand.add(playerCurrentCard);
            playersHand.remove(0);            
            dealersHand.remove(0);
         }
         else if(tempWinner.equals("Dealer Wins"))
         {
            System.out.println("Dealer won the battle with since " + dealerCurrentCard + " beats " + playerCurrentCard); 
            dealersHand.add(dealerCurrentCard);
            dealersHand.add(playerCurrentCard);
            dealersHand.remove(0);
            playersHand.remove(0);
         } 
         else
         {
            System.out.println("Oh wow, y'all both tied with " + dealerCurrentCard + " (dealer's card) and " + playerCurrentCard + " (your card) " +  "\nLet's have a war with with your and the dealer's next three cards!");  
            if(dealersHand.size() < 3 && totalTurns > 0)
            {
               System.out.println("\nSince the dealer had less than 3 cards, they can not war, meaning that you win!\nIt took you a total of " + totalTurns + " turns and " + reshuffles + " reshuffles to beat the dealer this session");
               gameFinished = true;
               break;
            }
            else if(dealersHand.size() < 3 && totalTurns == 0)
            {
               System.out.println("\nSince the dealer had less than 3 cards, they can not war, meaning that you win!\nIt took you a total of " + turns + " turns and " + reshuffles + " reshuffles to beat the dealer this session");
               gameFinished = true;
               break;
            }
            else if(playersHand.size() < 3 && totalTurns > 0)
            {
               System.out.println("\nSince you had less than 3 cards, you can not war, meaning that you lost!\nIt took the dealer a total of " + totalTurns + " turns and " + reshuffles + " reshuffles to beat you this session" );
               gameFinished = true;
               break;
            }
            else if(playersHand.size() < 3 && totalTurns == 0)
            {
               System.out.println("\nSince you had less than 3 cards, you can not war, meaning that you lost!\nIt took the dealer a total of " + turns + " turns and " + reshuffles + " reshuffles to beat you this session" );
               gameFinished = true;
               break;
            }            
            else if(war(playerCurrentCard,dealerCurrentCard,playersHand.get(1),dealersHand.get(1),playersHand.get(2),dealersHand.get(2)).equals("Player Wins"))
            {
               System.out.println("And with the war, you won with since you won the majority/all the battles:\n" + playerCurrentCard + " vs " + dealerCurrentCard + " || " + playersHand.get(1) + " vs " + dealersHand.get(1) + " || " + playersHand.get(2) + " vs " + dealersHand.get(2));
               playersHand.add(dealerCurrentCard);
               playersHand.add(playerCurrentCard);
               playersHand.add(playersHand.get(1));
               playersHand.add(playersHand.get(2));
               playersHand.add(dealersHand.get(1));
               playersHand.add(dealersHand.get(2));            
               playersHand.remove(2);   
               playersHand.remove(1);
               playersHand.remove(0);
               dealersHand.remove(2);
               dealersHand.remove(1);
               dealersHand.remove(0); 
               }
            else
            {
                  System.out.println("And with the war, you lost with since you lost the majority/all the battles:\n" + playerCurrentCard + " vs " + dealerCurrentCard + " || " + playersHand.get(1) + " vs " + dealersHand.get(1) + " || " + playersHand.get(2) + " vs " + dealersHand.get(2));
                  dealersHand.add(dealerCurrentCard);
                  dealersHand.add(playerCurrentCard);
                  dealersHand.add(playersHand.get(1));
                  dealersHand.add(playersHand.get(2));
                  dealersHand.add(dealersHand.get(1));
                  playersHand.add(dealersHand.get(2));            
                  dealersHand.remove(2);   
                  dealersHand.remove(1);
                  dealersHand.remove(0);
                  playersHand.remove(2);
                  playersHand.remove(1);
                  playersHand.remove(0); 
             }    
      }
      turns++;
      System.out.println("Dealer's hand size: " + dealersHand.size());
      System.out.println("Player's hand size: " + playersHand.size());
      
      if(turns > 3000)
         break;
      if(playersHand.size() == 0 || dealersHand.size() == 0)
      {
         gameFinished = true;
         break;
      }
     }
     
     if(turns > 3000)
     {
        System.out.println("\nSorry, it appears that the deck needs to be reshuffled, let us reshuffle them for y'all. This will only take a few moments :)");
        delay(10000);
        reshuffle();
     }     
     if(gameFinished)
     {
        endTime = System.nanoTime();
        
        System.out.println("\nThis session of War took " + ((endTime-startTime)/1000000000.0)+ " seconds!");
        
        if(playersHand.size() > dealersHand.size() && playersHand.size() == 52 && totalTurns == 0)
         System.out.println("\nCongratulations, you've beaten the dealer in War! It took you a total of " + turns + " turns and " + reshuffles + " reshuffles to beat the dealer in war this session!");
        else if(playersHand.size() < dealersHand.size() && dealersHand.size() == 52 && totalTurns > 0)
         System.out.println("\nOh well, every general can't prevail in war, better luck next time. It took a total of " + totalTurns + " turns and " + reshuffles + " reshuffles for the dealer to beat you this session");
        else if(playersHand.size() > dealersHand.size() && playersHand.size() == 52 && totalTurns > 0)
         System.out.println("\nCongratulations, you've beaten the dealer in War! It took you a total of " + totalTurns + " turns and " + reshuffles + " reshuffles to beat the dealer in war this session!");
        else if(playersHand.size() < dealersHand.size() && dealersHand.size() == 52 && totalTurns == 0)
         System.out.println("\nOh well, every general can't prevail in war, better luck next time. It took a total of " + turns + " turns and " + reshuffles + " reshuffles for the dealer to beat you this session");         
     }
    }
   
   public static void reshuffle()
   {
    totalTurns += turns;
    reshuffles++;
    allCards = new ArrayList<String>();
    halfDeck = new ArrayList<String>();
   
    playersHand = new ArrayList<String>();
    dealersHand = new ArrayList<String>();
    temp = 0;
    turns = 0;
        
    simulateRound();
   }
   
   public static String determineWin(String s1, String s2)
   {
      int s1tempVal = 0;
      int s2tempVal = 0;
      
      if(s1.contains("2"))
         s1tempVal = 2;
      else if(s1.contains("3"))
         s1tempVal = 3;
      else if(s1.contains("4"))
         s1tempVal = 4;
      else if(s1.contains("5"))
         s1tempVal = 5;
      else if(s1.contains("6"))
         s1tempVal = 6;
      else if(s1.contains("7"))
         s1tempVal = 7;
      else if(s1.contains("8"))
         s1tempVal = 8;
      else if(s1.contains("9"))
         s1tempVal = 9;
      else if(s1.contains("10"))
         s1tempVal = 10;
      else if(s1.contains("J"))
         s1tempVal = 11;     
      else if(s1.contains("Q"))
         s1tempVal = 12;
      else if(s1.contains("K"))
         s1tempVal = 13;
      else if(s1.contains("A"))
         s1tempVal = 14;  
           
      if(s2.contains("2"))
         s2tempVal = 2;
      else if(s2.contains("3"))
         s2tempVal = 3;
      else if(s2.contains("4"))
         s2tempVal = 4;
      else if(s2.contains("5"))
         s2tempVal = 5;
      else if(s2.contains("6"))
         s2tempVal = 6;
      else if(s2.contains("7"))
         s2tempVal = 7;
      else if(s2.contains("8"))
         s2tempVal = 8;
      else if(s2.contains("9"))
         s2tempVal = 9;
      else if(s2.contains("10"))
         s2tempVal = 10;
      else if(s2.contains("J"))
         s2tempVal = 11;     
      else if(s2.contains("Q"))
         s2tempVal = 12;
      else if(s2.contains("K"))
         s2tempVal = 13;
      else if(s2.contains("A"))
         s2tempVal = 14;      
      
      if(s1tempVal > s2tempVal)
         return "Player Wins";
      else if(s1tempVal < s2tempVal)   
         return "Dealer Wins";
      else
         return "Tie";
   }
   
   public static String war(String s1, String s2, String s3, String s4, String s5, String s6)
   {
      int playerWins = 0;
      int dealerWins = 0;
      
      if(determineWin(s1,s2).equals("Player Wins"))
         playerWins++;
      else if(determineWin(s1,s2).equals("Dealer Wins"))
         dealerWins++;
      else
      {
         if(BlackJack.coinFlip())
            playerWins++;
         else
            dealerWins++;
      }      
      if(determineWin(s3,s4).equals("Player Wins"))
         playerWins++;
      else if(determineWin(s3,s4).equals("Dealer Wins"))
         dealerWins++;
      else
      {
         if(BlackJack.coinFlip())
            playerWins++;
         else
            dealerWins++;
      }      
      if(determineWin(s5,s6).equals("Player Wins"))
         playerWins++;
      else if(determineWin(s5,s6).equals("Dealer Wins"))
         dealerWins++;
      else
      {
         if(BlackJack.coinFlip())
            playerWins++;
         else
            dealerWins++;
      }      
      if(playerWins > dealerWins)
         return "Player Wins";
      else
         return "Dealer Wins";      
   }
   
   public static ArrayList<String> scrambleDeck(ArrayList<String> deck)
   {
      ArrayList<String> tempList = new ArrayList<String>();
      ArrayList<Integer> integerList = new ArrayList<Integer>();
      int num1 = 0;      
      
      for(int k = 0;k < deck.size();k++)
      { 
         num1 = randInt.nextInt(deck.size());
         while(integerList.contains(num1))
         {
            num1 = randInt.nextInt(deck.size());
         }
         integerList.add(num1);
         tempList.add(k,deck.get(num1));
      }   
      return tempList;
   }
   
   public static ArrayList<String> splitDeck(ArrayList<String> c)
   {
      for(int k = 0; k < 26;k++)
      {
         temp = randInt.nextInt(52-k);
         halfDeck.add(c.get(temp));
         c.remove(temp);
      }
      return c;
   }
   
   public static ArrayList<String> copyHalfDeck(ArrayList<String> copy)
   {
      return copy;
   }
   
   public static void delay(int n)
   {
      long startDelay = System.currentTimeMillis();
      long endDelay = 0;
      while (endDelay - startDelay < n)
      endDelay = System.currentTimeMillis();
   }   
}