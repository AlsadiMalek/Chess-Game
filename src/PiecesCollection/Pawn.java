package PiecesCollection;

import GameBases.*;

public class Pawn extends Piece {
    public Pawn(Color color) {
        setColor(color);
        firstMove = true;
    }

    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {
        moveAbility movement1 = new moveAbility(new pawnSteps());
        moveAbility movement2 = new moveAbility(new pawnKill());
        return movement1.canMove(begin,end,board) || movement2.canMove(begin,end,board);
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
