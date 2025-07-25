package july;

import java.util.*;
public class 백준_컨베이어벨트 {
    static boolean[] robots;
    static int[] belt;
    static int n;
    static int k;
    static int len;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        len = 2*n;
        robots = new boolean[n];
        belt = new int[len];
        for(int i = 0; i < 2*n; i++){
            belt[i] = sc.nextInt();
        }
        func();
        System.out.print(answer);
    }
    // 단계별로 내구도가 0인 칸 갯수 체크해서 출력하기
    static void func(){
        int start = 0;
        int pointer = 0;

        while (true){
            start += 1;
            // 1단계 벨트 포인터 옮기고 로봇도 위치 옮기고 내리는 위치면 내려
            pointer = (pointer+1) % len;
            for(int i = n-2; i >= 0; i--){
                if(robots[i]){
                    robots[i] = false;
                    robots[i+1] = true;
                }
            }
            if (robots[n-1]){
                robots[n-1] = false;
            }
            // 2단계
            for (int i = n-2; i >= 0; i--){
                if (robots[i]){
                    int idx = (pointer + i) % len;
                    if (belt[idx] > 0){
                        if (!robots[i+1]){
                            belt[idx] -= 1;
                            robots[i+1] = true;
                            robots[i] = false;
                            if (robots[n-1]){
                                robots[n-1] = false;
                            }

                        }

                    }
                }
            }
            if (belt[pointer] > 0){
                belt[pointer] -= 1;
                robots[0] = true;
            }

            int count = 0;
            for(int b: belt){
                if(b == 0){
                    count++;
                }
            }
            if (count >= k){
                answer = start;
                return;
            }

        }
    }

}
