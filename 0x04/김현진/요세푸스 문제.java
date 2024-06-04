import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int idx = 0;
        sb.append("<");
        while (list.size() > 1) {
            idx = (idx + K - 1) % list.size();
            sb.append(list.remove(idx)).append(", ");
        }
        sb.append(list.remove(0)).append(">");

        System.out.println(sb);

    }
}
