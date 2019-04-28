import java.awt.*;
import java.awt.event.*; 
import java.applet.*;
import javax.swing.*;

public class FinalProject3 extends Applet implements ActionListener {
  JButton [][] a2 = new JButton [5][5];
  char [][] pics2 = {{'1', '2', '3', '4', '5'}, {'6', '7', '8', '9', '!'}, {'@', '#', '$', '%', '^'}, {'&', '(', ')', '_', '-'}, {'[', ']', '{', ';', '}'}};
  Panel v;
  int x3 = 3;
  int y3 = 4;
  int pos5 = -1;
  int pos6 = -1;
  
  public void init() {
    resize (600, 800);
    v = new Panel (new GridLayout (5, 5, 0, 0)); //5 rows x 5 columns
    
    for (int y = 0; y < 5; y++) {
      for (int x = 0 ; x < 5; x++) {
        a2[x][y] = new JButton ("");
        a2[x][y].addActionListener (this);
        a2[x][y].setActionCommand (x + "" + y);
        a2[x][y].setPreferredSize(new Dimension (117, 66));
        v.add (a2 [x][y]);
      }
    }
    enabledMethod3();
    
    a2[0][0].setIcon(createImageIcon("1.jpeg"));
    a2[1][0].setIcon(createImageIcon("2.jpeg"));
    a2[2][0].setIcon(createImageIcon("3.jpeg"));
    a2[3][0].setIcon(createImageIcon("4.jpeg"));
    a2[4][0].setIcon(createImageIcon("5.jpeg"));
    
    a2[0][1].setIcon(createImageIcon("6.jpeg"));
    a2[1][1].setIcon(createImageIcon("7.jpeg"));
    a2[2][1].setIcon(createImageIcon("8.jpeg"));
    a2[3][1].setIcon(createImageIcon("9.jpeg"));
    a2[4][1].setIcon(createImageIcon("!.jpeg"));
    
    a2[0][2].setIcon(createImageIcon("@.jpeg"));
    a2[1][2].setIcon(createImageIcon("#.jpeg"));
    a2[2][2].setIcon(createImageIcon("$.jpeg"));
    a2[3][2].setIcon(createImageIcon("%.jpeg"));
    a2[4][2].setIcon(createImageIcon("^.jpeg"));
    
    a2[0][3].setIcon(createImageIcon("&.jpeg"));
    a2[1][3].setIcon(createImageIcon("(.jpeg"));
    a2[2][3].setIcon(createImageIcon(").jpeg"));
    a2[3][3].setIcon(createImageIcon("_.jpeg"));
    a2[4][3].setIcon(createImageIcon("-.jpeg"));
    
    a2[0][4].setIcon(createImageIcon("[.jpeg"));
    a2[1][4].setIcon(createImageIcon("].jpeg"));
    a2[2][4].setIcon(createImageIcon("{.jpeg"));
    a2[3][4].setIcon(createImageIcon(";.jpeg"));
    a2[4][4].setIcon(createImageIcon("}.jpeg"));
    v.add (a2 [0][0]);
    v.add (a2 [1][0]);
    v.add (a2 [2][0]);
    v.add (a2 [3][0]);
    v.add (a2 [4][0]);//
    v.add (a2 [0][1]);
    v.add (a2 [1][1]);
    v.add (a2 [2][1]);
    v.add (a2 [3][1]);
    v.add (a2 [4][1]);//
    v.add (a2 [0][2]);
    v.add (a2 [1][2]);
    v.add (a2 [2][2]);
    v.add (a2 [3][2]);
    v.add (a2 [4][2]);//
    v.add (a2 [0][3]);
    v.add (a2 [1][3]);
    v.add (a2 [2][3]);
    v.add (a2 [3][3]);
    v.add (a2 [4][3]);//
    v.add (a2 [0][4]);
    v.add (a2 [1][4]);
    v.add (a2 [2][4]);
    v.add (a2 [3][4]);
    v.add (a2 [4][4]);//
    
    add (v);
  }
  
  public boolean isSolved3 () {
    if (pics2[0][0] == '1' && pics2[0][1] == '2' && pics2[0][2] == '3' && pics2[0][3] == '4' && pics2[0][4] == '5' && pics2[1][0] == '6' && pics2[1][1] == '7' && pics2[1][2] == '8' && pics2[1][3] == '9' && pics2[1][4] == '!' && pics2[2][0] == '@' && pics2[2][1] == '#' && pics2[2][2] == '$' && pics2[2][3] == '%' && pics2[2][4] == '^' && pics2[3][0] == '&' && pics2[3][1] == '(' && pics2[3][2] == ')' && pics2[3][3] == '_' && pics2[3][4] == '-' && pics2[4][0] == '[' && pics2[4][1] == ']' && pics2[4][2] == '{' && pics2[4][3] == '}') {
      setBackground(Color.GREEN);
      for (int y = 0; y < 5; y++) {
        for (int x = 0 ; x < 5; x++) {
          a2[x][y].setActionCommand("nothing");
        }
      }
      pics2[4][4] = ','; //Fills x with proper image once image is complete
      return true;
    } else {
      setBackground(Color.RED);
      return false;
    }
  }
  
  public void enabledMethod3() {
    for (int y = 0; y < 5; y++) {
      for (int x = 0 ; x < 5; x++) {
        a2[x][y].setActionCommand("nothing");
      }
    }
    //linear search for z
    for (int y = 0; y < 5; y++) {
      for (int x = 0 ; x < 5; x++) {
        if (pics2 [y][x] == ';') {
          pos5 = x;
          pos6 = y;
        }
      }
    }
    a2[pos5][pos6].setActionCommand(pos5 + "" + pos6);
    if (pos5+1 < 5)
      a2[pos5+1][pos6].setActionCommand((pos5+1) + "" + pos6);
    if (pos6+1 < 5)
      a2[pos5][pos6+1].setActionCommand(pos5 + "" + (pos6+1));
    if (pos5-1 > -1)
      a2[pos5-1][pos6].setActionCommand((pos5-1) + "" + pos6);
    if (pos6-1 > -1)
      a2[pos5][pos6-1].setActionCommand(pos5 + "" + (pos6-1));
    
    isSolved3();
  }
  
  public void actionPerformed (ActionEvent e) {
    if (e.getActionCommand().equals("nothing")) {
      
    } else if (e.getActionCommand().equals((pos5-1) + "" + pos6) || e.getActionCommand().equals(pos5 + "" + (pos6-1)) || e.getActionCommand().equals((pos5+1) + "" + pos6) || e.getActionCommand().equals(pos5 + "" + (pos6+1))) {
      String pos = (e.getActionCommand());
      int i = (int) (pos.charAt(0)-48);
      int j = (int) (pos.charAt(1)-48);
      pics2[y3][x3] = pics2[j][i];
      pics2[j][i] = ';';
      enabledMethod3();
      a2[x3][y3].setIcon(createImageIcon(pics2[y3][x3] + ".jpeg"));
      a2[i][j].setIcon(createImageIcon(pics2[j][i] + ".jpeg"));
      
      x3 = i;
      y3 = j;
    }
  }
  
  public static ImageIcon createImageIcon (String path) {
    java.net.URL imgURL = FinalProject3.class.getResource (path);
    if (imgURL != null)
      return new ImageIcon (imgURL);
    else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
}