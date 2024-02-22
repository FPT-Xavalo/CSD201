/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

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

    void loadData(int k) { //do not edit this function
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
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
     void addLast(Boo x) {//You should write here appropriate statements to complete this function.
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

 
    void addLast(String xForest, int xRate, int xSound) {
        //You should write here appropriate statements to complete this function.
   if(xForest.charAt(0)=='A') return;
    Boo x = new Boo(xForest,  xRate,xSound);
    addLast(x);
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
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
     void addFirst(Boo x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }



    void addAfter(Node p, Boo x) {
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

    void insert(Boo x, int index) {
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
        Boo x, y;
        x = new Boo("X", 1, 2);
        y = new Boo("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        insert(y,1);
        insert(x,2);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    
    void delNodeHaveValueX(int x) {
        Node p = head;
        int i = 0;
        while (p != null) {
            if (p.info.rate == x) break;
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
        delPosition(1);
        delPosition(1);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    Node pos(int k){
        int i=0;
        Node p = head;
        while(p!=null){
            if (i==k){
                return (p);
            }
            i++;
            p=p.next;
        }
        return (null);
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
     void sortByAge(int k,int h){
        if (k>h){
            return;
        }
        if (k<h){
            k=0;
        }
        int n=size();
        if (h>n-1){
            h=n-1;
        }
        Node u=pos(k);
        Node v=pos(h+1);
        Node pi,pj ;
        Boo x;
        pi=u;
        while (pi !=v){
            pj=pi.next;
            while (pj != v){
                if (pj.info.sound<pi.info.sound)
                {
                    x=pi.info;
                    pi.info=pj.info;
                    pj.info=x;
                }
                pj=pj.next;
            }
            pi=pi.next;          
        }
    }
    
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
        sortByAge(0,4);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
