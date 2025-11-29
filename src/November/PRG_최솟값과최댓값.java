package November;

public class PRG_최솟값과최댓값 {
}
class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int max = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[0]);
        for(String a: arr){
            int now = Integer.parseInt(a);
            if (now > max){
                max = now;
            }
            if (now < min){
                min = now;
            }
        }
        return min + " " + max;
    }
}