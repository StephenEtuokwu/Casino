import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class TexasHoldEm
{
   static Random randInt = new Random();
   
   static String randomCard = "";
   static String randomCard2 = "";
   static String randomCard3 = "";
   static String randomCard4 = "";
   static String randomCard5 = "";
   static String randomCard6 = "";
   static String randomCard7 = "";
   static String startingHand = "";
   static String cardValue = "";
   static String pairs = "";
   static String twoPairs = "";
   static String threeOfAKind = "";
   static String dealerCard1 = "";
   static String dealerCard2 = "";
   static String aTemp = "";
   static String bTemp = "";
   
   static int valueA = 0;
   static int valueB = 0;     
   
   static ArrayList<String> allCards = new ArrayList<String>();
   static ArrayList<String> communityCards = new ArrayList<String>();
   static ArrayList<String> playerHand = new ArrayList<String>();
   static ArrayList<String> dealerHand = new ArrayList<String>();
   
   public static void runAGameOfTexasHoldEm()
   { 
      setCardDeck(allCards);
      
      openingHand();
      generateRiver();    
            
      System.out.println(startingHand + "\n\nHere are the river cards\n");
      for(int k = 0; k < communityCards.size(); k++)
      {
         System.out.println(communityCards.get(k));
         playerHand.add(communityCards.get(k));
         dealerHand.add(communityCards.get(k));
      }         
      
      System.out.println("\nHere is your hand (with the river cards included)");
      printArray(playerHand);
      
      System.out.println("Here is the dealer's hand (with the river cards included)");
      printArray(dealerHand);
      
      System.out.println(checkForWinP(playerHand));
      System.out.println(checkForWinD(dealerHand));
      System.out.println("\n" + printWinner());  
      
       String randomCard = "";
       String randomCard2 = "";
       String randomCard3 = "";
       String randomCard4 = "";
       String randomCard5 = "";
       String randomCard6 = "";
       String randomCard7 = "";
       String startingHand = "";
       String cardValue = "";
       String pairs = "";
       String twoPairs = "";
       String threeOfAKind = "";
       String dealerCard1 = "";
       String dealerCard2 = "";
       String aTemp = "";
       String bTemp = "";
      
       int valueA = 0;
       int valueB = 0;     
      
       allCards = new ArrayList<String>();
       communityCards = new ArrayList<String>();
       playerHand = new ArrayList<String>();
       dealerHand = new ArrayList<String>();                
   }
      
   public static void openingHand()
   {
         randomCard = allCards.get(randInt.nextInt(52));
         allCards.remove(randomCard);
         
         randomCard2 = allCards.get(randInt.nextInt(51));
         allCards.remove(randomCard2);
         
         dealerCard1 = allCards.get(randInt.nextInt(50));
         allCards.remove(dealerCard1);
         
         dealerCard2 = allCards.get(randInt.nextInt(49));
         allCards.remove(dealerCard2);         
         
         playerHand.add(randomCard);
         playerHand.add(randomCard2);   
         
         dealerHand.add(dealerCard1);
         dealerHand.add(dealerCard2);     
   }   
   
   public static void generateRiver()
   {
       randomCard3 = allCards.get(randInt.nextInt(48));
       communityCards.add(randomCard3);       
       allCards.remove(randomCard3);
       randomCard4 = allCards.get(randInt.nextInt(47));
       communityCards.add(randomCard4);      
       allCards.remove(randomCard4); 
       randomCard5 = allCards.get(randInt.nextInt(46));
       communityCards.add(randomCard5);      
       allCards.remove(randomCard5); 
       randomCard6 = allCards.get(randInt.nextInt(45));
       communityCards.add(randomCard6);
       allCards.remove(randomCard6);       
       randomCard7 = allCards.get(randInt.nextInt(44));
       communityCards.add(randomCard7);  
       allCards.remove(randomCard7);             
   }
   
   public static String checkForHighestCard(ArrayList<String> arr)
   {
      String highestCard = "";
      
      for(int k = 0; k < arr.size(); k++)
      {
         if(arr.get(k).contains("A"))
          return arr.get(k);
         else if(arr.get(k).startsWith("K"))
          highestCard = arr.get(k);
         else if(arr.get(k).startsWith("Q") && !highestCard.startsWith("K"))
          highestCard = arr.get(k);
         else if(arr.get(k).startsWith("J") && !highestCard.startsWith("K") && !highestCard.startsWith("Q"))
          highestCard = arr.get(k);
         else if(arr.get(k).startsWith("10") && !highestCard.startsWith("K") && !highestCard.startsWith("Q") && !highestCard.startsWith("J"))
          highestCard = arr.get(k);
         else if(arr.get(k).startsWith("9") && !highestCard.startsWith("K") && !highestCard.startsWith("Q") && !highestCard.startsWith("J") && !highestCard.startsWith("10"))
          highestCard = arr.get(k);
         else if(arr.get(k).startsWith("8") && !highestCard.startsWith("K") && !highestCard.startsWith("Q") && !highestCard.startsWith("J") && !highestCard.startsWith("10") && !highestCard.startsWith("9"))
          highestCard = arr.get(k);
         else if(arr.get(k).startsWith("7") && !highestCard.startsWith("K") && !highestCard.startsWith("Q") && !highestCard.startsWith("J") && !highestCard.startsWith("10") && !highestCard.startsWith("9") && !highestCard.startsWith("8"))
          highestCard = arr.get(k);
         else if(arr.get(k).startsWith("6") && !highestCard.startsWith("K") && !highestCard.startsWith("Q") && !highestCard.startsWith("J") && !highestCard.startsWith("10") && !highestCard.startsWith("9") && !highestCard.startsWith("8") && !highestCard.startsWith("7"))
          highestCard = arr.get(k);
         else if(arr.get(k).startsWith("5") && !highestCard.startsWith("K") && !highestCard.startsWith("Q") && !highestCard.startsWith("J") && !highestCard.startsWith("10") && !highestCard.startsWith("9") && !highestCard.startsWith("8") && !highestCard.startsWith("7") && !highestCard.startsWith("6"))
          highestCard = arr.get(k);
         else if(arr.get(k).startsWith("4") && !highestCard.startsWith("K") && !highestCard.startsWith("Q") && !highestCard.startsWith("J") && !highestCard.startsWith("10") && !highestCard.startsWith("9") && !highestCard.startsWith("8") && !highestCard.startsWith("7") && !highestCard.startsWith("6") && !highestCard.startsWith("5"))
          highestCard = arr.get(k);
         else if(arr.get(k).startsWith("3") && !highestCard.startsWith("K") && !highestCard.startsWith("Q") && !highestCard.startsWith("J") && !highestCard.startsWith("10") && !highestCard.startsWith("9") && !highestCard.startsWith("8") && !highestCard.startsWith("7") && !highestCard.startsWith("6") && !highestCard.startsWith("5") && !highestCard.startsWith("4"))
          highestCard = arr.get(k);
     }           
     return highestCard + "  ";                                     
   }
   
   public static String checkForTwoOfAKind(ArrayList<String> arr)
   {
      String pairA = "";
      String pairK = "";
      String pairQ = "";
      String pairJ = "";
      String pair10 = "";
      String pair9 = "";
      String pair8 = "";
      String pair7 = "";
      String pair6 = "";
      String pair5 = "";
      String pair4 = "";
      String pair3 = "";
      String pair2 = "";
      
      for(int k = 0; arr.size() > k; k++)
      {
         if(arr.get(k).contains("A"))
         {
            pairA += arr.get(k) + " ";
            if(pairA.indexOf("of") != pairA.lastIndexOf("of"))
               return pairA;
         }
         else if(arr.get(k).contains("K"))
         {
            pairK += arr.get(k) + " ";
            if(pairK.indexOf("of") != pairK.lastIndexOf("of"))
               return pairK;
         }
         else if(arr.get(k).contains("Q"))
         {
            pairQ += arr.get(k) + " ";
            if(pairQ.indexOf("of") != pairQ.lastIndexOf("of"))
               return pairQ;
         }
         else if(arr.get(k).contains("J"))
         {
            pairJ += arr.get(k) + " ";
            if(pairJ.indexOf("of") != pairJ.lastIndexOf("of"))
               return pairJ;
         }
         else if(arr.get(k).contains("10"))
         {
            pair10 += arr.get(k) + " ";
            if(pair10.indexOf("of") != pair10.lastIndexOf("of"))
               return pair10;
         }
         else if(arr.get(k).contains("9"))
         {
            pair9 += arr.get(k) + " ";
            if(pair9.indexOf("of") != pair9.lastIndexOf("of"))
               return pair9;
         }
         else if(arr.get(k).contains("8"))
         {
            pair8 += arr.get(k) + " ";
            if(pair8.indexOf("of") != pair8.lastIndexOf("of"))
               return pair8;
         }
         else if(arr.get(k).contains("7"))
         {
            pair7 += arr.get(k) + " ";
            if(pair7.indexOf("of") != pair7.lastIndexOf("of"))
               return pair7;
         }
         else if(arr.get(k).contains("6"))
         {
            pair6 += arr.get(k) + " ";
            if(pair6.indexOf("of") != pair6.lastIndexOf("of"))
               return pair6;
         }      
         else if(arr.get(k).contains("5"))
         {
            pair5 += arr.get(k) + " ";
            if(pair5.indexOf("of") != pair5.lastIndexOf("of"))
               return pair5;
         }
         else if(arr.get(k).contains("4"))
         {
            pair4 += arr.get(k) + " ";
            if(pair4.indexOf("of") != pair4.lastIndexOf("of"))
               return pair4;
         }  
         else if(arr.get(k).contains("3"))
         {
            pair3 += arr.get(k) + " ";
            if(pair3.indexOf("of") != pair3.lastIndexOf("of"))
               return pair3;
         }
         else if(arr.get(k).contains("2"))
         {
            pair2 += arr.get(k) + " ";
            if(pair2.indexOf("of") != pair2.lastIndexOf("of"))
               return pair2;
         }                                                                                
      }
      return "none";
   }
   
   public static String checkForTwoPairs(ArrayList<String> arr)
   {                                                                                        
      String PairA = "";
      String PairK = "";
      String PairQ = "";
      String PairJ = "";
      String Pair10 = "";
      String Pair9 = "";
      String Pair8 = "";
      String Pair7 = "";
      String Pair6 = "";
      String Pair5 = "";
      String Pair4 = "";
      String Pair3 = "";
      String Pair2 = "";
      
      pairs = checkForTwoOfAKind(arr);
      
      for(int k = 0; arr.size() > k; k++)
      {
         if(arr.get(k).contains("A") && !pairs.contains(arr.get(k)))
         {
            PairA += arr.get(k) + " ";
            if(PairA.indexOf("of") != PairA.lastIndexOf("of"))
               return PairA + pairs;
         }
         else if(arr.get(k).contains("K") && !pairs.contains(arr.get(k)))
         {
            PairK += arr.get(k) + " ";
            if(PairK.indexOf("of") != PairK.lastIndexOf("of"))
               return PairK + pairs;
         }
         else if(arr.get(k).contains("Q")  && !pairs.contains(arr.get(k)))
         {
            PairQ += arr.get(k) + " ";
            if(PairQ.indexOf("of") != PairQ.lastIndexOf("of"))
               return PairQ + pairs;
         }
         else if(arr.get(k).contains("J") && !pairs.contains(arr.get(k)))
         {
            PairJ += arr.get(k) + " ";
            if(PairJ.indexOf("of") != PairJ.lastIndexOf("of"))
               return PairJ + pairs;
         }
         else if(arr.get(k).contains("10") && !pairs.contains(arr.get(k)))
         {
            Pair10 += arr.get(k) + " ";
            if(Pair10.indexOf("of") != Pair10.lastIndexOf("of"))
               return Pair10 + pairs;
         }
         else if(arr.get(k).contains("9") && !pairs.contains(arr.get(k)))
         {
            Pair9 += arr.get(k) + " ";
            if(Pair9.indexOf("of") != Pair9.lastIndexOf("of"))
               return Pair9 + pairs;
         }
         else if(arr.get(k).contains("8") && !pairs.contains(arr.get(k)))
         {
            Pair8 += arr.get(k) + " ";
            if(Pair8.indexOf("of") != Pair8.lastIndexOf("of"))
               return Pair8 + pairs;
         }
         else if(arr.get(k).contains("7") && !pairs.contains(arr.get(k)))
         {
            Pair7 += arr.get(k) + " ";
            if(Pair7.indexOf("of") != Pair7.lastIndexOf("of"))
               return Pair7 + pairs;
         }
         else if(arr.get(k).contains("6") && !pairs.contains(arr.get(k)))
         {
            Pair6 += arr.get(k) + " ";
            if(Pair6.indexOf("of") != Pair6.lastIndexOf("of"))
               return Pair6 + pairs;
         }      
         else if(arr.get(k).contains("5") && !pairs.contains(arr.get(k)))
         {
            Pair5 += arr.get(k) + " ";
            if(Pair5.indexOf("of") != Pair5.lastIndexOf("of"))
               return Pair5 + pairs;
         }
         else if(arr.get(k).contains("4") && !pairs.contains(arr.get(k)))
         {
            Pair4 += arr.get(k) + " ";
            if(Pair4.indexOf("of") != Pair4.lastIndexOf("of"))
               return Pair4 + pairs;
         }  
         else if(arr.get(k).contains("3") && !pairs.contains(arr.get(k)))
         {
            Pair3 += arr.get(k) + " ";
            if(Pair3.indexOf("of") != Pair3.lastIndexOf("of"))
               return Pair3 + pairs;
         }
         else if(arr.get(k).contains("2") && !pairs.contains(arr.get(k)))
         {
            Pair2 += arr.get(k) + " ";
            if(Pair2.indexOf("of") != Pair2.lastIndexOf("of"))
               return Pair2 + pairs;
         }                                                                               
      }    
      
      return "none";
   }
   
   public static String checkForThreeOfAKind(ArrayList<String> arr)
   {
      String tripleA = "";
      String tripleK = "";
      String tripleQ = "";
      String tripleJ = "";
      String triple10 = "";
      String triple9 = "";
      String triple8 = "";
      String triple7 = "";
      String triple6 = "";
      String triple5 = "";
      String triple4 = "";
      String triple3 = "";
      String triple2 = "";   
      
      for(int k = 0; arr.size() > k; k++)
      {
         if(arr.get(k).contains("A"))
         {
            tripleA += arr.get(k) + " ";
            if(tripleA.indexOf("of") != tripleA.lastIndexOf("of") && ofCounter(tripleA) == 3)
               return tripleA;
         }
         else if(arr.get(k).contains("K"))
         {
            tripleK += arr.get(k) + " ";
            if(tripleK.indexOf("of") != tripleK.lastIndexOf("of") && ofCounter(tripleK) == 3)
               return tripleK;
         }
         else if(arr.get(k).contains("Q"))
         {
            tripleQ += arr.get(k) + " ";
            if(tripleQ.indexOf("of") != tripleQ.lastIndexOf("of") && ofCounter(tripleQ) == 3)
               return tripleQ;
         }
         else if(arr.get(k).contains("J"))
         {
            tripleJ += arr.get(k) + " ";
            if(tripleJ.indexOf("of") != tripleJ.lastIndexOf("of") && ofCounter(tripleJ) == 3)
               return tripleJ;
         }
         else if(arr.get(k).contains("10"))
         {
            triple10 += arr.get(k) + " ";
            if(triple10.indexOf("of") != triple10.lastIndexOf("of") && ofCounter(triple10) == 3)
               return triple10;
         }
         else if(arr.get(k).contains("9"))
         {
            triple9 += arr.get(k) + " ";
            if(triple9.indexOf("of") != triple9.lastIndexOf("of") && ofCounter(triple9) == 3)
               return triple9;
         }
         else if(arr.get(k).contains("8"))
         {
            triple8 += arr.get(k) + " ";
            if(triple8.indexOf("of") != triple8.lastIndexOf("of") && ofCounter(triple8) == 3)
               return triple8;
         }
         else if(arr.get(k).contains("7"))
         {
            triple7 += arr.get(k) + " ";
            if(triple7.indexOf("of") != triple7.lastIndexOf("of") && ofCounter(triple7) == 3)
               return triple7;
         }
         else if(arr.get(k).contains("6"))
         {
            triple6 += arr.get(k) + " ";
            if(triple6.indexOf("of") != triple6.lastIndexOf("of") && ofCounter(triple6) == 3)
               return triple6;
         }      
         else if(arr.get(k).contains("5"))
         {
            triple5 += arr.get(k) + " ";
            if(triple5.indexOf("of") != triple5.lastIndexOf("of") && ofCounter(triple5) == 3)
               return triple5;
         }
         else if(arr.get(k).contains("4"))
         {
            triple4 += arr.get(k) + " ";
            if(triple4.indexOf("of") != triple4.lastIndexOf("of") && ofCounter(triple4) == 3)
               return triple4;
         }  
         else if(arr.get(k).contains("3"))
         {
            triple3 += arr.get(k) + " ";
            if(triple3.indexOf("of") != triple3.lastIndexOf("of") && ofCounter(triple3) == 3)
               return triple3;
         }
         else if(arr.get(k).contains("2"))
         {
            triple2 += arr.get(k) + " ";
            if(triple2.indexOf("of") != triple2.lastIndexOf("of") && ofCounter(triple2) == 3)
               return triple2;
         }                                                                                
      }
      return "none";
   }     
   
   public static String checkForStraight(ArrayList<String> arr)
   {
      String temp = "";
        
      for(int k = 0; k < arr.size(); k++)
      {
         temp += arr.get(k) + " ";
      }
      
         if(temp.contains("A") && temp.contains("K") && temp.contains("Q") && temp.contains("J") && temp.contains("10"))
            return "straight with an Ace, a King, a Queen, a Jack, and a 10";      
         else if(temp.contains("K") && temp.contains("Q") && temp.contains("J") && temp.contains("10") && temp.contains("9"))
            return "straight with an King, a Queen, a Jack, a 10 and a 9";      
         else if(temp.contains("Q") && temp.contains("J") && temp.contains("10") && temp.contains("9") && temp.contains("8"))
            return "straight with a Queen, a Jack, a 10, a 9, and an 8";
         else if(temp.contains("J") && temp.contains("10") && temp.contains("9") && temp.contains("8") && temp.contains("7"))
            return "straight with a Jack, a 10, a 9, an 8, and a 7";
         else if(temp.contains("10") && temp.contains("9") && temp.contains("8") && temp.contains("7") && temp.contains("6"))
            return "straight with a 10, a 9, an 8, a 7, and a 6";
         else if(temp.contains("9") && temp.contains("8") && temp.contains("7") && temp.contains("6") && temp.contains("5"))
            return "straight with a 9, an 8, a 7, a 6, and a 5";
         else if(temp.contains("8") && temp.contains("7") && temp.contains("6") && temp.contains("5") && temp.contains("4"))
            return "straight with an 8, a 7, a 6, a 5, and a 4";
         else if(temp.contains("7") && temp.contains("6") && temp.contains("5") && temp.contains("4") && temp.contains("3"))
            return "straight with a 7, a 6, a 5, a 4, and a 3";
         else if(temp.contains("6") && temp.contains("5") && temp.contains("4") && temp.contains("3") && temp.contains("2"))
            return "straight with a 6, a 5, a 4, a 3, and a 2";
         else if(temp.contains("A") && temp.contains("2") && temp.contains("3") && temp.contains("4") && temp.contains("5"))
            return "straight with an Ace, a 5, a 4, a 3, and a 2";
         else
            return "none";
   }
   
   public static String checkForFlush(ArrayList<String> arr)
   {
      String flush = "";
      
      if(!suitCounter(arr).equals("none"))
      {
         for(int k = 0; k < arr.size(); k++)
           if(arr.get(k).endsWith(suitCounter(arr)))
            flush += arr.get(k) + " ";
         return flush + " which were all " + suitCounter(arr);
      }
      else
         return "none";      
   }
   
   public static String checkForFullHouse(ArrayList<String> arr)
   {
         if(!checkForTwoOfAKind(arr).equals("none") && !checkForThreeOfAKind(arr).equals("none") && !(checkForTwoOfAKind(arr).startsWith(checkForTwoOfAKind(arr).substring(0,1)) == (checkForThreeOfAKind(arr).startsWith(checkForThreeOfAKind(arr).substring(0,1)))))
            return checkForTwoOfAKind(arr) + " " + checkForThreeOfAKind(arr);
         else
            return "none";
   }
   
   public static String checkForFourOfAKind(ArrayList<String> arr)
   {
      String quadA = "";
      String quadK = "";
      String quadQ = "";
      String quadJ = "";
      String quad10 = "";
      String quad9 = "";
      String quad8 = "";
      String quad7 = "";
      String quad6 = "";
      String quad5 = "";
      String quad4 = "";
      String quad3 = "";
      String quad2 = "";   
      
      for(int k = 0; arr.size() > k; k++)
      {
         if(arr.get(k).contains("A"))
         {
            quadA += arr.get(k) + " ";
            if(quadA.indexOf("of") != quadA.lastIndexOf("of") && ofCounter(quadA) == 4)
               return quadA;
         }
         else if(arr.get(k).contains("K"))
         {
            quadK += arr.get(k) + " ";
            if(quadK.indexOf("of") != quadK.lastIndexOf("of") && ofCounter(quadK) == 4)
               return quadK;
         }
         else if(arr.get(k).contains("Q"))
         {
            quadQ += arr.get(k) + " ";
            if(quadQ.indexOf("of") != quadQ.lastIndexOf("of") && ofCounter(quadQ) == 4)
               return quadQ;
         }
         else if(arr.get(k).contains("J"))
         {
            quadJ += arr.get(k) + " ";
            if(quadJ.indexOf("of") != quadJ.lastIndexOf("of") && ofCounter(quadJ) == 4)
               return quadJ;
         }
         else if(arr.get(k).contains("10"))
         {
            quad10 += arr.get(k) + " ";
            if(quad10.indexOf("of") != quad10.lastIndexOf("of") && ofCounter(quad10) == 4)
               return quad10;
         }
         else if(arr.get(k).contains("9"))
         {
            quad9 += arr.get(k) + " ";
            if(quad9.indexOf("of") != quad9.lastIndexOf("of") && ofCounter(quad9) == 4)
               return quad9;
         }
         else if(arr.get(k).contains("8"))
         {
            quad8 += arr.get(k) + " ";
            if(quad8.indexOf("of") != quad8.lastIndexOf("of") && ofCounter(quad8) == 4)
               return quad8;
         }
         else if(arr.get(k).contains("7"))
         {
            quad7 += arr.get(k) + " ";
            if(quad7.indexOf("of") != quad7.lastIndexOf("of") && ofCounter(quad7) == 4)
               return quad7;
         }
         else if(arr.get(k).contains("6"))
         {
            quad6 += arr.get(k) + " ";
            if(quad6.indexOf("of") != quad6.lastIndexOf("of") && ofCounter(quad6) == 4)
               return quad6;
         }      
         else if(arr.get(k).contains("5"))
         {
            quad5 += arr.get(k) + " ";
            if(quad5.indexOf("of") != quad5.lastIndexOf("of") && ofCounter(quad5) == 4)
               return quad5;
         }
         else if(arr.get(k).contains("4"))
         {
            quad4 += arr.get(k) + " ";
            if(quad4.indexOf("of") != quad4.lastIndexOf("of") && ofCounter(quad4) == 4)
               return quad4;
         }  
         else if(arr.get(k).contains("3"))
         {
            quad3 += arr.get(k) + " ";
            if(quad3.indexOf("of") != quad3.lastIndexOf("of") && ofCounter(quad3) == 4)
               return quad3;
         }
         else if(arr.get(k).contains("2"))
         {
            quad2 += arr.get(k) + " ";
            if(quad2.indexOf("of") != quad2.lastIndexOf("of") && ofCounter(quad2) == 4)
               return quad2;
         }                                                                                
      }
      return "none";   
   }
   
   public static String checkForStraightFlush(ArrayList<String> arr)
   {
      if(!checkForStraight(arr).equals("none") && !checkForFlush(arr).equals("none"))
         return checkForStraight(arr) + " that was all the same suit: " + suitCounter(arr); 
      else
         return "none";
   }
   
   public static String checkForRoyalFlush(ArrayList<String> arr)
   {
      String newTemp = "";
      for(int k = 0; k < arr.size(); k++)
      {
         newTemp += arr.get(k) + " ";
      }

    if(!checkForFlush(arr).equals("none") && newTemp.contains("A") && newTemp.contains("K") && newTemp.contains("Q") && newTemp.contains("J") && newTemp.contains("10"))
      return " got a royal flush!";
    else
      return "none";
   }
   
   public static String checkForWinP(ArrayList<String> a)
   {      
      pairs = checkForTwoOfAKind(a);
      
      if(!checkForHighestCard(a).equals("none"))
      {
         valueA = 1;
         aTemp = "Your highest Card Value: " + checkForHighestCard(a);
      }
      if(!checkForTwoOfAKind(a).equals("none"))
      {
         valueA = 2;
         aTemp = "Your pair of cards: " + checkForTwoOfAKind(a);
      } 
      if(!checkForTwoPairs(a).equals("none"))
      {
         valueA = 3; 
         aTemp = "Your two pairs: " + checkForTwoPairs(a);
      }
      if(!checkForThreeOfAKind(a).equals("none"))
      {
         valueA = 4;
         aTemp = "Your triple in your hand: " + checkForThreeOfAKind(a);
      }
      if(!checkForStraight(a).equals("none"))
      {
         valueA = 5;  
         aTemp = "Your " + checkForStraight(a);      
      } 
      if(!checkForFlush(a).equals("none"))
      {
         valueA = 6;         
         aTemp = "Your flush in your hand: " + checkForFlush(a);
      }
      if(!checkForFullHouse(a).equals("none"))
      {
         valueA = 7;         
         aTemp = "Your Full  House in your hand: " + checkForFullHouse(a);
      }
      if(!checkForFourOfAKind(a).equals("none"))
      {
         valueA = 8; 
         aTemp = "Your 4 of a kind in your hand: " +  checkForFourOfAKind(a);
      }        
      if(!checkForStraightFlush(a).equals("none"))
      {
         valueA = 9;         
         aTemp = "Your Straight Flush in your hand: " + checkForStraightFlush(a);
      }
      if(!checkForRoyalFlush(a).equals("none"))
      {
         valueA = 10;   
         aTemp = "You " + checkForRoyalFlush(a);
      }  
      return aTemp;     
   }  
      
   public static String checkForWinD(ArrayList<String> b)
   {               
         pairs = checkForTwoOfAKind(b);
         
         if(!checkForHighestCard(b).equals("none"))
         {
            valueB = 1;
            bTemp = "The dealer's highest card: " + checkForHighestCard(b);   
         }
         if(!checkForTwoOfAKind(b).equals("none"))
         {
            valueB = 2;
            bTemp = "The dealer's pair: " + checkForTwoOfAKind(b);
         }
         if(!checkForTwoPairs(b).equals("none"))
         {
            valueB = 3;     
            bTemp = "The dealer's two pairs: " + checkForTwoPairs(b);
         }    
         if(!checkForThreeOfAKind(b).equals("none"))
         {
            valueB = 4;
            bTemp = "The dealer's triple: " + checkForThreeOfAKind(b);
         }
         if(!checkForStraight(b).equals("none"))
         {
            valueB = 5;         
            bTemp = "The dealer's: " + checkForStraight(b);
         }
         if(!checkForFlush(b).equals("none"))
         {
            valueB = 6;      
            bTemp = "The dealer's flush in their hand " + checkForFlush(b);
         }   
         if(!checkForFullHouse(b).equals("none"))
         {
            valueB = 7; 
            bTemp = "The dealer's Full House in their hand: " + checkForFullHouse(b);
         }        
         if(!checkForFourOfAKind(b).equals("none"))
         {
            valueB = 8;         
            bTemp = "The dealer's 4 of a kind in their hand: " + checkForFourOfAKind(b);
         }
         if(!checkForStraightFlush(b).equals("none"))
         {
            valueB = 9; 
            bTemp = "The dealer's Straight Flush in thier hand: " + checkForStraightFlush(b);
         } 
         if(!checkForRoyalFlush(b).equals("none"))
         {
            valueB = 10;  
            bTemp = "The dealer " + checkForRoyalFlush(b);
         }
         return bTemp;
    }
         
         
    public static String printWinner()
    {
      if(valueA > valueB)
         return "You won! " + aTemp + " beats " + bTemp;
      else if(valueA < valueB) 
         return "You lost. " + aTemp + " lost to " + bTemp;
      else if(valueA == valueB)
         return "Your and the dealer's hands tied in value";   
      return "none";    
   }
   
   public static int ofCounter(String l)
   {
      int count = 0;
      for(int k = 0; k < l.length()-2;k++)
      {
         if(l.substring(k,k+2).equals("of"))
            count++;
      }
      return count;
   }
   
   public static String suitCounter(ArrayList<String> arr)
   {
     int clubCount = 0;
     int diamondCount = 0;
     int heartCount = 0;
     int spadeCount = 0;
     
     for(int k = 0; k < arr.size(); k++)
     {
       if(arr.get(k).endsWith("Clubs"))
         clubCount++;
       else if(arr.get(k).endsWith("Diamonds"))
         diamondCount++;
       else if(arr.get(k).endsWith("Hearts"))
         heartCount++;
       else
         spadeCount++;
     } 
     
     if(clubCount >= 5)
      return "Clubs";
     else if(diamondCount >= 5)
      return "Diamonds";
     else if(heartCount >= 5)
      return "Hearts";
     else if(spadeCount >= 5)
      return "Spades";   
   
     return "none";
   }
   
   public static ArrayList<String> printArray(ArrayList<String> arr)
   {
      for(int k = 0; k < arr.size();k++)
         if(k < arr.size() - 1)
          System.out.print(arr.get(k) + ", ");
         else
          System.out.println(arr.get(k));
      System.out.println();
         
      return arr;
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
}