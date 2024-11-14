public class NumberUtils {

    public static String squareNumberString(String str) {
        int n;
        try {
            n = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("str must contain a valid integer");
        }
        return "" + Math.pow(n, 2);
    }

    public static void main(String[] args) {
        try {
            System.out.println(squareNumberString("5"));    // Outputs "25.0"
            System.out.println(squareNumberString("abc"));  // Throws IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
