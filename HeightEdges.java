import java.util.*;
public class HeightEdges{
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
            if(root == null){
                return -1;
            }
            else{
                return 1+Math.max(treeHeight(root.left), treeHeight(root.right));
            }
        }
        public static void main(String[] args) { 
           HeightEdges tree = new HeightEdges(); 
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
