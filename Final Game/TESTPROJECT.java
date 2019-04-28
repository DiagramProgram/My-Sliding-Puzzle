import java.awt.*;
import java.awt.event.*; 
import java.applet.*;
import javax.swing.*;
import java.net.*;

public class TESTPROJECT extends Applet implements ActionListener {
  Panel p_card;
  Panel card1, card2, card3, card4, card5, card6;
  CardLayout cdLayout = new CardLayout();
  JButton [][] a = new JButton [3][3];
  char [][] pics = {{'z', 'c', 'f'}, {'b', 'e', 'h'}, {'a', 'd', 'g'}};
  int moves = 0;
  Panel m;
  int x1 = 0;
  int y1 = 0;
  int pos1 = -1;
  int pos2 = -1;
  /////////////////////////////////////////////////////////////
  JButton [][] a1 = new JButton [4][4];
  char [][] pics1 = {{'n', 'j', 'p', 'l'}, {'r', 'k', 't', 'm'}, {'v', 'o', 'x', 'q'}, {'0', 's', 'w', 'u'}};
  int moves2 = 0;
  Panel p;
  int x2 = 0;
  int y2 = 3;
  int pos3 = -1;
  int pos4 = -1;
  ////////////////////////////////////////////////////////////
  JButton [][] a2 = new JButton [5][5];
  char [][] pics2 = {{';', '2', '3', '4', '5'}, {'1', '6', '8', '9', '!'}, {'@', '7', '#', '%', '^'}, {'&', '(', '$', ')', '-'}, {'[', ']', '{', '_', '}'}};
  int moves3 = 0;
  Panel v;
  int x3 = 0;
  int y3 = 0;
  int pos5 = -1;
  int pos6 = -1;
  
  URL url = HeheFinalProject.class.getResource("GameMusic.wav");
  AudioClip clip = Applet.newAudioClip(url);
  
  public void init() {
    resize (800, 600);
    
    p_card = new Panel ();
    p_card.setLayout(cdLayout);
    screen1 ();
    screen2 ();
    screen3 ();
    screen4 ();
    screen5 ();
    screen6 ();
    setLayout(new BorderLayout ());
    add ("Center", p_card);
  }
  
