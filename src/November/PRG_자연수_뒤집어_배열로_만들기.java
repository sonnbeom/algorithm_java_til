package November;

public class PRG_자연수_뒤집어_배열로_만들기 {
    public int[] solution(long n) {
        String s = String.valueOf(n);

        int[] answer = new int[s.length()];

        for(int i = 0; i < s.length(); i++){
            answer[i] = Integer.parseInt(s.substring(s.length()-i-1, s.length()-i));
        }

        return answer;
    }
}