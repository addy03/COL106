public class employee
{
    node ceo;

    public employee(String name)
    {
        ceo = new node(name, 1);
    }

    public node Search(String s, node emp)
    {
        node x = emp;
        if (x == null)
        {
            return null;
        }
        else
        {
            if (x.ViewName().equals(s))
            {
                return x;
            }
            else
            {
                MyNode y = x.junior.ViewFirst();
                node a = null;
                while (y != null)
                {
                    a = Search(s, y.get_data());
                    if (a != null)
                    {
                        break;
                    }
                    y = y.next;
                }
                return a;
            }
        }
    }

    public void AddEmployee(String s1, String s2)
    {
        try
        {
            if (Search(s1,ceo) == null)
            {
                node x = Search(s2, ceo);
                node new_emp = new node(s1, x.ViewLevel() + 1);
                new_emp.boss = x;
                MyNode new_jun = new MyNode(new_emp);
                x.junior.AddList(new_jun);
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("Employee with name " + s2 + " not found.");
        }

    }

    public void DeleteEmployee(String s1, String s2)
    {
        try
        {
            if(s1 != s2)
            {
                node x1 = Search(s1, ceo);
                node x2 = null;

                MyQueue q = new MyQueue();
                q.push(ceo.junior);
                while (q.get_front() != null)
                {
                    if(q.get_front().elem.ViewFirst().get_data().ViewLevel() == x1.ViewLevel())
                    {
                        while(q.get_front() != null)
                        {
                            MyList x = q.pop();
                            MyNode a = x.ViewFirst();
                            while(a != null)
                            {
                                if(a.get_data().ViewName() == s2)
                                {
                                    x2 = a.get_data();
                                    break;
                                }

                                if(x2 == null)
                                {
                                    a = a.next;
                                }
                                else
                                {
                                    break;
                                }
                            }
                        }
                    }
                    else
                    {
                        MyList x = q.pop();
                        MyNode a = x.ViewFirst();
                        while(a != null)
                        {
                            q.push(a.get_data().junior);
                            a = a.next;
                        }
                    }
                }
                if(x2 != null)
                {
                    x1.boss.junior.DeleteList(x1);
                }

                if(x2.junior.ViewLast() != null)
                {
                    x2.junior.ViewLast().next = x1.junior.ViewFirst();
                }
                else
                {
                    x2.junior = x1.junior;
                }
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("Employee not found.");
        }
    }

    public void LowestCommonBoss(String s1, String s2)
    {
        try
        {
            node x1 = Search(s1,ceo);
            node x2 = Search(s2,ceo);

            if (x1.ViewLevel() > x2.ViewLevel())
            {
                while(x2.ViewLevel() != x1.ViewLevel())
                {
                    x1 = x1.boss;
                }
            }
            else
            {
                while(x2.ViewLevel() != x1.ViewLevel())
                {
                    x2 = x2.boss;
                }
            }

            while (x1.boss.ViewName() != x2.boss.ViewName())
            {
                x1 = x1.boss;
                x2 = x2.boss;
            }
            System.out.println(x1.boss.ViewName());
        }
        catch(NullPointerException e)
        {
            System.out.println("Employee not found");
        }
    }

    public void PrintEmployees()
    {
        System.out.println(ceo.ViewName());
        MyQueue q = new MyQueue();
        q.push(ceo.junior);
        while (q.get_front() != null)
        {
            MyList x = q.pop();
            x.traverse();
            MyNode a = x.ViewFirst();
            while(a != null)
            {
                q.push(a.get_data().junior);
                a = a.next;
            }
        }
    }
}

