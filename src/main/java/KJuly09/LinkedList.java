package KJuly09;

public class LinkedList {

    public class Node {
        int data;
        Node next;
    }

    Node head;
    Node tail;
    int size;

    public void addLast(int val) {  //O1
        if (size == 0) {
            handleAddwhensize0(val);
            return;
        }

        Node node = new Node();
        node.data = val;
        tail.next = node;
        tail = node;
        size++;

    }

    public void handleAddwhensize0(int val) { //O1
        Node node = new Node();
        node.data = val;
        tail = head = node;
        size++;
    }

    public void display() { //On
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println();
    }

    public int getFirst() { //O1
        if (size == 0) {
            System.out.println("List empty");
            return -1;
        }
        return head.data;
    }

    public int getLast() { //O1
        if (size == 0) {
            System.out.println("List Empty");
            return -1;
        }
        return tail.data;
    }

    public int getAt(int indx) { //On

        if (size == 0) {
            System.out.println("List empty");
            return -1;
        } else if (indx < 0 || indx >= size) {
            System.out.println("Index out of bounds");
        }
        Node node = head;
        for (int i = 0; i < indx; i++) {
            node = node.next;
        }
        return node.data;
    }

    public Node getNodeAt(int indx) {
        if (indx < 0 || indx >= size) {
            System.out.println("Invalid index");
            return new Node();
        }
        Node node = head;
        for (int i = 0; i < indx; i++) {
            node = node.next;
        }
        return node;

    }

    public void addFirst(int val) { //O1
        if (size == 0) {
            handleAddwhensize0(val);
            return;
        }
        Node node = new Node();
        node.data = val;
        node.next = head;
        head = node;
        size++;
    }

    public void addAt(int indx, int val) {  //On
        if (indx < 0 || indx > size) {
            System.out.println("Invalid index");
            return;
        }
        if (indx == 0) {
            addFirst(val);
            return;
        }
        if (indx == size) {
            addLast(val);
            return;
        }
        Node node = new Node();
        node.data = val;

        Node nm1 = getNodeAt(indx - 1);
        Node np1 = nm1.next;
        nm1.next = node;
        node.next = np1;
        size++;

    }

