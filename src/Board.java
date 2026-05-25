import java.util.Random;

public class Board {

    private int mines;
    private Cell[][] cells;
    private int width;
    private int height;

    public Board(int height, int mines, int width) {
        this.cells = new Cell[height][width];
        this.height = height;
        this.width = width;
        this.mines = mines;

        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[0].length; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void fillMines(){
        Random random = new Random();
        int col;
        int row;
        for (int i = 0; i < this.mines; i++) {

            col = random.nextInt(this.width);
            row = random.nextInt(this.height);

            if(this.cells[row][col].getMine()){
                i--;
            }
            else {
                this.cells[row][col].setMine(true);
            }
        }
    }
    public void minesAround(){

        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[0].length; j++) {
                int count = 0;
                Cell curr = this.cells[i][j];
                if(!(curr.getMine())){
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1;dj <= 1; dj++){
                            if (di == 0 && dj == 0){
                                continue;
                            }
                            if ((i+di >= 0 && i+di < height && j+dj >= 0 && j+dj < width) && this.cells[i+di][j+dj].isMine()) {
                                count++;
                            }
                        }
                    }
                    curr.setNumberOfMinesAround(count);
                }
            }
        }
    }
    public void revealFlood(int row, int col) {
        Cell cell = this.cells[row][col];
        if (cell.isRevealed()) {
            return;
        }
        cell.setRevealed(true);
        int count = cell.getNumberOfMinesAround();
        if(count > 0){
            return;
        }
        if(count == 0){
            for (int di = -1; di <= 1; di++) {
                for (int dj = -1; dj <= 1; dj++) {
                    if (di == 0 && dj == 0) {
                        continue;
                    }
                    if ((row+di >= 0 && row+di < height && col+dj >= 0 && col+dj < width) && (!this.cells[row+di][col+dj].isMine())) {
                    revealFlood(row+di, col+dj);
                    }
                }
            }
        }
    }
    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMines() {
        return mines;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
