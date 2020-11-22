/*
Count leaf nodes
Description
A node is a leaf node if its both left and right child nodes are NULL.

As an example, consider the following Binary Search tree.
﻿
﻿Here, the leaf nodes would be 4, 10, 22 and 14 since they are the only ones who do not have any children (neither left child nor right child). Thus, when the input is the above tree, the output is 4

Input: The input will be in the following format:
The first line will be ‘n’ representing the number of elements to be inserted into the BST.
Next line will be n elements separated by spaces representing the elements to be inserted into the BST. 

Output: The output should be of the following format:
       Value of number of leaf nodes.

Sample Input:
7
20 8 4 22 12 10 14
Sample Output:
4

Sample Input:
6
3 4 2 5 7 1
Sample Output:
2
*/

import java.util.*;
public class Source{
public static class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 
   
public static class BinaryTree  
{ 
    Node root; 
    
    BinaryTree() {
        root = null;
    }
    
    // Function to insert in the BST 
    void insert(int key) { 
       root = insertRec(root, key); 
    } 
      
    // A recursive function to insert a new key in BST
    Node insertRec(Node root, int key) { 
  
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
  
        if (key < root.data) 
            root.left = insertRec(root.left, key); 
        else if (key > root.data) 
            root.right = insertRec(root.right, key); 
  
        return root; 
    } 
    
    int getLeafCount()  
    { 
        return getLeafCount(root); 
    } 
   
    int getLeafCount(Node node)  
    { 
        if (node == null) 
            return 0; 
        if (node.left == null && node.right == null) 
            return 1; 
        else
            return getLeafCount(node.left) + getLeafCount(node.right); 
        
    } 
} 

public static void main(String[] args)  
    { 

        BinaryTree tree = new BinaryTree(); 
        Scanner sc = new Scanner(System.in);
	    int size;	
		size = sc.nextInt();
		
		if(size<= 0){
		    System.out.println("Size should be a positive integer");
		}
		
		else{
    		int[] elementsArr = new int[size];
    		for(int i = 0; i < size; i++){
    			elementsArr[i] = sc.nextInt();
    			tree.insert(elementsArr[i]);
    		}
    		System.out.println(tree.getLeafCount());
		}
    } 
}
