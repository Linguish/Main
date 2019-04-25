package My;

import java.util.Iterator;

public class MyLinkedStack<E> implements Iterable<E>
{
    private class Node
    {
        /**
         * 数据域
         */
        E data = null;
        /**
         * 指针域
         */
        Node next = null;
        
        public Node(){}
        public Node(E data){this.data = data;}
    }
    
    private class reverseIterator implements Iterator<E>
    {
        @Override
        public boolean hasNext(){return top != null;}
        @Override
        public E next()
        {
            E temp = top.data;
            top = top.next;
            return temp;
        }
    }
    
    private Node top = null;
    private int size = 0;

    public boolean isEmpty(){return top == null;}
    
    public int size(){return size;}
    /**
     * 压栈
     *
     * @param item 压入的元素
     */
    public void push(E item)
    {
        Node old = top;
        top = new Node(item);
        top.next = old;
        size++;
    }
    /**
     * 出栈
     *
     * @return 弹出的元素
     */
    public E pop()
    {
        E temp = top.data;
        top = top.next;
        size--;
        return temp;
    }
    /**
     * 返回栈顶元素但不出栈
     *
     * @return 栈顶元素
     */
    public E peek(){return top.data;}
    public void clear(){top = null;}
    
    @Override
    public Iterator<E> iterator(){return new reverseIterator();}
}
