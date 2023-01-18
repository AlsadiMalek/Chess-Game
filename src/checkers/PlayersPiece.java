package checkers;

import GameBases.ChessBoard;
import GameBases.Square;
import checkers.*;

public class PlayersPiece extends Validation {
    @Override
    public boolean Check(ChessBoard board){
        Square spot = board.getSquareAt(getX1(),getY1());
        if(spot.isHasPiece() && !spot.getPiece().getColor().equals(getPlayerColor())) {
            setAbility(false);
            return false;
        }
        if(!spot.isHasPiece()) {
            setAbility(false);
            return false;
        }

        return super.handleCheck(board);
    }
}
