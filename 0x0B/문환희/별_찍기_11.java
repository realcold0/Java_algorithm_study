import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 별_찍기_11 {
    static char[][] map;
    static void print(int n, int i, int j) {
        if(n == 3) {
            for(int k = 0; k < 3; k++) {
                for(int l = -2; l < 3; l++) {
                    if(k == 0 && (l == -2 || l == 2 || l == 1 || l == -1)) {
                        continue;
                    }
                    else if(k == 1 && (l == -2 || l == 0 || l == 2)) {
                        continue;
                    }
                    map[i + k][j + l] = '*';
                }
            }
        }
        else {
            print(n / 2, i, j);
            print(n / 2, i + (n / 2), j - (n / 2));
            print(n / 2, i + (n / 2), j + (n / 2));

        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scanner.nextInt();
        map = new char[n][n * 2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n * 2; j++) {
                map[i][j] = ' ';
            }
        }
        print(n, 0, n - 1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n * 2; j++) {
                bw.write(map[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
