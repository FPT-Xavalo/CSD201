/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
   void addLast(Bike x) {//You should write here appropriate statements to complete this function.
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

  void addLast(String xBrand, int xColor, int xWeight) {
    //You should write here appropriate statements to complete this function.
    if(xBrand.charAt(0)=='A') return;
    Bike x = new Bike(xBrand,  xColor, xWeight);
    addLast(x);
   }

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void f2() throws Exception {
     clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Bike x, y;
     x = new Bike("X",1,2);
     y = new Bike("Y",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
         insert(y,2);

         insert(x,indexLast());
    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
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
  void addFirst(Bike x){
       head = new Node(x,head);
       if(tail==null) tail=head;
     }


    void addAfter(Node p, Bike x) {
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
 void insert(Bike x, int index) {
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
//==================================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

    dele(6);
 
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }
void dele(Node q) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;//q is not found
        }
        if (f == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }

       void dele(int xPrice) {
             int dem=0;
        Node p = head;
        while(p!=null){
            if (p.info.weight < xPrice){
                dem++;
            } 
            
             if (dem==2){  
             
                 dele(p);
                 break;
              }
             p=p.next;
        }   

       
    }
//==================================================================
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

sort(MaxAgeN(),indexLast2());

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }
void sort(int startIndex, int endIndex) {       
        int count = 0,m=0;
        Bike tmp;
        Node p = head,i;
        while (p.next != null) {
            if (count == startIndex) {
                for (; p != null; p = p.next) {
                    int n=0;
                    for (i = p.next; i != null; i = i.next) {
                        if (p.info.weight > i.info.weight) {
                            tmp = p.info;
                            p.info = i.info;
                            i.info = tmp;
                        }
                        n++;
                        if (m+n==endIndex-startIndex) {
                            break;
                        }
                    }
                    if (m+1==endIndex-startIndex) {
                        break;
                    }
                    m++;
                }
                break;
            }
            count++;
            p = p.next;
        }
    }

int indexLast2() {
        int index1 = 0;
        Node p = head;
        while (p.next != null) {
            index1++;
            p = p.next;
        }
        return index1;
    }

 int MaxAgeN() {
        Node p = head;

        int index = 0;

        int max = p.info.weight;
        while (p.next != null) {
            if (p.next.info.weight < max) {
                max = p.next.info.weight;
            }
            p = p.next;
        }
        Node p1 = head;
        while (p1.next != null) {
            index++;
            if (p1.info.weight == max) {
                break;
            }
            p1 = p1.next;
        }

        return index;
    }
 }

