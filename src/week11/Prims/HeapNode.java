package week11.Prims;

public class HeapNode implements Comparable<HeapNode> {
        int dest = -1;
        int distance = -1;
        
        HeapNode(int v, int d) {
            dest = v;
            distance = d;
        }
        
        @Override
        public int compareTo(HeapNode o) {
            return this.distance - o.distance;
        }
    }

