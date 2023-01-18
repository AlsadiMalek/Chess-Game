package PiecesCollection;

import GameBases.ChessBoard;
import GameBases.Location;

public class Diagonal implements Imovable{

    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {
        if(Math.abs(begin.getX()-end.getX())==Math.abs(begin.getY()-end.getY()))
            return true;
        return false;
    }
}
