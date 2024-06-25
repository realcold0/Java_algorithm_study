import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int ans = 0;
        int cnt = 0; // 현재 막대기 개수
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                cnt++;
            } else {
                if (s.charAt(i-1) == '(') { // 레이저
                    cnt--;
                    ans += cnt;
                } else {
                    cnt--;
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
