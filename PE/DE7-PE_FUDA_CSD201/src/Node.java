/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Node {
    Worker info;
    Node left, right;

    public Node(Worker info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
    
    public Node(Worker info) {
        this(info, null, null);
    }
}
