import java.util.*;
import java.lang.*;

public class Main
{
    public int fibodpmem(int n,int a[])
    {
        if(n==0 || n==1)
        return n;
        
        else if(a[n]!=0)
        {
            return a[n];
        }
        
        else
        {
            int m=fibodpmem(n-1,a)+fibodpmem(n-2,a);
            a[n]=m; 
            return m;
        }
        
    }
    
    public void fibodptab(int n)
    {
        int f[]=new int[n+1];
        
        f[0]=0;
        f[1]=1;
        
        for(int x=2;x<=n;x++)
        {
            f[x]=f[x-1]+f[x-2];
        }
        
        System.out.println(f[n]);
    }
    
    public int countpathmem(int s,int d, int a[])
    {
        if(s>d)
            return 0;
        
        else if(s==d)
           return 1;
           
        else if(a[s]!=0)
        {
            return a[s];
        }
        
        else
        {
            int x=0;
            
            for(int i=1;i<=6;i++)
            {
                //x+=  countpathmem(s+i,d);//,a);

                if(s+i<=d)
                {
                  x+=  countpathmem(s+i,d,a);
                }
            }
            
            a[s]=x;
            
            return x;
            
        }
    }
    
    public void countpathtab(int n)
    {
        int f[]=new int[n+1];
        
        f[n]=1;
        //f[n-1]=1;
        //f[n-2]=2;
      //  f[n-3]=4;
    //    f[n-4]=8;
        //f[n-5]=16;
        //f[n-6]=32;
        
        for(int x=n-1;x>=0;x--)
        {
            int t=0;
            for(int i=1;i<=6;i++)
            {
                if(x+i<=n)
                t+=f[x+i];
            }
            f[x]=t;
        }
        
        System.out.println(f[0]);
    }
    
   /*public void countpathtabslider(int n)
    
    {
        int a=1,b=1,c=2,d=4,e=8,f=16;
        
        for(int i=n-6;i>=0;i--)
        {
            int x=a+b+c+d+e+f;
            
            a=b;
            b=c;
            c=d;
            d=e;
            e=f;
            f=x;
        }
        

        System.out.println(f);
    }*/
    
    public int countmpathm(int sr,int sc, int dr, int dc,int a[][])
    {
        if(sr==dr && sc==dc)
        return 1;
        
        //else if(sr>dr || sc>dc)
        //return 0;
        
        
        else if(a[sr][sc]!=0)
        {
            return a[sr][sc];
        }
        
        else
        {
            int p1=0;
            int p2=0;
            
            if(sr+1<=dr)
            p1=countmpathm(sr+1,sc,dr,dc,a);
            
            if(sc+1<=dc)
            p2=countmpathm(sr,sc+1,dr,dc,a);
            
            int p=p1+p2;
            
            a[sr][sc]=p;
            
            return p;
        }
    }
    
    public void countmpathtab(int sr,int sc, int dr, int dc)
    {
        int a[][]=new int[dr+1][dc+1];
        
        a[dr][dc]=1;
        
        for(int i=dr;i>=0;i--)
        {
            for(int j=dc;j>=0;j--)
            {
                int x=0;
              if(i==dr && j==dc)
              {
                  continue;
              }
              else
              {
                if(i+1>dr)
                x+=a[i][j+1];
                
                else if(j+1>dc)
                x+=a[i+1][j];
                
                else
                {
                    x+=a[i+1][j]+a[i][j+1];
                }
              }
              a[i][j]=x;
            }
        }
        
        System.out.println(a[0][0]);
    }
    
    public int mincostpathmem(int sr, int sc, int dr,int dc, int a[][], int f[][])
    {
        if(sr==dr && dc==sc)
        return 0;
        
        else if(f[sr][sc]!=0)
        {
            return f[sr][sc];
        }
        
        else
        {
            int p=-1;
            int q=-1;
            
            
            int p1=0;
            int q1=0;
            
            if(sr+1<=dr)
            {
                p=mincostpathmem(sr+1,sc,dr,dc,a,f);
            }
            
            if(sc+1<=dc)
            {
                q=mincostpathmem(sr,sc+1,dr,dc,a,f);
            }
            
            //else
            //{
              //  p=mincostpathmem(sr+1,sc,dr,dc,a,f);
                //q=mincostpathmem(sr,sc+1,dr,dc,a,f);
            //}
            
            
            
            if(p>=0 && q==-1)
            {
                p1=p+a[sr+1][sc];
                f[sr][sc]=p1;
            }
            
            else if(q>=0 && p==-1)
            {
                q1=q+a[sr][sc+1];
                f[sr][sc]=q1;
            }
            
            else
            {
                p1=p+a[sr+1][sc];
                q1=q+a[sr][sc+1];
                
                if(p1<=q1)
                f[sr][sc]=p1;
                else
                f[sr][sc]=q1;
            }
            
            return f[sr][sc];
            
        }
        
    }
    
    
    public int maxsqsize(int a[][],int n)
    {
        int f[][]=new int[n][n];
        
        int max=0;
        
        for(int i=0;i<n;i++)
        {
            f[i][n-1]=a[i][n-1];
            if(f[i][n-1]>max)
            max=f[i][n-1];
            
            f[n-1][i]=a[n-1][i];
            if(f[n-1][i]>max)
            max=f[n-1][i];
        }
        
        for(int i=n-2;i>=0;i--)
        {
            for(int j=i;j>=0;j--)
            {
                if(a[i][j]==0)
                {
                    f[i][j]=0;
                }
                
                else
                {
                    int temp = f[i+1][j] <= f[i][j+1] ? f[i+1][j]:f[i][j+1];
                    int result = f[i+1][j+1] <= temp ? f[i+1][j+1] :temp;
                    f[i][j]=result+1;
                    if(f[i][j]>max)
                    max=f[i][j];
                }
                
                if(a[j][i]==0)
                {
                    f[j][i]=0;
                }
                else
                {
                    int temp = f[j+1][i] <= f[j][i+1] ? f[j+1][i]:f[j][i+1];
                    int result = f[j+1][i+1] <= temp ? f[j+1][i+1] :temp;
                    f[j][i]=result+1;
                    if(f[j][i]>max)
                    max=f[j][i];
                }
                
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(f[i][j]);
            }
            System.out.println();
        }
        
        return f[0][0];
    }
    
