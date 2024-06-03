import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b =  Integer.parseInt(br.readLine());
        int c =  Integer.parseInt(br.readLine());

        int result = a * b* c;
        int answer[] = new int[10];
        String resultString = Integer.toString(result);

        for(int i =0; i< resultString.length(); i++){
            answer[resultString.charAt(i) - '0']++;
        }
        for(int i = 0; i<10; i++){
            bw.write(answer[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
