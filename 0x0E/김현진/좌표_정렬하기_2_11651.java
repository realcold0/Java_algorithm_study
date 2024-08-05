import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Cord cord[] = new Cord[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cord[i] = new Cord(x, y);

        }

        Arrays.sort(cord);

        for (int i = 0; i < N; i++) {
            bw.write(cord[i].x + " " + cord[i].y + "\n");
        }
        bw.flush();
        bw.close();

    }

    static class Cord implements Comparable<Cord> {
        int x;
        int y;

        public Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Cord o) {
            if (this.y == o.y) {
                return this.x - o.x;
            } else {
                return this.y - o.y;
            }
        }
    }
}
