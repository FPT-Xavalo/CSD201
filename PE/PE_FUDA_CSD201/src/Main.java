
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Main {
    
    static Scanner sc = new Scanner(System.in);
    
    static String[] menus = {
        "Find the node...",
        "Insert a new worker...",
        "Ouput...",
        "Exit"
    };
    
    static int getChoice() {
        for (int i = 0; i < menus.length; i++) {
            System.out.println((i+1) + ". " + menus[i]);
        }
        
        System.out.print("Enter choice: ");
        return Integer.parseInt(sc.nextLine());
    }
    
    public static void main(String[] args) {
        int choice, key, age;
        BST tree = new BST();
        String name;
        do {
            choice = getChoice();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    System.out.print("Enter key: ");
                    key = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    System.out.print("Age: ");
                    age = Integer.parseInt(sc.nextLine());
                    
                    if (tree.insert(key, name, age)) {
                        System.out.println("Insert successfully");
                    } else {
                        System.out.println("Key existed");
                    }
                    
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("INVALID CHOICE!!!");
            }
            
            System.out.println();
        } while (choice != 4);
    }
}
