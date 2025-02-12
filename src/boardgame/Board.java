package boardgame;

public class Board {

    private int rows;
    private int collumns;
    private Piece[][] pieces;

    public Board(int rows, int collumns) {
        this.rows = rows;
        this.collumns = collumns;
        pieces = new Piece[rows][collumns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCollumns() {
        return collumns;
    }

    public void setCollumns(int collumns) {
        this.collumns = collumns;
    }

    public Piece piece(int row, int collum){
        return pieces[row][collum];
    }

    public Piece piece(Position position){
        return pieces[position.getRow()][position.getCollum()];
    }

    public void placePiece(Piece piece, Position position) {
        pieces[position.getRow()][position.getCollum()] = piece;
        piece.position = position;
    }
}
