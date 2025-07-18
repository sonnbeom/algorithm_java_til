package 복습;

import java.util.*;
public class 도시분할복습 {
    static int n;
    static int m;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[m][3];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < 3; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(graph, (o1, o2)-> o1[2]-o2[2]);
        int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int totalCost = 0;
        int maxEdge = 0;
        for (int i = 0; i < graph.length; i++) {
            if (find(parent,graph[i][0]) != find(parent, graph[i][1])){
                union(graph[i][0], graph[i][1], parent);
                totalCost += graph[i][2];
                maxEdge = graph[i][2];
            }
        }
        System.out.println(totalCost - maxEdge);
    }
    static int find(int[] parent, int x){
        if (parent[x]==x){
            return x;
        }
        else {
            return find(parent, parent[x]);
        }
    }
    static void union(int x, int y, int[] parent){
        x = find(parent, x);
        y = find(parent, y);

        if (x < y){
            parent[y] = x;
        }
        else {
            parent[x] = y;
        }

    }
}
