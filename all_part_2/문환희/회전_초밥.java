import java.io.*;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class 회전_초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);

        int[] belt = new int[n];
        int[] counts = new int[d + 1];


        for(int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        Deque<Integer> window = new LinkedList<>();

        int current = 0;


        for (int i = 0; i < k; i++) {
            int sushi = belt[i];
            window.addLast(sushi);
            if (counts[sushi] == 0) {
                current++;
            }
            counts[sushi]++;
        }
        answer = counts[c] == 0 ? current + 1 : current;

        for(int i = 1; i < n; i++) {

            int removed = window.removeFirst();
            counts[removed]--;
            if(counts[removed] == 0) {
                current--;
            }

            int addNew = belt[(i + k - 1) % n];
            window.addLast(addNew);
            if(counts[addNew] == 0) {
                current++;
            }

            counts[addNew]++;

            int res = counts[c] == 0 ? current + 1 : current;
            answer = Math.max(answer, res);

        }

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}