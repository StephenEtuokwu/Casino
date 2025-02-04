import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Uno
{   
   static ArrayList<String> unoDeck = new ArrayList<String>();
   static ArrayList<String> playerHand = new ArrayList<String>();
   static ArrayList<String> dealerHand = new ArrayList<String>();
   static ArrayList<String> pile = new ArrayList<String>();
   
   static Random randInt = new Random();
   
   static Scanner input = new Scanner(System.in);
    
   static int turn = 0;   
   static int ran = 0;
   
   static String colorChoice = "";
   static String playersChoice = "";
   
   public static void runAGameOfUno()
   {
      setDeck(unoDeck);
      System.out.print("Here is your opening hand ");
      System.out.println(openingHand(playerHand));
      unoDeck = scrambleDeck(unoDeck);
      simulateARound();
   }
   
   public static void simulateARound()
   {     
      pile.add(unoDeck.get(unoDeck.size()-1));
      while(pile.get(0).contains("Skip") || pile.get(0).contains("Reverse") || pile.get(0).contains("Draw 4") || pile.get(0).contains("Wild Card"))
      {
         pile.set(0,unoDeck.get(randInt.nextInt(unoDeck.size()-1)));
      }
      unoDeck.remove(pile.get(0));
      while(playerHand.size() > 0 && playerHand.size() > 0)
      {
        if(turn == 0)
        {
           System.out.println("The starting card is: " + pile.get(0));
           System.out.println(checkPlayerHand());
           if(!checkPlayerHand().equals("You can't play any cards in your hand, you need to draw a card"))
           {
              playersChoice = input.nextLine();
              while(!playerHand.contains(playersChoice))
              {
                 System.out.println("Sorry, please type the exact card you want play");
                 playersChoice = input.nextLine();
              }
              System.out.println("You have played a " + playersChoice);
              powerUpDeciderP(playersChoice);
              playerHand.remove(playersChoice);
              pile.add(playersChoice);
           }
           else
           {
            playerHand.add(unoDeck.get(unoDeck.size()-1));
            unoDeck.remove(unoDeck.size()-1);
            System.out.println("You have drawn a " + playerHand.get(playerHand.size()-1));
           }          
           turn++;
       }
       else if(turn % 2 == 0 && turn != 0)
       {
         System.out.print("Here is your hand: ");
         System.out.println(playerHand);
         System.out.println("The top of the playing pile is " + pile.get(pile.size()-1));
         System.out.println(checkPlayerHand()); 
         if(!checkPlayerHand().equals("You can't play any cards in your hand, you need to draw a card"))
         {
            playersChoice = input.nextLine();
            while(!playerHand.contains(playersChoice))
            {
               System.out.println("Sorry, please type the exact card you want play");
               playersChoice = input.nextLine();
            }
            System.out.println("You have played a " + playersChoice);
            powerUpDeciderP(playersChoice);
            playerHand.remove(playersChoice);
            pile.add(playersChoice);
            colorChoice = getColor(pile.get(pile.size()-1));
            turn++;
         }
         else
         {
            playerHand.add(unoDeck.get(unoDeck.size()-1));
            unoDeck.remove(unoDeck.size()-1);
            System.out.println("You have drawn a " + playerHand.get(playerHand.size()-1));
            colorChoice = getColor(pile.get(pile.size()-1));
            turn++;
         }         
        }
        else
        {
          if(checkDealerHand().equals("The dealer can't play any cards, they need to draw a card"))
          {
            dealerHand.add(unoDeck.get(unoDeck.size()-1));
            unoDeck.remove(unoDeck.size()-1);
            colorChoice = getColor(pile.get(pile.size()-1));
            turn++;
          }
          else
          {
            if(checkDealerHand().contains("Draw 4"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("Draw 4"))
                  { 
                     System.out.println("The Dealer plays a Draw 4");
                     powerUpDeciderD("Draw 4");
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("Draw 2"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("Draw 2"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " Draw 2");
                     powerUpDeciderD("Draw 2");
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }         
            else if(checkDealerHand().contains("Wild Card"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("Wild"))
                  {
                     System.out.println("The dealer plays a Wild Card");                  
                     powerUpDeciderD("Wild Card");
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("Reverse"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("Reverse"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " Reverse");
                     powerUpDeciderD("Reverse");
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("Skip"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("Skip"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " Skip");
                     powerUpDeciderD("Skip");
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("9"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("9"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " 9");
                     colorChoice = getColor(dealerHand.get(k));
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("8"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("8"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " 8");
                     colorChoice = getColor(dealerHand.get(k));
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("7"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("7"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " 7");
                     colorChoice = getColor(dealerHand.get(k));
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("6"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("6"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " 6");
                     colorChoice = getColor(dealerHand.get(k));
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("5"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("5"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " 5");
                     colorChoice = getColor(dealerHand.get(k));
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("4"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("4"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " 4");
                     colorChoice = getColor(dealerHand.get(k));
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("3"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("3"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " 3");
                     colorChoice = getColor(dealerHand.get(k));
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("2"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("2"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " 2");
                     colorChoice = getColor(dealerHand.get(k));
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("1"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("1"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " 1");
                     colorChoice = getColor(dealerHand.get(k));
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            else if(checkDealerHand().contains("0"))
            {
               for(int k = 0; k < dealerHand.size();k++)
               {
                  if(dealerHand.get(k).contains("0"))
                  {
                     System.out.println("The dealer plays a " + getColor(dealerHand.get(k)) + " 0");
                     colorChoice = getColor(dealerHand.get(k));
                     pile.add(dealerHand.get(k));
                     dealerHand.remove(k);
                     break;
                  }
               }
            }
            turn++;
          }
        }
      }
      if(playerHand.size() == 0)
         System.out.println("Congratutaions, you've beaten the dealer in Uno!");     
      else if(dealerHand.size() == 0)
         System.out.println("Aww tough luck, you lost to the dealer in Uno");
      else if(playerHand.size() > dealerHand.size())
         System.out.println("After going through the whole deck, you had the smaller remaining hand, meaning you've beaten the dealer in Uno!");
      else
         System.out.println("After going through the whole deck, you had the smaller remaining hand, meaning you've been beaten by the dealer in Uno");
      reset();
   }        
   
   public static void reset()
   {
      turn = 0;   
      ran = 0;
   
      colorChoice = "";
      playersChoice = "";
   }
   
   public static ArrayList<String> setDeck(ArrayList<String> c)
   {
      c.add("Red 0"); 
      for(int k = 1;k < 10; k++)
      {
         c.add("Red " + k);
         c.add("Red " + k);
      }
      c.add("Red Skip");
      c.add("Red Skip");
      c.add("Red Reverse");
      c.add("Red Reverse");
      c.add("Red Draw 2");
      c.add("Red Draw 2");
      c.add("Blue 0"); 
      for(int k = 1;k < 10; k++)
      {
         c.add("Blue " + k);
         c.add("Blue " + k);
      }
      c.add("Blue Skip");
      c.add("Blue Skip");
      c.add("Blue Reverse");
      c.add("Blue Reverse");
      c.add("Blue Draw 2");
      c.add("Blue Draw 2");      
      c.add("Yellow 0"); 
      for(int k = 1;k < 10; k++)
      {
         c.add("Yellow " + k);
         c.add("Yellow " + k);
      }
      c.add("Yellow Skip");
      c.add("Yellow Skip");
      c.add("Yellow Reverse");
      c.add("Yellow Reverse");
      c.add("Yellow Draw 2");
      c.add("Yellow Draw 2");      
      c.add("Green 0"); 
      for(int k = 1;k < 10; k++)
      {
         c.add("Green " + k);
         c.add("Green " + k);
      }  
      c.add("Green Skip");
      c.add("Green Skip");
      c.add("Green Reverse");
      c.add("Green Reverse");
      c.add("Green Draw 2");
      c.add("Green Draw 2");     
      
      c.add("Wild Card");
      c.add("Wild Card");
      c.add("Wild Card");
      c.add("Wild Card");
      c.add("Draw 4");   
      c.add("Draw 4");
      c.add("Draw 4");
      c.add("Draw 4");    
      return c;                
   }
   
   public static void powerUpDeciderP(String i)
   {
      if(i.contains("Draw 4"))
      {
          for(int k = 0; k < 4;k++)
          {
            dealerHand.add(unoDeck.get(unoDeck.size()-1));
            unoDeck.remove(unoDeck.size()-1);
          }
          System.out.println("What color do you want to change to?");
          colorChoice = input.nextLine();
          while(!colorChoice.toUpperCase().equals("RED") && !colorChoice.toUpperCase().equals("GREEN") && !colorChoice.toUpperCase().equals("BLUE") && !colorChoice.toUpperCase().equals("YELLOW"))
          {
             System.out.println("Sorry, please choose between the colors Red Green Blue and Yellow");
             colorChoice = input.nextLine();
          }
          System.out.println("You made the dealer draw 4 cards, changed the color to " + colorChoice + " and, it's your turn again");
          turn++;
      }
      
      else if(i.contains("Draw 2"))
      {
          for(int k = 0; k < 2;k++)
          {
            dealerHand.add(unoDeck.get(unoDeck.size()-1));
            unoDeck.remove(unoDeck.size()-1);
          }
          System.out.println("You made the dealer draw 2 cards, and it's your turn again");
          if(i.indexOf("Red") != -1)
          {
            colorChoice = i.substring(i.indexOf("Red"),i.indexOf(" "));
          }
          else if(i.indexOf("Blue") != -1)
          {
            colorChoice = i.substring(i.indexOf("Blue"),i.indexOf(" "));
          }
          else if(i.indexOf("Green") != -1)
          {
            colorChoice = i.substring(i.indexOf("Green"),i.indexOf(" "));
          }
          else
          {
            colorChoice = i.substring(i.indexOf("Yellow"),i.indexOf(" "));
          }
          turn++;
      }           
      else if(i.contains("Wild Card"))
      {
          System.out.println("What color do you need to change the color to?");
          colorChoice = input.nextLine();
          while(!colorChoice.toUpperCase().equals("RED") && !colorChoice.toUpperCase().equals("GREEN") && !colorChoice.toUpperCase().equals("BLUE") && !colorChoice.toUpperCase().equals("YELLOW"))
          {
             System.out.println("Sorry, please choose between the colors Red Green Blue and Yellow");
             colorChoice = input.nextLine();
          }
          System.out.println("You have changed the color to " + colorChoice);      
      }  
      else if(i.contains("Skip"))
      {
          if(i.indexOf("Red") != -1)
          {
            colorChoice = i.substring(i.indexOf("Red"),i.indexOf(" "));
          }
          else if(i.indexOf("Blue") != -1)
          {
            colorChoice = i.substring(i.indexOf("Blue"),i.indexOf(" "));
          }
          else if(i.indexOf("Green") != -1)
          {
            colorChoice = i.substring(i.indexOf("Green"),i.indexOf(" "));
          }
          else
          {
            colorChoice = i.substring(i.indexOf("Yellow"),i.indexOf(" "));
          }
         System.out.println("You have skipped the dealer's turn so it's your turn again");
         turn++;
      }
      else if(i.contains("Reverse"))
      {
          if(i.indexOf("Red") != -1)
          {
            colorChoice = i.substring(i.indexOf("Red"),i.indexOf(" "));
          }
          else if(i.indexOf("Blue") != -1)
          {
            colorChoice = i.substring(i.indexOf("Blue"),i.indexOf(" "));
          }
          else if(i.indexOf("Green") != -1)
          {
            colorChoice = i.substring(i.indexOf("Green"),i.indexOf(" "));
          }
          else
          {
            colorChoice = i.substring(i.indexOf("Yellow"),i.indexOf(" "));
          }      
         System.out.println("You have reversed the flow of play, so it's the dealer's turn again");
         turn++;
      }    
   }

   public static void powerUpDeciderD(String i)
   {
      if(i.contains("Draw 4"))
      {
          for(int k = 0; k < 4;k++)
          {
            playerHand.add(unoDeck.get(unoDeck.size()-1));
            unoDeck.remove(unoDeck.size()-1);
          }
          ran = randInt.nextInt(4);
          if(ran == 0)
            colorChoice = "Red";
          else if (ran == 1)
            colorChoice = "Blue";
          else if (ran == 2)
            colorChoice = "Yellow";
          else
            colorChoice = "Green";          
          System.out.println("The dealer made you draw 4 cards, changed the color to " + colorChoice + " and it's the dealer's turn again");
          turn++;
      }
      
      else if(i.contains("Draw 2"))
      {
          if(i.indexOf("Red") != -1)
          {
            colorChoice = i.substring(i.indexOf("Red"),i.indexOf(" "));
          }
          else if(i.indexOf("Blue") != -1)
          {
            colorChoice = i.substring(i.indexOf("Blue"),i.indexOf(" "));
          }
          else if(i.indexOf("Green") != -1)
          {
            colorChoice = i.substring(i.indexOf("Green"),i.indexOf(" "));
          }
          else if(i.indexOf("Yellow") != -1)
          {
            colorChoice = i.substring(i.indexOf("Yellow"),i.indexOf(" "));
          }      
          for(int k = 0; k < 2;k++)
          {
            playerHand.add(unoDeck.get(unoDeck.size()-1));
            unoDeck.remove(unoDeck.size()-1);
          }
          System.out.println("The dealer has made you draw 2 cards, and it's the dealer's turn again");
          turn++;
      }           
      
      else if(i.contains("Wild Card"))
      {
          ran = randInt.nextInt(4);
          if(ran == 0)
            colorChoice = "Red";
          else if (ran == 1)
            colorChoice = "Blue";
          else if (ran == 2)
            colorChoice = "Yellow";
          else
            colorChoice = "Green";
          System.out.println("The dealer has changed the color to " + colorChoice);      
      }  
      else if(i.contains("Skip"))
      {
          if(i.indexOf("Red") != -1)
          {
            colorChoice = i.substring(i.indexOf("Red"),i.indexOf(" "));
          }
          else if(i.indexOf("Blue") != -1)
          {
            colorChoice = i.substring(i.indexOf("Blue"),i.indexOf(" "));
          }
          else if(i.indexOf("Green") != -1)
          {
            colorChoice = i.substring(i.indexOf("Green"),i.indexOf(" "));
          }
          else if(i.indexOf("Yellow") != -1)
          {
            colorChoice = i.substring(i.indexOf("Yellow"),i.indexOf(" "));
          }      
         System.out.println("The dealer has skipped the your turn so it's dealer's turn again");
         turn++;
      }
      else if(i.contains("Reverse"))
      {
          if(i.indexOf("Red") != -1)
          {
            colorChoice = i.substring(i.indexOf("Red"),i.indexOf(" "));
          }
          else if(i.indexOf("Blue") != -1)
          {
            colorChoice = i.substring(i.indexOf("Blue"),i.indexOf(" "));
          }
          else if(i.indexOf("Green") != -1)
          {
            colorChoice = i.substring(i.indexOf("Green"),i.indexOf(" "));
          }
          else if(i.indexOf("Yellow") != -1)
          {
            colorChoice = i.substring(i.indexOf("Yellow"),i.indexOf(" "));
          }      
         System.out.println("The dealer has reversed the flow of play, so it's the dealer's turn again");
         turn++;
      }          
   }
   
   public static ArrayList<String> openingHand(ArrayList<String> r)
   {
      for(int k = 0; k < 7;k++)
      {
         int randomNum = randInt.nextInt(unoDeck.size());
         r.add(unoDeck.get(randomNum));
         unoDeck.remove(randomNum);
      }
      
      return r;
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
   
   public static String checkPlayerHand()
   {
      String temp = "";
      for(int k = 0; k < playerHand.size();k++)
      {
         if(/*getColor(playerHand.get(k)).equals(getColor(pile.get(pile.size()-1))) ||*/ getNum(playerHand.get(k)) == getNum(pile.get(pile.size()-1)) || getColor(playerHand.get(k)).equals(colorChoice))
            temp += playerHand.get(k) + " || ";
         else if(playerHand.get(k).contains("Draw 4"))
            temp += playerHand.get(k) + " || ";
         else if(playerHand.get(k).contains("Wild Card"))
            temp += playerHand.get(k) + " || ";
      }
      
      if(temp.length() > 0)
         return "You can play these cards: " + temp.substring(0,temp.length()-3);
      else
         return "You can't play any cards in your hand, you need to draw a card";
   }
   
   public static String checkDealerHand()
   {
      String temp1 = "";
      for(int k = 0; k < dealerHand.size();k++)
      {
         if(/*(getColor(dealerHand.get(k)).equals(getColor(pile.get(pile.size()-1))) ||*/ getNum(dealerHand.get(k)) == getNum(pile.get(pile.size()-1)) || getColor(dealerHand.get(k)).equals(colorChoice))
            temp1 += dealerHand.get(k) + " || ";
         else if(dealerHand.get(k).contains("Draw 4"))
            temp1 += dealerHand.get(k) + " || ";
         else if(dealerHand.get(k).contains("Wild Card"))
            temp1 += dealerHand.get(k) + " || ";
      }
      
      if(temp1.length() > 0)
         return temp1;
      else
         return "The dealer can't play any cards, they need to draw a card";   
      
   }
   
   public static String getColor(String s)
   {
      if(s.contains("Red"))
         return "Red";
      else if(s.contains("Blue"))
         return "Blue";
      else if(s.contains("Yellow"))
         return "Yellow";
      else if(s.contains("Green"))
         return "Green";
      else if(s.contains("Wild Card"))
      {
         if(colorChoice.equals("Red"))
           return "Red";
         else if(colorChoice.equals("Blue"))
           return "Blue";
         else if(colorChoice.equals("Yellow"))
           return "Yellow";
         else if(colorChoice.equals("Green"))
            return "Green";
      }
      else if(s.contains("Skip"))
         return "Skip";
      else if(s.contains("Reverse"))
         return "Reverse";
      else
      {
         if(colorChoice.equals("Red"))
           return "Red";
         else if(colorChoice.equals("Blue"))
           return "Blue";
         else if(colorChoice.equals("Yellow"))
           return "Yellow";
         else if(colorChoice.equals("Green"))
            return "Green";
      }
      return "";
   }
   
   public static int getNum(String s)
   {
      if(s.contains("0"))
         return 0;
      else if(s.contains("1"))
         return 1;
      else if(s.contains("2") && !s.contains("Draw 2"))
         return 2;
      else if(s.contains("3"))
         return 3;
      else if(s.contains("4") && !s.contains("Draw 4"))
         return 4;
      else if(s.contains("5"))
         return 5;
      else if(s.contains("6"))
         return 6;
      else if(s.contains("7"))
         return 7;
      else if(s.contains("8"))
         return 8;
      else if(s.contains("9"))
         return 9;    
      else if(s.contains("Wild Card"))
         return 10;
      else if(s.contains("Skip"))
         return 11;
      else if(s.contains("Reverse"))
         return 12;
      else if(s.contains("Draw 2"))
         return 13;
      else
         return 14;  
   }
}