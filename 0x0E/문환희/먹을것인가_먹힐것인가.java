import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 먹을것인가_먹힐것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            int answer = 0;
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            List<Integer> a = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());

            List<Integer> b = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());

            a.sort(Integer::compareTo);
            b.sort(Integer::compareTo);

            for(int num : a) {
                int left = 0;
                int right = b.size();
                while(left < right) {
                    if(b.get((left + right) / 2) < num) {
                        left = (left + right) / 2 + 1;
                    }
                    else {
                        right = (left + right) / 2;
                    }
                }
                answer += (left + right) / 2;
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
