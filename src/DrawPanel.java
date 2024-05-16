import org.w3c.dom.css.Rect;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Font;

class DrawPanel extends JPanel implements MouseListener {

    private ArrayList<Novel> novels;
    private Rectangle button;
    private Rectangle button2;
    private String genre;
    private boolean button2Shown = false;
    public DrawPanel(String genre) {
        this.genre = genre;
        button = new Rectangle(666, 413, 350, 40);
        this.addMouseListener(this);
        novels = Novel.buildRecommendation(genre);
    }

    public DrawPanel() {
        this.genre = "random";
        button = new Rectangle(666, 413, 350, 40);
        this.addMouseListener(this);
        novels = Novel.buildRandomRecommendation();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int y = 10;
        for (int i = 0; i < novels.size(); i++) {
            if (i == 9){
                x-=1900;
                y+=600;
            }
            Novel n = novels.get(i);
            n.setRectangleLocation(x, y);
            g.drawImage(n.getImage(), x, y, null);
            x = x + n.getImage().getWidth()+10;
            if (!n.isShown()) {
                button2 = new Rectangle(888, 555, 400, 80);
                button2Shown = true;
                g.setFont(new Font("Times New Roman",Font.BOLD,20));
                g.drawString("Are you interested?", 890, 570);
                g.drawString("If yes, click on this box.", 890, 600);
                g.drawString("If no, click the synopsis to go back.", 890, 630);
                g.drawRect((int)button2.getX(), (int)button2.getY(), (int)button2.getWidth(), (int)button2.getHeight());
                break;
            }
            if (n.isShown()){
                button2Shown = false;
                g.setFont(new Font("Courier New", Font.BOLD, 20));
                g.drawString("REFRESH PAGE", 670, 433);
                g.drawRect((int)button.getX(), (int)button.getY(), (int)button.getWidth(), (int)button.getHeight());
            }
        }
    }



    public void mousePressed(MouseEvent e) {

        Point pressed = e.getPoint();

        if (e.getButton() == 1) {
            if (button.contains(pressed) && genre.equals("random")) {
                novels = Novel.getRandomRecommendation();
            } else if (button.contains(pressed)) {
                novels = Novel.getRecommendation(genre);
            }
            for (int i = 0; i < novels.size(); i++) {
                Rectangle box = novels.get(i).getCardBox();
                if (box.contains(pressed)) {
                    novels.get(i).flipImage();
                }

            }
            if (button2Shown) {
                if (button2.contains(pressed)) {
                    System.out.println("You have selected this novel.");
                    ReadingList userList = new ReadingList();
                    userList.addToList("null");

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

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}

