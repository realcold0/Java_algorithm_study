
import java.util.*;
import java.io.*;

public class 부분수열의 합
{
    static int N, S;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        //정수의 개수를 나타내는 n과 정수 S가 주어진다.

        N = Integer.parseInt(st1.nextToken());
        S = Integer.parseInt(st1.nextToken());;

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = (recur(0, 0));
        //공집합을 제거하기 위해 S가 0일 때는 -1을 해준다
        System.out.println(S == 0 ? count -1 : count);

    }

    public static int recur(int index, int sum) {
        // N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중
        // 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구해라
        if (index == N) {
            //합이 S가 되면 부분 수열의 개수 출력
            if (sum == S) count++;
            return count;
        }

        recur(index + 1, sum + arr[index]); //현재 인덱스의 요소를 포함하는 경우
        recur(index + 1, sum); //현재 인덱스의 요소를 포함하지 않는 경우

        return count;
    }
}