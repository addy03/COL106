class MyNode
{
    private node elem;
    MyNode next = null;
    public MyNode(node elem)
    {
        this.elem = elem;
    }

    public node get_data()
    {
        return elem;
    }
}

class MyList
{
    private MyNode first;
    private MyNode last;

    public MyList()
    {
        first = null;
        last = null;
    }

    public void AddList(MyNode e)
    {
        if (first == null && last == null)
        {
            first = e;
            last = e;
        }
        else
        {
            last.next = e;
            last = e;
        }
    }

    public void DeleteList(node x)
    {
        if (first.get_data() == x)
        {
            first = first.next;
        }
        else
        {
            MyNode n = first;
            while(n != null)
            {
                if(n.next.get_data() == x)
                {
                    n.next = n.next.next;
                    break;
                }
                n = n.next;
            }
        }
    }

    public void traverse()
    {
        MyNode f = first;
        while(f != null)
        {
            System.out.println(f.get_data().ViewName());
            f = f.next;
        }
    }

    public MyNode ViewFirst()
    {
        return first;
    }
    public MyNode ViewLast()
    {
        return last;
    }
}

public class node
{
    private String employee_name;
    private int level;
    node boss = null;
    MyList junior = new MyList();

    public node(String employee_name, int level)
    {
        this.employee_name = employee_name;
        this.level = level;
    }

    public String ViewName()
    {
        return employee_name;
    }

    public int ViewLevel()
    {
        return level;
    }
}
