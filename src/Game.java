public class Game {
    private GameState state;
    private Board board;
    private int countRevealed;
    private int flags;

    public Game(int mines , int width , int height) {
        this.board = new Board(height, mines, width);
        this.countRevealed = 0;
        this.flags = board.getMines();
        this.state = GameState.PLAYING;
        initGame();
    }
    public void initGame(){
        board.fillMines();
        board.minesAround();
    }
   public void toggleFlag(int row, int col){
       if (row < 0 || col < 0 || row >= board.getHeight() || col >= board.getWidth()) {
            System.out.println("Run The Game Again!");
           throw new IllegalArgumentException("Invalid position: " + row + ", " + col);
       }
        Cell cell = this.board.getCells()[row][col];
       if((!cell.isRevealed()) && this.state == GameState.PLAYING) {
           if (cell.isFlagged()) {
               cell.setFlagged(false);
               this.flags++;
           }
           else{
               cell.setFlagged(true);
               this.flags--;
           }
       }
    }
    public void revealCell(int row , int col){
        if (row < 0 || col < 0 || row >= board.getHeight() || col >= board.getWidth()) {
            System.out.println("Run The Game Again!");
            throw new IllegalArgumentException("Invalid position: " + row + ", " + col);
        }
        Cell cell = this.board.getCells()[row][col];
        if(!cell.isRevealed() && !cell.isMine()
           && cell.getNumberOfMinesAround() == 0
           && this.state == GameState.PLAYING){
            this.countRevealed = 0;
            board.revealFlood(row, col);
            for (int i = 0; i < this.board.getCells().length; i++) {
                for (int j = 0; j < this.board.getCells()[0].length; j++) {
                    if(this.board.getCells()[i][j].isRevealed() && !this.board.getCells()[i][j].isMine()) {
                        this.countRevealed++;
                    }
                    if (cell.isFlagged()) {
                        return;
                    }
                }
            }
       }
       if((!cell.isRevealed()) && cell.isMine() && this.state == GameState.PLAYING){
           cell.setRevealed(true);
           this.state = GameState.LOST;
       }
       if(((!cell.isRevealed()) && (!cell.isMine())) && this.state == GameState.PLAYING){
           cell.setRevealed(true);
           this.countRevealed++;
       }
       if (this.state == GameState.PLAYING && (board.getHeight() * board.getWidth()) - board.getMines() == countRevealed) {
           this.state = GameState.WON;
       }

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    public GameState getState() { return state; }
}
