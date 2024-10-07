public class Task3 {
    char arr[];
    int top = 0, size;

    Task3(int size) {
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

    void check() {
        boolean isRepeating;

        for (int i = 0; i < top; i++) {
            isRepeating = false;


            for (int j = 0; j < top; j++) {
                if (i != j && arr[i] == arr[j]) {
                    isRepeating = true;
                    break;
                }
            }


            if (!isRepeating) {
                System.out.println("Output: " + arr[i]);
                System.out.println("Explanation: " + arr[i] + " is the first character in the array that does not repeat.");
                return;
            }
        }

        System.out.println("No non-repeating character found.");
    }


    void display() {
        for (int i = 0; i < top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Task3 t3 = new Task3(10);
        t3.push('S');
        t3.push('A');
        t3.push('Q');
        t3.push('L');
        t3.push('A');
        t3.push('I');
        t3.push('N');
        t3.display();
        t3.check();
    }
}
