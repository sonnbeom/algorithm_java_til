package january_2026;
import java.util.Scanner;

public class BOJ_빗물_v2 {
    static int h, w;
    static int[] height;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        h = scan.nextInt();
        w = scan.nextInt();

        height = new int[w];
        for (int i = 0; i < w; i++) {
            height[i] = scan.nextInt();
        }

        int result = 0;

        for (int i = 1; i < w-1; i++) {
            int l = 0;
            int r = 0;

            for (int j = 0; j < i; j++) {
                l = Math.max(l, height[j]);
            }

            for (int j = i + 1; j < w; j++) {
                r = Math.max(r, height[j]);
            }

            if (height[i] < l && height[i] < r){
                result += Math.min(l, r) - height[i];
            }
        }
        System.out.println(result);
    }
}
