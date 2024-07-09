import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 종이의_개수 {
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    static int[][] map;

    static boolean check(int n, int i, int j) {
        int c = map[i][j];
        for(int p = i; p < i + n; p++) {
            for(int q = j; q < j + n; q++) {
                if(map[p][q] != c) {
                    return false;
                }
            }
        }
        return true;
    }

    static void devide(int n, int i, int j) {
        if(check(n, i, j)) {
            if (map[i][j] == -1) {
                minus++;
            }
            else if(map[i][j] == 0) {
                zero++;
            }
            else {
                plus++;
            }
        }
        else {
            int third = n / 3;
            for (int p = 0; p < 3; p++) {
                for (int q = 0; q < 3; q++) {
                    devide(third, i + p * third, j + q * third);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        devide(n, 0, 0);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }
}
