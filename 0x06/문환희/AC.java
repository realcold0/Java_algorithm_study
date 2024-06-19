import java.io.*;
import java.util.*;

public class AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());


        outer:
        for (int i = 0; i < tc; i++) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> dq = new LinkedList<>();
            String input = br.readLine();

            if (n > 0) {
                for (String s : input.substring(1, input.length() - 1).split(",")) {
                    dq.add(Integer.parseInt(s));
                }
            }
            boolean flag = true; //앞
            //boolean isError = false;
            for (char c : p) {
                if (c == 'R') {
                    flag = !flag;
                } else {
                    if (dq.isEmpty()) {
                        bw.write("error\n");
                        continue outer;
                    }
                    if (flag) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            answer.append("[");
            if (flag) {
                while (!dq.isEmpty()) {
                    answer.append(dq.pollFirst());
                    if (!dq.isEmpty()) {
                        answer.append(",");
                    }
                }
            } else {
                while (!dq.isEmpty()) {
                    answer.append(dq.pollLast());
                    if (!dq.isEmpty()) {
                        answer.append(",");
                    }
                }
            }
            answer.append("]\n");

            bw.write(answer.toString());


        }
        bw.flush();
        bw.close();
        br.close();
    }
}
