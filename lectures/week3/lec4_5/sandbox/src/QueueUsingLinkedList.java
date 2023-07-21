/**
 *  Queue implementation using linked list (LL)
 *
 *  Uses: Node.java
 */


public class QueueUsingLinkedList {
    public Node front = null;
    public Node rear = null;
    public int length;

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if(rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        length++;
    }

    public int dequeue() {
        if (front == null) return ' ';
        int data = front.data;
        front = front.next;
        if (front == null) rear=null;
        length--;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node current = front;
        System.out.println("Queue elements:");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();
    }
}