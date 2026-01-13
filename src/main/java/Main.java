public class Main
{
	public static void main(String[] args)
	{
		Queue<String> q = new Queue<String>();
		q.insert("a");
		q.insert("a");
		q.insert("b");
		q.insert("a");
		q.insert("d");
		q.insert("d");
		
        System.out.println(q);
        System.out.println(q_1(q));
        
        System.out.println();
        
        Queue<Integer> q1 = new Queue<Integer>();
		q1.insert(14);
		q1.insert(33);
		q1.insert(34);
		q1.insert(40);
		q1.insert(100);
        
        Queue<Integer> q2 = new Queue<Integer>();
		q2.insert(17);
		q2.insert(32);
		q2.insert(33);
		q2.insert(40);
		q2.insert(100);
		
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q_5(q1, q2));
        
        System.out.println();

        Queue<Integer> q3 = new Queue<Integer>();
		q3.insert(3);
		q3.insert(3);
		q3.insert(5);
		q3.insert(5);
		q3.insert(5);
		q3.insert(6);
		q3.insert(2);
		q3.insert(2);
		q3.insert(2);
		q3.insert(2);
		
        System.out.println(q3);
        System.out.println(q_6(q3));
        
	}
	public static <T> Queue<T> copy(Queue<T> q1)
    {
        Queue<T> q2 = new Queue<T>();
        Queue<T> q3 = new Queue<T>();
        while(!q1.isEmpty())
        {
            q2.insert(q1.head());
            q3.insert(q1.remove());
        }
        while(!q3.isEmpty())
        {
            q1.insert(q3.remove());
        }
        return q2;
	}
	
	public static Queue<Integer> q_1(Queue<String> q)
    {
        Queue<String> q_copy= copy(q);
        Queue<Integer> q2 = new Queue<Integer>();
        while(!q_copy.isEmpty())
        {
            boolean x = true;
            String s = q_copy.remove();
            int a=1;
            while(x && !q_copy.isEmpty())
            {
                
                if(q_copy.head()==s)
                {
                    a++;
                    q_copy.remove();
                }
                else
                {
                    
                    x = false;
                }
            }
            q2.insert(a);
            
        }
        return q2;
        
	}

public static boolean q_2(Queue<String> q)
{
    Queue<String> a = new Queue<>();

    while (!q.isEmpty())
    {
        String b = q.remove();

        if (isIn(b, a))
        {
            q.insert(b);
            while (!a.isEmpty())
                q.insert(a.remove());
            return true;
        }

        a.insert(b);
    }

    while (!a.isEmpty())
        q.insert(a.remove());

    return false;
}

public static void q_3(Queue<Integer> q)
{
    Queue<Integer> a = new Queue<Integer>();
    while (!q.isEmpty())
    {
        int x = q.remove();
        a.insert(x);
        Queue<Integer> b = new Queue<Integer>();
        while (!q.isEmpty())
        {
            int y = q.remove();
            if (y != x)
            {
                b.insert(y);
            }
        }
        while (!b.isEmpty())
        {
            q.insert(b.remove());
        }
    }
    while (!a.isEmpty())
    {
        q.insert(a.remove());
    }
}

public static void q_4(Queue<Integer> q)
{
    Queue<Integer> a = new Queue<Integer>();
    Queue<Integer> b = new Queue<Integer>();
    while (!q.isEmpty())
    {
        int x = q.remove();
        while (!a.isEmpty() && a.head() < x)
        {
            b.insert(a.remove());
        }
        b.insert(x);
        while (!a.isEmpty())
        {
            b.insert(a.remove());
        }
        while (!b.isEmpty())
        {
            a.insert(b.remove());
        }
    }
    while (!a.isEmpty())
    {
        q.insert(a.remove());
    }
}

	public static Queue<Integer> q_5(Queue<Integer> q, Queue<Integer> q2)
    {
        Queue<Integer> q_copy= copy(q);
        Queue<Integer> q2_copy= copy(q2);
        Queue<Integer> q3 = new Queue<Integer>();
        
        while(!q_copy.isEmpty() && !q2_copy.isEmpty())
        {
            if(q_copy.head()>q2_copy.head())
            {
                q3.insert(q2_copy.remove());
            }
            else
            {
                q3.insert(q_copy.remove());
            }
        }
        while(!q2_copy.isEmpty())
        {
            q3.insert(q2_copy.remove());
        }
        while(!q_copy.isEmpty())
        {
            q3.insert(q_copy.remove());
        }
        return q3;
    }
    
    
    public static int q_6(Queue<Integer> q1) 
    {
        Queue<Integer> q= copy(q1);
        int m=0;
        int s=0;
        int c=0;
        int t=0;
        while (!q.isEmpty()) 
        {
            int x = q.remove();
            
            if (x % 2 == 0) 
            {
                c++;
                t += x;
            } 
            else 
            {
                if (c > m) 
                {
                    m = c;
                    s = t;
                }
                c = 0;
                t = 0;
            }
        }
        if (c > m) 
        {
            m=c;
            s=t;
        }
        return s;
    }

}
