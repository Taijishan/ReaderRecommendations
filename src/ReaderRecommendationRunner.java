import java.util.Scanner;
public class ReaderRecommendationRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = s.nextLine();
        MainFrame display = new MainFrame("Hello " + name + ", welcome to the Reader's Recommendation website!");
    }
}
