/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {
   Node root;
   BSTree() {root=null;}
   boolean isEmpty() {
       return(root==null);
      }
   void clear() {
       root=null;
      }
   void visit(Node p) {
      System.out.print("p.info: ");
      if(p != null) System.out.println(p.info + " ");
     }
   void fvisit(Node p, RandomAccessFile f) throws Exception {
      if(p != null) f.writeBytes(p.info + " ");
     }
   void preOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }
  void breadth(Node p, RandomAccessFile f) throws Exception {
     if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty()) {
        r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void loadData(int k) { //do not edit this function
      String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int [] c = Lib.readLineToIntArray("data.txt", k+2);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i],c[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(String xDriver, int xRate, int xColor) {
    //You should insert here statements to complete this function    
    if (xDriver.charAt(0) == 'A') {
            return;
        }
        Canoe x = new Canoe(xDriver,xRate,xColor);
        insert(x);
   }
void insert(Canoe x) {
        Node q = new Node(x);
        if (root == null) {
            root = q;
            return;
        }
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (p.info.color == x.color) {
                return;
            }
            if (x.color < p.info.color) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (x.color< f.info.color) {
            f.left = q;
        } else {
            f.right = q;
        }
    }


//Do not edit this function. Your task is to complete insert function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    inOrder(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
  
//=============================================================
   void preOrder2(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      if(p.info.rate<6)
      fvisit(p,f);
      preOrder2(p.left,f);
      preOrder2(p.right,f);
     }
  void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    preOrder(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    preOrder2(root,f);
    //------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }  

//=============================================================
  int count=0;
   void preOrder3(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
     
      if (p.left != null && p.right==null){
           count++;
          if (count==1){
          deleteByCopying(p.info.color);
          return;
        }
      }
    //  fvisit(p,f);
      preOrder3(p.left,f);
      preOrder3(p.right,f);
     }
    public void deleteByCopying(int x) {
        if (isEmpty()) {
            System.out.println("The tree is empty. No deletion.");
            return;
        }

        Node p = root;
        Node f = p;
        while (p != null) {
            if (p.info.color == x) {
                break;
            } else {
                f = p;
                if (x < p.info.color) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
        }

        if (p == null) {
            System.out.println(x + " does not exist. No deletion.");
            return;
        }

        // Case 1: p is a leaf node
        if (p.left == null && p.right == null) {
            if (root == p) {
                root = null;
                return;
            }

            if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        }

        // Case 2: p has only one child
        if (p.left == null && p.right != null) { // p has right child
            if (root == p) {
                root = root.right;
                return;
            }

            if (p == f.left) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } else if (p.left != null && p.right == null) { // p has left child
            if (root == p) {
                root = root.left;
                return;
            }

            if (p == f.left) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }

        // Case 3: p has both left and right children
        if (p.left != null && p.right != null) {
            Node s = p.left; // Find the rightmost node in the left subtree
            Node fs = p; // Parent of s
            while (s.right != null) {
                fs = s;
                s = s.right;
            }

            // Copying
            p.info = s.info; // Replace p's key with s's key

            // Deleting by copying
            if (fs.left == s) {
                fs.left = s.left;
            } else {
                fs.right = s.left;
            }
        }
    }


  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    preOrder(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    preOrder3(root,f);
    //------------------------------------------------------------------------------------
    preOrder(root,f);
    f.writeBytes("\r\n");
    f.close();
   }          

//=============================================================
     int count4=0;
   void preOrder4(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
     
      if (p.left != null && p.right==null){
           count4++;
          if (count4==1){
          rotateRight(p);
          return;
        }
      }
    //  fvisit(p,f);
      preOrder4(p.left,f);
      preOrder4(p.right,f);
     }
   public void rotateRight(Node par) {
        Node p = root;
        Node gr = null;
        while (p != null) {
            if (p == par) {
                break;
            }
            gr = p;
            if (p.info.color>par.info.color) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (par.left == null) {
            return;
        }
        Node ch = par.left;
        par.left = ch.right;
        ch.right = par;
        if (gr == null) {
            root = ch;
        } else if (gr.left == p) {
            gr.left = ch;
        } else if (gr.right == p) {
            gr.right = ch;
        }
    }

  void f4() throws Exception {
    clear();
    loadData(13);;
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    preOrder(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
     preOrder4(root,f);
    //------------------------------------------------------------------------------------
    preOrder(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
  
 }
