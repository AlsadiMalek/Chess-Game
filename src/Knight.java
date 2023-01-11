public class Knight extends Piece{
    public Knight(Color color) {
        setColor(color);
    }

    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {

        if(Math.abs(begin.getX()-end.getX())==1 && Math.abs(begin.getY()-end.getY())==2){
            return true;
        }else if(Math.abs(begin.getX()-end.getX())==2 && Math.abs(begin.getY()-end.getY())==1)
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
        coloring+=" KNIGHT ";
        coloring+="\u001B[0m";
        return coloring;
    }
}
