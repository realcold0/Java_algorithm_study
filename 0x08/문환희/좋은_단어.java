import java.io.*;
import java.util.Stack;

public class 좋은_단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int i = 1; i <= n; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(Character c : input.toCharArray()) {
                if(!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
            if(stack.isEmpty()) {
                answer++;
            }
        }


        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();

    }
}
