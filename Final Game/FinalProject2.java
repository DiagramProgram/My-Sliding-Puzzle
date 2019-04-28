import java.awt.*;
import java.awt.event.*; 
import java.applet.*;
import javax.swing.*;

public class FinalProject2 extends Applet implements ActionListener {
  JButton [][] a1 = new JButton [4][4];
  char [][] pics1 = {{'j', 'k', 'l', 'm'}, {'n', 'o', 'p', 'q'}, {'r', 's', 't', 'u'}, {'v', 'w', '0', 'x'}};
  Panel p;
  int x2 = 2;
  int y2 = 3;
  int pos3 = -1;
  int pos4 = -1;
  
  public void init() {
    resize (600, 800);
    p = new Panel (new GridLayout (4, 4, 0, 0)); //4 rows x 4 columns
    
    for (int y = 0; y < 4; y++) {
      for (int x = 0 ; x < 4; x++) {
        a1[x][y] = new JButton ("");
        a1[x][y].addActionListener (this);
        a1[x][y].setActionCommand (x + "" + y);
        a1[x][y].setPreferredSize(new Dimension (147, 101));
        p.add (a1[x][y]);
      }
    }
    enabledMethod2();
    
    a1[0][0].setIcon(createImageIcon("j.jpeg"));
    a1[1][0].setIcon(createImageIcon("k.jpeg"));
    a1[2][0].setIcon(createImageIcon("l.jpeg"));
    a1[3][0].setIcon(createImageIcon("m.jpeg"));
    
    a1[0][1].setIcon(createImageIcon("n.jpeg"));
    a1[1][1].setIcon(createImageIcon("o.jpeg"));
    a1[2][1].setIcon(createImageIcon("p.jpeg"));
    a1[3][1].setIcon(createImageIcon("q.jpeg"));
    
    a1[0][2].setIcon(createImageIcon("r.jpeg"));
    a1[1][2].setIcon(createImageIcon("s.jpeg"));
    a1[2][2].setIcon(createImageIcon("t.jpeg"));
    a1[3][2].setIcon(createImageIcon("u.jpeg"));
    
    a1[0][3].setIcon(createImageIcon("v.jpeg"));
    a1[1][3].setIcon(createImageIcon("w.jpeg"));
    a1[2][3].setIcon(createImageIcon("0.jpeg"));
    a1[3][3].setIcon(createImageIcon("x.jpeg"));
    p.add (a1[0][0]);
    p.add (a1[1][0]);
    p.add (a1[2][0]);
    p.add (a1[3][0]);
    p.add (a1[0][1]);
    p.add (a1[1][1]);
    p.add (a1[2][1]);
    p.add (a1[3][1]);
    p.add (a1[0][2]);
    p.add (a1[1][2]);
    p.add (a1[2][2]);
    p.add (a1[3][2]);
    p.add (a1[0][3]);
    p.add (a1[1][3]);
    p.add (a1[2][3]);
    p.add (a1[3][3]);
    
    add (p);
  }
  
  public boolean isSolved2 () {
    if (pics1[0][0] == 'j' && pics1[0][1] == 'k' && pics1[0][2] == 'l' && pics1[0][3] == 'm' && pics1[1][0] == 'n' && pics1[1][1] == 'o' && pics1[1][2] == 'p' && pics1[1][3] == 'q' && pics1[2][0] == 'r' && pics1[2][1] == 's' && pics1[2][2] == 't' && pics1[2][3] == 'u' && pics1[3][0] == 'v' && pics1[3][1] == 'w' && pics1[3][2] == 'x') {
      setBackground(Color.GREEN);
      for (int y = 0; y < 4; y++) {
        for (int x = 0 ; x < 4; x++) {
          a1[x][y].setActionCommand("nothing");
        }
      }
      
      pics1[3][3] = 'y'; //Fills x with proper image once image is complete
      return true;
    } else {
      setBackground(Color.RED);
      return false;
    }
  }
  
  public void enabledMethod2() {
    for (int y = 0; y < 4; y++) {
      for (int x = 0 ; x < 4; x++) {
        a1[x][y].setActionCommand("nothing");
      }
    }
    //linear search for z
    for (int y = 0; y < 4; y++) {
      for (int x = 0 ; x < 4; x++) {
        if (pics1 [y][x] == '0') {
          pos3 = x;
          pos4 = y;
        }
      }
    }
    a1[pos3][pos4].setActionCommand(pos3 + "" + pos4);
    if (pos3+1 < 4)
      a1[pos3+1][pos4].setActionCommand((pos3+1) + "" + pos4);
    if (pos4+1 < 4)
      a1[pos3][pos4+1].setActionCommand(pos3 + "" + (pos4+1));
    if (pos3-1 > -1)
      a1[pos3-1][pos4].setActionCommand((pos3-1) + "" + pos4);
    if (pos4-1 > -1)
      a1[pos3][pos4-1].setActionCommand(pos3 + "" + (pos4-1));
    
    isSolved2();
  }
  
  public void actionPerformed (ActionEvent e) {
    if (e.getActionCommand().equals("nothing")) {
      
    } else if (e.getActionCommand().equals((pos3-1) + "" + pos4) || e.getActionCommand().equals(pos3 + "" + (pos4-1)) || e.getActionCommand().equals((pos3+1) + "" + pos4) || e.getActionCommand().equals(pos3 + "" + (pos4+1))) {
      String pos = (e.getActionCommand());
      int k = (int) (pos.charAt(0)-48);
      int l = (int) (pos.charAt(1)-48);
      pics1[y2][x2] = pics1[l][k];
      pics1[l][k] = '0';
      enabledMethod2();
      a1[x2][y2].setIcon(createImageIcon(pics1[y2][x2] + ".jpeg"));
      a1[k][l].setIcon(createImageIcon(pics1[l][k] + ".jpeg"));
      
      x2 = k;
      y2 = l;
    }
  }
  
  public static ImageIcon createImageIcon (String path) {
    java.net.URL imgURL = FinalProject2.class.getResource (path);
    if (imgURL != null)
      return new ImageIcon (imgURL);
    else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
}