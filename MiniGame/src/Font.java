
for (int row = 0; row < array.length; row++) {
    if (array[row][0] == playerSymbol && array[row][1] == playerSymbol
            && array[row][2] == playerSymbol) {
        gameOver = true;
        playerWin = true;
    }
    for (int col = 0; col < array[row].length; col++) {
        if (array[0][col] == playerSymbol && array[1][col] == playerSymbol
                && array[2][col] == playerSymbol) {
            gameOver = true;
            playerWin = true;
        }
    }
    if (array[0][0] == playerSymbol && array[1][1] == playerSymbol && array[2][2] == playerSymbol) {
        gameOver = true;
        playerWin = true;
    } else if (array[0][2] == playerSymbol && array[1][1] == playerSymbol
            && array[2][0] == playerSymbol) {
        gameOver = true;
        playerWin = true;
    }
}
}