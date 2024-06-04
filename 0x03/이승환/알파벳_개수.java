import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int answer[] = new int[50];

        for(int i =0;i < S.length(); i++){
            char tmp = S.charAt(i);

            int index = tmp - 'a';

            answer[index]++;
        }

        StringBuilder sb  = new StringBuilder();
        for(int i =0;i< 26;i++){
            sb.append(answer[i]).append(" ");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}