import java.util.*;
public class Main
{
    // node 
    private class Node
    {
        int data;
        Node next;
    }
    
    //linked list content
    private Node head;
    private Node tail;
    private int size=0;
    
    //adding nodes
    public void addnode(int d)
    {
        Node node = new Node();
        
        node.data=d;
        node.next=null;
        
        //for empty list
        if(this.size==0)
        {
   
            this.head=node;
            this.tail=node;
            this.size++;
        }
        
        else
        {
            this.tail.next=node;
            this.tail=node;
            this.size++;
        }
    }
    
    //display the list
    public void displaylist()
    {
        if(this.size!=0)
        {
            Node node=this.head;
            while(node!=null)
            {
                System.out.println(node.data);
                node=node.next;
            }
        }
        else
        {
            System.out.println("empty list");
        }
    }
    
    public void addbeg(int d)
    {
        Node node=new Node();
        
        node.data=d;
        if(this.size!=0)
        {
            node.next=this.head;
            this.head=node;
            this.size++;
        }
        else
        {
            node.next=null;
            this.head=this.tail=node;
            this.size++;
        }
    }
    
    public int getnode(int index)
    {
        if(this.size==0 || this.size<=index)
        {
            System.out.println("do not exist");
            return (-1);
        }
        else
        {
            Node node=this.head;
            
            for(int i=0;i<index;i++)
            {
                node=node.next;
            }
            
            return(node.data);
            //System.out.println(node.data);
        }
    }
    
    public void addatanyindex(int d,int index)
    { 
        if(index==0)
        {
            addbeg(d);
        }
        
        else if(index==size)
        {
            addnode(d);
        }
        
        else if(index>size)
        {
            System.out.println("invalid index");
        }
        
        else
        {
        Node nice=new Node();
        nice.data=d;
        
        
        Node node=this.head;
        
        for(int i=0;i<index-1;i++)
        {
            node=node.next;
        }
        
        nice.next=node.next;
        node.next=nice;
        this.size++;
        }
        
        
    }
    
    public void removebeg()
    {
        if(this.size==0)
        System.out.println("empty list");
        
        else if(this.size==1)
        {
            this.tail=this.head=null;
            this.size=0;
        }
        
        else
        {
            this.head=this.head.next;
            this.size--;
        }
    }
    
    
    public void removeend()
    {
        if(this.size==0)
        System.out.println("empty list,, removall not possible");
        
        else if(this.size==1)
        {
        this.head=this.tail=null;
        this.size--;
        }
        
        else
        {
            Node node=this.head;
            while(node.next!=tail)
            {
                node=node.next;
            }
            node.next=null;
            tail=node;
            this.size--;
        }
    }
    
    public void removeany(int index)
    {
        if(this.size==0 || this.size==index)
        System.out.println("please enter valid option");
        
        else if(index==0)
        removebeg();
        
        else if(index==size-1)
        removeend();
        
        else
        {
            Node node=this.head;
            for(int i=0;i<index-1;i++)
            {
                node=node.next;
            }
            
            node.next=node.next.next;
            this.size--;
        }
        
    }
    
    
    public void displayrev()
    {
        Node node=new Node();
        
        for(int i=size-1;i>=0;i--)
        {
            this.getnode(i);
            //System.out.println(node.data);
        }
    }
    
    public void dorevptrrec(Main list2,Node zero,Node one, Node two)
    {
        
        if(two==null)
        {
           one.next=zero;
           list2.head=one;
           return;
        }
        
        one.next=zero;
        zero=two.next;
        dorevptrrec(list2,one,two,zero);
    }
    
    public void revlistpointerrec(Main list1)
    {
        
        Node z=list1.head;
        Node o=z.next;
        Node t=o.next;
        z.next=null;
        list1.tail=z;
        
        dorevptrrec(list1,z,o,t);
    }
    
    public void mergesortedlist(Main list2)
    {
        int m=0;//this.size;
        int n=0;//list2.size;
        
        while(m<this.size && n<list2.size)
        {
            if(this.getnode(m)<list2.getnode(n))
            {
                System.out.println(this.getnode(m));
                m++;
            }
            else
            {
                System.out.println(list2.getnode(n));
                n++;
            }
        }
        
        if(m==this.size)
        {
            for(int i=n;i<list2.size;i++)
            System.out.println(list2.getnode(i));
        }
        
        else
        {
            for(int i=m;i<this.size;i++)
            System.out.println(this.getnode(i));
        }
        
        //System.out.println(m);
        //System.out.println(n);
    }
    
    
    
    public static void main(String args[])
    {
        Main list=new Main();
        Main list1=new Main();
        
        /*list.addbeg(0);
        list.addnode(10);
        list.addnode(20);
        list.addnode(30);
        list.addbeg(0);
        list.addnode(40);
        list.addnode(50);
        list.addatanyindex(90,3);*/
        
        list.addbeg(0);
        list.addnode(10);
        list.addnode(20);
        list.addnode(30);
        //list.addbeg(0);
        list.addnode(40);
        list.addnode(50);
        
        
        
        list1.addbeg(1);
        list1.addnode(6);
        list1.addnode(11);
        list1.addnode(21);
        list1.addnode(26);
        list1.addnode(31);
        list1.addnode(141);
        list1.addnode(501);
        
        //list.removebeg();
        
        //list.removeany(4);

        //list.displaylist();
        
        //System.out.println(list.size);
        
        //list.getnode(6);
        
        //list.revlistpointerrec(list);
        
        //list.displayrev();
        
        //list.displaylist();
        
        list.mergesortedlist(list1);
        
        
    }
}

