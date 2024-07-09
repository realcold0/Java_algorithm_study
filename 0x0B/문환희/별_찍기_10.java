import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 별_찍기_10 {
    static char[][] map;
    static void print(int n, int i, int j) {
        if(n == 1) {
            map[i][j] = '*';
        }
        else {
            int size = n / 3;
            map[i][j] = ' ';
            for (int p = 0; p < 3; p++) {
                for (int q = 0; q < 3; q++) {
                    if(p == 1 && q == 1) {
                        continue;
                    }
                    print(size, i + p * size, j + q * size);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scanner.nextInt();
        map = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = ' ';
            }
        }
        print(n, 0, 0);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                bw.write(map[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
