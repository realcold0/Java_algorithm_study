import java.io.*;

public class Boj_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String multi = Integer.toString(A*B*C);
        char ans_arr[];
        ans_arr = multi.toCharArray();
        int answer[] = new int [10];
        for(int i = 0; i < ans_arr.length ; i++){

            answer[ans_arr[i] -'0'] ++;
        }
        for (int j = 0; j < answer.length; j++){
            System.out.println(answer[j]);
        }

    }
}
