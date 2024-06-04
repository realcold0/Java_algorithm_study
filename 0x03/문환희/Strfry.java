import java.util.Arrays;
import java.util.Scanner;

public class Strfry {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().split(" ");
            char[] tmp1 = arr[0].toCharArray();
            Arrays.sort(tmp1);
            char[] tmp2 = arr[1].toCharArray();
            Arrays.sort(tmp2);
            if(String.valueOf(tmp1).equals(String.valueOf(tmp2))) {
                System.out.println("Possible");
            }
            else{
                System.out.println("Impossible");
            }
        }

    }
}
