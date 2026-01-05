package january_2026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_소형기관차_v2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // -----------------------------
        // 1) 입력 받기
        // -----------------------------
        // n: 객차(칸) 개수
        int n = Integer.parseInt(br.readLine());

        // passenger[i]: i번째 객차의 손님 수 (1-indexed로 관리)
        int[] passenger = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            passenger[i] = Integer.parseInt(st.nextToken());
        }

        // t: 소형 기관차 1대가 끌 수 있는 "연속 객차 수"
        // 즉, 기관차 1대가 한 번에 선택할 수 있는 구간 길이
        int t = Integer.parseInt(br.readLine());

        // -----------------------------
        // 2) 누적합(prefix sum) 만들기
        // -----------------------------
        // prefix[i] = 1번 객차 ~ i번 객차까지 손님 수의 합
        // 구간합을 O(1)로 뽑기 위한 전처리
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + passenger[i];
        }

        // -----------------------------
        // 3) window 배열 만들기 (길이 t짜리 구간합)
        // -----------------------------
        // window[i] = (i - t + 1)번 객차 ~ i번 객차까지의 손님 수 합
        // 즉, "i에서 끝나는" 길이 t짜리 구간을 기관차 1대가 끌 때 얻는 손님 수
        //
        // 예) t=3, i=7 이면 window[7]은 5~7번 객차 합
        int[] window = new int[n + 1];
        for (int i = t; i <= n; i++) {
            window[i] = prefix[i] - prefix[i - t];
        }

        // -----------------------------
        // 4) DP 정의
        // -----------------------------
        // dp[k][i] = 1번 객차 ~ i번 객차까지만 고려했을 때,
        //            소형 기관차를 k대 사용해서 얻을 수 있는 최대 손님 수
        //
        // k는 0~3 (총 3대)
        // i는 0~n
        //
        // 핵심: i번째까지 봤을 때, "i에서 끝나는 구간을 고르냐/안고르냐"로 나뉨
        int[][] dp = new int[4][n + 1];

        // -----------------------------
        // 5) 점화식(선택) 적용
        // -----------------------------
        // i에서의 선택은 2가지:
        //
        // (선택 A) i에서 끝나는 구간을 선택하지 않음
        //   -> dp[k][i] = dp[k][i-1]
        //
        // (선택 B) i에서 끝나는 길이 t 구간을 선택함 (i>=t일 때만 가능)
        //   -> 이 구간은 (i-t+1 ~ i)를 차지하므로,
        //      이전에 선택한 구간들과 겹치지 않으려면 "최소 i-t까지"에서 끝나야 함
        //   -> dp[k][i] = dp[k-1][i-t] + window[i]
        //
        // 최종적으로 둘 중 큰 값을 취함:
        // dp[k][i] = max(dp[k][i-1], dp[k-1][i-t] + window[i])
        for (int k = 1; k <= 3; k++) {          // 기관차 1대~3대까지
            for (int i = 1; i <= n; i++) {      // 1번 객차~n번 객차까지

                // (선택 A) 이번 i에서 끝나는 구간을 안 고르는 경우
                dp[k][i] = dp[k][i - 1];

                // (선택 B) i에서 끝나는 길이 t 구간을 고를 수 있는 경우
                if (i >= t) {
                    // i에서 끝나는 구간을 고르면 이전은 i-t까지만 허용(겹침 방지)
                    dp[k][i] = Math.max(dp[k][i], dp[k - 1][i - t] + window[i]);
                }
            }
        }

        // -----------------------------
        // 6) 정답 출력
        // -----------------------------
        // 객차 n개 전체를 고려했을 때, 기관차 3대를 사용한 최대 손님 수
        System.out.println(dp[3][n]);
    }
}
