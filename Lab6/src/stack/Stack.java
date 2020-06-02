package stack;

public interface Stack<Object> {

    public boolean isEmpty();

    public Object top() throws Underflow;

    public void push(Object element) throws Overflow;

    public Object pop() throws Underflow, Overflow;

    public String toString();

}