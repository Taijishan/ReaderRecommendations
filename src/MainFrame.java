import javax.swing.JFrame;
import java.util.Scanner;

public class MainFrame extends JFrame implements Runnable {

    private DrawPanel p;
    private Thread windowThread;

    public MainFrame(String display) {
        super(display);
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = s.nextLine();
        System.out.println("Hello " + name + ", welcome to the Reader's Recommendation website!");
        System.out.println("What novels do you want to read?\n1) mystery\n2) romance\n3) vr\n4) xianxia");
        String response = s.nextLine();
        if (response.equals("1")){
            System.out.println("Displaying mystery novel images.");
            int frameWidth = 50;
            int frameHeight = 50;
            p = new DrawPanel();
            this.add(p);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(frameWidth, frameHeight);
            this.setLocation(10, 10);
            this.setVisible(true);
            startThread();
        } else if (response.equals("2")) {
            System.out.println("Displaying romance novel images.");
            int frameWidth = 50;
            int frameHeight = 50;
            p = new DrawPanel();
            this.add(p);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(frameWidth, frameHeight);
            this.setLocation(10, 10);
            this.setVisible(true);
            startThread();
        }
        else if (response.equals("3")) {
            System.out.println("Displaying vr novel images.");
            int frameWidth = 50;
            int frameHeight = 50;
            p = new DrawPanel();
            this.add(p);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(frameWidth, frameHeight);
            this.setLocation(10, 10);
            this.setVisible(true);
            startThread();
        }
        else if (response.equals("4")) {
            System.out.println("Displaying xianxia novel images.");
            int frameWidth = 50;
            int frameHeight = 50;
            p = new DrawPanel();
            this.add(p);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(frameWidth, frameHeight);
            this.setLocation(10, 10);
            this.setVisible(true);
            startThread();
        }
        else {
            System.out.println("So you just want to see my photo album, eh?");
            int frameWidth = 50;
            int frameHeight = 50;
            p = new DrawPanel();
            this.add(p);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(frameWidth, frameHeight);
            this.setLocation(10, 10);
            this.setVisible(true);
            Novel.getRecommendation();
        }

        int frameWidth = 1000;
        int frameHeight = 1000;
        p = new DrawPanel();
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(10, 10);
        this.setVisible(true);
        startThread();
    }

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }

    public void run() {
        while (true) {
            p.repaint();
        }
    }
}