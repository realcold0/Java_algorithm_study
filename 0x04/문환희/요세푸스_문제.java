import java.util.*;

public class 요세푸스_문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < arr[0]; i++) {
            queue.add(i + 1);
        }
        ArrayList<Integer> result = new ArrayList<>();
        int idx = 0;
        while(!queue.isEmpty()) {
            int tmp = ((idx + (arr[1] - 1)) % queue.size());
            result.add(queue.get(tmp));
            queue.remove(tmp);
            idx = tmp;
        }
        char[] res = result.toString().toCharArray();

        res[0] = '<';
        res[res.length - 1] = '>';

        System.out.println(res);


    }
}
