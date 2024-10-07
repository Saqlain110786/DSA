public class Task4 {
    char arr[];
    int top = 0, size;
    Task4(int size) {
        this.size = size;
        arr = new char[size];
    }
    void push(char data) {
        if (top >= size) {
            System.out.println("Stack is Full!!");
        } else {
            arr[top] = data;
            top++;
        }
    }

    char pop() {
        if (top == 0) {
            System.out.println("Stack is Empty!!");
            return '\0';
        } else {
            top--;
            return arr[top];
        }
    }

    char peek() {
        if (top == 0) {
            return '\0';
        } else {
            return arr[top - 1];
        }
    }

    int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    void convertToPostfix(String expression) {
        StringBuilder result = new StringBuilder();


        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (isOperand(c)) {
                result.append(c);
            }

            else if (c == '(') {
                push(c);
            }

            else if (c == ')') {
                while (top > 0 && peek() != '(') {
                    result.append(pop());
                }
                pop();
            }
            else {
                while (top > 0 && precedence(c) <= precedence(peek())) {
                    result.append(pop());
                }
                push(c);
            }
        }

        while (top > 0) {
            result.append(pop());
        }
        System.out.println("Postfix Expression: " + result);
    }

    public static void main(String[] args) {
        Task4 converter = new Task4(20);
        String expression = "A+B*C+D";
        System.out.println("Infix Expression: " + expression);
        converter.convertToPostfix(expression);
    }
}
