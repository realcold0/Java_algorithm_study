import java.io.*;
import java.util.Arrays;

public class 곱셈 {

    static Long devide(Long A, Long B, Long C) {
        if (B == 1) {
            return A % C;
        }

        Long res = devide(A, B / 2, C);
        res = (res * res) % C;

        if (B % 2 == 0) {
            return res;
        }

        return (res * A) % C;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Long A = (long) input[0];
        Long B = (long) input[1];
        Long C = (long) input[2];

        System.out.println(devide(A, B, C));

    }
}
