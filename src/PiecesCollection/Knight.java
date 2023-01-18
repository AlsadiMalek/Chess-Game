package PiecesCollection;

import GameBases.*;

public class Knight extends Piece {
    public Knight(Color color) {
        setColor(color);
    }

    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {
        moveAbility movement = new moveAbility(new shapeL());
        return movement.canMove(begin,end,board);
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
