package week11.Prims;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/priorityqueue-comparator-method-in-java/
//https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
public class Prims {
    public static void PrimsMain(Graphene g) {
        PriorityQueue<HeapNode> queue = new PriorityQueue<>();
        int[] Path = new int[g.vNum];
        int[] Distance = new int[g.vNum];
        boolean[] Included = new boolean[g.vNum];
        
        Arrays.fill(Distance, -1);
        Arrays.fill(Path, -1);
        queue.offer(new HeapNode(0, 0));
        Included[0] = true;
        Distance[0] = 0;
        Path[0] = 0;
        
        while (!queue.isEmpty()) {
            HeapNode vNode = queue.poll(); //delete min
            int v = vNode.dest;
            // for all edges from v
            EdgeList vList = g.edgeList[v]; //adjacency list of GraphNode v
            
            for (Edge edge : vList) {
                //the edge to destination w
                int w = edge.dest;
                
                // edge.weight;
                int newDest = Distance[v] + edge.weight;
                
                
                if (Distance[w] == -1) {
                    Distance[w] = Distance[v] + edge.weight;
                    queue.offer(new HeapNode(w, newDest));
                    Path[w] = v;
                }else{
                    //get original dist
//                    Distance[w] = Distance[Path[w]]+ edge.weight;
                }
                if (Distance[w] > newDest) {
                    // need relax
                    Distance[w] = newDest;
                    //update priority of w -> newDest
                    queue.removeIf(n -> n.dest == w);
                    queue.offer(new HeapNode(w, newDest));
                    Path[w] = v;
                }
                
                
            }
            
            
        }//end of while
        System.out.println("Precedessors of node:");
        for (int i = 0; i < Path.length; i++) {
            System.out.println(Path[i]);
        }
        
//        Iterator<HeapNode> listIt = queue.iterator();
//        while (listIt.hasNext()) {
//            System.out.println(listIt.next());
//        }
        
    }
}


