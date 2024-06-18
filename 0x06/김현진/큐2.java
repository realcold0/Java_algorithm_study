import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static int last = 0; // 마지막 값 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    push(last);
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
            }

        }
        System.out.println(sb);
    }

    static void push(int x) {
        queue.offer(x);
    }

    static int pop() {
        if (!queue.isEmpty()) {
            return queue.poll();
        }
        return -1;
    }

    static int size() {
        return queue.size();
    }

    static int empty() {
        if (queue.isEmpty()) {
            return 1;
        }
        return 0;
    }

    static int front() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return -1;
    }

    static int back() {
        if (!queue.isEmpty()) {
            return last;
        }
        return -1;
    }
}
