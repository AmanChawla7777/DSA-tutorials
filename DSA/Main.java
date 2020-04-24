import java.util.*;

public class Main
{
    private class node
    {
        int data;
        ArrayList<node> children=new ArrayList<>();
    }
    
    private int size;
    private node root;
    
    private void createtree()
    {
        this.root=construct(null,0);
    }
    
    private node construct(node parent,int i)
    {
        Scanner sc= new Scanner(System.in);
        if(parent==null)
        System.out.println("enter root data");
        else
        System.out.println("enter data for child"+i+"with parent"+parent.data);
        
        node child=new node();
        this.size++;
        
        child.data=sc.nextInt();
        
        System.out.println("no of children for this");
        int cnum=sc.nextInt();
        
        for(int j=0;j<cnum;j++)
        {
            node baby=construct(child,j);
            child.children.add(baby);
        }
        
        return child;
    }
    
    public void display(node current)
    {
    System.out.print(current.data);
    System.out.print("->");
    for(int i=0;i<current.children.size();i++)
    System.out.print(current.children.get(i).data+" ");
    System.out.println();
    
    for(int i=0;i<current.children.size();i++)
    display(current.children.get(i));
    }

        int count=0;
    
    public void findsize(node current)
    {
        count++;
        
        if(current.children.size()==0)
        return;
        
        for(int i=0;i<current.children.size();i++)
        findsize(current.children.get(i));
    }
    
    public int findmax(node current)
    {
        int max=current.data;
        for(int i=0;i<current.children.size();i++)
        {
            int tmax=findmax(current.children.get(i));
            if(tmax>max)
            max=tmax;   
        }
        return max;
    }
    
    public int findheight(node current)
    {
        int max=-1;
        
        for(int i=0;i<current.children.size();i++)
        {
            int cheight=findheight(current.children.get(i));
            
            if(cheight>max)
            max=cheight;
        }
        
        return max+1;
    }
    
    public void preorder(node current)
    {
        System.out.println(current.data);
        System.out.println();
        
        for(int i=0;i<current.children.size();i++)
        {
            preorder(current.children.get(i));
        }
    }
    
    public void postorder(node current)
    {
    
        for(int i=0;i<current.children.size();i++)
        {
            postorder(current.children.get(i));
        }
        
        System.out.println(current.data);
        System.out.println();
        
    }
    
    public void levelorder()
    {
        LinkedList<node> queue=new LinkedList();
        LinkedList<Integer> num= new LinkedList();
        queue.addFirst(this.root);
        num.addFirst(0);
        while(queue.size()!=0)
        {
            node recent=queue.get(0);
            int  x=num.get(0);
            for(int i=0;i<recent.children.size();i++)
            {
                queue.add(recent.children.get(i));
                num.add(x+1);
            }
            
            System.out.print(recent.data);
            
            if(num.size()>1)
            {
            if(num.get(0)==num.get(1))
            System.out.print(" ");
            else
            System.out.println();
            }
            
            queue.remove(0);
            num.remove(0);
        }
    }
    
