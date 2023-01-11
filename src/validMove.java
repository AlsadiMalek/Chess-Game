public class validMove extends Validation{
    @Override
    public boolean Check(ChessBoard board) {
        if(getX1()>7||getX2()>7||getY1()>7||getY2()>7)
            return false;
        if(getX1()<0||getX2()<0||getY1()<0||getY2()<0)
            return false;

        Square loc = board.getSquareAt(getX1(),getY1());
        if(loc.isHasPiece()){
            Location cur = new Location((char)(getX1()+'a')+""+getY1());
            Location dist = new Location((char)(getX2()+'a')+""+getY2());
            Piece piece = board.getSquareAt(getX1(),getY1()).getPiece();
            if(!piece.canMove(cur,dist,board)) {
                setAbility(false);
                return false;
            }
        }
        return super.handleCheck(board);
    }
}
