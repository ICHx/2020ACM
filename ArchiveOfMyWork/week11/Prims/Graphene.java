package week11.Prims;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graphene {
    ArrayList<Integer> vertices;
    EdgeList[] edgeList;
    int vNum = 0;
    
    public Graphene(int vNum) {
        this.vNum = vNum;
        this.vertices = new ArrayList<>();
        edgeList = new EdgeList[vNum];
        
        for (int i = 0; i < vNum; i++) {
            vertices.add(i);
            edgeList[i] = new EdgeList();
        }
    }
    
    public void addEdges(int source, int dest, int weight) {
        int i, j;
        i = vertices.indexOf(source); // finding the index of node(source=A) in the linked list.
        j = vertices.indexOf(dest);
        
        Edge A, B;
        A = new Edge(source, weight);
        B = new Edge(dest, weight);
        
        if (i != -1 || j != -1) {
            edgeList[i].add(B);
            edgeList[j].add(A);
        }
        
    }
    
    public void removeEdges(int source, int dest) {
        int i, j;
        i = vertices.indexOf(source);
        j = vertices.indexOf(dest);
        
        if (i != -1 || j != -1) {
            // Linked List method to check object attribute
            edgeList[i].removeIf(n-> (n.dest==dest));
            edgeList[j].removeIf(n-> (n.dest==source));
        }
        
    }
    
    
}

class EdgeList extends LinkedList<Edge> {
}

class Edge {
    int dest = -1; //destination of edge
    int weight = -1;
    
    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
    

    public boolean equals(int i) {
        return (this.dest == i);
    }
}