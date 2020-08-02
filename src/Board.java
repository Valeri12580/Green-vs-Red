public class Board {

    private Cell[][] board;

    public Board(int y,int x) {
        this.board = new Cell[y][x];

    }


    void setRow(int currentRow,String[]rowData){
            for (int col = 0; col < board[currentRow].length; col++) {
                int currentColor=0;
                try {
                     currentColor=Integer.parseInt(rowData[col]);
                }catch (NumberFormatException ex){
                    System.out.println(ex.getMessage());
                    setRow(currentRow,rowData);
                }

                board[currentRow][col]=new Cell(currentColor);
            }

    }

    public int getHeight(){
        return this.board.length;
    }

    public void printBoard(){
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                System.out.print(this.board[row][col]);
            }
            System.out.println();
        }
    }


    public Cell getSpecificCell(int row,int col){
        return this.board[row][col];
    }

    //todo optimization
    public Cell[][] getBoard() {
        return board;
    }
}
