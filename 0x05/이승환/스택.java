import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String commend = st.nextToken();
            switch (commend) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "top":
                    if(stack.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }else{
                        sb.append(stack.peek()).append("\n");
                        break;
                    }
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(stack.isEmpty()) {
                        sb.append("1").append("\n");
                        break;
                    } else {
                        sb.append("0").append("\n");
                        break;
                    }
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append("-1").append("\n");
                        break;
                    } else {
                        sb.append(stack.pop()).append("\n");
                        break;
                    }
                default:
                    break;
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
