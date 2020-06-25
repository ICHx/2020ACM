import java.util.Scanner;

public class MeetingNode {
   public static void main (String[] args) {
      final int ROOT = 1;
      final int ROOT_PARENT = -1;
      Scanner sc = new Scanner( System.in );

      int K = sc.nextInt();  // 1 <= K <= 100000
      int[] superNode = new int[ K+1 ];
      superNode[ROOT] = ROOT_PARENT;   
      int parent, child;
      for (int i = 1; i < K; i++) {
         parent = sc.nextInt();
         child  = sc.nextInt();
         superNode[ child ] = parent;
      }

      int[] maxPersonInNode = new int[ K+1 ];
      int n = sc.nextInt();  // 1 <= n <= K <= 100000
      int node;
      for (int i = 0; i < n; i++) {
         node = sc.nextInt();
         do {
            ++maxPersonInNode[node];
            node = superNode[node];
         } while (node != ROOT_PARENT);
      }

      int[] nodeDepth = new int[ K+1 ];
      int maxDepth = 0, meetingNode = ROOT;
      for (int i = 2; i <= K; i++) {
         if (maxPersonInNode[i] == n) {
            node = i;
            int depth = 0;
            do {
               node = superNode[node];
               ++depth;
            } while (nodeDepth[node] == 0 && node != ROOT);
            nodeDepth[i] = depth + nodeDepth[node];
            if (maxDepth < nodeDepth[i]) {
               maxDepth = nodeDepth[i];
               meetingNode = i;
            }   
         } 
      }

      System.out.println( meetingNode );

      sc.close();
   }
}

