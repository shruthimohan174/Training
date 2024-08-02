//https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
package MIddleELementLinked;

public class MiddleElement {
    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);

        System.out.println(
                "Middle Value Of Linked List is: "
                        + getMiddle(head));
    }

    private static int getMiddle(Node head) {
        Node slow=head,fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
}
