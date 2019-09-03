/**Q. 33: Craps Game Modification
 *          The code for the game of craps was taken from the coursebook. 
 *          The required modifications of chatter and wagering were added subsequently as per the question. 
 */

import java.util.Random;
import java.util.Scanner;

public class craps{
    private static final Random randomNumbers = new Random();
    private enum Status { CONTINUE, WON, LOST };
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    private int bankBalance = 1000;

    public int getBankBalance(){
        return(bankBalance);
    }

    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);
        craps c = new craps();
        while(true){
            System.out.println("Your bank balance is currently "+c.getBankBalance());
            System.out.println("Place your wagers now!");
            int wager = sc.nextInt();
            if (wager<=c.getBankBalance()){
                crapsgame(c.getBankBalance(), wager);
                chatter();
                break;
            }
        }
    }

    public static void crapsgame(int b, int w){
        int myPoint = 0; // point if no win or loss on first roll
        Status gameStatus;
        int sumOfDice = rollDice();
        switch ( sumOfDice ){
            case SEVEN: // win with 7 on first roll
            case YO_LEVEN: // win with 11 on first roll
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES: // lose with 2 on first roll
            case TREY: // lose with 3 on first roll
            case BOX_CARS: // lose with 12 on first roll
                gameStatus = Status.LOST;
                break;
            default: // did not win or lose, so remember point
                gameStatus = Status.CONTINUE; // game is not over
                myPoint = sumOfDice; // remember the point
                System.out.printf( "Point is %d\n", myPoint );
                break;
        }
        while ( gameStatus == Status.CONTINUE ){
            sumOfDice = rollDice();
            if ( sumOfDice == myPoint ){ // win by making point
                gameStatus = Status.WON;
            }
            else{
                if ( sumOfDice == SEVEN ){ // lsoe by rolling 7 before point
                    gameStatus = Status.LOST;
                }
            }
        }
        // display won or lost message
        if ( gameStatus == Status.WON ){
            System.out.println( "Player wins" );
            b = b + w;
            System.out.println("Your current bank balance is "+ b);
        }
        else{
            System.out.println( "Player loses" );
            b = b - w;
            System.out.println("Your current bank balance is "+ b);
            if (b == 0){
                System.out.println("Sorry. You busted!");
            }
        }
    }

    public static int rollDice(){
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);
        int sum = die1 + die2;
        System.out.printf( "Player rolled %d + %d = %d\n", die1, die2, sum );
        return sum;
    }

    public static void chatter(){
        switch(randomNumbers.nextInt(3)){
            case 0:
                System.out.println("Oh, you're going for broke, huh?");
                break;
            case 1:
                System.out.println("Aw c'mon, take a chance!");
                break;
            case 2:
                System.out.println("You're up big. Now's the time to cash in your chips!");
                break;
        }
    }
}
