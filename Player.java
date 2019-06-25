// Class Player for CSCI 145 Project 2 Fall 17
// Modified by: Mai Pham

import java.util.*;

//************************************************************************
//   Class Player represents one roulette player.
//************************************************************************
class Player
{
	private static final int RELOAD_AMOUNT = 100;
    private int bet, money;
    private String name;
    private int betType, number;
    private int winLose, housePay;
    
 
    //=====================================================================
    //  The Player constructor sets up  name and initial available money.
    //=====================================================================
    public Player (String playerName, int initialMoney)
    {
		name = playerName;
      	money = initialMoney;
   	} // constructor Player


    //=====================================================================
    //  Returns this player's name.
    //=====================================================================
    public String getName()
    {
      	return name;
    }  // method getName


    //=====================================================================
    //  Returns this player's current available money.
    //=====================================================================
    public int getMoney()
    {
      	return money;
    }  // method getMoney


    //=====================================================================
    //  Prompts the user and reads betting information.
    //=====================================================================
    public void makeBet(Scanner scan)
    {
      	System.out.print("How much to bet: ");
      	bet = scan.nextInt();
      	
      	while (bet < 1 || bet > money)
      	{
      		System.out.print("The amount is invalid. \nPlease enter the amount again: ");
          	bet = scan.nextInt();
      	}
      	money = money - bet;
      	housePay += bet;
      	winLose -= bet;
      	
      	Wheel.betOptions();
      	System.out.print("Please enter a betting option: ");
      	betType = scan.nextInt();
      	while (betType < 1 || betType > 3)
      	{
      		System.out.print("The betting option is invalid. \nPlease enter betting option again: ");
      		betType = scan.nextInt();
      	}
      	
      	if (betType == Wheel.NUMBER)
      	{
      		System.out.print("Please enter a number: ");
      		number = scan.nextInt();
      		while (number < Wheel.MIN_NUM || number > Wheel.MAX_NUM)
      		{
      			System.out.print("The number is invalid. \nPlease enter a number again: ");
          		number = scan.nextInt();
      		}
      	}
    } // method makeBet

    
    public void payment()
    {	
    		int winAmount;
    		winAmount = Wheel.payoff(bet, betType, number);
    		money += winAmount;
        	housePay -= winAmount;
        	winLose += winAmount;
    		System.out.println("The amount " + name + " win is: " + winAmount);
    }
    
    
    public void displayStatus()
    {
    		System.out.println("The total amount winning/losing by " + name + " is: " + winLose);
    }
    
    
    public int byTheHouse()
    {
    		return housePay;
    }
    
    
    //=====================================================================
    //  Determines if the player wants to play again.
    //=====================================================================
    public boolean playAgain(Scanner scan)
    {
      	String answer;
      	System.out.print ("Play again [y/n]? ");
      	answer = scan.next();
      	if (answer.equalsIgnoreCase("Y"))
      		if (money == 0)
      			money += RELOAD_AMOUNT;
      	return (answer.equals("y") || answer.equals("Y"));
    }  // method playAgain
}
