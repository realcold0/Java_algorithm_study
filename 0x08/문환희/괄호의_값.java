import java.io.*;
import java.util.Stack;

public class 괄호의_값 {
    public static String str;
    public static int[] check;

//    static int calc(Stack<Character> stack, int idx, int sum) {
//
//        if(str.charAt(idx) == ')') {
//            if(str.charAt(idx - 1) == '(') {
//                return 2;
//            }
//            else {
//                return sum * 2;
//            }
//        }
//        else if(str.charAt(idx) == ']') {
//            if(str.charAt(idx - 1) == '[') {
//                return 3;
//            }
//            else {
//                return sum * 3;
//            }
//        }
//        else {
//            stack.push(str.charAt(idx));
//            sum += calc(stack, idx + 1, sum);
//        }
//        return sum;
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        check = new int[str.length()];
        Stack<Character> stack = new Stack<>();
        int val = 1;
        int ans = 0;
        for(int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == '(' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
                if(str.charAt(i) == '(') {
                    val *= 2;
                }
                else {
                    val *= 3;
                }
            }
            else {
                if(str.charAt(i) == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        ans = 0;
                        break;
                    }
                    else if(str.charAt(i - 1) == '('){
                        ans += val;
                    }
                    stack.pop();
                    val /= 2;
                }
                else if(str.charAt(i) == ']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        ans = 0;
                        break;
                    }
                    else if(str.charAt(i - 1) == '['){
                        ans += val;
                    }
                    stack.pop();
                    val /= 3;
                }
            }
        }
        if(!stack.isEmpty()) {bw.write("0\n");}
        else {bw.write(String.valueOf(ans));}

        bw.flush();
        bw.close();
        br.close();


    }
}
