public class practice {

    public static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static node head;
    public static node tail;
    public static int size;

    public void addfirst(int data) {
        node newnode = new node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    public void addlast(int data) {
        node newnode = new node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    }

    public void addmiddle(int data, int idx) {
        node newnode = new node(data);
        if (idx == 0) {
            addfirst(data);
            return;
        }
        node temp = head;
        size++;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newnode.next = temp.next;
        temp.next = newnode;

    }

    public int removefirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;

        head = head.next;
        size--;
        return val;
    }

    public int removelast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;

        }
        int val = prev.next.data;// tail value
        tail = prev;
        prev.next = null;
        size--;
        return val;
    }

    public int iterativeSearch(int key) {
        node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }

            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(int key, node head) {
        // base
        if (head == null) {
            return -1;

        }
        if (head.data == key) {
            return 0;

        }

        int idx = helper(key, head.next);

        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recursiveSearch(int key) {
        return helper(key, head);
    }

    public void reverse() {
        node prev = null;
        node current = tail = head;
        node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void deletenthNode(int n) {
        // calcuate size

        int size = 0;
        node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (n == size) { // LAST SE N MEANS 1ST
            head = head.next;
            return;
        }

        int i = 1;
        int iToFind = size - n;
        node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public node findMid(node head) {
        node slow = head;
        node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }

        return slow; // slow is our mid

    }

    public boolean checkpalindrome() {
        // corner case
        if (head == null || head.next == null) {
            return true;
        }
        node mid = findMid(head);

        // reverse

        node prev = null;
        node curr = mid;
        node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        node right = prev;
        node left = head;

        // check left and right half

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle() {
        node slow = head;
        node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;

    }

    public static void removeCycle() {
        // detect cycle
        node slow = head;
        node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // find the meeting point
        slow = head;
        node prev = fast;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle

        prev.next = null;
    }

    private node getMid(node head) {
        node slow = head;
        node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public node merge(node head1, node head2) {
        node MergedLL = new node(-1);
        node temp = MergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return MergedLL.next;
    }

    public node mergeSort(node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        node mid = getMid(head);

        // left and right MS

        node RightHead = mid.next;
        mid.next = null;
        node newLeft = mergeSort(head);
        node newRight = mergeSort(RightHead);

        // merge
        return merge(newLeft, newRight);

    }

    public void ZigZag() {
        // find mid
        node slow = head;
        node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        node mid = slow;

        // reverse half

        node current = mid.next;
        mid.next = null;
        node prev = null;
        node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        node left = head;
        node right = prev;
        node nextL, nextR;

        // alternate merging
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }

    public void print() {
        if (head == null) {
            System.out.println("LinkList is empty");
            return;
        }
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String args[]) {
        practice ll = new practice();

        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.addlast(6);

        ll.print();
        System.out.println();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();
        ll.ZigZag();
        ll.print();

    }
}
