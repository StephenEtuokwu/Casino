import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Slots
{
   static ArrayList<String> slotItems = new ArrayList<String>();
   static String[][] slotsBoard = new String[0][0];
   static String num = "";
   static int temp = 0;
   static int wins = 0;
   static boolean correct = false;
   
   static Scanner input = new Scanner(System.in);   
   static Random randInt = new Random();
   public static void runAGameOfSlots()
   {
       slotItems.add("Gold");
       slotItems.add("Silver");
       slotItems.add("Ace");
       slotItems.add("King");
       slotItems.add("Joker");
       slotItems.add("7");
       
       System.out.println("Do you want 5 rows and collumns or 10 rows and collumns?");
       num = input.nextLine();
       
       while(!num.equals("5") && !num.equals("10"))
       {
         System.out.println("Sorry, you can only choose between 5 and 10 rows/collumns");
         num = input.nextLine();
       }
       System.out.println();
       String[][] slotsBoard = new String[Integer.parseInt(num)][Integer.parseInt(num)];
       Array(slotsBoard);
       printArray(slotsBoard);
       System.out.println("\nLet's go Gambling!\n");
       delay(2500);
       for(int k = 0; k < 5;k++)
       {
          fillSlots(slotsBoard);
          rollSlotMachine();      
          printArray(slotsBoard);
          delay(3500); 
       }
       if(wins == 0)
         System.out.println("\nAww man, you lost all 5 rounds");
       else
         System.out.println("\nHey! You won " + wins + " rounds!");       
   }
   
   public static void fillSlots(String[][] arr)
   {
      for(int k = 0; arr.length > k; k++)
      {
         for(int p = 0; arr.length > p; p++)
         {
            temp = randInt.nextInt(slotItems.size());
            arr[k][p] = slotItems.get(temp);
         }
      }
   }
   
   public static void rollSlotMachine()
   {      
      if(checkForWinH(slotsBoard) || checkForWinV(slotsBoard) || checkForWinDiagLeft(slotsBoard) || checkForWinDiagRight(slotsBoard))
      {
         System.out.println("\nHey, you won!\n");
         wins++;
      }
      else
         System.out.println("\nAww Dangit\n");
   }
   
   public static boolean checkForWinH(String[][] arr)
   {
       for(int k = 0; arr.length > k; k++)
       {
         for(int p = 0; p < k; p++)
         {
            if(arr[k][p] == (arr[k][p+1]))
               correct = true;
            else 
               return false;
         }
       }
       if (correct == true)
         return true;
       else
         return false; 
   }
   
   public static boolean checkForWinV(String[][] arr)      
   {       
       for(int k = 0; k < arr.length-1; k++)
       {
         for(int p = 0; p > k; p++)
         {
            if(arr[k][p].equals(arr[k+1][p]))
               correct = true;
            else 
               return false;
         }
       } 
       if(correct == true)
         return true;
       else
         return false; 
    }  
    
   public static boolean checkForWinDiagLeft(String[][] arr)      
   {
       for(int k = 0; arr.length - 1 > k; k++)
       {
         for(int p = 0; p == k; p++)
         {
            if(arr[k][p].equals(arr[k+1][p+1]))
               correct = true;
            else 
               return false;
         }
       }
       if(correct == true)
         return true;
       else
         return false;
   } 

   public static boolean checkForWinDiagRight(String[][] arr)      
   {
       for(int k = arr.length ; k > 0; k--)
       {
         for(int p = arr.length; p == k; p--)
         {
            if(arr[k][p].equals(arr[k-1][p-1]))
               correct = true;
            else 
               return false;
         }
       }  
       if(correct == true)
         return true;
       else
         return false;
   }    
      
   public static void printArray(String[][] arr)
   {
      for(int k = 0; arr.length > k; k++)
      {
         for(int p = 0; arr[0].length > p; p++)
          System.out.printf("%-15s", arr[k][p]); 
         System.out.println();
      }
             
   }    
    
   public static void Array(String[][] arr)
   {
      for(int k = 0; arr.length > k; k++)
      {
         for(int p = 0; arr[0].length > p; p++)
         arr[k][p] = "-";
      }
             
   }    
    
   public static void delay(int n)
   {
      long startDelay = System.currentTimeMillis();
      long endDelay = 0;
      while (endDelay - startDelay < n)
      endDelay = System.currentTimeMillis();
   }             
}