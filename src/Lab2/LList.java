package Lab2;

public class LList {
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public Node(Node other) {
            this.value = other.value;
            this.next = other.next;
        }

        public Node() {
            this.value = 0;
            this.next = null;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void setValue(int newValue) {
            this.value = newValue;
        }

        public int getValue() {
            return value;
        }

        public void setNext(Node newNext) {
            this.next = newNext;
        }

        public Node getNext() {
            return this.next;
        }

    }

    private Node head;
    private int count;

    public LList() {
        this.head = null;
        this.count = 0;
    }

    public LList(int value) {
        this.head = new Node(value);
        this.count = 1;
    }

    public LList(Node head) {
        Node node = head;
        while (node != null) {
            this.add(node.value);
            node = node.next;
        }
    }

    public LList(LList other) {
        Node node = other.head;
        while (node != null) {
            this.add(node.value);
            node = node.next;
        }
    }

    public void add(int value) {
        if (this.head == null) {
            this.head = new Node(value);
        } else {
            Node n = this.head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = new Node(value);
        }
        this.count++;
    }

    public void add(int value, int index) {
        if (index <= 0) {
            Node newHead = new Node(value);
            newHead.next = this.head;
            this.head = newHead;
            this.count++;
        } else if (index >= this.count) {
            add(value);
        } else {
            Node newNode = new Node(value);
            Node previous = this.head;
//            Node current = this.head.next;
            int i = 1;
            while (i != index) {
                ++i;
                previous = previous.next;
//                current = current.next;
            }
//            newNode.next = current;
            newNode.next = previous.next;
            previous.next = newNode;
            this.count++;
        }
    }

    public int getFirst() {
        return this.head.value;
    }

    public int getLast() {
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        return node.value;
    }

    public Node getHead() {
        return this.head;
    }

    public int get(int index) {
        if (index <= 0) {
            return this.head.value;
        } else if (index >= this.count) {
            return getLast();
        } else {
            Node node = this.head.next;
            int i = 1;
            while (i != index) {
                node = node.next;
            }
            return node.value;
        }
    }

    public int size() {
        return this.count;
    }

    public boolean contains(int value) {
        Node node = this.head;
        boolean flag = false;
        while (node != null) {
            if (node.value == value) {
                flag = true;
                break;
            } else {
                node = node.next;
            }
        }
        return flag;
    }

    public int indexOf(int value) {
        boolean flag = false;
        int index = 0;
        Node node = this.head;
        while (node != null) {
            if (node.value == value) {
                flag = true;
                break;
            } else {
                index++;
                node = node.next;
            }
        }
        if (flag)
            return index;
        else return -1;
    }

    public int remove(int index) {
        if (this.head != null) {
            if (index <= 0) {
                Node node = this.head;
                this.head = node.next;
                node.next = null;
                count--;
                return node.value;
            } else if (index >= this.count - 1) {
                Node prev = this.head;
                Node node = this.head.next;
                while (node.next != null) {
                    node = node.next;
                    prev = prev.next;
                }
                prev.next = null;
                count--;
                return node.value;
            } else {
                Node node = this.head.next;
                Node prev = this.head;
                int i = 1;
                while (i != index) {
                    node = node.next;
                    prev = prev.next;
                    i++;
                }
                prev.next = node.next;
                node.next = null;
                count--;
                return node.value;
            }
        } else return 0;
    }

    public int set(int value, int index) {
        if (index <= 0) {
            int old = this.head.value;
            this.head.value = value;
            return old;
        } else if (index >= this.count - 1) {
            Node node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            int old = node.value;
            node.value = value;
            return old;
        } else {
            int i = 1;
            Node node = this.head.next;
            while (i != index) {
                node = node.next;
                ++i;
            }
            int old = node.value;
            node.value = value;
            return old;
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public String toString() {
        String str = "";
        Node node = this.head;
        while (node.next != null) {
            str += node.value + " ";
            node = node.next;
        }
        str += node.value;
        return str;
    }

    public static Node merge(Node firstHead, Node secondHead) {
        Node newHead = new Node();
        Node curA = firstHead;
        Node curB = secondHead;
        if (curA.value < curB.value) {
            newHead.value = curA.value;
            curA = curA.next;
        } else {
            newHead.value = curB.value;
            curB = curB.next;
        }
        Node cur = new Node();
        newHead.next = cur;
        while (curA != null || curB != null) {
            if (curA != null && curB != null) {
                if (curA.value < curB.value) {
                    cur.value = curA.value;
                    curA = curA.next;
                } else {
                    cur.value = curB.value;
                    curB = curB.next;
                }
            } else if (curA != null) {
                cur.value = curA.value;
                curA = curA.next;
            } else {
                cur.value = curB.value;
                curB = curB.next;
            }
            if (curA != null || curB != null) {
                cur.next = new Node();
                cur = cur.next;
            }
        }
//        Node newHead = new Node(firstHead.value);
//        Node current = new Node();
//        newHead.next = current;
//        Node node = firstHead.next;
//        while (node != null) {
//            current.value = node.value;
//            current.next = new Node();
//            node = node.next;
//            current = current.next;
//        }
//        current.value = secondHead.value;
//        current.next = new Node();
//        node = secondHead.next;
//        current = current.next;
//        while (node.next != null) {
//            current.value = node.value;
//            current.next = new Node();
//            node = node.next;
//            current = current.next;
//        }
//        current.value = node.value;
//        current.next = null;
        return newHead;
    }

}
