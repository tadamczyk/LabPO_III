import javax.swing.*;

public class HelloWorld {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Hello World!");
        frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        frame.add(new JLabel("Hello World!"));
        frame.pack();
        frame.setVisible(true);
      }
    });
  }
}
