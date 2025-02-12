package boardgame;

public class Board {

    private int rows;
    private int collumns;
    private Piece[][] pieces;

    public Board(int rows, int collumns) {
        if (rows < 1 || collumns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 collum");
        }
        this.rows = rows;
        this.collumns = collumns;
        pieces = new Piece[rows][collumns];
    }

    public int getRows() {
        return rows;
    }

    public int getCollumns() {
        return collumns;
    }

    public Piece piece(int row, int collum){
        if (!positionExists(row, collum)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][collum];
    }

    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getCollum()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getCollum()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int collum){
        return row >= 0 && row < rows && collum >= 0 && collum < collumns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getCollum());
    }

    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
