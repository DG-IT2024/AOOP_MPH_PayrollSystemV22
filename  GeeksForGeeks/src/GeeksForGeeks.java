import geeksforgeeks.NewJPanel;
import javax.swing.JFrame;
import java.awt.Dimension;

public class GeeksForGeeks {
    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(800, 600);

        // Create an instance of NewJPanel
        NewJPanel panel = new NewJPanel();

        // Add the panel to the frame
        frame.add(panel);

        // Set the frame visible
        frame.setVisible(true);
    }
}
