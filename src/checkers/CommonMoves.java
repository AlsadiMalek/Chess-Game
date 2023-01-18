package checkers;

import GameBases.ChessBoard;
import GameBases.Location;

public class CommonMoves {
    private int dirX;
    private int dirY;
    private Location begin , end;
    public CommonMoves(Location begin, Location end){
        setDirction(begin,end);
        this.begin = begin;
        this.end = end;
    }
    public CommonMoves(){};
    public boolean checkRoat(ChessBoard board) {
        int x = begin.getX();
        int y = begin.getY();
        int x2 = end.getX();
        int y2 = end.getY();
        while(x!=x2 || y!=y2){
            x += dirX;
            y += dirY;
            if(board.getSquareAt(x,y).isHasPiece() && (x!=x2 || y!=y2)){
                return false;
            }
        }
        return true;
    }
    private void setDirction(Location begin , Location end){
        int x1 = begin.getX() , x2 = end.getX();
        int y1 = begin.getY() , y2 = end.getY();
        dirX = dirY = 0;
        if(x2-x1>0)
            dirX = 1;
        else if(x1-x2>0)
            dirX = -1;
        if(y2-y1>0)
            dirY = 1;
        else if(y1-y2>0)
            dirY = -1;
    }

}
