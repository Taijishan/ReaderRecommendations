import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.util.Vector;

public class
Novel {
    private String genre;
    private String value;
    private String imageFileName;
    private String imageFileSynopsis;
    private boolean show;
    private BufferedImage image;
    private Rectangle cardBox;

    public Novel(String genre, String value) {
        this.genre = genre;
        this.value = value;
        this.imageFileName = "images/novel_"+genre+"_"+value+".png";
        this.show = true;
        this.imageFileSynopsis = "descriptions/novel_"+genre+"_"+value+".png";
        this.image = readImage();
        this.cardBox = new Rectangle(-100, -100, image.getWidth(), image.getHeight());
    }

    public Rectangle getCardBox() {
        return cardBox;
    }


    public void setRectangleLocation(int x, int y) {
        cardBox.setLocation(x, y);
    }


    public String toString() {
        return genre + " " + value;
    }
    public void flipImage(){
        show = !show;
        this.image = readImage();

    }

    public BufferedImage getImage() {
        return image;
    }

    public BufferedImage readImage() {
        try {
            BufferedImage image;
            if (show) {
                image = ImageIO.read(new File(imageFileName));
            }
            else {
                image = ImageIO.read(new File(imageFileSynopsis));
            }
            return image;
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Novel> buildRecommendation(String genre) {
        ArrayList<Novel> novels = new ArrayList<Novel>();
        String[] order = {"01", "02", "03", "04", "05"};
            for (String o : order) {
                Novel novel = new Novel(genre, o);
                novels.add(novel);
        }
        return novels;
    }

    public static ArrayList<Novel> buildRandomRecommendation() {
        ArrayList<Novel> novels = new ArrayList<Novel>();
        String[] genre = {"mystery", "romance", "vr", "xianxia"};
        String[] order = {"01", "02", "03", "04", "05"};
        for (String g : genre){
            for (String o : order) {
                Novel novel = new Novel(g, o);
                novels.add(novel);
            }
        }
        return novels;
    }

    public static ArrayList<Novel> getRandomRecommendation(){
        ArrayList<Novel> genre = Novel.buildRandomRecommendation();
        ArrayList<Novel> order = new ArrayList<Novel>();
        for (int i = 0; i < 6; i++) {
            int r = (int)(Math.random()*genre.size());
            Novel c = genre.remove(r);
            order.add(c);
        }
        return order;
    }

    public static ArrayList<Novel> getRecommendation(String g){
        ArrayList<Novel> genre = Novel.buildRecommendation(g);
        ArrayList<Novel> order = new ArrayList<Novel>();
        for (int i = 0; i < 5; i++) {
            int r = (int)(Math.random()*genre.size());
            Novel c = genre.remove(r);
            order.add(c);
        }
        return order;
    }


    public boolean isShown() {
        return show;
    }
}