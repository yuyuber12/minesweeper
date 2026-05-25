import java.io.IOError;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Game game = new Game(10, 9, 9);

        int row;
        int col;
        int numMode;
        Exception e = null;

        System.out.println("The Game is Optimized for: " + " W: " + game.getBoard().getWidth() + " H: " + game.getBoard().getHeight());
        printStart(game);
        while (game.getState() != GameState.LOST && game.getState() != GameState.WON) {
            System.out.println("FOR SELECTING A CELL TO REVEAL PRESS 1 OR PRESS 2 TO CHANGE TO FLAG MODE ⚑ ");
            numMode = in.nextInt();
            if (numMode != 2 && numMode != 1) {
                System.out.println("Press 1 to select a cell or 2 to flag mode");
                continue;
            }
            System.out.println("IN MODE: " + numMode + "\nEnter two numbers: ");
            row = in.nextInt();
            col = in.nextInt();
            if (numMode == 1) {

                game.revealCell(row, col);
            } else {
                game.toggleFlag(row, col);
            }
            printBoard(game, row, col);

            if (game.getState() == GameState.LOST) {
                System.out.println("You Lost! , Run the Program Again for a new game");
            } else if (game.getState() == GameState.WON) {
                System.out.println("You Won!");
            }
            if (game.getState() == (GameState.LOST)) {
                printMines(game);
            }
            System.out.println();
//            printMines(game);
        }
    }


    public static void printBoard(Game game, int selectedRow, int selectedCol) {
        Board theActualBoard = game.getBoard();
        System.out.print("");
        for (int i = 0; i < theActualBoard.getHeight(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < theActualBoard.getHeight(); i++) {
            for (int j = 0; j < theActualBoard.getWidth(); j++) {
                Cell cell = theActualBoard.getCells()[i][j];

                if (!cell.isRevealed()) {
                    if (cell.isFlagged()) {
                        System.out.print("[33m⚑[0m ");
                    } else {
                        System.out.print('■' + " ");
                    }
                } else if (cell.isRevealed() && cell.isMine()) {
                    System.out.print("[31m*[0m ");
                }

                if (cell.isRevealed() && !cell.isMine() && cell.getNumberOfMinesAround() == 0) {
                    if (i == selectedRow && j == selectedCol) {
                        System.out.print("[32mX[0m ");

                    } else {
                        System.out.print('X' + " ");
                    }
                } else if (cell.isRevealed() && !cell.isMine()) {
                    if (cell.getNumberOfMinesAround() == 1) {
                        System.out.print("[34m" + cell.getNumberOfMinesAround() + "[0m ");
                    } else if (cell.getNumberOfMinesAround() == 2) {
                        System.out.print("[35m" + cell.getNumberOfMinesAround() + "[0m ");
                    } else if (cell.getNumberOfMinesAround() == 3) {
                        System.out.print("[36m" + cell.getNumberOfMinesAround() + "[0m ");
                    } else
                        System.out.print(cell.getNumberOfMinesAround() + " ");
                }
            }
            System.out.println(" | " + i);
        }
    }

    public static void printMines(Game game) {
        Board theActuallBoard = game.getBoard();

        System.out.print("");
        for (int i = 0; i < theActuallBoard.getHeight(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < theActuallBoard.getHeight(); i++) {
            for (int j = 0; j < theActuallBoard.getWidth(); j++) {
                Cell cell = theActuallBoard.getCells()[i][j];
                if (cell.isMine()) {
                    System.out.print("[31m*[0m ");
                } else {
                    System.out.print('X' + " ");
                }
            }
            System.out.println(" | " + i);
        }
    }
    public static void printStart(Game game){
        Board theActuallBoard = game.getBoard();

        System.out.print("");
        for (int i = 0; i < theActuallBoard.getHeight(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < theActuallBoard.getHeight(); i++) {
            for (int j = 0; j < theActuallBoard.getWidth(); j++) {
                System.out.print('■' + " ");
            }
            System.out.println(" | " + i);
        }
    }
}
