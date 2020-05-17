package week11.HuffmanCoding;

import java.util.PriorityQueue;

//the program uses priority queue ADT to ensure minimal selection.

public class Main {
    final static int[] data = {12, 2, 7, 13, 14, 85};
    
    public static void main(String[] args) throws NullPointerException {
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
        while (!queue.isEmpty() || lrCombined == freqSum) {
            //dequeue 2 elements
            Node left, right;
            left = queue.poll();
            right = queue.poll();
            
            if (left == null || right == null) System.exit(12);
            
            lrCombined = left.freq + right.freq;
            Node combine = new Node(-1, lrCombined); // -1 means it is a combined node.
            combine.setChild(left,right);
            
            Head = combine;
            queue.offer(combine);
        }
    }
}


class Node implements Comparable<Node> {
    int key = '\0';
    int freq = 0;
    Node left, right;
    
    Node(int key, int freq) {
        this.key = key;
        this.freq = freq;
        left = right = null;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.freq - o.freq;
    }
    
    public void setChild(Node left, Node right) {
        this.left = left;
        this.right= right;
    }
    
}