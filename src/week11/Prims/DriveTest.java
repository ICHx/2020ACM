package week11.Kruskals;

public class DriveTest {
    static Graphene graph1 = new Graphene(6);
    // A = 0, C = 2; F =5..
    public static void main(String[] args) {
        graph1.addEdges(0,1,2); //ok
        graph1.addEdges(0,2,2);
        graph1.addEdges(1,2,2);
        graph1.addEdges(1,3,1);
        graph1.addEdges(2,3,2);
        graph1.addEdges(2,4,3);
        graph1.addEdges(3,4,3);
        graph1.addEdges(3,5,4);
        graph1.addEdges(4,5,1);
    
        graph1.removeEdges(0,1); //ok
        System.out.println(graph1);
    }
}
