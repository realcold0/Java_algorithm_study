import java.util.Arrays;
import java.util.Scanner;

public class 개수_세기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int v = sc.nextInt();

        int res = 0;
        for(int i : arr) {
            if(i == v) res++;
        }
        System.out.println(res);

    }

}
