import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class task_15 {
    public static void main(String[] args) {
        System.out.println(func_for_line("[[(()]]"));
    }

    public static boolean func_for_line(String val){
        Stack<Character> stack = new Stack<Character>();
        boolean res = true;

        if (val.length()%2 != 0){
            res = false;
            return res;
        }

        for (int i = 0; i < val.length(); i++){
            char temp = val.charAt(i);
            if (temp == '(' || temp == '{' || temp == '[' ){
                stack.push(temp);
            }
            else if(temp == ')'){
                if (stack.peek() != '('){
                    res = false;
                    return res;
                }
            }
            else if(temp == ']'){
                if (stack.peek() != '['){
                    res = false;
                    return res;
                }
            }
            else if(temp == '}'){
                if (stack.peek() != '{'){
                    res = false;
                    return res;
                }
            }
        }
        return res;
    }

}
