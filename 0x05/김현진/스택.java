import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] stack = new int[10001];
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch (s) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    static void push(int n) {
        stack[idx] = n;
        idx++;
    }

    static int pop() {
        if (idx == 0) {
            return -1;
        }
        int tmp = stack[idx-1];
        stack[idx-1] = 0;
        idx--;
        return tmp;
    }

    static int size() {
        return idx;
    }

    static int empty() {
        if (idx == 0) {
            return 1;
        }
        return 0;
    }

    static int top() {
        if (idx == 0) {
            return -1;
        }
        return stack[idx-1];
    }
}
