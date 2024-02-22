/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class BST {
    Node root;

    public BST() {
        root = null;
    }
    
    void clear() {
        root = null;
    }
    
    boolean isEmpty() {
        return root == null;
    }
    
    // 1
    
    // 2
    boolean insert(int key, String name, int age) {
        Node q = new Node(new Worker(key, name, age));
        if (isEmpty()) {
            root = q;
            return true;
        }
        Node p = root, f = null;
        while (p != null) {
            if (p.info.getKey() == key) {
                return false;
            }
            
            f = p;
            if (p.info.getKey() > key) 
                p = p.left;
            else
                p = p.right;
        }
        
        if (f.info.getKey() > key) 
            f.left = q;
        else
            f.right = q;
        
        return true;
    } 
    
    // 3
    
    // 4
    
    // 5
    
    // 6
    
    // 7
}
