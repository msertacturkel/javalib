import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridBagWithContainers {

  @SuppressWarnings("deprecation")
public static void main(String[] args) {
    JFrame f = new JFrame(
        "Demonstrates the use of gridx, gridy,ipadx, ipady and insets constraints");
    JPanel p = new JPanel();

    p.setLayout(new GridBagLayout());
    // creates a constraints object
    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(2, 2, 2, 2); // insets for all components
    c.gridx = 0; // column 0
    c.gridy = 0; // row 0
    c.ipadx = 5; // increases components width by 10 pixels
    c.ipady = 5; // increases components height by 10 pixels
    p.add(new JButton("Java"), c); // constraints passed in
    c.gridx = 1; // column 1
    // c.gridy = 0; // comment out this for reusing the obj
    c.ipadx = 0; // resets the pad to 0
    c.ipady = 0;
    p.add(new JButton("Source"), c);
    c.gridx = 0; // column 0
    c.gridy = 1; // row 1
    p.add(new JButton("and"), c);
    c.gridx = 1; // column 1
    p.add(new JButton("Support."), c);

    WindowListener wndCloser = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    f.addWindowListener(wndCloser);

    f.getContentPane().add(p);
    f.setSize(600, 200);
    f.show();
  }
}
           