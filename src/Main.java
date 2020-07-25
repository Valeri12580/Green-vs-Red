import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)  {
        Game game=new Game(new BufferedReader(new InputStreamReader(System.in)));
        try {
            game.run();
        } catch (IOException e) {
            System.out.println("Some error occurred!");
        }
    }
}
