// /ChefAndDigitJumps
//Problem LInk : https://www.codechef.com/LRNDSA08/problems/DIGJUMP
import java.io.*;
import java.util.*;
public class ChefAndDigitJumps{
	static int t,n;
	static int[] arr;
	static StringBuilder ans=new StringBuilder();
	static long mod=1000000007l;
    static int max=Integer.MAX_VALUE,min=Integer.MIN_VALUE;
    static long maxl=Long.MAX_VALUE,minl=Long.MIN_VALUE;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> adj[];
    static boolean[] vis;
    static int[] dist;
    static int[] lastIndex;
    public static void main(String[] args) throws IOException{
    	st=new StringTokenizer(br.readLine());
    	int t=1;
    	StringBuilder sb=new StringBuilder();
    	o:
    	while(t-->0)
    	{
    		String s=s();
    		int len=s.length();
    		adj=new ArrayList[len];
    		vis=new boolean[len];
    		dist=new int[len];
    		for(int i=0;i<len;i++){
    			adj[i]=new ArrayList<>();
    		}
    		lastIndex=new int[10];
    		for(int i=0;i<len;i++){    			
    			int indx=s.charAt(i)-'0';
    			lastIndex[indx]=i;
    		}
            adj[0].add(1);
    		for(int i=1;i<len-1;i++){
                adj[i].add(i-1);
                adj[i].add(i+1);
            }
            adj[len-1].add(len-2);		
    		
    		sb.append(bfs(0,len-1,s));
    		if(t!=0)
    		sb.append("\n");
    	}
    	p(sb);
    }
    static int bfs(int src,int dest,String s){
    	Queue<Integer> queue = new LinkedList<>();    	
        queue.add(src);
    	vis[src]=true;    	
    	dist[src]=0;
    	while(!queue.isEmpty()){
    		int rp=queue.poll();
    		if(rp==dest){
    			return dist[rp];
    		}
            int pos=lastIndex[s.charAt(rp)-'0'];
            if(!vis[pos]){
                queue.add(pos);
                vis[pos]=true;
                dist[pos]=dist[rp]+1;
            }
    		for(Integer nbrs:adj[rp]){                
    			if(!vis[nbrs]){
    				queue.add(nbrs);
    				vis[nbrs]=true;
    				dist[nbrs]=dist[rp]+1;
    			}
    		}
    	}
    	return dist[dest];
    }
    static int max(int a,int b){return a>b?a:b;}
    static int min(int a,int b){return a<b?a:b;}
    static int abs(int a){return Math.abs(a);}
    static long max(long a,long b){return a>b?a:b;}
    static long min(long a,long b){return a<b?a:b;}
    static long abs(long a){return Math.abs(a);}
    static int sq(int a){return (int)Math.sqrt(a);}
    static long sq(long a){return (long)Math.sqrt(a);}
    static long gcd(long a,long b){return b==0l?a:gcd(b,a%b);}
     static int fib(int n){return (int)Math.round(Math.pow((1+sq(5))/2,n)/sq(5));} 
    
