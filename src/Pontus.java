import javax.swing.*;
import java.util.Random;

public class Pontus {

    public static void  main (String [] args) {
        Random randGenerator = new Random();

        int randInt = randGenerator.nextInt(15);

        JOptionPane.showMessageDialog(null, randInt);
    }

}
