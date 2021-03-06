import java.awt.*;
import java.awt.event.*; 
import java.applet.*;
import javax.swing.*;
import java.net.*;

public class TestFinalProject extends Applet implements ActionListener {
  JButton [][] a = new JButton [3][3];
  char [][] pics = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'z'}};
  int moves = 0;
  Panel m;
  int x1 = 2;
  int y1 = 2;
  Panel p_card;
  Panel card1, card2, card3, card4, card5, card6;
  CardLayout cdLayout = new CardLayout();
  int pos1 = -1;
  int pos2 = -1;
  /////////////////////////////////////////////////////////////
  JButton [][] a1 = new JButton [4][4];
  char [][] pics1 = {{'j', 'k', 'l', 'm'}, {'n', 'o', 'p', 'q'}, {'r', 's', 't', 'u'}, {'v', 'w', '0', 'x'}};
  Panel p;
  int x2 = 2;
  int y2 = 3;
  int pos3 = -1;
  int pos4 = -1;
  ////////////////////////////////////////////////////////////
  JButton [][] a2 = new JButton [5][5];
  char [][] pics2 = {{'1', '2', '3', '4', '5'}, {'6', '7', '8', '9', '!'}, {'@', '#', '$', '%', '^'}, {'&', '(', ')', '_', '-'}, {'[', ']', '{', ';', '}'}};
  Panel v;
  int x3 = 3;
  int y3 = 4;
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
    card4.setBackground(new Color(0,0,128));
    
    m = new Panel (new GridLayout (3, 3, 0, 0)); //3 rows x 3 columns
    for (int y = 0; y < 3; y++) {
      for (int x = 0 ; x < 3; x++) {
        a[x][y] = new JButton ("");
        a[x][y].addActionListener (this);
        a[x][y].setActionCommand (x + "" + y);
        a[x][y].setPreferredSize(new Dimension (197, 115));
        a[x][y].setIcon(createImageIcon(pics[y][x] + ".jpeg")); //replace with scramble it method
        m.add (a [x][y]);
      }
    }
    enabledMethod();
    
    card4.add (m);
    p_card.add ("4", card4);
  }
  
  public void screen5 () {
    card5 = new Panel ();
    p_card.add ("5", card5);
  }
  
  public void screen6 () {
    card6 = new Panel ();
    p_card.add ("6", card6);
  }
  
  public void actionPerformed (ActionEvent e) {
    String var = e.getActionCommand ();
    cdLayout.show (p_card, var);
    
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
  
  public boolean isSolved () {
    if (pics[0][0] == 'a' && pics[0][1] == 'b' && pics[0][2] == 'c' && pics[1][0] == 'd' && pics[1][1] == 'e' && pics[1][2] == 'f' && pics[2][0] == 'g' && pics[2][1] == 'h') {
      return true;
    } else {
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