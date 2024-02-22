/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

public class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) {  //do not edit this function
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }

    void fdispAdj(RandomAccessFile f) throws Exception {
        int i, j;
        f.writeBytes("n = " + n + "\r\n");
        for (i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for (j = 0; j < n; j++) {
                f.writeBytes("  " + a[i][j]);
            }
        }
        f.writeBytes("\r\n");
    }

    void breadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }

    void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }
    }

    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
     int count1=0;
  void depth2(boolean [] visited,int k,int min,int max, RandomAccessFile f) throws Exception {
    count1++;
      if (count1>=min && count1<=max) {
          fvisit(k, f);
      }
    visited[k]=true;
    for(int i=0;i<n;i++) {
      if(!visited[i] && a[k][i]>0) depth2(visited,i,min,max,f);
     }
   }
  void depth2(int k,int min,int max, RandomAccessFile f) throws Exception {
    boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depth2(visited,k,min,max,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depth2(visited,i,min,max,f);
   }

    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(0, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        depth2(0,2,6,f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=================================================================
    void f2() throws Exception {
        loadData(13);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f2.txt 
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f2.txt  
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> setS1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        ArrayList<Integer> setS2 = new ArrayList<>();
        dijkstra(path1, setS1, 2, 5);
        dijkstra(path2, setS2, 0, 6);
        dijkstra(0,6,f);

      for (int i = setS2.size() - 4; i < setS2.size(); i++) {
            fvisit2(setS2.get(i),f);
        }
      f.writeBytes("\n");

      dijkstra(2,5,f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
  
    void fvisit2(int i, RandomAccessFile f) throws Exception {
        f.writeBytes( v[i]+" ");
    }
 void dijkstra(int fro, int to, RandomAccessFile f) throws Exception {
        int i, j, k, t, INF;
        INF = 999;
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }

        int[] ss = new int[n];
        int[] pp = new int[n];
        int m, r;

        j = 0;

        // select fro into the set S
        S[fro] = true;
        ss[0] = fro;
        while (true) {
            k = -1;
            t = INF;
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] < t) {
                    k = i;
                    t = d[i];
                }
            }
            if (k == -1) {
                return; 
            }           
            S[k] = true;
            j++;
            ss[j] = k;
            if (k == to) {
                break;
            }
            // Recalculate d[i]
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        m = j;
        Stack s = new Stack();
        i = to;
        while (true) {
            s.push(i);
            if (i == fro) {
                break;
            }
            i = p[i];
        }
        j = 0;
        while (!s.isEmpty()) {
            i = s.pop();
            pp[j++] = i;
        }
        r = j;
        f.writeBytes("" + v[pp[0]]);
        for (i = 1; i < r; i++) {
            f.writeBytes(" " + v[pp[i]]);
        }
        f.writeBytes("\r\n");

    }
  void dijkstra(ArrayList<Integer> path,ArrayList<Integer> set,int fro, int to) {
        int INF = 99;
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        int i, j, k, t;
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }
        S[fro] = true;

        while (true) {
            t = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] < t) {
                    t = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                System.out.println("No solution");
                return;
            }
            // select k into the set S
            S[k] = true;
            set.add(k);
            if (k == to) {
                break;
            }
            // update data
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
   //     System.out.println("The shortest distance is " + d[to]);
        Stack s = new Stack();
        i = to;
        while (true) {
            s.push(i);
            if (i == fro) {
                break;
            }
            i = p[i];
        }
        i = s.pop();
      //  System.out.println("Th shotest path is");
   //     System.out.print(i);
//        path.add(i);
//        while (!s.isEmpty()) {
//            i = s.pop();
//            path.add(i);
     //       System.out.print(" -> " + i);
        }
   //     System.out.println();
    }

    

