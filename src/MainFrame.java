import javax.swing.JFrame;
import java.util.Scanner;

public class MainFrame extends JFrame implements Runnable {

    private DrawPanel p;
    private Thread windowThread;

    public MainFrame(String display) {
        super(display);
        Scanner s = new Scanner(System.in);
        System.out.println("What novels do you want to read?\n1) mystery\n2) romance\n3) vr\n4) xianxia");
        String response = s.nextLine();
        if (response == "1"){
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