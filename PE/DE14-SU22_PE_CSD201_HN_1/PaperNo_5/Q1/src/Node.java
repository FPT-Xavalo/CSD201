// ======= DO NOT EDIT THIS FILE ============
class Node {
  Bean info;
  Node next;
  Node(Bean x, Node p) {
    info=x;next=p;
   }
  Node(Bean x) {
    this(x,null);
   }
  Node() {
   }
 }
