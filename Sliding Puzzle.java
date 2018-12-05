//3x3 sliding puzzle of Iron Man
//Background starts off as red but turns green when puzzle is solved
//All pieces also become disabled when the puzzle is solved
//X-marker piece gets replaced by real picture when puzzle is solved
//(Only one move is required to be made to solve the puzzle for simplicity purposes - could be changed to varying levels of complexity)
//Coded by: Yuktesh
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class FinalProject extends Applet implements ActionListener {
  JButton [][] a = new JButton [3][3];
  char [][] pics = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'z', 'h'}};
  int moves = 0;
  Panel p;
  int x1 = 1;
  int y1 = 2;
  int pos1 = -1;
  int pos2 = -1;
  
  public void init() {
    resize (600, 800);
    p = new Panel (new GridLayout (3, 3, 0, 0)); //3 rows x 3 columns
    
    for (int y = 0; y < 3; y++) {
      for (int x = 0 ; x < 3; x++) {
        a[x][y] = new JButton ("");
        a[x][y].addActionListener (this);
        a[x][y].setActionCommand (x + "" + y);
        a[x][y].setPreferredSize(new Dimension (197, 115));
        p.add (a [x][y]);
      }
    }
    enabledMethod();
    
    a[0][0].setIcon(createImageIcon("a.jpeg"));
    a[1][0].setIcon(createImageIcon("b.jpeg"));
    a[2][0].setIcon(createImageIcon("c.jpeg"));
    a[0][1].setIcon(createImageIcon("d.jpeg"));
    a[1][1].setIcon(createImageIcon("e.jpeg"));
    a[2][1].setIcon(createImageIcon("f.jpeg"));
    a[0][2].setIcon(createImageIcon("g.jpeg"));
    a[1][2].setIcon(createImageIcon("z.jpeg"));
    a[2][2].setIcon(createImageIcon("h.jpeg"));
    p.add (a [0][0]);
    p.add (a [1][0]);
    p.add (a [2][0]);
    p.add (a [0][1]);
    p.add (a [1][1]);
    p.add (a [2][1]);
    p.add (a [0][2]);
    p.add (a [1][2]);
    p.add (a [2][2]);
    
    add (p);
  }
  
  public boolean isSolved () {
    if (pics[0][0] == 'a' && pics[0][1] == 'b' && pics[0][2] == 'c' && pics[1][0] == 'd' && pics[1][1] == 'e' && pics[1][2] == 'f' && pics[2][0] == 'g' && pics[2][1] == 'h') {
      setBackground(Color.GREEN);
      for (int y = 0; y < 3; y++) {
        for (int x = 0 ; x < 3; x++) {
          a[x][y].setActionCommand("nothing");
        }
      }
      
      pics[2][2] = 'i'; //Replaces x with correct image at end
      return true;
    } else {
      setBackground(Color.RED);
      return false;
    }
  }
  
  public void enabledMethod() {
    for (int y = 0; y < 3; y++) {
      for (int x = 0 ; x < 3; x++) {
        a[x][y].setActionCommand("nothing");
      }
    }
    //linear search for z
    for (int y = 0; y < 3; y++) {
      for (int x = 0 ; x < 3; x++) {
        if (pics [y][x] == 'z') {
          pos1 = x;
          pos2 = y;
        }
      }
    }
    a[pos1][pos2].setActionCommand(pos1 + "" + pos2);
    if (pos1+1 < 3)
      a[pos1+1][pos2].setActionCommand((pos1+1) + "" + pos2);
    if (pos2+1 < 3)
      a[pos1][pos2+1].setActionCommand(pos1 + "" + (pos2+1));
    if (pos1-1 > -1)
      a[pos1-1][pos2].setActionCommand((pos1-1) + "" + pos2);
    if (pos2-1 > -1)
      a[pos1][pos2-1].setActionCommand(pos1 + "" + (pos2-1));
    
    isSolved();
  }
  
  public void actionPerformed (ActionEvent e) {
    if (e.getActionCommand().equals("nothing")) {
      
    } else if (e.getActionCommand().equals((pos1-1) + "" + pos2) || e.getActionCommand().equals(pos1 + "" + (pos2-1)) || e.getActionCommand().equals((pos1+1) + "" + pos2) || e.getActionCommand().equals(pos1 + "" + (pos2+1))) {
      moves++;
      String pos = (e.getActionCommand());
      int i = (int) (pos.charAt(0)-48);
      int j = (int) (pos.charAt(1)-48);
      pics[y1][x1] = pics[j][i];
      pics[j][i] = 'z';
      enabledMethod();
      a[x1][y1].setIcon(createImageIcon(pics[y1][x1] + ".jpeg"));
      a[i][j].setIcon(createImageIcon(pics[j][i] + ".jpeg"));
      
      x1 = i;
      y1 = j;
    }
  }
  
  public static ImageIcon createImageIcon (String path) {
    java.net.URL imgURL = FinalProject.class.getResource (path);
    if (imgURL != null)
      return new ImageIcon (imgURL);
    else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
}