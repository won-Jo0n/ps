import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer = bfs(new int[]{0, 0, 1},maps);
        return answer;
    }
    public int bfs(int[] start,int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        queue.add(start);
        for(int i = 0; i < maps.length; i++){
            for(int j=0; j< maps[0].length; j++){
                if(maps[i][j]==0){
                    visited[i][j] = true;
                }
            }
        }
        visited[start[1]][start[0]] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            for(int x= -1; x <= 1; x ++){
                for(int y = -1; y<= 1; y++){
                    if(Math.abs(x) == Math.abs(y)) continue;
                    int[] pos = new int[]{current[0] + x,current[1] + y, current[2] + 1};
                    if(pos[0] < 0 || pos[1] < 0)  continue;
                    if(pos[0] >= maps[0].length || pos[1] >= maps.length) continue;
                    if(visited[pos[1]][pos[0]]) continue; 
                    
                    if(pos[0] == maps[0].length -1 && pos[1] == maps.length -1){
                        
                        return pos[2];
                    }
                    
                    
                    
                    queue.add(pos);
                    visited[pos[1]][pos[0]] = true;
                    
                }
            }
            
        }
        return -1;
        
    }
    
}