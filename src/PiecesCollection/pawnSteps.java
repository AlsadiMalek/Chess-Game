package PiecesCollection;

import GameBases.*;

public class pawnSteps implements Imovable{

    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {
        Color color = board.getSquareAt(begin.getX(), begin.getY()).getPiece().getColor();
        int rev = 1;
        if(color == Color.White)
            rev = -1;
        boolean firstMove = board.getSquareAt(begin.getX(),begin.getY()).getPiece().firstMove;

        if (end.getY() - begin.getY() == rev && Math.abs(end.getX()-begin.getX())==0)
            return true;
        if (firstMove && end.getY() - begin.getY() == 2 * rev && Math.abs(end.getX()-begin.getX())==0)
            return true;

        return false;
    }
}
