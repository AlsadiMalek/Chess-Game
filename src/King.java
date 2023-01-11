public class King extends Piece{
    public King(Color color) {
        setColor(color);
    }

    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {
        if(Math.abs(begin.getX()-end.getX())+Math.abs(begin.getY()-end.getY()) == 1)
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
        coloring+="  KING  ";
        coloring+="\u001B[0m";
        return coloring;
    }
}
