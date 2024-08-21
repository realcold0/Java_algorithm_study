import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Integer[]{s, e});
        }
        list.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[1].equals(o2[1])) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
//        list.stream().forEach(a -> System.out.println(a[0] + " " + a[1]));
        int answer = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (t > list.get(i)[0]) continue;
            answer++;
            t = list.get(i)[1];
        }
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
