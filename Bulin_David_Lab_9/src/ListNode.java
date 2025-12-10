public class ListNode {
        public int data;
        public ListNode next;

        public ListNode(){
            this(0,null);
        }

        public ListNode(int data, ListNode next) {
            this.data=data;
            this.next=next;
        }
        public ListNode(int data){
            this(data,null);
        }
    }
