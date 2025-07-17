import java.util.*;

class Solution {
    int count=0;
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        dfs(1, 1,n, q, ans, new boolean[n+1]);
        
        answer = count;
        return answer;
    }
    private void dfs(int cur, int cnt, int n, int[][] q, int[] ans, boolean[] pickedNum){
        
        if(cnt > 5){
            for(int i = 0; i < q.length; i++){
                int matchCount = 0;
                for(int j=0; j < q[0].length; j++){
                    if(matchCount > ans[i]) return;
                    if(pickedNum[q[i][j]]) matchCount++;
                }
                if(ans[i] != matchCount) return;
            }
            count++;
            return;
        }
        
        for(int i = cur; i <= n; i++){
            pickedNum[i] = true;
            dfs(i+1, cnt+1, n, q, ans, pickedNum);
            pickedNum[i] = false;
        }
        
    }
    
}