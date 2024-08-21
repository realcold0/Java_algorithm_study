import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new int[]{s, e});
        }

        Collections.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int start = 0;
        int end = 0;
        int answer = 0;
        int length = 0;
        for (int i = 0; i < n; i++) {
            int s = arr.get(i)[0];
            int e = arr.get(i)[1];
            if (s >= start && e <= end) continue;
            else if (s >= start && s <= end) { //시작이 범위 안일때
                length += e - end; //length에 길이 추가
                end = e;
            } else if (e >= start && e <= end) {
                length += start - s;
                start = s;
            } else { //새로운 범위일때
                answer += length; //이전의 완성된 길이 추가
                start = s;
                end = e;
                length = e - s;
            }
        }
        answer += length;

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
