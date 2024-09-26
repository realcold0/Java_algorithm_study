import java.io.*;

public class 회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);

        int[] belt = new int[n];
        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] sushi = new int[d + 1];
        int uniqueCount = 0;
        for (int i = 0; i < k; i++) {
            if (sushi[belt[i]] == 0) uniqueCount++;
            sushi[belt[i]]++;
        }

        int maxSushi = uniqueCount;

        for (int i = 0; i < n; i++) {
            int endIndex = (i + k) % n;

            if (sushi[belt[i]] == 1) uniqueCount--;
            sushi[belt[i]]--;

            if (sushi[belt[endIndex]] == 0) uniqueCount++;
            sushi[belt[endIndex]]++;

            int currentMax = uniqueCount;
            if (sushi[c] == 0) currentMax++;

            maxSushi = Math.max(maxSushi, currentMax);
        }

        bw.write(maxSushi + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
