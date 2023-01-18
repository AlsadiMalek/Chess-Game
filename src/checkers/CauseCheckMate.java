package checkers;

import GameBases.*;

public class CauseCheckMate extends Validation {

    @Override
    public boolean Check(ChessBoard board) {
        ChessBoard tmpBoard = board.clone();
        int x1 = getX1() , x2 = getX2(), y1 = getY1(), y2 = getY2();
        Location begin = new Location((char)(x1+'a')+""+y1);
        Location end = new Location((char)(x2+'a')+""+y2);
        Color color = tmpBoard.getSquareAt(x1,y1).getPiece().getColor();
        tmpBoard.getSquareAt(getX1(),getY1()).getPiece().move(begin,end,tmpBoard);
        Location kingsLoc = tmpBoard.getKingLocation(color);
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(tmpBoard.getSquareAt(j,i).isHasPiece()){
                    if(tmpBoard.getSquareAt(j,i).getPiece().getColor().equals(color))
                        continue;
                    Location loc = tmpBoard.getSquareAt(j,i).getLocation();


                    Validation validChecker1 = new validMove();
                    validChecker1.setAll(loc,kingsLoc);
                    Validation validChecker2 = new validRoat();
                    validChecker2.setAll(loc,kingsLoc);

                    validChecker1.SetNext(validChecker2);

                    if(validChecker1.Check(tmpBoard)) {
                        setAbility(false);
                        return false;
                    }
                }
            }
        }

        return super.handleCheck(board);
    }
}
