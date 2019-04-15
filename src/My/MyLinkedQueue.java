package My;

public class MyLinkedQueue<E>
{
    private Node first;//指向最早添加的
    private Node last;//指向最近添加的
    private int number = 0;//队列元素个数
    
    private class Node
    {
        E data = null;
        Node next = null;
        
        public Node(){}
        public Node(E data){this.data = data;}
    }
    
    public MyLinkedQueue(){}
    public void clear()
    {
        first = null;
        last = null;
        number = 0;
    }
    public boolean isEmpty(){return first == null;}
    public int length(){return number;}
    /**
     * 取队首元素但不出队
     *
     * @return 队首元素
     */
    public E peek(){return first.data;}
    
    /**
     * 入队
     *
     * @param input 要入的元素
     */
    public void enqueue(E input)
    {
        if(this.isEmpty()){first = last = new Node(input);}
        else
        {
            last.next = new Node(input);
            last = last.next;
        }
        number++;
    }
    /**
     * 出队
     *
     * @return 返回队首元素并从队列中删除
     */
    public E dequeue()
    {
        E temp = first.data;
        first = first.next;
        number--;
        return temp;
    }
}
