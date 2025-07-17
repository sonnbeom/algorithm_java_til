package july;

import java.util.*;
/*
1. cost의 크기를 오름차순으로 정렬한다
2. for문을 돌며 now_node 와 new_node의 parent를 비교한다.
3. 이미 연결되었다? 연결 x 왜냐면 더 적은 cost로 연결한 거니까
 */
public class 백준_네트워크_연결 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[m][3];
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < 3; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(graph, (o1, o2) -> o1[2]-o2[2]);
        int[] parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int cost = 0;
        for (int i = 0; i < graph.length; i++) {
            if (find(parent, graph[i][0]) != find(parent, graph[i][1])){
                cost += graph[i][2];
                union(parent, graph[i][0], graph[i][1]);
            }
        }
        System.out.println(cost);

    }
    static int find(int[] parent, int x){
        if (parent[x] == x){
            return x;
        }
        else {
            return find(parent, parent[x]);
        }
    }
    static void union(int[] parent, int x, int y){
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
