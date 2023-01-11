public class CheckMate {
    public static boolean canFixIt(ChessBoard board, Color color){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                Square spot = board.getSquareAt(j,i);
                if(spot.isHasPiece() && spot.getPiece().getColor()==color){
                    if(tryAllMoves(board,spot.getLocation(),color))
                        return true;
                }
            }
        }
        return false;
    }
    private static boolean tryAllMoves(ChessBoard board, Location pieceLoc, Color color){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){

                Location dist = new Location((char)(j+'a')+""+i);
                Validation validChecker1 = new PlayersPiece();
                validChecker1.setAll(pieceLoc,dist);
                validChecker1.setPlayerColor(color);
                Validation validChecker2 = new validMove();
                validChecker2.setAll(pieceLoc,dist);
                Validation validChecker3 = new validRoat();
                validChecker3.setAll(pieceLoc,dist);
                Validation validChecker4 = new OverSameColor();
                validChecker4.setAll(pieceLoc,dist);
                Validation validChecker5 = new CauseCheckMate();
                validChecker5.setAll(pieceLoc,dist);
                validChecker5.setPlayerColor(color);

                validChecker1.SetNext(validChecker2);
                validChecker2.SetNext(validChecker3);
                validChecker3.SetNext(validChecker4);
                validChecker4.SetNext(validChecker5);

                if(validChecker1.Check(board)) {
                    firstmovehandler(board);
                    return true;
                }

            }
        }
        firstmovehandler(board);
        return false;
    }
    static void firstmovehandler(ChessBoard board){
        if(board.getSquareAt(0,6).isHasPiece())
            board.getSquareAt(0,6).getPiece().setFirstMove(true);
    }
}
