import java.util.*;
public class TreeHeight{
    static Node root;
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
        public int treeHeight(Node root){
            int lh = 0;
            int rh = 0, h = 0;
            if(root.left != null){
                lh = treeHeight(root.left);
            }
            else if(root.right != null){
                rh = treeHeight(root.right);
            }
            if(lh > rh){
                h = lh;
            }
            else{
                h = rh;
            }
            return h+1;
        }
        public static void main(String[] args) { 
            TreeHeight tree = new TreeHeight(); 
            tree.insert(50); 
            tree.insert(30); 
            tree.insert(10); 
            tree.insert(40); 
            tree.insert(80); 
            tree.insert(70); 
            tree.insert(150);
            int h = tree.treeHeight(root);
            System.out.println("Height of tree is: "+h);
        }
}