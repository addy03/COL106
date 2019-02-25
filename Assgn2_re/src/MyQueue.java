class Node_queue
{
    MyList elem;
    Node_queue next = null;

    public Node_queue(MyList elem)
    {
        this.elem = elem;
    }
}

public class MyQueue
{
    private Node_queue front;
    private Node_queue rear;

    public MyQueue()
    {
        front = null;
        rear = null;
    }

    public void push(MyList e)
    {
        Node_queue x = new Node_queue(e);
        if(front == null)
        {
            front = x;
            rear = x;
        }
        else
        {
            rear.next = x;
            rear = x;
        }
    }

    public MyList pop()
    {
        MyList x = front.elem;
        front = front.next;
        return x;
    }

    public Node_queue get_front()
    {
        return front;
    }
}
