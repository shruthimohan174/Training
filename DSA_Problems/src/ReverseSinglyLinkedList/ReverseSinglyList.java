//https://www.geeksforgeeks.org/reverse-a-linked-list/
package ReverseSinglyLinkedList;

public class ReverseSinglyList {

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Given Linked list:");
        printList(head);

        head = reverseList(head);

        System.out.print("\nReversed Linked List:");
        printList(head);
    }

    private static Node reverseList(Node head) {
        Node cur=head,prev=null,next=null;


        while(cur!=null){
            next=cur.next;
            cur.next=prev;

            prev=cur;
            cur=next;
        }
        return prev;
    }
}

