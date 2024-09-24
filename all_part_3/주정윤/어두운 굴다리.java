
import java.io.*;
import java.util.*;

public class 어두운 굴다리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  //터널 길이
        int m = Integer.parseInt(br.readLine());  //가로등 개수
        int[] lights = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        int maxDistance = Math.max(lights[0], n - lights[m - 1]);  //끝에서의 거리 처리

        for (int i = 1; i < m; i++) {
            int distance = (lights[i] - lights[i - 1] + 1) / 2;
            maxDistance = Math.max(maxDistance, distance);
        }

        System.out.println(maxDistance);
        br.close();
    }
}
