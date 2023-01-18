package checkers;

import GameBases.*;
import PiecesCollection.*;

public class validRoat extends Validation{
    @Override
    public boolean Check(ChessBoard board) {
        Location begin = new Location((char)(getX1()+'a')+""+getY1());
        Location end = new Location((char)(getX2()+'a')+""+getY2());
        CommonMoves moves = new CommonMoves(begin,end);
        Piece piece = board.getSquareAt(getX1(),getY1()).getPiece();
        if(piece instanceof Knight == false){
            if(!moves.checkRoat(board)) {
                setAbility(false);
                return false;
            }
        }
        return super.handleCheck(board);
    }
}
