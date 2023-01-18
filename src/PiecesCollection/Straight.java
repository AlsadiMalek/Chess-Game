package PiecesCollection;

import GameBases.ChessBoard;
import GameBases.Location;

public class Straight implements Imovable {
    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {
        if(begin.getY()-end.getY()==0 || begin.getX()-end.getX()==0)
            return true;
        return false;
    }
}
