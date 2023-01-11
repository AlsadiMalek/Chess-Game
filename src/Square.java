public class Square {
    private boolean hasPiece;
    private Color squareColor;
    private Piece piece;
    private Location location;

    public Square(boolean hasPiece, Location location) {
        this.hasPiece = hasPiece;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    public boolean isHasPiece() {
        return hasPiece;
    }
    public void setHasPiece(boolean hasPiece) {
        this.hasPiece = hasPiece;
    }

    public void setSquareColor(Color squareColor) {
        this.squareColor = squareColor;
    }
    @Override
    protected Square clone(){
        Square tmp = new Square(hasPiece,location);
        tmp.setSquareColor(squareColor);
        if(hasPiece){
            tmp.setPiece(piece);
        }
        return tmp;
    }
    @Override
    public String toString() {
        if(hasPiece)
            return piece.toString();
        String coloring = "\u001B[3";

        if(squareColor.equals(Color.Black))
            coloring += "0m";
        else
            coloring += "7m";
        coloring+=" ______ ";
        coloring+="\u001B[0m";
        return coloring;
    }
}
