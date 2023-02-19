

import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        //Here, I Created a 3x3 array that represents our  tic_tac_toe Game.

        char[][] tic_tac_toe = new char[3][3];

        //Here, I Initialize our tic_tac_toe with dashes (empty positions).

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                tic_tac_toe[i][j] = '-';
            }
        }



        //Here, I Create a Scanner and ask the players for their names.

        Scanner in = new Scanner(System.in);
        System.out.println("Play Tic Tac  Toe: ");
        System.out.print("Player_one, what's your name?  ");
        String p1 = in.nextLine();
        System.out.print("Player_two, what's your name?  ");
        String p2 = in.nextLine();

        //Here, I Create a player___one boolean Which is true if it is Player_one's turn and false if it is Player_two's turn

        boolean player___one = true;

        //Here, I Create a gameFinished  boolean and use it as the condition in the while loop

        boolean gameFinished  = false;
        while(!gameFinished ) {

            //Here, I Draw the tic_tac_toe

            drawTic_tac_toe(tic_tac_toe);

            //Here, I Print whose turn it is

            if(player___one) {
                System.out.println(p1 + "'s Turn (x):");
            } else {
                System.out.println(p2 + "'s Turn (o):");
            }

            //Here, I Create a char variable that stores either 'x' or 'o' based on what player's turn it is
            char c = '-';
            if(player___one) {
                c = 'x';
            } else {
                c = 'o';
            }

            //Here, I Create row and col variables which represent indexes that correspond to a position on our tic_tac_toe

            int row = 0;
            int col = 0;

            //Here, I break out of the while loop once the user enters a valid position.

            while(true) {

                //Here, I Ask the user for what position they want to place their x or o.

                System.out.print("Enter a row number (0, 1, or 2): ");
                row = in.nextInt();
                System.out.print("Enter a column number (0, 1, or 2): ");
                col = in.nextInt();

                //Here, I Check if the row and col are 0, 1, or 2.

                if(row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("This position is off the bounds of the tic_tac_toe game and Try again.");

                    //Here, I Check if the position on the tic_tac_toe the user entered is empty (has a -) or not


                } else if(tic_tac_toe[row][col] != '-') {
                    System.out.println("Someone has already made a move at this position: Try again!!!");

                    //if not, the position is valid so break out of the while loop
                } else {
                    break;
                }

            }

            //Here, I Set the position on the tic_tac_toe at row, col to c

            tic_tac_toe[row][col] = c;

            //Here, I Check to see if either player has won

            if(playerHasWon(tic_tac_toe) == 'x') {
                System.out.println(p1 + " won!");
                gameFinished  = true;
            } else if(playerHasWon(tic_tac_toe) == 'o') {
                System.out.println(p2 + " won!");
                gameFinished  = true;
            } else {

                //Here, I make a condition, If neither player has won, check to see if there has been a tie (if the tic_tac_toe is full)

                if(tic_tac_toeIsFull(tic_tac_toe)) {
                    System.out.println("It's a tie!");
                    gameFinished  = true;
                } else {
                    //If player___one is true, make it false, and vice versa; this way, the players alternate each turn
                    player___one = !player___one;
                }

            }

        }

        //Here, I Draw the tic_tac_toe at the end of the game
        drawTic_tac_toe(tic_tac_toe);

    }



    //Here, I Make a function to draw the tic tac toe tic_tac_toe

    public static void drawTic_tac_toe(char[][] tic_tac_toe) {
        System.out.println("Tic_tac_toe:");
        for(int i = 0; i < 3; i++) {
            //The inner for loop prints out each row of the tic_tac_toe
            for(int j = 0; j < 3; j++) {
                System.out.print(tic_tac_toe[i][j]);
            }
            //This print statement makes a new line so that each row is on a separate line
            System.out.println();
        }
    }

    //Here, I Make a function to see if someone has won and return the winning char

    public static char playerHasWon(char[][] tic_tac_toe) {

        //Check each row

        for(int i = 0; i < 3; i++) {
            if(tic_tac_toe[i][0] == tic_tac_toe[i][1] && tic_tac_toe[i][1] == tic_tac_toe[i][2] && tic_tac_toe[i][0] != '-') {
                return tic_tac_toe[i][0];
            }
        }

        //Check each column

        for(int j = 0; j < 3; j++) {
            if(tic_tac_toe[0][j] == tic_tac_toe[1][j] && tic_tac_toe[1][j] == tic_tac_toe[2][j] && tic_tac_toe[0][j] != '-') {
                return tic_tac_toe[0][j];
            }
        }

        //Check the diagonals

        if(tic_tac_toe[0][0] == tic_tac_toe[1][1] && tic_tac_toe[1][1] == tic_tac_toe[2][2] && tic_tac_toe[0][0] != '-') {
            return tic_tac_toe[0][0];
        }
        if(tic_tac_toe[2][0] == tic_tac_toe[1][1] && tic_tac_toe[1][1] ==  tic_tac_toe[0][2] && tic_tac_toe[2][0] != '-') {
            return tic_tac_toe[2][0];
        }

        //Otherwise nobody has not won yet
        return ' ';

    }

    //Here, I Make a function to check if all of the positions on the tic_tac_toe have been filled

    public static boolean tic_tac_toeIsFull(char[][] tic_tac_toe) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(tic_tac_toe[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
