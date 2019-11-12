import java.util.*;
public class PreToPostIn{
    Node root;
    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data; 
            left = right  = null;
        }
    }
    void insert(int data){
        root = insertRec(root,data);
    }
        Node insertRec(Node root, int data){
            if(root == null){
                root = new Node(data);
                return root;
            }
            if(data < root.data){
                root.left = insertRec(root.left,data);
            } else if(data > root.data){
                root.right = insertRec(root.right,data);
            }
            return root;
        }
          void inorder()  { 
            inorderRec(root); 
         } 
       void inorderRec(Node root) { 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.print(" "+root.data); 
            inorderRec(root.right); 
        } 
    }
    
     void postorder()  { 
            postorderRec(root); 
         } 
       void postorderRec(Node root) { 
        if (root != null) { 
            postorderRec(root.left); 
            postorderRec(root.right); 
            System.out.print(" "+root.data); 
        } 
      
    } 
     
     public static void main(String[] args) { 
        PreToPostIn tree = new PreToPostIn(); 
        tree.insert(50); 
        tree.insert(30); 
        tree.insert(10); 
        tree.insert(40); 
        tree.insert(80); 
        tree.insert(70); 
        tree.insert(150);
        System.out.println("Inorder:"); 
        tree.inorder(); 
        System.out.println("");
        System.out.println("");
        System.out.println("Postorder:"); 
        tree.postorder();
    } 
   
    
}