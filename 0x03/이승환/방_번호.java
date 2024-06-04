import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        int answer[] = new int[10];

        for (int i = 0; i < n.length(); i++) {
            int num = Character.getNumericValue(n.charAt(i));
            if (num == 6 || num == 9) {
                if (answer[6] > answer[9])
                    answer[9]++;
                else
                    answer[6]++;
            } else {
                answer[num]++;
            }
        }
        int count = 1;
        for (int i = 0; i < answer.length; i++) {
            if (count < answer[i])
                count = answer[i];
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
