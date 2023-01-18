package checkers;

import GameBases.ChessBoard;
import GameBases.Color;
import GameBases.Location;

public abstract class Validation {
    private Validation nextCheck;
    private int x1, y1;
    private int x2, y2;
    Color playerColor;
    private boolean ability;
    public boolean isAbility() {
        return ability;
    }

    public void setAbility(boolean ability) {
        this.ability = ability;
    }
    public Color getPlayerColor() {
        return playerColor;
    }
    public void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }
    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }

    public void setAll(Location begin , Location end){
        x1 = begin.getX();
        y1 = begin.getY();
        x2 = end.getX();
        y2 = end.getY();
        ability = true;
    }
    public void SetNext(Validation next){
        nextCheck = next;
    }
    public abstract boolean Check(ChessBoard board);
    public boolean handleCheck(ChessBoard board){
        if(nextCheck!= null){
            nextCheck.Check(board);
            ability = nextCheck.isAbility();
        }
        return ability;
    }
}
