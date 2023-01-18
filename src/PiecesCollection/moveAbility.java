package PiecesCollection;

import GameBases.ChessBoard;
import GameBases.Location;

public class moveAbility {
    private Imovable movement;
    public moveAbility(Imovable movement){
        this.movement = movement;
    }
    public boolean canMove(Location begin, Location end, ChessBoard board){
        return movement.canMove(begin,end,board);
    }
}
