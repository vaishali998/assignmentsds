import java.util.*;
public class SpiralTree{
    Node root;
    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data; 
            left = right  = null;
        }
    }
    SpiralTree(){
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
          public void printOrder(){
              int h = height(root);
              boolean sp = false;
              for(int i = 1; i <= h ; i++){
                  printLevel(root, i, sp);
                  sp=!sp;
              }
          }
          public void printLevel(Node root,int level,boolean sp){
              if(root == null){
                  return;
              }
              else if(level == 1){
                  System.out.println(root.data);
              }
              else if(level > 1){
                  if(sp == true){
                  printLevel(root.left,level-1,sp);
                  printLevel(root.right,level-1,sp);
                  }
                  else{
                  printLevel(root.right,level-1,sp);
                  printLevel(root.left,level-1,sp);
                  }
              }
          }
     
     public static void main(String[] args) { 
        SpiralTree tree = new SpiralTree(); 
        tree.insert(50); 
        tree.insert(30); 
        tree.insert(10); 
        tree.insert(40); 
        tree.insert(80); 
        tree.insert(70); 
        tree.insert(150);
        System.out.println("Spiral Tree is:");
        tree.printOrder();
        
    } 
   
    
}