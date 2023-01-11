public class PieceMaker {
    private PieceMaker(){};
    public static Piece create(String kind , Color color){
        if(kind.equals("Knight"))
            return new Knight(color);
        else if(kind.equals("Bishop"))
            return new Bishop(color);
        else if(kind.equals("Pawn"))
            return new Pawn(color);
        else if(kind.equals("Queen"))
            return new Queen(color);
        else if(kind.equals("Rook"))
            return new Rook(color);
        else
            return new King(color);
    }
}
