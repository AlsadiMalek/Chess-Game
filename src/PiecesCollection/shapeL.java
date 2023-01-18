package PiecesCollection;

import GameBases.ChessBoard;
import GameBases.Location;

public class shapeL implements Imovable{

    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {
        if(Math.abs(begin.getX()-end.getX())==1 && Math.abs(begin.getY()-end.getY())==2){
            return true;
        }else if(Math.abs(begin.getX()-end.getX())==2 && Math.abs(begin.getY()-end.getY())==1)
            return true;

        return false;
    }
}
