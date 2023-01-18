package PiecesCollection;

import GameBases.ChessBoard;
import GameBases.Location;

public interface Imovable {
    boolean canMove(Location begin, Location end, ChessBoard board);
}
