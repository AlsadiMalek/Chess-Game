public class Rook extends Piece{
    public Rook(Color color) {
        setColor(color);
    }

    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {
        if(begin.getY()-end.getY()==0 || begin.getX()-end.getX()==0)
            return true;
        return false;
    }
    @Override
    public String toString() {
        String coloring = "\u001B[3";
        if(getColor().equals(Color.Black))
            coloring += "0m";
        else
            coloring += "7m";
        coloring+="  ROOK  ";
        coloring+="\u001B[0m";
        return coloring;
    }
}