    static int[] fac(int n)
    {
        int bo[]=new int[n+1];
        for(int x=1;x<=n;x++)for(int y=x;y<=n;y+=x)bo[y]++;
        return bo;
    }
    static long div(long a,long b,long m) 
    {
        long r=1l;
        a%=m;  
        while(b>0)
        {
            if((b&1)==1)r=(r*a)%m; 
            b>>=1;
            a=(a*a)%m;  
        } 
        return r; 
    }
    static int i()throws IOException
    {
        if(!st.hasMoreTokens()) st=new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
    static long l()throws IOException
    {
        if(!st.hasMoreTokens())st=new StringTokenizer(br.readLine());
        return Long.parseLong(st.nextToken());
    }
    static String s()throws IOException
    {
        if(!st.hasMoreTokens())st=new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static double d()throws IOException
    {
        if(!st.hasMoreTokens())st=new StringTokenizer(br.readLine());
        return Double.parseDouble(st.nextToken());
    }
    static void p(Object p){System.out.print(p);}
    static void p(String p){System.out.print(p);}
    static void p(int p){System.out.print(p);}
    static void p(double p){System.out.print(p);}
    static void p(long p){System.out.print(p);}
    static void p(char p){System.out.print(p);}
    static void p(boolean p){System.out.print(p);}
    static void pl(Object p){System.out.println(p);}
    static void pl(String p){System.out.println(p);}
    static void pl(int p){System.out.println(p);}
    static void pl(char p){System.out.println(p);}
    static void pl(double p){System.out.println(p);}
    static void pl(long p){System.out.println(p);}
    static void pl(boolean p){System.out.println(p);}
    static void pl(){System.out.println();}
    static int[] ari(int n)throws IOException
    {
        int ar[]=new int[n];
        if(!st.hasMoreTokens())st=new StringTokenizer(br.readLine());
        for(int x=0;x<n;x++)ar[x]=Integer.parseInt(st.nextToken());
        return ar;
    }
    static int[][] ari(int n,int m)throws IOException
    {
        int ar[][]=new int[n][m];
        for(int x=0;x<n;x++)
        {
        	if(!st.hasMoreTokens())st=new StringTokenizer(br.readLine());
            for(int y=0;y<m;y++)ar[x][y]=Integer.parseInt(st.nextToken());
        }
        return ar;
    }
    static long[] arl(int n)throws IOException
    {
        long ar[]=new long[n];
        if(!st.hasMoreTokens())st=new StringTokenizer(br.readLine());
        for(int x=0;x<n;x++) ar[x]=Long.parseLong(st.nextToken());
        return ar;
    }
    static long[][] arl(int n,int m)throws IOException
    {
        long ar[][]=new long[n][m];
        for(int x=0;x<n;x++)
        {
        	if(!st.hasMoreTokens())st=new StringTokenizer(br.readLine());
            for(int y=0;y<m;y++)ar[x][y]=Long.parseLong(st.nextToken());
        }
        return ar;
    }
    static String[] ars(int n)throws IOException
    {
        String ar[]=new String[n];
        if(!st.hasMoreTokens())st=new StringTokenizer(br.readLine());
        for(int x=0;x<n;x++) ar[x]=st.nextToken();
        return ar;
    }
    static double[] ard(int n)throws IOException
    {
        double ar[]=new double[n];
        if(!st.hasMoreTokens())st=new StringTokenizer(br.readLine());
        for(int x=0;x<n;x++)ar[x]=Double.parseDouble(st.nextToken());
        return ar;
    }
    static double[][] ard(int n,int m)throws IOException
    {
        double ar[][]=new double[n][m];
        for(int x=0;x<n;x++)
        {
        	if(!st.hasMoreTokens())st=new StringTokenizer(br.readLine());
            for(int y=0;y<m;y++)ar[x][y]=Double.parseDouble(st.nextToken());
        }
        return ar;
    }
    static char[] arc(int n)throws IOException
    {
        char ar[]=new char[n];
        if(!st.hasMoreTokens())st=new StringTokenizer(br.readLine());
        for(int x=0;x<n;x++)ar[x]=st.nextToken().charAt(0);
        return ar;
    }
    static char[][] arc(int n,int m)throws IOException
    {
        char ar[][]=new char[n][m];
        for(int x=0;x<n;x++)
        {
            String s=br.readLine();
            for(int y=0;y<m;y++)ar[x][y]=s.charAt(y);
        }
        return ar;
    }
    static void p(int ar[])
    {
        StringBuilder sb=new StringBuilder(11*ar.length);
        for(int a:ar)
        {
        	sb.append(a);
        	sb.append(' ');
        }
        System.out.println(sb);
    }
    static void p(int ar[][])
    {
        StringBuilder sb;
        for(int a[]:ar)
        {
            sb=new StringBuilder(2*a.length);
            for(int aa:a)
            {
            	sb.append(aa);
            	sb.append(' ');
            }
            System.out.println(sb);
        }
    }
    static void p(long ar[])
    {
        StringBuilder sb=new StringBuilder(20*ar.length);
        for(long a:ar)
        {
        	sb.append(a);
        	sb.append(' ');
        }
        System.out.println(sb);
    }
    static void p(long ar[][])
    {
        StringBuilder sb;
        for(long a[]:ar)
        {
            sb=new StringBuilder(2*a.length);
            for(long aa:a)
            {
            	sb.append(aa);
            	sb.append(' ');
            }
            System.out.println(sb);
        }
    }
    static void p(String ar[])
    {
        StringBuilder sb=new StringBuilder(2*ar.length);
        for(String a:ar)
        {
        	sb.append(a);
        	sb.append(' ');
        }
        System.out.println(sb);
    }
    static void p(double ar[])
    {
        StringBuilder sb=new StringBuilder(20*ar.length);
        for(double a:ar)
        {
        	sb.append(a);
        	sb.append(' ');
        }
        System.out.println(sb);
    }
    static void p(double ar[][])
    {
        StringBuilder sb;
        for(double a[]:ar)
        {
            sb=new StringBuilder(4*a.length);
            for(double aa:a)
            {
            	sb.append(aa);
            	sb.append(' ');
            }
            System.out.println(sb);
        }
    }
    static void p(char ar[])
    {
        StringBuilder sb=new StringBuilder(2*ar.length);
        for(char aa:ar)
        {
        	sb.append(aa);
        	sb.append(' ');
        }
        System.out.println(sb);
    }
    static void p(char ar[][])
    {
        StringBuilder sb;
        for(char a[]:ar)
        {
            sb=new StringBuilder(2*a.length);
            for(char aa:a)
            {
            	sb.append(aa);
            	sb.append(' ');
            }
            System.out.println(sb);
        }
    }
}