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

    public DrawPanel() {
        button = new Rectangle(666, 333, 300, 40);
        this.addMouseListener(this);
        novels = Novel.buildRecommendation();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int y = 10;
        for (int i = 0; i < novels.size(); i++) {
            if (i == 3){
                x-=500;
                y+=600;
            }
            Novel n = novels.get(i);
            n.setRectangleLocation(x, y);
            g.drawImage(n.getImage(), x, y, null);
            x = x + n.getImage().getWidth()+10;
        }
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("GET NEW RECOMMENDATIONS", 670, 353);
        g.drawRect((int)button.getX(), (int)button.getY(), (int)button.getWidth(), (int)button.getHeight());
    }

    public void mousePressed(MouseEvent e) {

        Point clicked = e.getPoint();

        if (e.getButton() == 1) {
            if (button.contains(clicked)) {
                novels = Novel.getRecommendation();
            }
            for (int i = 0; i < novels.size(); i++) {
                Rectangle box = novels.get(i).getCardBox();
                if (box.contains(clicked)) {
                    novels.get(i).flipImage();
                    System.out.println("Does this spark interest?");
                }


            }

            if (e.getButton() == 3) {
                for (int i = 0; i < novels.size(); i++) {
                    Rectangle box = novels.get(i).getCardBox();
                    if (box.contains(clicked)) {
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

//for (int i = 0; i < novels.size(); i++) {
//                Rectangle box = novels.get(i).getCardBox();
//                if (box.contains(clicked)) {
//                    Novel novel = Novel.getRecommendation().get(0);
//                    System.out.println(novel.getImageFileName());
//                    int index = 0;
//                    while (index < 19){
//                        novel = Novel.getRecommendation().get(index+1);
//                        System.out.println(novel.getImageFileName());
//                        index++;
//                    }
//                }
//            }