/*
Mirror a Tree
Description
You are given a binary tree. You are required to convert this binary tree into its mirror image. Consider the binary tree given below:﻿
﻿The mirror image of this binary tree will be:﻿
﻿Input:
The input will be in the following format:
The first line should be the the number ‘n’. Here, the number ‘n’ is the total number of nodes present in the binary tree.
The second line contains space separated ‘n’ values. No value should be equal to -1. This is the level-order traversal of the tree. The code for inserting the values in the tree for the given level order traversal has already been taken care of in the code.

Output:
The output should should be the pre-order traversal of the mirror tree with the nodes separated by spaces. The code for pre-order traversal of a tree has already been provided to you in the stub code. You just need to complete the code for mirroring a tree.

Sample Input:
5
1 2 3 4 5
Sample Output:
1 3 2 5 4

Sample Input:
6
6 9 8 7 4 5
Sample Output:
6 8 5 9 4 7
*/

import java.util.*;

class Node {
	int data;
	Node left, right;
	
	Node(int value) {
		data = value;
		left = right = null;
	}
}

class Tree {
	Node root;
	
	Tree() {
		root = null;
	}
	
	// Method to construct a binary tree from the given array
	public Node insertNode(int[] elementsArr, Node node, int i) {
		if(i < elementsArr.length){
			node = new Node(elementsArr[i]);
			node.left = insertNode(elementsArr,node.left,2 * i + 1);
			node.right = insertNode(elementsArr,node.right,2 * i + 2);
		}
		return node;
	}
	
	// Method to print the tree in pre-order traversal
    void preOrderDFS(Node node) {
        if (node == null)
            return;

        // visit the parent node (parent of left & right children)
        System.out.print(node.data + " ");
        // recursively go to left subtree
        preOrderDFS(node.left);
        // recursively go to right subtree
        preOrderDFS(node.right);
    }
	
	// Method to convert a given binary tree into its mirror image
	public Node mirror(Node node) {
		  if (node == null) 
            return node; 
  
        /* do the subtrees */
        Node left = mirror(node.left); 
        Node right = mirror(node.right); 
  
        /* swap the left and right pointers */
        node.left = right; 
        node.right = left; 
        return node;
	}
}

// WARNING: Do not edit the code given below; otherwise the test cases might fail
class Source {
	public static void main(String[] x) {
		Tree tree = new Tree();
		
		int size;
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		
		if(size <= 0){
		    System.out.println("Size should be a positive integer");
		}
		
		else{
    		int[] elementsArr = new int[size];
    		for(int i = 0; i < size; i++) {
    			elementsArr[i] = sc.nextInt();
    		}
    		
    		tree.root = tree.insertNode(elementsArr, tree.root, 0);
    		
    		tree.mirror(tree.root);
    		
    		tree.preOrderDFS(tree.root);
		}
	}
}
