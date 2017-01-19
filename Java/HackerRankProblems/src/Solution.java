import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.ParseConversionEvent;


public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int lenOfArray = sc.nextInt();
        List nodesList = new ArrayList();
        
        for (int i = 0 ;i < lenOfArray  ; i++) {
            nodesList.add(sc.nextInt());
        }
        int sumToSearch = sc.nextInt();  
        
        BinaryTree bt = new BinaryTree();
        
        for (int i = 0 ; i < lenOfArray ; i ++) 
			bt.insertNode((int)nodesList.get(i));
        
        if (lenOfArray == 0) {
        	System.out.println('-');
        }
       
        sc.close();
        }
    }
      

class Node {
        public int value;
        public Node left;
        public Node right;
        
        public Node(int val) {
        	this.value = val;
        	this.left = null;
        	this.right = null;
        }
        
        public Node leftChild(){
            return this.left;
        }
        
        public Node rightChild(){
            return this.right;
        }
}
    
class BinaryTree {
        
        Node root;
        
        public int findHeightOfTree(Node n) {
        	
        	int l = 0;
        	int r = 0;
        	if (n== null) 
        		return 0;
        	if (n.left != null) {
        		l = findHeightOfTree(n.left)+1;
        	}
        	if (n.right != null) {
        		r = findHeightOfTree(n.left)+1;
        	}
        	
        	return Math.max(l,r);
        }
        
        public void insertNode(int val) {
            Node n = new Node(val);
            
            if (root == null)
            {	
            	root = insert(n, root);
            	return;
            }
            Node curr = root;
            while (true) {
	            int heightofTree = findHeightOfTree(curr);
				int heigthOfLTree = findHeightOfTree(curr.leftChild());
				int heightOfRTree = findHeightOfTree(curr.rightChild());
	            
				//if this is the first node inserted
	        	if (heightofTree == 0 ) {
	        		curr = insert(n, curr);
	        		return;
	        	}
	        	// base case for height from root = 1
	        	if (heightofTree == 1 && !isTreeFull(curr, heightofTree))
	        	{
	        		curr = insert(n, curr);
	        		return;
	        	}
	        	// if height of left sub tree and right sub tree are equal
	        	if (heightOfRTree == heigthOfLTree) {
	        		//check if right sub tree is full or not
	        		if (!isTreeFull(curr.rightChild(), heightOfRTree))
	        			curr = curr.rightChild();
	        		else {
	        			curr = curr.leftChild();
	        		}
	        	}
	        	else {
	        		// always try to maintain case where height of left sub tree cannot be greater than 2 from height of right sub tree
	        		if (heightOfRTree == heigthOfLTree -1) {
	        			//if left sub tree is not full
	        			if (!isTreeFull(curr.leftChild(), heigthOfLTree)) {
	        				curr = curr.leftChild();
	        			}
	        			else {
	        				curr = curr.rightChild();
	        			}
	        		}
	        		
	        	}
        	}
        }
        
        //function to check if tree is full or balanced upto given height from given node
        public boolean isTreeFull(Node n, int h) {
        	
        	boolean l = true;
        	boolean r = true;
        	if (h == 0) 
        		return true;
        	if (n.leftChild() == null || n.rightChild() == null)
        		return false;
        	if (n.leftChild() != null) {
        		l = isTreeFull(n.leftChild(), h-1);
        	}
        	if (n.rightChild() != null) {
        		r = isTreeFull(n.rightChild(), h-1);
        	}
        	return (l & r);
        			
        }
        
        //base case of node insertion
        public Node insert(Node n, Node curr) {
        	if (curr  == null) {
        		curr = n;
        		return curr;
        	}
        	else {
        		if (curr.leftChild() == null) {
        			curr.left = n;
    				return curr;
    			}
    			if (curr.rightChild() == null) {
    				curr.right = n;
    				return curr;
    				
    			}
        	}
			return curr;
        }
        
        //method to find sum anywhere from root to leaf nodes
        public boolean hasPathSum(Node n, int val) {
        	ArrayList<Integer> valList = new ArrayList<Integer>();
        	return hasPath(n, val, valList);
        }
        
        public boolean hasPath(Node n, int val,ArrayList<Integer> valList ){
        	boolean l = false;
        	boolean r = false;
        	for (int i = 0 ; i < valList.size() ; i++) {
        		int v = (int)valList.get(i);
        		if (v == 0)
        			return true;
        		if (v - n.value == 0) {
        			return true;
        		}
        		valList.set(i, v - n.value);	
        	}
        	if (n.value == val) {
        		return true;
        	}
        	
        	valList.add(val - n.value);
        	
        	if (n == null) {
        		return false;
        	}
        	
        	if (n.leftChild() == null && n.rightChild() == null)
        		return false;
        	
        	if (n.leftChild() != null) {
        		l = hasPath(n.leftChild(), val, (ArrayList<Integer>) valList.clone());
        	}
        	if (n.rightChild() != null) {
        		r = hasPath(n.rightChild(), val, (ArrayList<Integer>) valList.clone());
        	}
        	
        	
        	return  (r | l);
        }
}     