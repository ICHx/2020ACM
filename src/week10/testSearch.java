package week10;

public class testSearch {

public static void main(String[] args) {
//Graf g = new Graf(7, false);
//g.insEdge(1,2);
//g.insEdge(2,3);
//g.insEdge(2,5);
//g.insEdge(2,6);
//g.insEdge(3,4);
//g.insEdge(3,7);
//g.insEdge(5,4);
//
    //cycle
    Graf g = new Graf(5, false);
    g.insEdge(1,2);
    g.insEdge(1,4);
    g.insEdge(2,3);
    g.insEdge(2,5);
    g.insEdge(3,4);
    g.insEdge(4,1);
    
    
    System.out.println("DFS");
g.dfs();
    System.out.println("BFS");
g.bfs();
}




}



