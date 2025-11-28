package august;

import java.util.*;
public class 백준_도시분할계획 {
    static int n;
    static int m;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        answer = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] parent = new int[n+1];
        for (int i = 1; i <=n; i++){
            parent[i] = i;
        }
        int[][] graph = new int[m][3];
        for(int i = 0; i<m; i++){
            for (int j = 0; j < 3; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(graph, (a0, a1)-> a0[2] - a1[2]);
        int max = 0;
        int cost = 0;
        for(int i = 0; i < m; i++){
            if (find(graph[i][0], parent)!= find(graph[i][1], parent)){
                max = Math.max(graph[i][2], max);
                union(graph[i][0], graph[i][1], parent);
                cost += graph[i][2];
            }
        }
        System.out.println(cost - max);
    }
    static int find(int x, int[] parent){
        if (parent[x] == x){
            return x;
        }
        else {
            return find(parent[x], parent);
        }
    }
    static void union(int a, int b, int[] parent){
        a = find(a, parent);
        b = find(b, parent);
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }
}
