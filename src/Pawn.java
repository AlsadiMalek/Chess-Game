public class Pawn extends Piece{
    public Pawn(Color color) {
        setColor(color);
        firstMove = true;
    }

    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {
        int rev = 1;
        if(getColor() == Color.White)
            rev = -1;

        Square spot = board.getSquareAt(end.getX(),end.getY());
        if(spot.isHasPiece()) {
            if(end.getY()-begin.getY()==rev && Math.abs(end.getX()- begin.getX())==1){
                if(spot.isHasPiece()){
                    Piece piece = spot.getPiece();
                    if(piece.getColor()!=getColor())
                        return true;
                }
            }
        }else {
            if (end.getY() - begin.getY() == rev && Math.abs(end.getX()-begin.getX())==0)
                return true;
            if (firstMove && end.getY() - begin.getY() == 2 * rev && Math.abs(end.getX()-begin.getX())==0)
                return true;
        }

        return false;
    }
    @Override
    public String toString() {
        String coloring = "\u001B[3";
        if(getColor().equals(Color.Black))
            coloring += "0m";
        else
            coloring += "7m";
        coloring+="  PAWN  ";
        coloring+="\u001B[0m";
        return coloring;
    }

}
