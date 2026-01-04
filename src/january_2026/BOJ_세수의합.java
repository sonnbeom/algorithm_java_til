package january_2026;

import java.io.*;
import java.util.*;

public class BOJ_세수의합 {
    static Map<Integer, Integer> map;
    static int n;
    static int[] u;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        u = new int[n];
        map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            u[i] = Integer.parseInt(br.readLine());
            map.put(u[i], u[i]);
        }
        Arrays.sort(u);

        Set<Integer> sum = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum.add(u[i] + u[j]);
            }
        }

        for (int i = n-1; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                int diff = u[i] - u[j];
                if (sum.contains(diff)){
                    System.out.println(u[i]);
                    return;
                }
            }
        }
    }
}

// for문을 돌면서 가장 뒤에 있는 숫자를 가지고 이거 완성할 수 있어? 해서 값 받고
// -1이면 for문 계속 돌고 아니면 리턴
// left mid right 거기서 삼중 for문..?
//아니면 온갖 합을 다 만들고 거기서 set에 있어요 하면 되는 거 아님?
// Map으로 해도 됨

// d는 idx 뒤에서 -1하기?