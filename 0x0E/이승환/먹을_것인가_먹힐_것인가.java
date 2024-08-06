import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Integer[] arrA = new Integer[a];
            int[] arrB = new int[b];

            //a입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < a; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            //b입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < b; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrB);
            int count = 0;
            for (int i = 0; i < a; i++) {
                int left = 0;
                int right = b - 1;
                int index = 0;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (arrB[mid] < arrA[i]) {//b의 값이 지금 a값 보다 작다면
                        left = mid + 1;
                        index = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                count += index;
            }
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
