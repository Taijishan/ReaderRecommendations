import java.util.Scanner;

public class ReaderRecommendationRunner { //add novel names
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = s.nextLine();
        System.out.println("Hello " + name + ", welcome to the Reader's Recommendation website!");
        MainFrame display = new MainFrame("Reinhart's scholarly recommendations");
    }
}
