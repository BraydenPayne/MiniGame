import java.util.Scanner;

public class Minesweeper {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] mineMap = new int[3][3];
        String playerSymbol = "?";
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
                playerSymbol = "O";
                pass = true;
            } else if (response == 2) {
                playerSymbol = "X";
                pass = true;
            } else {
                System.out.println("That's not what I asked you buster");
            }
        }
        while (!gameOver) {
            //Printing map
            for (int row = 0; row < mineMap.length; row++) {
                System.out.print("|");
                for (int col = 0; col < mineMap[row].length; col++) {
                    if (mineMap[row][col] == 0) {
                        System.out.print("  |");
                    } else if (mineMap[row][col] == 1) {
                        System.out.print("O |");
                    } else if (mineMap[row][col] == 2) {
                        System.out.print("X |");
                    }
                }
                System.out.println(" ");
            }
            //Choosing next move
            System.out.println("Where would you like to place your " + playerSymbol + "?" + "rows and columns are labelled 0-2.");

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
