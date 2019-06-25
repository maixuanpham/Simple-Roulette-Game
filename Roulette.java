// Class Roullete for CSCI 145 Project 2 Fall 17
// Modified by: Mai Pham

import java.util.*;

//************************************************************************
//   Class Roulette contains the main driver for a roulette betting game.
//************************************************************************
class Roulette
{
    //=====================================================================
    //  Contains the main processing loop for the roulette game.
    //=====================================================================
    public static void main (String[] args)
    {
      	Scanner scan = new Scanner(System.in);
      	Player player1 = new Player ("Jane", 100);   // $100 to start for Jane
      	Player player2 = new Player ("Jerel", 100);   // $100 to start for Jerel
      	boolean done1 = false;
      	boolean done2 = false;
      	
      	System.out.println ("A Simple Roulette Game");
      	System.out.println ("By Mai Pham\n");
      	Wheel.welcomeMessage();

      	while (!done1 || !done2)
      	{
      		if (!done1)
      		{
      			System.out.println ("Money available for " + player1.getName()
      						+ ": " + player1.getMoney());
      			player1.makeBet(scan);
      			System.out.println();
      		}
      		if (!done2)
      		{
      			System.out.println ("Money available for " + player2.getName()
      						+ ": " + player2.getMoney());
      			player2.makeBet(scan);
      			System.out.println();
      		}
      		
         	Wheel.spin();
         	System.out.println();
         	
         	if (!done1)
         	{
         		player1.payment();
         		done1 = !player1.playAgain(scan);
         		System.out.println();
         	}
         	if (!done2)
            {
         		player2.payment();
         		done2 = !player2.playAgain(scan);
         		System.out.println();
            }
      	}
      	player1.displayStatus();
      	player2.displayStatus();
    	
      	System.out.println("The total amount winning/losing by the house is: " 
    						+ (player1.byTheHouse() + player2.byTheHouse()));
      	
      	System.out.println ("\nGame over!  Thanks for playing.");
      	scan.close();
   }
}
