package PiecesCollection;

import GameBases.*;

public class Queen extends Piece {
    public Queen(Color color) {
        setColor(color);
    }

    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {
        moveAbility movement1 = new moveAbility(new Diagonal());
        moveAbility movement2 = new moveAbility(new Straight());
        return movement1.canMove(begin,end,board) || movement2.canMove(begin,end,board);
    }
    @Override
    public String toString() {
        String coloring = "\u001B[3";
        if(getColor().equals(Color.Black))
            coloring += "0m";
        else
            coloring += "7m";
        coloring+="  QUEEN ";
        coloring+="\u001B[0m";
        return coloring;
    }
}
