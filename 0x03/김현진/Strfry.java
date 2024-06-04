import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            int[] arr = new int[26];
            int[] arr2 = new int[26];

            for (int j = 0; j < a.length(); j++) {
                arr[a.charAt(j)-'a']++; // arr에 a 글자 체크
            }

            for (int j = 0; j < b.length(); j++) {
                arr2[b.charAt(j)-'a']++; // arr2에 b 글자 체크
            }

            for (int j = 0; j < 26; j++) {
                if (arr[j] != arr2[j]) {
                    System.out.println("Impossible");
                    return;
                } else if (j == 25) {
                    System.out.println("Possible");
                }
            }
        }
    }
}
