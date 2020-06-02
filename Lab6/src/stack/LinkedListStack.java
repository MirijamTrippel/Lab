package stack;

public class LinkedListStack<Object> implements Stack<Object> {

    public Node first;
    //public Node last;
    int currentHeight;

    public class Node<Object> {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    @Override
    public boolean isEmpty() {
        if (currentHeight == 0)
            return true;
        else
            return false;
    }

    @Override
    public Object top() throws Underflow {
        if (currentHeight == 0) {
            throw new Underflow();
        }
        return (Object) first.getData();
    }

    @Override
    public void push(Object element) throws Overflow {
        Node node = new Node(element, first);
        first = node;
        currentHeight++;
    }

    @Override
    public Object pop() throws Underflow {
        if (currentHeight == 0) {
            throw new Underflow();
        }
        Object data = (Object) first.getData();
        first = first.getNext();
        currentHeight--;
        return data;
    }

    @Override
    public String toString() {
        String result = "";
        for (Node<Object> current = first; current != null; current = current.next) {
            result += current.getData();
            if (current.getNext() != null)
                result += ", ";
        }
        return result;
    }
}