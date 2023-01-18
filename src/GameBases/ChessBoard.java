package GameBases;

import PiecesCollection.*;

public class ChessBoard {
    private final int Size = 8;
    private Square[][] spots;
    public void printGrid(){
        int num = 8;
        for(int i=0;i<Size;i++){
            for(int j=0;j<Size;j++){
                if(j==0){
                    System.out.print(num-- + " ");
                }
                System.out.print("|"+spots[i][j]);
                if(j==Size-1)
                    System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("\t  a\t\t\tb\t\t c\t\t  d\t\t  e\t\t\tf\t\tg\t\t  h");
    }
    public void reset(){

        boolean white = true;
        for(int i= 0;i<Size;i++){
            for(int j=0;j<Size;j++){
                Location loc = new Location((char)(j+'a')+""+i);
                spots[i][j] = new Square(false,loc);
                if(white)
                    spots[i][j].setSquareColor(Color.White);
                else
                    spots[i][j].setSquareColor(Color.Black);
                if(j!=Size-1)
                    white = !white;
            }
        }
        spots[0][0].setPiece( PieceMaker.create("PiecesCollection.Rook",Color.Black) );
        spots[0][1].setPiece( PieceMaker.create("PiecesCollection.Knight",Color.Black) );
        spots[0][2].setPiece( PieceMaker.create("PiecesCollection.Bishop",Color.Black) );
        spots[0][3].setPiece( PieceMaker.create("PiecesCollection.Queen",Color.Black) );
        spots[0][4].setPiece( PieceMaker.create("PiecesCollection.King",Color.Black) );
        spots[0][5].setPiece( PieceMaker.create("PiecesCollection.Bishop",Color.Black) );
        spots[0][6].setPiece( PieceMaker.create("PiecesCollection.Knight",Color.Black) );
        spots[0][7].setPiece( PieceMaker.create("PiecesCollection.Rook",Color.Black) );
        for(int i=0;i<Size;i++){
            spots[1][i].setPiece( PieceMaker.create("PiecesCollection.Pawn",Color.Black) );
        }
        for(int i=0;i<2;i++)
            for(int j=0;j<Size;j++) {
                spots[i][j].setHasPiece(true);
            }

        spots[7][0].setPiece( PieceMaker.create("PiecesCollection.Rook",Color.White) );
        spots[7][1].setPiece( PieceMaker.create("PiecesCollection.Knight",Color.White) );
        spots[7][2].setPiece( PieceMaker.create("PiecesCollection.Bishop",Color.White) );
        spots[7][3].setPiece( PieceMaker.create("PiecesCollection.Queen",Color.White) );
        spots[7][4].setPiece( PieceMaker.create("PiecesCollection.King",Color.White) );
        spots[7][5].setPiece( PieceMaker.create("PiecesCollection.Bishop",Color.White) );
        spots[7][6].setPiece( PieceMaker.create("PiecesCollection.Knight",Color.White) );
        spots[7][7].setPiece( PieceMaker.create("PiecesCollection.Rook",Color.White) );
        for(int i=0;i<Size;i++){
            spots[6][i].setPiece( PieceMaker.create("PiecesCollection.Pawn",Color.White) );
        }

        for(int i=6;i<Size;i++)
            for(int j=0;j<Size;j++)
                spots[i][j].setHasPiece(true);

    }
    public ChessBoard clone(){
        Square tmp[][] = new Square[8][8];

        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                tmp[i][j] = spots[i][j].clone();
            }
        return new ChessBoard(tmp);
    }
    public ChessBoard(Square[][] others){
        spots = new Square[Size][Size];
        for(int i=0;i<Size;i++)
            for(int j=0;j<Size;j++)
                spots[i][j] = others[i][j].clone();
    }
    public ChessBoard(){
        spots = new Square[Size][Size];
        for(int i=0;i<Size;i++){

        }
        reset();
    }
    public Square getSquareAt(int x, int y){
        return spots[y][x];
    }
    public Location getKingLocation(Color color){
        for(int i=0;i<Size;i++)
            for(int j=0;j<Size;j++)
                if(spots[i][j].getPiece() instanceof King && spots[i][j].getPiece().getColor()==color)
                    return new Location((char)(j+'a')+""+i);
        return new Location("e1");
    }

}
