package PiecesCollection;

import GameBases.Color;
import PiecesCollection.*;

public class PieceMaker {
    private PieceMaker(){};
    public static Piece create(String kind , Color color){
        if(kind.equals("PiecesCollection.Knight"))
            return new Knight(color);
        else if(kind.equals("PiecesCollection.Bishop"))
            return new Bishop(color);
        else if(kind.equals("PiecesCollection.Pawn"))
            return new Pawn(color);
        else if(kind.equals("PiecesCollection.Queen"))
            return new Queen(color);
        else if(kind.equals("PiecesCollection.Rook"))
            return new Rook(color);
        else
            return new King(color);
    }
}
