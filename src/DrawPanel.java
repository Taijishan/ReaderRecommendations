import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DrawPanel extends JPanel implements MouseListener {

    private ArrayList<Novel> novels;
    private ArrayList<Background> backgrounds;
    private Rectangle button;
    private Rectangle button2;
    private String genre;
    private boolean button2Shown = false;
    private ReadingList userList = new ReadingList();

    public DrawPanel(String genre) {
        this.genre = genre;
        button = new Rectangle(666, 413, 350, 40);
        this.addMouseListener(this);
        novels = Novel.buildRecommendation(genre);
        backgrounds = Background.buildBackground(genre);
    }

    public DrawPanel() {
        this.genre = "random";
        button = new Rectangle(666, 413, 350, 40);
        this.addMouseListener(this);
        novels = Novel.buildRandomRecommendation();
        backgrounds = Background.buildRandomBackground();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(readImage("backgrounds/" + genre + ".png"), 0, 0, null);
        int x = 50;
        int y = 10;
        for (int i = 0; i < novels.size(); i++) {
            if (i == 8){
                x-=2700;
                y+=600;
            }
            Novel n = novels.get(i);
            n.setRectangleLocation(x, y);
            g.drawImage(n.getImage(), x, y, null);
            x = x + n.getImage().getWidth()+100;
            if (!n.isShown()) {
                button2 = new Rectangle(888, 555, 400, 80);
                button2Shown = true;
                g.drawRect((int)button2.getX(), (int)button2.getY(), (int)button2.getWidth(), (int)button2.getHeight());
                g.setColor(Color.WHITE);
                g.setFont(new Font("Times New Roman",Font.BOLD,20));
                g.drawString("Are you interested?", 890, 570);
                g.drawString("If yes, click on this box.", 890, 600);
                g.drawString("If no, click the synopsis to go back.", 890, 630);

            }
            if (n.isShown()){
                button2Shown = false;
                g.setColor(Color.WHITE);
                g.setFont(new Font("Courier New", Font.BOLD, 20));
                g.drawString("REFRESH PAGE", 670, 433);
                g.drawRect((int)button.getX(), (int)button.getY(), (int)button.getWidth(), (int)button.getHeight());
            }
        }
    }



    public void mousePressed(MouseEvent e) {
        Scanner s = new Scanner(System.in);
        Point pressed = e.getPoint();

        if (e.getButton() == 1) {
            if (button.contains(pressed) && genre.equals("random")) {
                novels = Novel.getRandomRecommendation();
                backgrounds = Background.getRandomBackground();
            } else if (button.contains(pressed)) {
                novels = Novel.getRecommendation(genre);
                backgrounds = Background.getBackground(genre);
            }
            for (int i = 0; i < novels.size(); i++) {
                Rectangle box = novels.get(i).getCardBox();
                if (box.contains(pressed)) {
                    novels.get(i).flipImage();
                }
            }
            if (button2Shown) {
                if (button2.contains(pressed)) {
                    System.out.println("You have selected the novel(s) for your reading list.");
                    userList.addToList("placeholder");
                    System.out.println("As of now, your current reading list consists of these novels : " + userList.showReadingList()); //doesnt work
                    System.out.println("Would you like to start another browsing session? Your reading list will be saved. \ny/n?"); //save+load file implementation after fixing above^
                    String reply = s.nextLine();
                    if (reply.equals("n")){
                        System.exit(0);
                    } else if (reply.equals("y")) {
                        System.out.println("placeholder"); //meant to be a recursive method that returns back to the beginning of program(after saving the reading list)
                    }
                    else {
                        System.out.println("invalid response, operation terminated");
                        System.exit(0);
                    }


                }
            }

            if (e.getButton() == 3) {
                for (int i = 0; i < novels.size(); i++) {
                    Rectangle box = novels.get(i).getCardBox();
                    if (box.contains(pressed)) {
                        System.out.println("You can't do that");
                    }
                }
            }


        }
    }

    public BufferedImage readImage(String backgroundFileName) {
        try {
            BufferedImage image;
            image = ImageIO.read(new File(backgroundFileName));
            return image;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }

    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}

