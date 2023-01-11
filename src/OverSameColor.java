public class OverSameColor extends Validation{
    @Override
    public boolean Check(ChessBoard board) {
        if(board.getSquareAt(getX2(),getY2()).isHasPiece()){
            Color color1 = board.getSquareAt(getX2(),getY2()).getPiece().getColor();
            Color color2 = board.getSquareAt(getX1(),getY1()).getPiece().getColor();
            if(color1.equals(color2)) {
                setAbility(false);
                return false;
            }
        }

        return super.handleCheck(board);
    }
}
