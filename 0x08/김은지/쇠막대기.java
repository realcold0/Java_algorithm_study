import java.io.*;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] line = br.readLine().toCharArray();
        int ans = 0;
        int tmp = 0;
        for(int i =0; i < line.length; i++){
            switch (line[i]){
                case'(':
                    tmp +=1;
                    break;
                case')':
                    //레이저
                    if(line[i-1] =='('){
                        tmp -=1;
                        ans +=tmp;
                    }else{
                        ans +=1;
                        tmp -=1;
                    }
                    break;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
