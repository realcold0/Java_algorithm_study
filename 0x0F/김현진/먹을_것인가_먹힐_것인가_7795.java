import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Integer arrA[] = new Integer[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arrA[j] = Integer.parseInt(st.nextToken());
            }

            Integer arrB[] = new Integer[M];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arrB[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrA, Collections.reverseOrder());
            Arrays.sort(arrB);

            int cnt = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arrA[j] > arrB[k]) {
                        cnt++;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
