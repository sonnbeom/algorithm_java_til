package january_2026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_소형기관차 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] train = new int[n];
        for (int i = 0; i < n; i++) {
            train[i] = Integer.parseInt(st.nextToken());
        }
        int t = Integer.parseInt(br.readLine());
//        int[] dp = new int[n];

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(3, 0, 0));
        int ans = 0;
// 5 2
        while (!q.isEmpty()){
            Pair pair = q.poll();
//            System.out.println(pair);
            //최고 값 갱신
            if (pair.coin == 0 || pair.idx == n-1) {
                ans = Math.max(ans, pair.sum);
                continue;
            }

            // 코인 돌리면서 더해주기
            if (pair.coin > 0 && pair.idx + t <= n ){

                //for문 돌리지 않고 패싱
                if (pair.idx + 1 < n){
                    q.add(new Pair(pair.coin, pair.idx+1, pair.sum));
                }

                // for문 돌리면서 coin-- max값 더해주기
                if (pair.coin > 0 && pair.idx + t <= n){
                    for (int i = 0; i < t; i++) {
                        pair.sum += train[pair.idx + i];
                    }
                    if (pair.coin == 0 || pair.idx + t == n) {
                        ans = Math.max(ans, pair.sum);
                    }
                    else {
                        q.add(new Pair(pair.coin-1, pair.idx + t, pair.sum));
                    }
                }
            }
        }
        System.out.println(ans);

    }
    static class Pair{
        int coin;
        int idx;
        int sum;

        @Override
        public String toString() {
            return "Pair{" +
                    "coin=" + coin +
                    ", idx=" + idx +
                    ", sum=" + sum +
                    '}';
        }

        Pair(int coin, int idx, int sum){
            this.coin = coin;
            this.idx = idx;
            this.sum = sum;
        }
    }
}
