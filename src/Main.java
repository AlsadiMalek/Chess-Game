import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessGame game = new ChessGame();


        String []filename = new String[2];
        filename[0] = "AtyponTest.txt";
        filename[1] = "test2.txt";
        Scanner in = new Scanner(System.in);
        for(int i=0;i<2;i++) {
            File file = new File(filename[i]);
            Scanner sc = null;
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            System.out.println();
            System.out.println("Game " +  (i+1));
            System.out.println();
            game.startGame(file, in);

        }

    }
}