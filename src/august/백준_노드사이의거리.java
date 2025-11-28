package august;

import java.util.*;
public class 백준_노드사이의거리 {
    static int n;
    static int m;
    static ArrayList<Pair>[] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph[a].add(new Pair(cost, b));
            graph[b].add(new Pair(cost, a));
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(func(a,b));
        }

    }
    static int func(int now, int target){
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(0, now));
        int max = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n+1];
        visited[now] = true;
        while(!q.isEmpty()){
            Pair pair = q.poll();

            if (pair.next == target){
                return pair.cost;
            }
            for (Pair nextPair : graph[pair.next]) {
                if (!visited[nextPair.next]){
                    visited[nextPair.next] = true;
                    q.offer(new Pair(pair.cost + nextPair.cost, nextPair.next));
                }
            }

        }
        return max;
    }
    static class Pair{
        int cost;
        int next;

        Pair(int cost, int next){
            this.cost = cost;
            this.next = next;
        }
    }
}
