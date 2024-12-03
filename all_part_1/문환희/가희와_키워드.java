import java.util.HashSet;
import java.util.Scanner;

public class 가희와_키워드 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(sc.nextLine());
        }
        for(int i = 0; i < m; i++) {
            String[] input = sc.nextLine().split(",");
            for(String s : input) {
                set.remove(s);
            }
            System.out.println(set.size());
        }
    }
}