  public void screen1 () {
    card1 = new Panel ();
    resize(600,800);
    card1.setBackground(Color.GRAY);
    card1.setLayout(null);
    JLabel title = new JLabel("Marvel Sliding Puzzle");
    title.setForeground(new Color(178,34,34));
    title.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 70));
    title.setBounds(90, 15, 634, 83);
    card1.add(title);
    
    JButton play = new JButton("Play Game");
    play.setBounds(175, 517, 180, 50);
    play.setFont(new Font("Arial", Font.PLAIN, 25));
    play.setBackground(Color.ORANGE);
    card1.add(play);
    play.addActionListener (this);
    play.setActionCommand ("3");
    
    JButton instructions = new JButton("Instructions");
    instructions.setBounds(440, 517, 180, 50);
    instructions.setFont(new Font("Arial", Font.PLAIN, 25));
    instructions.setBackground(Color.BLUE);
    instructions.setForeground(Color.WHITE);
    card1.add(instructions);
    instructions.addActionListener (this);
    instructions.setActionCommand ("2");
    
    JLabel imglabel = new JLabel("");
    Image img = new ImageIcon(this.getClass().getResource("/bg.jpg")).getImage();
    imglabel.setIcon(new ImageIcon(img));
    imglabel.setBounds(106, 105, 600, 400); //LR, UD, size:length, size:height
    card1.add(imglabel);
    
    JLabel soundopt = new JLabel("Music:");
    soundopt.setFont(new Font("Arial", Font.BOLD, 20));
    soundopt.setForeground(Color.WHITE);
    soundopt.setBounds(700, 500, 99, 33);
    card1.add(soundopt);
    
    JRadioButton rdbtn = new JRadioButton("On");
    rdbtn.setBounds(700, 530, 63, 23);
    rdbtn.setOpaque(false);
    rdbtn.setContentAreaFilled(false);
    rdbtn.setForeground(Color.WHITE);
    rdbtn.setBorderPainted(false);
    rdbtn.addActionListener (this);
    card1.add(rdbtn);
    
    JLabel b = new JLabel("");
    Image b1 = new ImageIcon(this.getClass().getResource("/b1.jpg")).getImage();
    b.setIcon(new ImageIcon(b1));
    b.setBounds(0, 0, 800, 600);
    card1.add(b);
    p_card.add ("1", card1);
  }
  
  public void screen2 () {
    card2 = new Panel ();
    card2.setLayout(null);
    card2.setBackground(Color.GRAY);
    
    JLabel title = new JLabel("Instructions");
    title.setForeground(new Color(178,34,34));
    title.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 70));
    title.setBounds(228, 10, 634, 83); //LR, UD, size:length, size:height
    card2.add(title);
    
    Panel box = new Panel();
    box.setBounds(197, 130, 425, 305);
    box.setBackground(Color.WHITE);
    card2.add(box);
    box.setLayout(null);
    
    JLabel subtitle = new JLabel("How To Play:");
    subtitle.setFont(new Font("Arial", Font.BOLD, 25));
    subtitle.setBounds(10, 0, 202, 52);
    box.add(subtitle);
    
    JLabel text = new JLabel(" - There will be a grid picturing a scrambled image and your");
    JLabel text2 = new JLabel(" job is to solve it.");
    JLabel text3 = new JLabel(" - To solve it, you will have to click around the image marked");
    JLabel text4 = new JLabel(" with an 'X' to move the other images into place.");
    JLabel text5 = new JLabel(" - Only the images either up/down or left/right from the marked");
    JLabel text6 = new JLabel(" - image can be moved");
    JLabel text7 = new JLabel(" - Try to complete the images in the least amount of moves");
    JLabel text8 = new JLabel(" - Level of difficulity selected will affect grid size");
    JLabel text9 = new JLabel(" - ENJOY! :)");
    text.setFont(new Font("Arial", Font.PLAIN, 15));
    text.setBounds(10, 45, 415, 35);
    text2.setFont(new Font("Arial", Font.PLAIN, 15));
    text2.setBounds(10, 65, 415, 35);
    text3.setFont(new Font("Arial", Font.PLAIN, 15));
    text3.setBounds(10, 95, 415, 35);
    text4.setFont(new Font("Arial", Font.PLAIN, 15));
    text4.setBounds(10, 115, 415, 35);
    text5.setFont(new Font("Arial", Font.PLAIN, 15));
    text5.setBounds(10, 145, 415, 35);
    text6.setFont(new Font("Arial", Font.PLAIN, 15));
    text6.setBounds(10, 175, 415, 35);
    text7.setFont(new Font("Arial", Font.PLAIN, 15));
    text7.setBounds(10, 205, 415, 35);
    text8.setFont(new Font("Arial", Font.PLAIN, 15));
    text8.setBounds(10, 235, 415, 35);
    text9.setFont(new Font("Arial", Font.PLAIN, 15));
    text9.setBounds(10, 265, 415, 35);
    box.add(text);
    box.add(text2);
    box.add(text3);
    box.add(text4);
    box.add(text5);
    box.add(text6);
    box.add(text7);
    box.add(text8);
    box.add(text9);
    
    JButton back = new JButton("Back");
    back.setBounds(175, 500, 180, 50);
    back.setFont(new Font("Arial", Font.PLAIN, 25));
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    card2.add(back);
    back.addActionListener (this);
    back.setActionCommand ("1");
    
    JButton play = new JButton("Play");
    play.setBounds(440, 500, 180, 50);
    play.setFont(new Font("Arial", Font.PLAIN, 25));
    play.setBackground(Color.ORANGE);
    card2.add(play);
    play.addActionListener (this);
    play.setActionCommand ("3");
    
    JLabel glove = new JLabel(createImageIcon ("glove1.png"));
    glove.setBounds(3, 90, 200, 370);
    card2.add(glove);
    
    JLabel mask = new JLabel(createImageIcon ("mask.png"));
    mask.setBounds(615, 90, 200, 370);
    card2.add(mask);
    
    JLabel b = new JLabel("");
    Image b1 = new ImageIcon(this.getClass().getResource("/b1.jpg")).getImage();
    b.setIcon(new ImageIcon(b1));
    b.setBounds(0, 0, 800, 600);
    card2.add(b);
    p_card.add ("2", card2);
  }
  
  public void screen3 () {
    card3 = new Panel ();
    card3.setLayout(null);
    card3.setBackground(Color.GRAY);
    
    JButton back = new JButton (createImageIcon ("back.png"));
    back.setBounds(10, 10, 180, 50);
    back.setOpaque(false);
    back.setContentAreaFilled(false);
    back.setBorderPainted(false);
    card3.add(back);
    back.addActionListener (this);
    back.setActionCommand ("1");
    
    JLabel title = new JLabel("Select a Level");
    title.setForeground(new Color(178,34,34)); //LR, UD, size:length, size:height
    title.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 70));
    title.setBounds(197, 22, 634, 83);
    card3.add(title);
    
    JButton easy = new JButton("Easy");
    easy.setBounds(285, 160, 219, 82);
    easy.setFont(new Font("Arial", Font.PLAIN, 39));
    easy.setBackground(Color.YELLOW);
    card3.add(easy);
    easy.addActionListener (this);
    easy.setActionCommand ("4");
    
    JButton medium = new JButton("Medium");
    medium.setBounds(285, 290, 219, 82);
    medium.setFont(new Font("Arial", Font.PLAIN, 39));
    medium.setBackground(Color.ORANGE);
    card3.add(medium);
    medium.addActionListener (this);
    medium.setActionCommand ("5");
    
    JButton hard = new JButton("Hard");
    hard.setBounds(285, 420, 219, 82);
    hard.setFont(new Font("Arial", Font.PLAIN, 39));
    hard.setBackground(Color.RED);
    card3.add(hard);
    hard.addActionListener (this);
    hard.setActionCommand ("6");
    
    JLabel imglabel = new JLabel("");
    Image img = new ImageIcon(this.getClass().getResource("/spidermask.png")).getImage();
    imglabel.setIcon(new ImageIcon(img));
    imglabel.setBounds(42, 180, 215, 300);
    card3.add(imglabel);
    
    JLabel imglabel1 = new JLabel("");
    Image img1 = new ImageIcon(this.getClass().getResource("/shield.png")).getImage();
    imglabel1.setIcon(new ImageIcon(img1));
    imglabel1.setBounds(552, 180, 215, 300);
    card3.add(imglabel1);
    
    JLabel b = new JLabel("");
    Image b1 = new ImageIcon(this.getClass().getResource("/b1.jpg")).getImage();
    b.setIcon(new ImageIcon(b1));
    b.setBounds(0, 0, 800, 600);
    card3.add(b);
    p_card.add ("3", card3);
  }
  
  public void screen4 () {
    card4 = new Panel ();
    // To solve, go backwards in a circle
    m = new Panel (new GridLayout (3, 3, 0, 0)); //3 rows x 3 columns
    for (int d = 0; d < 3; d++) {
      for (int e = 0 ; e < 3; e++) {
        a[e][d] = new JButton ("");
        a[e][d].addActionListener (this);
        a[e][d].setActionCommand (e + "" + d);
        a[e][d].setPreferredSize(new Dimension (197, 115));
        m.add (a [e][d]);
      }
    }
    enabledMethod();
    
    a[0][0].setIcon(createImageIcon("z.jpeg"));
    a[1][0].setIcon(createImageIcon("c.jpeg"));
    a[2][0].setIcon(createImageIcon("f.jpeg"));
    a[0][1].setIcon(createImageIcon("b.jpeg"));
    a[1][1].setIcon(createImageIcon("e.jpeg"));
    a[2][1].setIcon(createImageIcon("h.jpeg"));
    a[0][2].setIcon(createImageIcon("a.jpeg"));
    a[1][2].setIcon(createImageIcon("d.jpeg"));
    a[2][2].setIcon(createImageIcon("g.jpeg"));
    m.add (a [0][0]);
    m.add (a [1][0]);
    m.add (a [2][0]);
    m.add (a [0][1]);
    m.add (a [1][1]);
    m.add (a [2][1]);
    m.add (a [0][2]);
    m.add (a [1][2]);
    m.add (a [2][2]);
    card4.add (m);
    
    JLabel movnum1 = new JLabel("Moves: " + moves);
    movnum1.setForeground(new Color(178,34,34)); //LR, UD, size:length, size:height
    movnum1.setFont(new Font("Rockwell Condensed", Font.BOLD, 60));
    movnum1.setBounds(197, 22, 900, 83);
    card4.add(movnum1);
    
    p_card.add ("4", card4);
  }
  
  public void screen5 () {
    card5 = new Panel ();
    
    p = new Panel (new GridLayout (4, 4, 0, 0)); //4 rows x 4 columns
    
    for (int f = 0; f < 4; f++) {
      for (int g = 0 ; g < 4; g++) {
        a1[g][f] = new JButton ("");
        a1[g][f].addActionListener (this);
        a1[g][f].setActionCommand (g + "" + f);
        a1[g][f].setPreferredSize(new Dimension (147, 101));
        p.add (a1[g][f]);
      }
    }
    enabledMethod2();
    
    a1[0][0].setIcon(createImageIcon("n.jpeg"));
    a1[1][0].setIcon(createImageIcon("j.jpeg"));
    a1[2][0].setIcon(createImageIcon("p.jpeg"));
    a1[3][0].setIcon(createImageIcon("l.jpeg"));
    a1[0][1].setIcon(createImageIcon("r.jpeg"));
    a1[1][1].setIcon(createImageIcon("k.jpeg"));
    a1[2][1].setIcon(createImageIcon("t.jpeg"));
    a1[3][1].setIcon(createImageIcon("m.jpeg"));
    a1[0][2].setIcon(createImageIcon("v.jpeg"));
    a1[1][2].setIcon(createImageIcon("o.jpeg"));
    a1[2][2].setIcon(createImageIcon("x.jpeg"));
    a1[3][2].setIcon(createImageIcon("q.jpeg"));
    a1[0][3].setIcon(createImageIcon("0.jpeg"));
    a1[1][3].setIcon(createImageIcon("s.jpeg"));
    a1[2][3].setIcon(createImageIcon("w.jpeg"));
    a1[3][3].setIcon(createImageIcon("u.jpeg"));
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
    
    card5.add (p);
    p_card.add ("5", card5);
  }
  
  public void screen6 () {
    card6 = new Panel ();
    
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
    
    a2[0][0].setIcon(createImageIcon(";.jpeg"));
    a2[1][0].setIcon(createImageIcon("2.jpeg"));
    a2[2][0].setIcon(createImageIcon("3.jpeg"));
    a2[3][0].setIcon(createImageIcon("4.jpeg"));
    a2[4][0].setIcon(createImageIcon("5.jpeg"));
    a2[0][1].setIcon(createImageIcon("1.jpeg"));
    a2[1][1].setIcon(createImageIcon("6.jpeg"));
    a2[2][1].setIcon(createImageIcon("8.jpeg"));
    a2[3][1].setIcon(createImageIcon("9.jpeg"));
    a2[4][1].setIcon(createImageIcon("!.jpeg"));
    a2[0][2].setIcon(createImageIcon("@.jpeg"));
    a2[1][2].setIcon(createImageIcon("7.jpeg"));
    a2[2][2].setIcon(createImageIcon("#.jpeg"));
    a2[3][2].setIcon(createImageIcon("%.jpeg"));
    a2[4][2].setIcon(createImageIcon("^.jpeg"));
    a2[0][3].setIcon(createImageIcon("&.jpeg"));
    a2[1][3].setIcon(createImageIcon("(.jpeg"));
    a2[2][3].setIcon(createImageIcon("$.jpeg"));
    a2[3][3].setIcon(createImageIcon(").jpeg"));
    a2[4][3].setIcon(createImageIcon("-.jpeg"));
    a2[0][4].setIcon(createImageIcon("[.jpeg"));
    a2[1][4].setIcon(createImageIcon("].jpeg"));
    a2[2][4].setIcon(createImageIcon("{.jpeg"));
    a2[3][4].setIcon(createImageIcon("_.jpeg"));
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
    
    card6.add (v);
    p_card.add ("6", card6);
  }
  
  public boolean isSolved () {
    if (pics[0][0] == 'a' && pics[0][1] == 'b' && pics[0][2] == 'c' && pics[1][0] == 'd' && pics[1][1] == 'e' && pics[1][2] == 'f' && pics[2][0] == 'g' && pics[2][1] == 'h') {
      card4.setBackground(new Color(206, 255, 217));
      for (int y = 0; y < 3; y++) {
        for (int x = 0 ; x < 3; x++) {
          a[x][y].setActionCommand("nothing");
        }
      }
      pics[2][2] = 'i'; //Replaces x with correct image at end
      return true;
    } else {
      card4.setBackground(new Color(255, 206, 206));
      return false;
    }
  }
  
  public boolean isSolved2 () {
    if (pics1[0][0] == 'j' && pics1[0][1] == 'k' && pics1[0][2] == 'l' && pics1[0][3] == 'm' && pics1[1][0] == 'n' && pics1[1][1] == 'o' && pics1[1][2] == 'p' && pics1[1][3] == 'q' && pics1[2][0] == 'r' && pics1[2][1] == 's' && pics1[2][2] == 't' && pics1[2][3] == 'u' && pics1[3][0] == 'v' && pics1[3][1] == 'w' && pics1[3][2] == 'x') {
      card5.setBackground(new Color(206, 255, 217));
      for (int y = 0; y < 4; y++) {
        for (int x = 0 ; x < 4; x++) {
          a1[x][y].setActionCommand("nothing");
        }
      }
      pics1[3][3] = 'y'; //Fills x with proper image once image is complete
      return true;
    } else {
      card5.setBackground(new Color(255, 206, 206));
      return false;
    }
  }
  
  public boolean isSolved3 () {
    if (pics2[0][0] == '1' && pics2[0][1] == '2' && pics2[0][2] == '3' && pics2[0][3] == '4' && pics2[0][4] == '5' && pics2[1][0] == '6' && pics2[1][1] == '7' && pics2[1][2] == '8' && pics2[1][3] == '9' && pics2[1][4] == '!' && pics2[2][0] == '@' && pics2[2][1] == '#' && pics2[2][2] == '$' && pics2[2][3] == '%' && pics2[2][4] == '^' && pics2[3][0] == '&' && pics2[3][1] == '(' && pics2[3][2] == ')' && pics2[3][3] == '_' && pics2[3][4] == '-' && pics2[4][0] == '[' && pics2[4][1] == ']' && pics2[4][2] == '{' && pics2[4][3] == '}') {
      card6.setBackground(new Color(206, 255, 217));
      for (int y = 0; y < 5; y++) {
        for (int x = 0 ; x < 5; x++) {
          a2[x][y].setActionCommand("nothing");
        }
      }
      pics2[4][4] = ','; //Fills x with proper image once image is complete
      return true;
    } else {
      card6.setBackground(new Color(255, 206, 206));
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
        moves++;
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
  
  public void enabledMethod2() {
    for (int a = 0; a < 4; a++) {
      for (int b = 0 ; b < 4; b++) {
        a1[b][a].setActionCommand("nothing");
      }
    }
    //linear search for z
    for (int a = 0; a < 4; a++) {
      for (int b = 0 ; b < 4; b++) {
        if (pics1 [a][b] == '0') {
          pos3 = b;
          pos4 = a;
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
  
  public void enabledMethod3() {
    for (int c = 0; c < 5; c++) {
      for (int d = 0 ; d < 5; d++) {
        a2[d][c].setActionCommand("nothing");
      }
    }
    //linear search for z
    for (int c = 0; c < 5; c++) {
      for (int d = 0 ; d < 5; d++) {
        if (pics2 [c][d] == ';') {
          pos5 = d;
          pos6 = c;
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
    String var = e.getActionCommand ();
    cdLayout.show (p_card, var);
    
    if (e.getActionCommand().equals("nothing")) {
    }
    else if (e.getActionCommand().equals((pos5-1) + "" + pos6) || e.getActionCommand().equals(pos5 + "" + (pos6-1)) || e.getActionCommand().equals((pos5+1) + "" + pos6) || e.getActionCommand().equals(pos5 + "" + (pos6+1)) ) {
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
      
      else if (e.getActionCommand().equals((pos3-1) + "" + pos4) || e.getActionCommand().equals(pos3 + "" + (pos4-1)) || e.getActionCommand().equals((pos3+1) + "" + pos4) || e.getActionCommand().equals(pos3 + "" + (pos4+1))) {
        String poss = (e.getActionCommand());
        int k = (int) (poss.charAt(0)-48);
        int l = (int) (poss.charAt(1)-48);
        pics1[y2][x2] = pics1[l][k];
        pics1[l][k] = '0';
        enabledMethod2();
        a1[x2][y2].setIcon(createImageIcon(pics1[y2][x2] + ".jpeg"));
        a1[k][l].setIcon(createImageIcon(pics1[l][k] + ".jpeg"));
        
        x2 = k;
        y2 = l;
      }
    
      else if (e.getActionCommand().equals((pos1-1) + "" + pos2) || e.getActionCommand().equals(pos1 + "" + (pos2-1)) || e.getActionCommand().equals((pos1+1) + "" + pos2) || e.getActionCommand().equals(pos1 + "" + (pos2+1))) {
        String pose = (e.getActionCommand());
        int m = (int) (pose.charAt(0)-48);
        int n = (int) (pose.charAt(1)-48);
        pics[y1][x1] = pics[n][m];
        pics[n][m] = 'z';
        enabledMethod();
        a[x1][y1].setIcon(createImageIcon(pics[y1][x1] + ".jpeg"));
        a[m][n].setIcon(createImageIcon(pics[n][m] + ".jpeg"));
        
        x1 = m;
        y1 = n;
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