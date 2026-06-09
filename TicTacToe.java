import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    // Method to initialize board
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Method to print board
    static void printBoard() {
        System.out.println();

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    // Method for player move
    static void playerMove(Scanner sc) {

        int row, col;

        while (true) {

            System.out.println("Player " + currentPlayer + ", enter row and column (0-2): ");

            row = sc.nextInt();
            col = sc.nextInt();

            // Check valid move
            if (row >= 0 && row < 3 &&
                col >= 0 && col < 3 &&
                board[row][col] == '-') {

                board[row][col] = currentPlayer;
                break;
            }
            else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    // Method to check winner
    static boolean checkWinner() {

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer) {
            return true;
        }

        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    // Method to check draw
    static boolean isBoardFull() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }

    // Method to switch player
    static void switchPlayer() {

        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        }
        else {
            currentPlayer = 'X';
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        initializeBoard();

        System.out.println("=== TIC TAC TOE GAME ===");

        while (true) {

            printBoard();

            playerMove(sc);

            // Check winner
            if (checkWinner()) {

                printBoard();

                System.out.println("Player " + currentPlayer + " wins!");

                break;
            }

            // Check draw
            if (isBoardFull()) {

                printBoard();

                System.out.println("Game Draw!");

                break;
            }

            switchPlayer();
        }

        sc.close();
    }
}