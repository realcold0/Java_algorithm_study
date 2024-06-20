import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐 크기
        int cnt = 0;
        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i); // deque에 기본 원소 삽입
        }

        while (st.hasMoreTokens()) { // 다음 토큰이 남아있을 때까지
            int tmp = Integer.parseInt(st.nextToken());

            while (deque.peekFirst() != tmp) {
                if ((deque.size() / 2) >= deque.indexOf(tmp)) {
                    deque.addLast(deque.removeFirst());
                    cnt++;
                } else {
                    deque.addFirst(deque.removeLast());
                    cnt++;
                }
            }
            deque.removeFirst();
        }
        System.out.println(cnt);
    }
}
