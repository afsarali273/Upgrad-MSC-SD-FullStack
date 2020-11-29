/*
Merge K sorted linked list
Description
You will be given K sorted linked list and you have to merge these linked lists into one linked list such that the resultant linked list is also sorted. Note that all the k linked lists are of the same size.

Input: The input will be in the following format
The first line will be an integer ‘n’ representing the number of lists
The next line will be an integer ‘k’ representing the size of the list
The next line will be ‘nk’ number of integers which represent the data of the nodes of linked lists.

Output: The output should be in the following format
A single line of containing all the nodes of the merged linked list, separated by a single space.



Sample Test case:
Input:
3
4
4 5 7 8 1 2 10 11 0 3 6 9

Output:
0 1 2 3 4 5 6 7 8 9 10 11 
*/

import java.util.*;

//class representing Structure of node in the linked list
class Node {
    int data;
    Node next;
};

class Source {
    
    //creates a new node with the given 'data' and returns that node
    Node newNode (int data) {

        Node newNode = new Node();

        newNode.data = data;
        newNode.next = null;

        return newNode;
    }
    
    // function to merge k
    // sorted linked lists
    public static Node mergeKSortedLists(
        ArrayList<Node> arr, int k)
    {
        Node head = null, last = null;
 
        // priority_queue 'pq' implemeted
        // as min heap with the
        // help of 'compare' function
        PriorityQueue<Node> pq
            = new PriorityQueue<>(
                new Comparator<Node>() {
                    public int compare(Node a, Node b)
                    {
                        return a.data - b.data;
                    }
                });
 
        // push the head nodes of all
        // the k lists in 'pq'
        for (int i = 0; i < k; i++)
            if (arr.get(i) != null)
                pq.add(arr.get(i));
 
        // loop till 'pq' is not empty
        while (!pq.isEmpty()) {
            // get the top element of 'pq'
            Node top = pq.peek();
            pq.remove();
 
            // check if there is a node
            // next to the 'top' node
            // in the list of which 'top'
            // node is a member
            if (top.next != null)
                // push the next node in 'pq'
                pq.add(top.next);
 
            // if final merged list is empty
            if (head == null) {
                head = top;
                // points to the last node so far of
                // the final merged list
                last = top;
            }
            else {
                // insert 'top' at the end
                // of the merged list so far
                last.next = top;
 
                // update the 'last' pointer
                last = top;
            }
        }
        // head node of the required merged list
        return head;
    }

    // Driver program to test above
    public static void main(String args[]) {

        //array list whose each element is the head of each linked list
        ArrayList<Node> arr = new ArrayList<>();
        Source obj = new Source();

        Scanner in = new Scanner(System.in);

        // Number of linked lists
        int k = in.nextInt();

        // Number of elements in each linked list
        int n = in.nextInt();

        Node tmp = null;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                
                //head node of the linked list
                if (j == 0) {
                    int dt = in.nextInt();
                    arr.add(obj.newNode (dt));
                } else {
                    int dt = in.nextInt();
                    tmp = arr.get(i);
                    for (int m = 1; m < j; m++) {
                        tmp = tmp.next;
                    }
                    tmp.next = obj.newNode (dt);
                }
            }
        }

        //write your code here
     Node head =  mergeKSortedLists(arr,k);
     
      while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
    }
}



