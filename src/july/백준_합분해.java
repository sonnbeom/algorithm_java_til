package july;
import java.util.*;

public class 백준_합분해 {
    static int n;
    static int k;
    static int[] arr;
    static long [] dp;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        dp = new long[n+1];
        arr = new int[n+1];
        answer = 0;
        for (int i = 0; i <= n; i++){
            arr[i] = i;
        }
        Queue<int[]> q = new LinkedList<>();
        for(int a : arr){
            if (a <= n){
                q.offer(new int[]{1,a});
            }
        }
        while (!q.isEmpty()){
            answer = answer % 1000000000;
            int[] pair = q.poll();
            int time  = pair[0];
            int sum  = pair[1];

            if (time > k || sum > n){
                continue;
            }

            if (time == k && sum == n){
                answer++;
                continue;
            }

            for(int i = 0; i <= n - sum; i++){
                if (i+sum <= n && time+1 <= k){
                    q.offer(new int[]{time+1, i+sum});
                }
            }
        }
        System.out.print(answer);
//        System.out.println(Arrays.toString(dp));
    }
}
