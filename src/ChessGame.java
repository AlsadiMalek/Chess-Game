import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChessGame {
    private ChessBoard board;
    public void startGame(File file,Scanner sc){
        System.out.println();
        board = new ChessBoard();
        Color color = Color.White;
        int cnt = 0;
        while(true) {
            System.out.println();
            board.printGrid();
            System.out.println();
            if(CheckMate.canFixIt(board,color)==false){
                if(Color.White == color) {
                    System.out.println("player " + Color.Black + " wins!");
                }else
                    System.out.println("player " + Color.White + " wins!");
                break;
            }
            if(cnt == 50) {
                System.out.println("you passed 50 moves !\nGame ends draw\n");
                break;
            }
            if(color.equals(Color.White)){
                System.out.println("White player turn!");
            }else{
                System.out.println("Black player turn!");
            }

            System.out.println("Enter Piece location and destination eg:(b1 a3)");
            String loc1 = sc.next();
            String loc2 = sc.next();

            Location loc = new Location();
            loc.UserInput(loc1);
            Location dis = new Location();
            dis.UserInput(loc2);

            Validation validChecker1 = new PlayersPiece();
            validChecker1.setAll(loc,dis);
            validChecker1.setPlayerColor(color);
            Validation validChecker2 = new validMove();
            validChecker2.setAll(loc,dis);
            Validation validChecker3 = new validRoat();
            validChecker3.setAll(loc,dis);
            Validation validChecker4 = new OverSameColor();
            validChecker4.setAll(loc,dis);
            Validation validChecker5 = new CauseCheckMate();
            validChecker5.setAll(loc,dis);

            validChecker1.SetNext(validChecker2);
            validChecker2.SetNext(validChecker3);
            validChecker3.SetNext(validChecker4);
            validChecker4.SetNext(validChecker5);
            if(validChecker1.Check(board)){
                Square spot = board.getSquareAt(loc.getX(),loc.getY());
                spot.getPiece().move(loc,dis,board);

                if(color.equals(Color.White))
                    color = Color.Black;
                else
                    color = Color.White;

            }else{
                System.out.printf("Invalid input retry again");
            }
        }
    }
}
