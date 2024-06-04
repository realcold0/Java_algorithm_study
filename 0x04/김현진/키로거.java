import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> Lstack = new Stack<>();
        Stack<Character> Rstack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case '-':
                        if (!Lstack.isEmpty()) {
                            Lstack.pop();
                        }
                        break;
                    case '>':
                        if (!Rstack.isEmpty()) {
                            Lstack.push(Rstack.pop());
                        }
                        break;
                    case '<':
                        if (!Lstack.isEmpty()) {
                            Rstack.push(Lstack.pop());
                        }
                        break;
                    default:
                        Lstack.push(s.charAt(j));
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
}
