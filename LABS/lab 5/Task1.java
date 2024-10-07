
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Task1 {
    Node head;

    public void printReverse(Node node) {
        if (node == null) {
            return;
        }

        printReverse(node.next);


        System.out.print(node.data + " ");
    }

    public void printReverse() {
        printReverse(head);
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public static void main(String[] args) {
        Task1 list = new Task1();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Linked List in Reverse Order:");
        list.printReverse();
    }
}
