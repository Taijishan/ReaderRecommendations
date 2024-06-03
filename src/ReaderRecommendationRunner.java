import java.util.Scanner;

public class ReaderRecommendationRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = s.nextLine();
        System.out.println("Hello " + name + ", welcome to the Reader's Recommendation website! If you can't see the description of some novels, click the 'get new recommendations' button until you can.\nThis is a WIP, so please be nice :)");
        MainFrame display = new MainFrame("Reinhart's scholarly recommendations");
    }
    public static void rerun(){
        System.out.println("Welcome back, reader. We will now commence your new browsing session");
        MainFrame display = new MainFrame("Reinhart's scholarly recommendations");
    }
}