    public void goldmine(int a[][], int n)
    {
        int f[][]=new int[n][n];
        
        for(int i=0;i<n;i++)
        {
            f[i][n-1]=a[i][n-1];
            //System.out.println(f[i][n-1]+1);
        }
        
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                int x=0,y=0;
                if(j==0)
                {
                    x=f[j][i+1]<=f[j+1][i+1]?f[j+1][i+1]:f[j][i+1];
                    f[j][i]=x+a[j][i];
                }
                
                else if(j==n-1)
                {
                    x=f[j][i+1]<=f[j-1][i+1]?f[j-1][i+1]:f[j][i+1];
                    f[j][i]=x+a[j][i];
                }
                
                else
                {
                    x=f[j][i+1]<=f[j+1][i+1]?f[j+1][i+1]:f[j][i+1];
                    y=x<=f[j-1][i+1]?f[j-1][i+1]:x;
                    
                    f[j][i]=y+a[j][i];
                }
            }
        }
        
        int max=0;
        int row=0;
        for(int i=0;i<n;i++)
        {
            if(f[i][0]>max)
            {
               max=f[i][0];
               row=i;
            }
        }
        System.out.println(max);
        System.out.println(row);
    }
    
    public int goldminemem(int sr,int sc,int dr,int dc,int a[][],int f[][])
    {
        int p=0,q=0,r=0;
        
        if(sc==dc)
        return(a[sr][sc]);
        
        else if(f[sr][sc]!=0)
        {
            return f[sr][sc];
        }
        
        else
        {
            p=goldminemem(sr,sc+1,dr,dc,a,f);
            
            
            if(sr!=0)
            {
                q=goldminemem(sr-1,sc+1,dr,dc,a,f);
            }
            
            if(sr!=dr)
            {
                r=goldminemem(sr+1,sc+1,dr,dc,a,f);
            }
        }
        
        int tmax=p>=q?p:q;
        int max=tmax>=r?tmax:r;
        
        f[sr][sc]=max+a[sr][sc];
        
        return f[sr][sc];
    }
    
	public static void main(String[] args) 
	{
		Main obj=new Main();
		
		/*int a[]=new int[11];
		int x=obj.fibodpmem(10,a);
		System.out.println(x);*/
		
		//obj.fibodptab(10);

		/*int a[]=new int[51];
		int x=obj.countpathmem(0,50,a);
		System.out.println(x);
		
		//obj.countpathtab(30);
		
		int a[][]=new int[21][21];
		int x=obj.countmpathm(0,0,20,20,a);
		System.out.println(x);*/
		
		//obj.countmpathtab(0,0,15,15);
		
		int a[][]=new int[5][5];
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("fill 2d cost path array");
		for(int i=0;i<5;i++)
		{
		    for(int j=0;j<5;j++)
		    {
		        a[i][j]=sc.nextInt();
		        /*double x=Math.random()*2;
		        int y=(int)x;
		        a[i][j]=y;
		        
		        System.out.print(a[i][j]);
		        System.out.print(" ");*/
		    }
		    System.out.println();
		    
		}
		
		
		
		long v1=System.currentTimeMillis();
		
		//int mc=obj.mincostpathmem(0,0,2,2,a,new int[3][3]);
		//int mc=obj.maxsqsize(a,5);
		
		//obj.goldmine(a,5);
		int maximum=0;
		
		for(int i=0;i<5;i++)
		{
		    int res=obj.goldminemem(i,0,4,4,a,new int[5][5]);
		    if(maximum<res)
		    maximum=res;
		}
		
		System.out.println(maximum);
		
		long v2=System.currentTimeMillis();
		
		//System.out.println(mc);
		
		System.out.println(v2-v1);
		
	}
}