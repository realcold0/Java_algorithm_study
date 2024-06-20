import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<Integer> deque;
    static StringBuilder sb = new StringBuilder();;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            deque = new ArrayDeque<>(); // deque 초기화

            int flag = 0; // 0이면 앞부터, 1이면 뒤부터 (순서 변경)
            boolean error = false; // error인지 확인
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String x = br.readLine();

            String[] arr = x.substring(1, x.length() - 1).split(","); // [와 ] 제거하고 , 기준으로 나눠서 배열에 저장

            for (int j = 0; j < n; j++) { // deque에 정수 넣기
                deque.addLast(Integer.parseInt(arr[j]));
            }

            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    if (flag == 0) {
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                } else {
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        error = true;
                        break;
                    }
                    if (flag == 0) { // 앞부터 시작
                        deque.removeFirst();
                    } else { // 뒤부터 시작
                        deque.removeLast();
                    }
                }
            }
            if (!error) {
                sb.append("[");
                while(!deque.isEmpty()) {
                    if (flag == 0) {
                        sb.append(deque.removeFirst());
                    } else {
                        sb.append(deque.removeLast());
                    }
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}