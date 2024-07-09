import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 색종이_만들기 {
    static int white = 0;
    static int blue = 0;

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
            if (map[i][j] == 0) {
                white++;
            } else {
                blue++;
            }
        }
        else {
            devide(n / 2, i, j);
            devide(n / 2, i + (n / 2), j);
            devide(n / 2, i, j + (n / 2));
            devide(n / 2, i + (n / 2), j + (n / 2));
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
        System.out.println(white);
        System.out.println(blue);
    }
}
