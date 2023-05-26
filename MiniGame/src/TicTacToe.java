import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] mineMap = new int[3][3];
        int playerSymbol = 0;
        int computerSymbol = 0;
        boolean playerWin;
        boolean computerWin;
        for (int row = 0; row < mineMap.length; row++) {
            for (int col = 0; col < mineMap[row].length; col++) {
                mineMap[row][col] = 0;
                System.out.print(mineMap[row][col] + "  ");
            }
            System.out.println("");
            System.out.println("");
        }

        boolean gameOver = false;
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
            // Person player Choosing next move.
            System.out.println("Where would you like to place your " + playerSymbol + "?");
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
        }

        // Computer player turn.
        for (int row = 0; row < mineMap.length; row++) {
            for (int col = 0; col < mineMap[row].length; col++) {
                int cRow = randomInt(0, 2);
                int cCol = randomInt(0, 2);
                if (mineMap[cRow][cCol] == 0) {
                    mineMap[cRow][cCol] = computerSymbol;
                }
            }
        }

        // Checking for winning conditions
        for (int row = 0; row < mineMap.length; row++) {
            if (mineMap[row][0] == playerSymbol && mineMap[row][1] == playerSymbol && mineMap[row][2] == playerSymbol) {
                gameOver = true;
                playerWin = true;
            }
            for (int col = 0; col < mineMap[row].length; col++) {
                if (mineMap[0][col] == playerSymbol && mineMap[1][col] == playerSymbol && mineMap[2][col] == playerSymbol) {
                    gameOver = true;
                    playerWin = true;
                }
            }
        }

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int randomInt(int low, int high) {
        return (int) ((high - low + 1) * Math.random() + low);
    }
}
