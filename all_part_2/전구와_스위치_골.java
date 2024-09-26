import java.io.*;
public class Main {
    public static int changeBulb(int[] arr, int[] target, int n, boolean press) {
        int count = 0;
        // 첫 번째 스위치를 누르는 경우
        if (press) {
            arr[0] = 1 - arr[0];
            arr[1] = 1 - arr[1];
            count++;
        }

        // 두 번째 전구부터 처리
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != target[i - 1]) {
                count++;
                arr[i - 1] = 1 - arr[i - 1]; // 현재 전구 변경
                arr[i] = 1 - arr[i];         // 바로 다음 전구 변경
                if (i + 1 < n) {
                    arr[i + 1] = 1 - arr[i + 1]; // 그 다음 전구도 변경
                }
            }
        }

        // 목표 상태와 같은지 확인
        for (int i = 0; i < n; i++) {
            if (arr[i] != target[i]) {
                return Integer.MAX_VALUE; // 목표 상태와 다르면 불가능한 경우로 처리
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new Buffer/edWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String initStr = br.readLine();
        String targetStr = br.readLine();

        int[] init1 = new int[n];
        int[] init2 = new int[n];
        int[] target = new int[n];
        for(int i =0; i<n; i++) {
            init1[i] = initStr.charAt(i) - '0';
            init2[i] = initStr.charAt(i) - '0';
            target[i] = targetStr.charAt(i) - '0';
        }


        //첫 스위치 ON
        int test1 = changeBulb(init1, target, n, true);
        //첫 스위치 Pass
        int test2 = changeBulb(init2, target, n, false);
        int ans = Math.min(test1,test2);
        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }

    }
}
