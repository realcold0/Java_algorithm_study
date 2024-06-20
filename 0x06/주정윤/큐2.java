
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        // 명령의 수 N 값 입력
        int N = Integer.parseInt(br.readLine());

        // back 함수를 구현하기 위해 매번 push하며 last의 값을 업데이트
        int last = 0;

        // N개의 줄에 명령이 하나씩 주어짐
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); // 명령어

            switch (command) {
                case "push":
                    int value = Integer.parseInt(st.nextToken()); // 명령어 뒤 값
                    last = value;
                    queue.add(value);
                    break;
                case "pop":
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.remove()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.peek()).append("\n");
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(last).append("\n");
                    break;
            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}