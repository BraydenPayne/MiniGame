import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] mineMap = new int[3][3];
        int playerSymbol = 0;
        int computerSymbol = 0;
        boolean playerWin = false;
        boolean twoPlayerWin = false;
        boolean computerWin;
        boolean gameOver = false;
        boolean isFull = false;

        // Welcome to Tic-Tac-Toe + choosing your symbol
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Would you like to be Os (1) or Xs (2)?");
        boolean pass = false;
        while (!pass) {
            int response = in.nextInt();
            if (response == 1) {
                playerSymbol = 1;
                computerSymbol = 2;
                pass = true;
            } else if (response == 2) {
                playerSymbol = 2;
                computerSymbol = 1;
                pass = true;
            } else {
                System.out.println("Please pick Os (1) or Xs (2) to proceed!");
            }
        }
        while (!gameOver) {
            // Printing map
            for (int row = 0; row < mineMap.length; row++) {
                System.out.print("|");
                for (int col = 0; col < mineMap[row].length; col++) {
                    if (mineMap[row][col] == 0) {
                        System.out.print("   |");
                    } else if (mineMap[row][col] == 1) {
                        System.out.print(" O |");
                    } else if (mineMap[row][col] == 2) {
                        System.out.print(" X |");
                    }
                }
                System.out.println(" ");
            }
            // First player Choosing next move.
            if (playerSymbol == 1) {
                System.out.println("Player 2 will be X.");
                System.out.println("Where would you like to place your O?");
            } else {
                System.out.println("Player 2 will be O.");
                System.out.println("Where would you like to place your X?");
            }
            System.out.print("Enter your preferred row: ");
            int r = in.nextInt();
            System.out.println("");
            System.out.print("Enter your preferred column: ");
            int c = in.nextInt();
            if (playerSymbol == 2) {
                mineMap[r][c] = 2;
            } else if (playerSymbol == 1) {
                mineMap[r][c] = 1;
            }

            // Checking for first-player winning conditions
            if (isPlayerWin(mineMap, playerSymbol) == true) {
                playerWin = true;
                gameOver = true;
            } else {
                playerWin = false;
            }
            // Checking if board is full
            if (isFull(mineMap) == true) {
                gameOver = true;
                isFull = true;
            } else {
                gameOver = false;
            }

            // Second player turn.
            if (computerSymbol == 1) {
                System.out.println("");
                System.out.println("Second player turn.");
                System.out.println("Where would you like to place your O?");
            } else {
                System.out.println("");
                System.out.println("Second player turn.");
                System.out.println("Where would you like to place your X?");
            }
            System.out.print("Enter your preferred row: ");
            int rTwo = in.nextInt();
            System.out.println("");
            System.out.print("Enter your preferred column: ");
            int cTwo = in.nextInt();
            if (computerSymbol == 2) {
                mineMap[rTwo][cTwo] = 2;
            } else if (computerSymbol == 1) {
                mineMap[rTwo][cTwo] = 1;
            }

            // Checking for second-player winning conditions
            if (isPlayerWin(mineMap, computerSymbol) == true) {
                twoPlayerWin = true;
                gameOver = true;
            } else {
                gameOver = false;
            }
            // Checking if board is full
            if (isFull(mineMap) == true) {
                gameOver = true;
                isFull = true;
            } else {
                gameOver = false;
            }

        }

        if (gameOver && playerWin && !twoPlayerWin) {
            System.out.println("Congrats, you have beaten a friend (or yourself) +1 point");
            endGame();
        } else if (gameOver && !playerWin && twoPlayerWin) {
            System.out.println("Congrats, player 2 has won (Or you beat yourself)");
            endGame();
        } else if (gameOver && !playerWin && !twoPlayerWin && isFull) {
            System.out.println("Congrats, the game is a draw (board is full)");
            endGame();
        }

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    // Checks board if full
    public static boolean isFull(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Checks for winning condition
    public static boolean isPlayerWin(int[][] array, int playerSymbol) {
        // top row
        if (array[0][0] == playerSymbol && array[0][1] == playerSymbol && array[0][2] == playerSymbol) {
            return true;
            // middle row
        } else if (array[1][0] == playerSymbol && array[1][1] == playerSymbol && array[1][2] == playerSymbol) {
            return true;
            // bottom row
        } else if (array[2][0] == playerSymbol && array[2][1] == playerSymbol && array[2][2] == playerSymbol) {
            return true;
            // middle column
        } else if (array[1][0] == playerSymbol && array[1][1] == playerSymbol && array[1][2] == playerSymbol) {
            return true;
            // left column
        } else if (array[0][0] == playerSymbol && array[0][1] == playerSymbol && array[0][2] == playerSymbol) {
            return true;
            // right column
        } else if (array[2][0] == playerSymbol && array[2][1] == playerSymbol && array[2][2] == playerSymbol) {
            return true;
            // diagonal top left to bottom right
        } else if (array[0][0] == playerSymbol && array[1][1] == playerSymbol && array[2][2] == playerSymbol) {
            return true;
            // diagonal bottom left to top right
        } else if (array[0][2] == playerSymbol && array[1][1] == playerSymbol && array[2][0] == playerSymbol) {
            return true;
            // if no one wins
        } else {
            return false;
        }
    }

    public static void endGame() {
        System.out.println("\033[0;31m" + "GAME END" + "\033[0;31m");
        System.exit(1);
    }
}