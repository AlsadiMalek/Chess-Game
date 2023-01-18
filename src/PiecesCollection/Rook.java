package PiecesCollection;

import GameBases.*;

public class Rook extends Piece {
    public Rook(Color color) {
        setColor(color);
    }

    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {
        moveAbility movement = new moveAbility(new Straight());
        return movement.canMove(begin,end,board);
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
