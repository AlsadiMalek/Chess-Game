import GameBases.ChessGame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String []files = {"AtyponTest.txt","test2.txt"};
        ChessGame game = new ChessGame();
        for(int i=0;i<2;i++) {
            File myFile = new File(files[i]);
            Scanner in = new Scanner(System.in);
            try {
                in = new Scanner(myFile);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println();
            game.startGame(in);
        }
    }
}