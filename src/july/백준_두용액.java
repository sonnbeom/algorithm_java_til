package july;

import java.util.*;
public class 백준_두용액 {
    static long[] arr;
    static int n;
    static long[] answer;
    static long diff;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new long[n];
        answer = new long[2];
        diff = 1000000001;
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        func();

//        System.out.println(Arrays.toString(answer));
        System.out.print(answer[0] + " " + answer[1]);
;

    }
    static void func(){
        for (int i = 0; i < n-1; i++){
            long now = arr[i];

            for (int j = i+1; j < n; j++) {
                long next = arr[j];
                long a = Math.abs(next + now);

                if (diff <= a) return;
                else {
                    diff = a;
                    answer[0] = now;
                    answer[1] = next;
                }
            }
        }
    }
}
