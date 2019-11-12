import java.util.*;
public class EvenNodes{
    Node root;
    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data; 
            left = right  = null;
        }
    }
    EvenNodes(){
        root = null;
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
          
          public int height(Node root){
              if(root == null){
                  return 0;
              }
              else{
                  int lh = height(root.left);
                  int rh = height(root.right);
                  if(lh > rh){
                      return lh+1;
                  } else{
                      return rh+1;
                  }
              }
          }
          void printOrder(){
              int h = height(root);
              for(int i = 1; i <= h ; i = i+2){
                  printLevel(root, i);
              }
          }
          void printLevel(Node root,int level){
              if(root == null){
                  return;
              }
              else if(level == 1){
                  System.out.println(root.data);
              }
              else if(level > 1){
                  printLevel(root.right,level-1);
                  printLevel(root.left,level-1);
              }
          }
     
     public static void main(String[] args) { 
        EvenNodes tree = new EvenNodes(); 
        tree.insert(50); 
        tree.insert(30); 
        tree.insert(100); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(10); 
        tree.insert(80); 
        tree.insert(150); 
        tree.insert(120);
        tree.insert(160); 

       
        System.out.println("Reverse Tree is");
        tree.printOrder();
        
    } 
   
    
}