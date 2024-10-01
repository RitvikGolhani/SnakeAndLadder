import java.util.Random;
import java.util.Scanner;

class MainRunner{

	static final int WINNING_POSITION = 100;
	static int[] board = new int[101]; // board[0] is unused for simplicity
	static int player1Position = 0;
	static int player2Position = 0;

	static {
		// Snakes and Ladders configuration
		board[3] = 22;  // Ladder from 3 to 25
		board[5] = 8;   // Ladder from 5 to 13
		board[11] = 26; // Ladder from 11 to 37
		board[20] = 29; // Ladder from 20 to 49
		board[17] = 4;  // Snake from 17 to 4
		board[19] = 7;  // Snake from 19 to 7
		board[27] = 1;  // Snake from 27 to 1
		board[39] = 3;  // Snake from 39 to 3
		board[52] = 29; // Snake from 52 to 29
		board[57] = 40; // Snake from 57 to 40
		board[70] = 55; // Snake from 70 to 55
		board[75] = 33; // Snake from 75 to 33
		board[82] = 18; // Snake from 82 to 18
		board[88] = 24; // Snake from 88 to 24
		board[95] = 73; // Snake from 95 to 73
		board[99] = 78; // Snake from 99 to 78
	}
    public static void main(String[] args) {
      
    }

    private static void playerTurn(int playerNumber, Scanner scanner, Random random) {
        int position = playerNumber == 1 ? player1Position : player2Position;

        System.out.println("Player " + playerNumber + "'s turn. Press Enter to roll the dice.");
        scanner.nextLine();
        int diceRoll = rollDice(random);
        System.out.println("Player " + playerNumber + " rolled a " + diceRoll);

        if (position == 0 && diceRoll == 6) {
            // Player starts from 0 only if they rolled a 6
            position += diceRoll;
            System.out.println("Player " + playerNumber + " can start moving!");
        } else if (position > 0) {
            position += diceRoll;
        }

        position = moveThroughSnakesAndLadders(position);
        System.out.println("Player " + playerNumber + "'s new position: " + position);

        if (playerNumber == 1) {
            player1Position = position;
        } else {
            player2Position = position;
        }
    }

    private static int rollDice(Random random) {
        return random.nextInt(6) + 1; // Roll a number between 1 and 6
    }

    private static int moveThroughSnakesAndLadders(int position) {
        if (position > WINNING_POSITION) {
            return position; // Ignore overshoot
        }
        return board[position] == 0 ? position : board[position]; // Move to new position if there's a snake or ladder
    }

	

}