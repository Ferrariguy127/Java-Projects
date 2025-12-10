public class SinglyLinkedList {
    public ListNode front;

    public SinglyLinkedList() {
        front = null;
    }

    void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }


    }

    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public void printlist() {
        if (front == null) {
            System.out.println("no element");
        } else {
            ListNode current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    public void shift() {
        ListNode prev = front.next;
        for (int i = 1; i <= this.size(); i++) {
                if (i == 1) { // logic for first node
                    ListNode node = front; // storing first node
                    ListNode current = front;
                    front = current.next;
                    while (current.next != null) {
                        current = current.next; // going to add node of list
                    }
                    node.next = null; // before adding node make next of node null because it will be added at last now
                    current.next = node; // adding first node at last
                }
                else if (i%2 == 1) {
                    ListNode current = front;
                    ListNode node = prev.next; // this is the odd number node which we will add at last
                    prev.next = node.next; // now linking the prev node to the next of odd index node.
                    prev = node.next; // stores the value at the end

                    while (current.next != null) {
                        current = current.next; // going to last node of list
                    }
                    node.next = null; // making next of node as null before being added at last
                    current.next = node; // now adding at last
                }
            }
        }
    }
