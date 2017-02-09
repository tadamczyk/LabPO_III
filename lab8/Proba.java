import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Okno extends JFrame implements ActionListener{
  JButton guzikOff, guzikData;
  JLabel data;
  JButton zrobGuzik(int x, int y, int w, int h, String t){
    JButton b = new JButton(t);
    b.setBounds(x, y, w, h);
    b.addActionListener(this);
    return b;
  }
  Okno(){
    super("Okno");
    setLocation(550, 275);
    setSize(500, 400);
    setLayout(null);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setDefaultLookAndFeelDecorated(true);
    setIconImage(new ImageIcon("bal.jpg").getImage());
    guzikOff = zrobGuzik(10, 50, 150, 30, "Zakończ");
    guzikData = zrobGuzik(10, 10, 150, 30, "Pokaż datę");
    add(guzikOff);
    add(guzikData);
    data = new JLabel("<--- Wciśnij");
    data.setBounds(170, 10, 200, 30);
    add(data);
  }
  public void actionPerformed(ActionEvent e){
    Object src = e.getSource();
    if (src == guzikOff){
      this.dispose();
    }
    else if (src == guzikData){
      data.setText(new Date().toString());
      data.setForeground(new Color(255, 40, 200));
      data.setFont(new Font("Arial", Font.BOLD, 12));
    }
  }
}

public class Proba{
  public static void main(String[] args){
    EventQueue.invokeLater(new Runnable(){
      public void run(){
        new Okno();
      }
    });
  }
}
