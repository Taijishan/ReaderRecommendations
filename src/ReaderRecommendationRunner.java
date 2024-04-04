import java.util.Scanner;
public class ReaderRecommendationRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name? ");
        MainFrame display = new MainFrame("Hello " + s.nextLine() + ", welcome to the Reader's Recommendation website!");
    }
}
