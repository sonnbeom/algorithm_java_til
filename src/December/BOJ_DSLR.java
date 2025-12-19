package December;
import java.util.*;

public class BOJ_DSLR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int input = sc.nextInt();
            int output = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] str = new String[10000];
            Arrays.fill(str, "");

            visited[input] = true;
            q.add(input);

            while (!q.isEmpty() && !visited[output]){
                int now = q.poll();

                int D = (now * 2) % 10000;
                int S = now == 0 ? 9999 : now -1;
                int L = now / 1000 + (now % 1000) * 10;
                int R = now / 10 + (now % 10) * 1000;

                if (!visited[D]){
                    q.add(D);
                    visited[D] = true;
                    str[D] = str[now] + "D";
                }
                if (!visited[S]){
                    q.add(S);
                    visited[S] = true;
                    str[S] = str[now] + "S";
                }
                if (!visited[L]){
                    q.add(L);
                    visited[L] = true;
                    str[L] = str[now] + "L";
                }
                if (!visited[R]){
                    q.add(R);
                    visited[R] = true;
                    str[R] = str[now] + "R";
                }
            }
            System.out.println(str[output]);

        }


    }
}

/*
/아웃풋을 계속 dslr 계속 돌리고 결과 나오면 결과 리턴
2배 if 9999보다 크다면 나머지
x * 2 =
1 -> 0 9999
9999 -> 1

 */

