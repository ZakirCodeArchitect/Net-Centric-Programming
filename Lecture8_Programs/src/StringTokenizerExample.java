import java.util.StringTokenizer;
import java.util.Scanner;

public class StringTokenizerExample {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String inputLine = keyboard.nextLine();

        // Create a StringTokenizer with delimiters: space, newline, period, comma
        StringTokenizer wordFinder = new StringTokenizer(inputLine, " \n.,");

        while (wordFinder.hasMoreTokens()) {
            System.out.println(wordFinder.nextToken());
        }
    }
}