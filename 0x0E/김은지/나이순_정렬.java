import java.util.*;
import java.io.*;

class Member implements Comparable<Member>{
    int idx;
    int age;
    String name;
    
    Member(int idx, int age, String name){
        this.idx = idx;
        this.age = age;
        this.name = name;
    }
    
    @Override
    public int compareTo(Member o){
        int firstSort = age - o.age;
        if(firstSort !=0) return firstSort;
        return idx-o.idx;
    }
    @Override
    public String toString(){
        return age +" "+name;
    }
    
}


public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Member[] members = new Member[n];
        StringTokenizer st = null;
        for(int i =0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            members[i] = new Member(i, Integer.parseInt(st.nextToken()),st.nextToken());
        }
        Arrays.sort(members);
        for(Member m : members){
            bw.write(m.toString());
            bw.newLine();
        }
        bw.flush();
    }
    
    
}