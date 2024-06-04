import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); // 초기 문자열
        Stack<Character> Lstack = new Stack<>(); // 왼쪽 스택
        Stack<Character> Rstack = new Stack<>(); // 오른쪽 스택
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < s.length(); i++) {
            Lstack.push(s.charAt(i)); // 초기 문자열 스택에 넣기
        }

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            switch (tmp.charAt(0)) {
                case 'L':
                    if (!Lstack.isEmpty()) { // 커서가 맨 앞이 아닐 경우
                        Rstack.push(Lstack.pop());
                    }
                    break;
                case 'D':
                    if (!Rstack.isEmpty()) { // 커서가 맨 뒤가 아닐 경우
                        Lstack.push(Rstack.pop());
                    }
                    break;
                case 'B':
                    if (!Lstack.isEmpty()) {
                        Lstack.pop();
                    }
                    break;
                case 'P':
                    Lstack.push(tmp.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!Lstack.isEmpty()) {
            Rstack.push(Lstack.pop());
        }
        while (!Rstack.isEmpty()) {
            sb.append(Rstack.pop());
        }
        System.out.println(sb);
    }
}
