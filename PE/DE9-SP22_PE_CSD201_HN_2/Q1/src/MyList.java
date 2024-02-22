/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
   void addLast(Table x) {//You should write here appropriate statements to complete this function.
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

 

    void addLast(String xColor, int xArea, int xPeri) {
        //You should write here appropriate statements to complete this function. 
    if(xColor.charAt(0)=='A' ) return;
    Table x = new Table(xColor,xArea, xPeri);
    addLast(x);
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
     void addFirst(Table x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }



    void addAfter(Node p, Table x) {
        Node p1 = new Node(x);
        if (isEmpty()) {
            return;
        }
        p1.next = p.next;
        p.next = p1;
        if (p == tail) {
            tail = p1;
        }
    }

    void insert(Table x, int index) {
        int count = 0;
        Node p = head;
        while (p.next != null) {
            if (index == 0) {
                this.addFirst(x);
                break;
            }
            if (count == index - 1) {
                this.addAfter(p, x);
                break;
            }
            count++;
            p = p.next;
        }
    }
    int indexLast() {
        int index1 = 0;
        Node p = head;
        while (p.next != null) {
            index1++;
            p = p.next;
        }
        return index1;
    }
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Table x = new Table("X", 1, 2);
        Table y = new Table("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/   
        insert(y,0);
        insert(x,indexLast());
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }    

//==================================================================
     void insert2(Node x, int index) {
        int count = 0;
        Node p = head;
        while (p.next != null) {
            if (index == 0) {
                this.addFirst(x.info);
                break;
            }
            if (count == index - 1) {
                this.addAfter(p, x.info);
                break;
            }
            count++;
            p = p.next;
        }
    }
     
    void delNodeHaveValueX(int x) {
        Node p = head;
        int i = 0;
        while (p != null) {
            if (p.info.peri == x) break;
            i++;
            p = p.next;
        }
        delPosition(i);
    }
    
    void delPosition(int pos) {
        // pos must != 0 and != size() - 1        
        Node p = head;
        while (pos-- > 1) {
            p = p.next;
        }
        p.next = p.next.next;
    }

    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/     
        Node x=head.next;
        Node y=head.next.next.next;
        delPosition(1);
        delPosition(2);
        insert2(y,1);
        insert2(x,3);
                
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        reverse(0,4);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    int size(){
        int i=0;
        Node p = head;
        while (p != null){
            i++;
            p=p.next;
        }
        return i;
    }
    
    Table[] toArray(){
        int i,n;
        n=size();
        Table[] a = new Table[n];
        Node p = head;
        i =0;
        while (p!=null){
            a[i++] = new Table(p.info.color,p.info.area,p.info.peri);
            p=p.next;
        }
        return a;
    }
    void reverse(int k,int h){
        if (k>h){
            return;
        }
        int n=size();
        int i,j;
        if (k<0 || h>n-1){
            return;
        }
        Table[] a = toArray();
        i=k;
        j=h;
        Table x;
        while (i<j){
            x=a[i];
            a[i]=a[j];
            a[j]=x;
            i++;
            j--;
        }
        clear();
        for (i=0;i<n;i++)
        {
            addLast(a[i]);
        }
    }
}
