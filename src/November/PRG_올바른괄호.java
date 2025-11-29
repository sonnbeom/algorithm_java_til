package November;
import java.util.*;

public class PRG_올바른괄호 {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.push(c);
            }
            else{
                if (stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}



