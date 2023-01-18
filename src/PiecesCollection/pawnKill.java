package PiecesCollection;

import GameBases.*;

public class pawnKill implements Imovable{

    @Override
    public boolean canMove(Location begin, Location end, ChessBoard board) {
        Square endS = board.getSquareAt(end.getX(),end.getY());
        Color color = board.getSquareAt(begin.getX(), begin.getY()).getPiece().getColor();
        int rev = 1;
        if(color == Color.White)
            rev = -1;

        if(endS.isHasPiece()) {
            if(end.getY()-begin.getY()==rev && Math.abs(end.getX()- begin.getX())==1){
                if(endS.isHasPiece()){
                    Piece piece = endS.getPiece();
                    if(piece.getColor()!=color)
                        return true;
                }
            }
        }
        return false;
    }
}