    public int removeFirst() { //O1
        if (size == 0) {
            System.out.println("List Empty");
            return -1;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int removeLast() { //On
        if (size == 0) {
            System.out.println("List Empty");
            return -1;
        }
        int data = tail.data;
        Node nm1 = getNodeAt(size - 2);
        nm1.next = null;
        tail = nm1;
        size--;
        return data;
    }

    public int removeAt(int indx) { //On
        if (size == 0) {
            System.out.println("List Empty");
            return -1;
        }
        if (indx == 0) {
            return removeFirst();
        }
        if (indx == size - 1) {
            return removeLast();

        }
        if (indx < 0 || indx >= size) {
            System.out.println("Invalid index");
            return -1;
        }

        Node nm1 = getNodeAt(indx - 1);
        Node n = nm1.next;
        Node np1 = n.next;
        nm1.next = np1;
        size--;
        return n.data;
    }

    // July 10

    public void reverseDataIterative() {  //On2//
        if (size == 0) {
            System.out.println("List Empty");
            return;
        }
        //
        // int li=0;
        // int ri=size-1;
        // while(li<ri){
        // Node left=getNodeAt(li);
        // Node right=getNodeAt(ri);
        // int temp=left.data;
        // left.data=right.data;
        // right.data=temp;
        // li++;
        // ri-;
        // }
        Node node1 = head;
        Node node2 = tail;
        int sizevar = size - 1;
        int t;
        for (int indx = 0; indx < size / 2; indx++) {
            t = node1.data;
            node1.data = node2.data;
            node2.data = t;
            node1 = node1.next;
            sizevar -= 1;
            node2 = getNodeAt(sizevar);

        }
    }

    public void reversePointerIterative() { //On
        if (size == 0) {
            System.out.println("List Empty");
            return;
        }
        Node prev = head;
        Node curr = prev.next;
        while (curr != null) {
            Node ocn = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ocn;
        }
        tail = head;
        tail.next = null;
        head = prev;

    }

    public void displayReverse() { //On
        if (size == 0) {
            System.out.println("List Empty");
            return;
        }
        Node node = head;
        reversedisplayhelper(node);
    }

    private void reversedisplayhelper(Node node) {
        if (node == null) {
            return;
        }

        reversedisplayhelper(node.next);
        System.out.print(" <- " + node.data);
    }

    public void reversePointerRecursive() { //On
        Node res = reversePointerRecursiveHelper(head);
        head = tail;
        tail = res;
        tail.next = null;
    }

    private Node reversePointerRecursiveHelper(Node node) {
        if (node.next == null) {
            return node;
        }
        Node p = reversePointerRecursiveHelper(node.next);
        p.next = node;

        return node;
    }

    public class HeapMover {
        Node node;
    }

    public void reverseDataRecursive() {
        HeapMover left = new HeapMover();
        left.node = head;
        reverseDataRecursiveHelper(left, head, 0);
    }

    private void reverseDataRecursiveHelper(HeapMover left, Node right, int floor) {

        if (right == null) {
            return;
        }
        reverseDataRecursiveHelper(left, right.next, floor + 1);
        if (floor >= size / 2) { // swap
            int temp = left.node.data;
            left.node.data = right.data;
            right.data = temp;
        }

        left.node = left.node.next;
    }

    public boolean isPalindrome() {
        HeapMover left = new HeapMover();
        left.node = head;
        boolean res = isPalindromeHelper(left, head);
        return res;
    }

    private boolean isPalindromeHelper(HeapMover left, Node right) {
        if (right == null) {
            return true;
        }
        boolean val;

        val = isPalindromeHelper(left, right.next);
        if (val == false) {
            return false;
        } else {
            if (left.node.data != right.data) {
                return false;
            } else {
                left.node = left.node.next;
            }
        }
        return val;
    }

    public void foldList() {
        HeapMover left = new HeapMover();
        left.node = head;
        foldListHelper(left, head, 0);
        tail = left.node.next;
        tail.next = null;
    }

    private void foldListHelper(HeapMover left, Node right, int floor) {
        if (right == null) {
            return;
        }
        foldListHelper(left, right.next, floor + 1);
        if (floor >= size / 2) {
            Node node = left.node.next;
            left.node.next = right;
            right.next = node;
            left.node = node;
        }
    }

    public void unfoldList() {
        unfoldListHelper(head);
    }

    //1 -> 6 -> 2 -> 5 -> 3 -> 4
    private void unfoldListHelper(Node node) {
        if (node == null) {
            return;
        }
        // This condition will reach if
        // the number of nodes is odd
        // head and tail is same i.e. last node
        if (node.next == null) {
            head = tail = node;
            return;
        }
        // This base condition will reach if
        // the number of nodes is even
        // mark head to the second last node
        // and tail to the last node
        else if (node.next.next == null) {
            head = node;
            tail = node.next;
            return;
        }

        Node temp = node.next;
        unfoldListHelper(node.next.next);

        // Connecting first node to head
        // and mark it as a new head
        node.next = head;
        head = node;

        // Connecting tail to second node (temp)
        // and mark it as a new tail
        tail.next = temp;
        tail = temp;
        tail.next = null;
    }

    public int kthfromLast(int k) { //O(n)
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;

        }
        return slow.data;

    }

    public int midPointOfList() {
        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    //List is in groups of k
    // (a->b->c)=>(d->e->f)=>(g->h->i)
    // (c->b->a)=>(f->e->d)=>(i->h->g)
    public void kReverseLL(int k) {
        Node n = kReverseLL(head, k);
        head = n;
    }

    private Node kReverseLL(Node head, int k) { //by Node

        Node prev = null;
        Node curr = head;
        int count = 0;
        Node ocn = null;
        while (count < k && curr != null) {
            ocn = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ocn;
            count++;
        }

        if (ocn != null) {
            head.next = kReverseLL(ocn, k);
        }

        return prev;
    }

    public void kreverse(int k) {

        LinkedList prev = new LinkedList();
        LinkedList curr = new LinkedList();
        while (this.size != 0) {
            for (int i = 0; i < k; i++) {
                curr.addFirstNode(this.removeFirstNode());
            }
            if (prev.size == 0) {
                prev = curr;
            } else {
                prev.tail.next = curr.head;
                prev.tail = curr.tail;
                prev.size += curr.size;
            }
            curr = new LinkedList();
        }
        this.head = prev.head;
        this.tail = prev.tail;
        this.size = prev.size;
    }

    private Node removeFirstNode() {
        if (size == 0) {
            System.out.println("List Empty");
            return null;
        }
        if (size == 1) {
            return handleRemovalOfNodeWhenSizeis1();

        }
        Node rv = head;
        head = head.next;
        rv.next = null;
        size--;

        return rv;

    }

    private Node handleRemovalOfNodeWhenSizeis1() {
        Node rv = head;
        tail = head = null;
        rv.next = null;
        size--;
        return rv;

    }

    private void addFirstNode(Node node) {
        if (size == 0) {
            handleAddNodeWhenSize0(node);
            return;
        }
        node.next = head;
        head = node;
        size++;

    }

    private void handleAddNodeWhenSize0(Node node) {

        head = tail = node;
        size++;
    }

    private void addLastNode(Node node) {
        if (size == 0) {
            handleAddNodeWhenSize0(node);
        }
        tail.next = node;
        tail = node;
        size++;
    }


    public void removeDuplicates() {
        if (size == 0) {
            System.out.println("List Empty");
            return;
        }

        LinkedList curr = new LinkedList();
        while (this.size != 0) {
            Node node = this.removeFirstNode();

            if (curr.size == 0 || curr.tail.data != node.data) {
                curr.addLastNode(node);
            }

        }
        this.head = curr.head;
        this.tail = curr.tail;
        this.size = curr.size;
    }

    public void oddevenSplit() {
        if (size == 0) {
            System.out.println("List Empty");
            return;
        }
        LinkedList odd = new LinkedList();
        LinkedList even = new LinkedList();
        while (this.size != 0) {
            Node node = this.removeFirstNode();
            if (node.data % 2 == 0) {
                even.addLastNode(node);
            } else {
                odd.addLastNode(node);
            }
        }

        if (even.size > 0) {
            even.tail.next = odd.head;
        }
        this.head = even.size > 0 ? even.head : odd.head;
        this.tail = odd.size > 0 ? odd.tail : even.tail;
        this.size = even.size + odd.size;
    }

    public static LinkedList mergesort(LinkedList list) {

        if (list.size == 1) {
            return list;
        }

        LinkedList fh = new LinkedList();
        LinkedList sh = new LinkedList();
        Node node = list.head;

        for (int i = 0; i < list.size; i++) {

            if (i < list.size / 2) {
                fh.addLast(node.data);
            } else {
                sh.addLast(node.data);
            }

            node = node.next;
        }

        fh = mergesort(fh);
        sh = mergesort(sh);
        LinkedList res = LinkedList.merge(fh, sh);
        return res;

    }

    public static LinkedList merge(LinkedList l1, LinkedList l2) {

        LinkedList l3 = new LinkedList();
        Node l1temp = l1.head;
        Node l2temp = l2.head;

        while (l1temp != null && l2temp != null) {
            if (l1temp.data < l2temp.data) {
                l3.addLast(l1temp.data);
                l1temp = l1temp.next;
            } else {
                l3.addLast(l2temp.data);
                l2temp = l2temp.next;
            }
        }
        while (l2temp != null) {
            l3.addLast(l2temp.data);
            l2temp = l2temp.next;
        }
        while (l1temp != null) {
            l3.addLast(l1temp.data);
            l1temp = l1temp.next;
        }
        return l3;
    }
}
