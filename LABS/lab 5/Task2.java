import java.util.Stack;
import java.util.Scanner;

public class Task2 {

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastOpened = stack.pop();

                if ((ch == ')' && lastOpened != '(') ||
                    (ch == '}' && lastOpened != '{') ||
                    (ch == ']' && lastOpened != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string with brackets:");
        String input = scanner.nextLine();

        if (isBalanced(input)) {
            System.out.println("The string has balanced brackets.");
        } else {
            System.out.println("The strSAing does not have balanced brackets.");
        }
    }
}