    public void levelorderzigzag()
    {
        LinkedList<node> queue=new LinkedList();
        LinkedList<Integer> num= new LinkedList();
        LinkedList<node> queue1=new LinkedList();
        LinkedList<Integer> num1= new LinkedList();
        queue.addFirst(this.root);
        num.addFirst(0);
        queue1.addFirst(this.root);
        num1.addFirst(0);
    
    
        while(queue.size()!=0)
        {
            node recent=queue.get(0);
            int  x=num.get(0);
            for(int i=0;i<recent.children.size();i++)
            {
                queue.add(recent.children.get(i));
                num.add(x+1);
                queue1.add(recent.children.get(i));
                num1.add(x+1);
            }
            queue.remove(0);
            num.remove(0);
        }
        
        for(int i=0;i<num1.size();i++)
        {
            if(num1.get(i)%2==0)
            {
                System.out.print(queue1.get(i).data);
                System.out.print(" ");
            }
            else if(i+1<num1.size())
            {
            if(num1.get(i)%2!=0 && num1.get(i+1)%2==0)
            {
                
                System.out.println();
                int j=i;
                while(num1.get(j)%2!=0 && num1.get(j-1)%2!=0)
                {
                    System.out.print(queue1.get(j).data);
                    System.out.print(" ");
                    j--;
                }
                System.out.print(queue1.get(j).data);
                System.out.println();
            }
            }
            else if(i+1==num1.size())
            {
                System.out.println();
                int j=i;
                while(num1.get(j)%2!=0 && num1.get(j-1)%2!=0)
                {
                    System.out.print(queue1.get(j).data);
                    System.out.print(" ");
                    j--;
                }
                System.out.print(queue1.get(j).data);
                System.out.println();
            }
        }
    }
    public void mirrorimagebin(node current)
    {
        for(int i=0;i<current.children.size();i++)
        mirrorimagebin(current.children.get(i));
        
        if(current.children.size()!=0)
        {
        node tempo=current.children.get(0);
        
        for(int i=0;i<current.children.size()-1;i++)
        {
            current.children.set(i,current.children.get(i+1));
        }
        current.children.set(current.children.size()-1,tempo);
        }
    }


    public void removelaves(node current)
    {
        //node tempo=new node();
        for(int i=0;i<current.children.size();i++)
        {
            if(current.children.get(i).children.size()==0)
            current.children.remove(current.children.get(i));
            else
            removelaves(current.children.get(i));
        }
    }
    
    public node linearize(node current)
    {
        if(current.children.size()==0)
        {
            return current;
        }
        
        node finalone=new node();
        finalone.data=current.data;
        node tempptr=finalone;
        
        for(int i=0;i<current.children.size();i++)
        {
           node justcome= linearize(current.children.get(i));
           tempptr.children.add(justcome);
           
           tempptr=tempptr.children.get(0);
           
        
        }
         return finalone;
    }
    
    public void linearizedisplay()
    {
        node thebigshow=linearize(this.root);
        node iterator=thebigshow;
        while(iterator.children.size()!=0)
        {
            System.out.println(iterator.data);
            iterator=iterator.children.get(0);
        }
    }
    
    //int checkvar=1;
    
    public boolean checkisomorphic(node pone, node ptwo)
    {
        /*if(checkvar==0)
        {
            return false;
        }*/
        
        else if(pone.children.size()!=ptwo.children.size())
        {
            //checkvar=0;
            return false;
        }
        
        else
        {
            for(int i=0;i<pone.children.size();i++)
            {
                if(checkvar==0)
                break;
                
                checkisomorphic(pone.children.get(i),ptwo.children.get(i));
            }
        }
    }
    
    public void checkisomorphicresult(node pone,node ptwo)
    {
        boolean x=this.checkisomorphic(pone,ptwo);
        
        System.out.println(x);
    }
    
    
    public void checksymmetry(node n1,node n2)
    {
        for(int i=0;i<n1.size;i++)
        {
            if()
        }
    }
    
    public void checksymm(node Node)
    {
        for(int i=0;i<(Node.children.size()+1)/2;i++)
        {
            checksymmetry(Node.children.get(i),Node.children.get(Node.children.size()-1-i));
        }
    }

    public static void main(String args[])
    {
    Main tree1=new Main();
    tree1.createtree();
    
    Main tree2=new Main();
    tree2.createtree();
    
    
    
    //tree1.findsize(tree1.root);
    //System.out.println(tree1.count);
    //tree1.postorder(tree1.root);
    //System.out.println(yo);
    
    //tree1.mirrorimagebin(tree1.root);
    //tree1.mirrorimagebin(tree1.root);

    //tree1.removelaves(tree1.root);

    //tree1.display(tree1.root);
    
    //tree1.checkisomorphicresult(tree1.root,tree2.root);
    
    tree1.checksymm(tree1.root);
    
    //tree1.linearizedisplay();
    //tree1.levelorderzigzag();
    }
    
}