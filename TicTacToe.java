/* 
Leonardo Tse
Steven Yang
OMIS 137 - Ghiassi
Assignment 5: TicTacToe Game
Question : Below is the incomplete code for TicTacToe game.
There are blanks in the code, which you need to fill out with the help of the output and logic.
Your output should look, exactly like the sample output.
This is a group Assignment. Work in teams of two.

Start understanding your code from main()
 */

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe
{
    // declaring variables
    static Scanner input;
    static String[] game_board;
    static String whose_turn;

    static void populateEmptyBoard() // This method is to populate the board
    {
        // (1) write your code here
        game_board = new String[9];
        for(int i=0; i<9; i++){
            game_board[i] = String.valueOf(i+1); //turns the numbers into strings, populating game_board
        }
    }

    static void printBoard() // This method is to print the board in the required format
    {
        // (2) write your code here
        System.out.println("/---|---|---\\");
        System.out.println("| " + game_board[0] + " | " + game_board[1] + " | " + game_board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + game_board[3] + " | " + game_board[4] + " | " + game_board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + game_board[6] + " | " + game_board[7] + " | " + game_board[8] + " |");
        System.out.println("/---|---|---\\");

    }

    static String checkWinner()
    {
        for (int a = 0; a < 8; a++)
        {
            String line = null;
            switch (a) //creates a list of possibilities that are "winning combinations
            {
                // (5) write your code here
                case 0: line = game_board[0] + game_board[1] + game_board[2];
                break;
                case 1: line = game_board[3] + game_board[4] + game_board[5];
                break;
                case 2: line = game_board[6] + game_board[7] + game_board[8];
                break;
                case 3: line = game_board[0] + game_board[3] + game_board[6];
                break;
                case 4: line = game_board[1] + game_board[4] + game_board[7];
                break;
                case 5: line = game_board[2] + game_board[5] + game_board[8];
                break;
                case 6: line = game_board[0] + game_board[4] + game_board[8];
                break;
                case 7: line = game_board[6] + game_board[4] + game_board[2];
                break;
            }
            
            //checks to see if the combination is a winner
            if(line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }

        }
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(game_board).contains(String.valueOf(a+1))) {
                break;
            }
            else if (a == 8) return "draw";
        }

        if(whose_turn == "X"){ //changes turn based on whose turn it currently is
            whose_turn = "O";
        } else
            whose_turn = "X";
        System.out.println(whose_turn + "'s turn; enter a slot number to place " + whose_turn + " in:");
        return null;
    }


    public static void main(String[] args)
    {
        // Initializing Variables
        input = new Scanner(System.in);
        game_board = new String[9];
        whose_turn = "X";
        String winner = null;


        //initial message
        System.out.println("Welcome to 2 Player Tic Tac Toe.");
        System.out.println("--------------------------------");
        populateEmptyBoard(); // (1) use this method to populate the empty board


        printBoard(); // (2) use this method to print the Tic Tac Toe board as showed in sample output

        System.out.println("X's will play first. Enter a slot to place X in.");

        // Logic to check if the number entered is in range or not and to check who is winner
        while (winner == null)
        {
            int number;
            try {
                number = input.nextInt();
                if (!(number > 0 && number <= 9)) {
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
            } catch (InputMismatchException e)
            {
                number = -1;
                System.out.println("Invalid input; Re start the game");
            }

            if (game_board[number-1] != "X" || game_board[number-1] != "O")  // (3) This statement is incorrect, edit it
            {
                // (4) write the code here for assigning 'X' or 'O' and changing turns.
                game_board[number-1] = whose_turn;

                printBoard(); // (2) use this method to print the Tic Tac Toe board as showed in sample output

                winner = checkWinner(); // (5) write the code to check who won the game
            }
            else
            {
                System.out.println("Slot already taken; re-enter slot number:");
                continue;
            }
        }
        // (7) write the code to print draw / winner
        if(winner.equals("draw"))
            System.out.println("It's a draw! Thanks for playing.");
         else if(winner.equals("X"))
            System.out.println("Congratulations! X's have won. Thanks for playing.");
        else
            System.out.println("Congratulations! O's have won. Thanks for playing.");
    }
}
