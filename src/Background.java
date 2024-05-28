import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Rectangle;
public class Background {
    private String genre;
    private String backgroundFileName;
    private boolean show;
    private Rectangle cardBox;
    private BufferedImage image;

    public Background(String genre) {
        this.genre = genre;
        this.backgroundFileName = "backgrounds/" + genre + ".png";
        this.image = readImage();
        this.cardBox = new Rectangle(-100, -100, image.getWidth(), image.getHeight());
    }

    public Rectangle getCardBox() {
        return cardBox;
    }


    public void setRectangleLocation(int x, int y) {
        cardBox.setLocation(x, y);
    }
    public BufferedImage getImage() {
        return image;
    }
    public BufferedImage readImage() {
        try {
            BufferedImage image;
            image = ImageIO.read(new File(backgroundFileName));
            return image;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }

    }

    public static ArrayList<Background> buildBackground(String genre) {
        ArrayList<Background> backgrounds = new ArrayList<>();
        Background background = new Background((genre));
        backgrounds.add(background);
        return backgrounds;
    }
    public static ArrayList<Background> buildRandomBackground() {
        ArrayList<Background> backgrounds = new ArrayList<>();
        String[] genre = {"mystery", "romance", "vr", "xianxia"};
        for (String g : genre) {
            Background background = new Background(g);
            backgrounds.add(background);
        }
        return backgrounds;
    }
    public static ArrayList<Background> getRandomBackground(){
        ArrayList<Background> genre = Background.buildRandomBackground();
        ArrayList<Background> order = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            int r = (int)(Math.random()*genre.size());
            Background c = genre.remove(r);
            order.add(c);
        }
        return order;
    }

    public static ArrayList<Background> getBackground(String g){
        ArrayList<Background> genre = Background.buildBackground(g);
        ArrayList<Background> order = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            int r = (int)(Math.random()*genre.size());
            Background c = genre.remove(r);
            order.add(c);
        }
        return order;
    }
}