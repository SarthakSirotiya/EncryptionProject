//@author Sarthak Sirotiya

import javax.swing.*; //importing swing for all nifty GUI needs

public class EncryptionProject {
    public static void main(String[] args)
    {
        boolean quit = false; //keeps track of when to quit the program
        while(!quit) //while quit is false; while the program should not quit
        {
            JFrame basicGUI = new JFrame("BasicEncryptionGUI"); //creates a new GUI from the BasicEncryptionGUI class
            basicGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the JFrame on exiting the basicGUI
            basicGUI.setVisible(true); //makes the basicGUI frame visible
        }

    }
}
