import javax.swing.JFrame;
import java.util.Scanner;

public class MainFrame extends JFrame implements Runnable {

    private DrawPanel p;
    private Thread windowThread;

    public MainFrame(String display) {
        super(display);
        Scanner s = new Scanner(System.in);
        System.out.println("What genre do you want to read?\n1) mystery\n2) romance\n3) vr(virtual reality)\n4) xianxia\n5) let me browse");
        String response = s.nextLine();
        if (response.equals("1")){
            System.out.println("Displaying mystery novel images.");
            int frameWidth = 1000;
            int frameHeight = 1000;
            p = new DrawPanel("mystery");
            this.add(p);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            this.setSize(frameWidth, frameHeight);
            this.setLocation(10, 10);
            this.setVisible(true);
            startThread();
        } else if (response.equals("2")) {
            System.out.println("Displaying romance novel images.");
            int frameWidth = 1000;
            int frameHeight = 1000;
            p = new DrawPanel("romance");
            this.add(p);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(frameWidth, frameHeight);
            this.setLocation(10, 10);
            this.setVisible(true);
            startThread();
        }
        else if (response.equals("3")) {
            System.out.println("Displaying vr novel images.");
            int frameWidth = 1000;
            int frameHeight = 1000;
            p = new DrawPanel("vr");
            this.add(p);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(frameWidth, frameHeight);
            this.setLocation(10, 10);
            this.setVisible(true);
            startThread();
        }
        else if (response.equals("4")) {
            System.out.println("Displaying xianxia novel images.");
            int frameWidth = 1000;
            int frameHeight = 1000;
            p = new DrawPanel("xianxia");
            this.add(p);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(frameWidth, frameHeight);
            this.setLocation(10, 10);
            this.setVisible(true);
            startThread();
        }
        else if (response.equals("5")) {
            System.out.println("Displaying random novel images.");
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
        else {
            System.out.println("This is not a valid option, please rerun the program.");
        }

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