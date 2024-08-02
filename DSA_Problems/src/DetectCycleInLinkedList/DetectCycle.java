//https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/

package DetectCycleInLinkedList;
public class DetectCycle {
    public static void main(String[] args)
    {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        head.next.next.next.next = head;

        if (detectLoop(head))
            System.out.println("Loop Found");
        else
            System.out.println("No Loop");
    }

    private static boolean detectLoop(Node head) {
        Node slow=head,fast=head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
                return true;
    }

        return false;
}
}
