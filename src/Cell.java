public class Cell {
    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int numberOfMinesAround;

    public Cell() {
        this.isFlagged = false;
        this.isMine = false;
        this.isRevealed = false;
        this.numberOfMinesAround = 0;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }
    public boolean getMine() {
        return this.isMine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public int getNumberOfMinesAround() {
        return numberOfMinesAround;
    }

    public void setNumberOfMinesAround(int numberOfMinesAround) {
        this.numberOfMinesAround = numberOfMinesAround;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "isFlagged=" + isFlagged +
                ", isMine=" + isMine +
                ", isRevealed=" + isRevealed +
                ", number=" + numberOfMinesAround +
                '}';
    }


}
