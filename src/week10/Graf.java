package week10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graf {
// I am using 1 as start node index.
private boolean[][] adjMatrix;
private int vertexCount;
private boolean UNDIRECTED;
private boolean visited[];

public Graf(int vertexCount, boolean UNDIRECTED) {
    this.UNDIRECTED = UNDIRECTED;
    this.vertexCount = vertexCount;
    this.adjMatrix = new boolean[vertexCount + 1][vertexCount + 1];
    this.visited = new boolean[vertexCount + 1];
}


public void insEdge(int i, int j) {
    // edge: i -> j
    // for directed graph
    if (checkValid(i) && checkValid(j)) {
        adjMatrix[i][j] = true;
        if (UNDIRECTED)
            adjMatrix[j][i] = true;
    }
    
}

public void removeEdge(int i, int j) {
    
    if (checkValid(i) && checkValid(j))
        adjMatrix[i][j] = false;
}

public boolean isEdge(int i, int j) {
    if (checkValid(i) && checkValid(j))
        return adjMatrix[i][j];
    return false;
}


private boolean checkValid(int i) {
    return (i > 0 && i <= getVertexCount());
}

public int getVertexCount() {
    return vertexCount;
}


public void dfs() {
    
    Stack<Integer> st = new Stack<>();
    
    System.out.println(1);
    visited[1] = true;
    st.push(1);
    
    
    int i;
    while (!st.isEmpty()) {
        i = getUnvisited((int) st.peek());
        if (i == -1) {
            st.pop();
            continue;
        }
        
        System.out.println(i);
        if (visited[i]) {
            // skip pushing visited node
            // Book's DFS is slower, without the skip
            continue;
        }
        
        visited[i] = true;
        st.push(i);
        
    }
    
    Arrays.fill(visited, false);
}

public int getUnvisited(int v) {
    //out edge traversal
    for (int k = 1; k <= vertexCount; k++) {
        if (adjMatrix[v][k] && !visited[k])
            return k;
    }
    
    return -1;
}

public void bfs(){
//queue uses offer() for add, poll() for pop.
    
    Queue<Integer> qt = new LinkedList<>();


    qt.offer(1);

    int i;
    while (!qt.isEmpty()) {
        // dequeue
        int top = qt.poll();
        System.out.println(top);
        visited[top] = true;
        
        while ((i = getUnvisited( top )) !=-1){
            // add all lower level node
            qt.offer(i);
            visited[i] = true;
    
        }
    }

    Arrays.fill(visited, false);
}


}
