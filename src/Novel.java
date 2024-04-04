import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.util.Vector;

public class Novel {
    private String genre;
    private String value;
    private String imageFileName;
    private BufferedImage image;
    private Rectangle cardBox;

    public Novel(String genre, String value) {
        this.genre = genre;
        this.value = value;
        this.imageFileName = "images/novel_"+genre+"_"+value+".png";
        this.image = readImage();
        this.cardBox = new Rectangle(-100, -100, image.getWidth(), image.getHeight());
    }

    public Rectangle getCardBox() {
        return cardBox;
    }

    public String getGenre() {
        return genre;
    }

    public String getValue(){
        return value;
    }

    public void setRectangleLocation(int x, int y) {
        cardBox.setLocation(x, y);
    }


    public String getImageFileName() {
        return imageFileName;
    }

    public String toString() {
        return genre + " " + value;
    }

    public BufferedImage getImage() {
        return image;
    }

    public BufferedImage readImage() {
        try {
            BufferedImage image;
            image = ImageIO.read(new File(imageFileName));
            return image;
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Novel> buildNovel() {
        ArrayList<Novel> novels = new ArrayList<Novel>();
        String[] genre = {"xianxia", "mystery", "romance", "vr"};
        String[] order = {"01", "02", "03", "04", "05"};
        for (String g : genre) {
            for (String o : order) {
                Novel novel = new Novel(g, o);
                novels.add(novel);
            }
        }
        return novels;
    }

}