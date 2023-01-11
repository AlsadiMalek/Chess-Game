public abstract class Piece {
    private Color color;
    boolean firstMove = true;

    public Color getColor(){
        return color;
    }

    public void setColor(Color color) {this.color = color;}
    public abstract boolean canMove(Location begin, Location end, ChessBoard board);
    public void move(Location begin, Location end, ChessBoard board){
        Square spot1 = board.getSquareAt(begin.getX(),begin.getY());
        Piece piece = spot1.getPiece();
        spot1.setPiece(null);
        spot1.setHasPiece(false);
        Square spot2 = board.getSquareAt(end.getX(),end.getY());
        spot2.setPiece(piece);
        spot2.setHasPiece(true);
        firstMove = false;
    }
    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
    @Override
    public String toString() {return "Piece";}
}
