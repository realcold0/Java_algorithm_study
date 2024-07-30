package boj.simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class CCTV{
    private int category;
    private int r;
    private int c;
    private List<Integer> ccount = new ArrayList<>();

    public int getCategory(){
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public List<Integer> getCcount() {
        return ccount;
    }


    public void setCcount(int cDirec) {
        ccount.clear();
        switch(category){
            case 1:
                ccount.add(cDirec);
                break;
            case 2:
                ccount.add(cDirec);
                ccount.add((cDirec + 2 )%4);
                break;
            case 3:
                ccount.add(cDirec);
                ccount.add((cDirec + 1 )%4);
                break;
            case 4:
                ccount.add(cDirec);
                ccount.add((cDirec + 1 )%4);
                ccount.add((cDirec + 2 )%4);

                break;
            case 5:
                ccount.add(0);
                ccount.add(1);
                ccount.add(2);
                ccount.add(3);

                break;

        }


    }

    public CCTV(int cat, int r, int c){
        this.category = cat;
        this.r = r;
        this.c = c;
    }



}


public class 감시 {
    static int[][] map;
    // cctv 종류, r값, c값
    static List<CCTV> cctv;
    static int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    static int n;
    static int m;
    static int ans= 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map= new int[n][m];
        cctv = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // cctv 정보라면 담아두기
                if(map[i][j] != 0 && map[i][j] !=6){
                    CCTV tmpCCTV = new CCTV(map[i][j], i, j);
                    cctv.add(tmpCCTV);
                }
            }
        }
        nextcctv(0,new ArrayList<>());
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }

    static void nextcctv(int idx, List<Integer> curr){
        if(curr.size() == cctv.size()){
            // 계산하기
            ans = Math.min(findBlindSpot(curr),ans);
            return;
        }
        //4방향 돌기
        for(int i = 0; i < 4; i++){
            //curr에 cctv의 방향값 담기
            curr.add(i);
            nextcctv(idx+1, curr);
            curr.remove(curr.size()-1);
        }
    }

    static int findBlindSpot(List<Integer> curr){
        int count =0;
        int[][] tmpMap = new int[n][0];
        for(int i = 0; i < n; i++){
            tmpMap[i] = Arrays.copyOf(map[i],m);
        }
        //cctv가 보는 영역 칠하기
        for(int i = 0; i < curr.size();i++){
            int cDirec = curr.get(i);
            //한개의 cctvInfo : cctv종류, r값, c값
            CCTV onecctv = cctv.get(i);
            //cctv의 종류에 따라
            onecctv.setCcount(cDirec);
            List<Integer> ccount = onecctv.getCcount();
            //cctv의 시야 수만큼 맵 칠하기
            for(int j = 0; j < ccount.size(); j++){
                makeMap(ccount.get(j),onecctv.getR(), onecctv.getC(), tmpMap);
            }
        }
        //0개 갯수 세기
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(tmpMap[i][j]== 0){
                   count++;
                }
            }
        }
        return count;

    }

    static void makeMap(int i, int r, int c, int[][] tmpmap){
        int nr = r + dirs[i][0];
        int nc = c + dirs[i][1];

        while (0 <= nr && nr < n && 0 <= nc && nc < m && tmpmap[nr][nc] != 6) {
            if (tmpmap[nr][nc] == 0) {
                tmpmap[nr][nc] = -1;
            }
            nr += dirs[i][0];
            nc += dirs[i][1];
        }
    }


}
