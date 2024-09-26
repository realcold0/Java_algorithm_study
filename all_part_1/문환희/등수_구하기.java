import java.util.*;
import java.util.stream.Collectors;

public class 등수_구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] scores;
        if (n > 0) {
            scores = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } else {
            scores = new int[0];
        }

        if (n == 0) {
            System.out.println(1);
            return;
        }
        int rank = 1;

        if(n == p && scores[n - 1] >= s) {
            System.out.println(-1);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(scores[i] > s) {
                rank++;
            }
            else {
                break;
            }
        }
        System.out.println(rank);
    }
}
