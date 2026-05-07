package may;

public class PRG_피보나치수 {
    public int solution(int n) {
        int past = 0;
        int now = 1;
        int last = 0;
        for(int i = 0; i < n-1; i++){
            int next = (now + past) % 1234567;
            int temp = now;
            now = next;
            past = temp;
        }
        return now;

    }
}
