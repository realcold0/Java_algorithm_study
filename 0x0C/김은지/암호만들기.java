import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 암호만들기 {
    static StringBuilder sb = new StringBuilder();
    public static void backtrack(List<Character>list, int l, ArrayList<Character>curr,boolean[] visited, int cnt,int idx) {
        if(curr.size() ==l){
            if(0<cnt && cnt<curr.size()-1){
            //print
            for(char c : curr){
                sb.append(c);
            }
            sb.append('\n');
            }
            return;
        }
        for(int i = idx; i<list.size(); i++) {
            if(visited[i]) continue;
            boolean flag = false;
            if(list.get(i) == 'a'||list.get(i) == 'e'||list.get(i) == 'i'||list.get(i) == 'o'||list.get(i) == 'u'){
                cnt++;
                flag = true;
            }
            curr.add(list.get(i));
            visited[i] =true;
            backtrack(list, l, curr,visited,cnt,i);
            curr.remove(curr.size()-1);
            visited[i] = false;
            if(flag){
                cnt--;
            };
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Character> list = new ArrayList<Character>();
        boolean[] visited = new boolean[c];
        for(int i=0; i<c;i++){
            list.add(st.nextToken().charAt(0));
        }
        Collections.sort(list);
        backtrack(list,l,new ArrayList<Character>(),visited,0,0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
