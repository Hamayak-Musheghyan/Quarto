public class Quarto {
    private static int BOARD_LENGTH = 4;
    private static int BOARD_HEIGHT = 4;
    private static Figure EMPTY = null;

    private Figure[][] board;
    private int counter;
    private Figure[] figures;


    public Quarto (){
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                this.board[i][j] = EMPTY;
            }
        }
        counter = 0;
        figures = Figure.values();
    }

    private Figure[][] getBoard(){
        Figure[][] board = new Figure[BOARD_LENGTH][BOARD_HEIGHT];
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                board[i][j] = this.board[i][j];
            }
        }
        return board;
    }


    private void printCurrentState (){
        System.out.println("Current Board");
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                System.out.println(this.board[i][j]);
            }
        }
        System.out.println("Number of moves is " + this.counter);
        System.out.println("Figures to use");
        for(Figure element: this.figures){
            if(element != null){
                System.out.println(element);
            }
        }
    }

    private int getTurn(){
        return counter%2;
    }

    private boolean isGameOver(){
        return false;
    }

    private boolean isEmpty(Position p){
        return this.board[p.getRow()][p.getColumn()] == null;
    }

    private Figure getPieceAt(Position p){
        return this.board[p.getRow()][p.getColumn()];
    }

    public Figure takeFigure(int index){
        Figure f = this.figures[index];
        this.figures[index] = null;
        return f;
    }

    public boolean performMove (Position p, Figure f){
        if(this.board[p.getRow()][p.getColumn()] == null){
            this.board[p.getRow()][p.getColumn()] = f;
            counter++;
            return true;
        }
        return false;
    }


}