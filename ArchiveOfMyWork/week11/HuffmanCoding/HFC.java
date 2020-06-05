package week11.HuffmanCoding;

import java.util.Comparator;
import java.util.PriorityQueue;

//the program uses priority queue ADT to ensure minimal selection.
// currently only concerns even amount

public class HFC {
    final static int[] data = {12, 2, 7, 13, 14, 85}; //index from 'a'
    
    public static void main(String[] args) {
        Node Head = HuffmanCoding();
        DisplayTree(Head);
    }
    
    public static Node HuffmanCoding() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Node[] HuffmanNodes = new Node[data.length]; //unsorted array of objects
        int freqSum = 0;
        for (int i = 0; i < data.length; i++) {
            freqSum += data[i];
            HuffmanNodes[i] = new Node(i, data[i]);
            queue.offer(HuffmanNodes[i]);
        }
        
        
        Node Head = null;
        int lrCombined = 0;
        while (!queue.isEmpty() && lrCombined != freqSum) {
            //dequeue 2 elements
            Node left, right;
            left = queue.poll();
            if (left == null) System.exit(12);
            right = queue.poll();
            assert right != null;
            
            lrCombined = left.freq + right.freq;
            Node combine = new Node(-1, lrCombined); // -1 means it is a combined node.
            combine.setChild(left, right);
            
            Head = combine;
            queue.offer(combine);
        }
        return Head;
    }
    
    
    public static void DisplayTree(Node tree) {
        // implement Level Order traversal
        // if key ==-1, go left
        Payload(tree, "");
    }
    
    public static void Payload(Node subtree, String sequence) {
        // implement Level Order traversal
        // if key ==-1, Print nothing
        // else, print string,
        if (subtree.key != -1) System.out.println(subtree.getAlpha() + ": " + sequence);
        // then .append "0" for left, "1" for right,
        if(subtree.right!=null) Payload(subtree.right, sequence + "1");
        if(subtree.left!=null)Payload(subtree.left, sequence + "0");
        
        
    }
}

class Node implements Comparator<Node>, Comparable<Node> {
    int freq = 0;
    int key = '\0';
    Node left, right;
    
    Node(int key, int freq) {
        this.key = key;
        this.freq = freq;
        left = right = null;
    }
    
    public String getAlpha() {
        return Character.toString(key + 'a');
    }
    
    public void setChild(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public int compare(Node o1, Node o2) {
        return o1.freq - o2.freq;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.freq - o.freq;
    }
}