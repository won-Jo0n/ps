import java.util.*;


class Solution {
    int[] changeRow = new int[]{-1,1,0,0};
    int[] changeCol = new int[]{0,0,-1,1};
    boolean[][] visited;
    int row;
    int col;
    
    public int solution(int[][] land) {
        int answer = 0;
        row = land.length;
        col = land[0].length;
        visited = new boolean[row][col];
        int[] sumOil = new int[col];
        int maxOil = 0;
        
        for(int r = 0; r < row; r++){
            for(int c=0; c<col; c++){
                if(land[r][c] == 1 && !visited[r][c]){
                    Map<String,Object> result = bfs(land, r, c);
                    int countOil = (int) result.get("countOil");
                    Set<Integer> set = (Set<Integer>) result.get("set");
                    
                    for(int colIdx : set){
                        sumOil[colIdx] += countOil;
                    }
                }
            }
        }
        
        for(int i = 0; i < sumOil.length; i++){
            if(sumOil[i] > maxOil){
                maxOil = sumOil[i];
            }
        }
        
        answer = maxOil;
            
        return answer;
    }
    private Map<String,Object> bfs(int[][] land, int startRow, int startCol){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        
        int countOil = 0;
        Set<Integer> set = new HashSet<>();
        
        while(!queue.isEmpty()){
            int[] curPoint = queue.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];
            
            countOil++;
            set.add(curCol);
            
            for(int i = 0; i < 4; i++){
                int qr = curRow + changeRow[i];
                int qc = curCol + changeCol[i];
                
                if(qr >= 0 && qr < row && qc >=0 && qc < col&&
                   land[qr][qc] == 1 && !visited[qr][qc]
                  ){
                    visited[qr][qc] = true;
                    queue.add(new int[]{qr,qc});
                }
                
            }
            
        }
        Map<String, Object> result = new HashMap<>();
        result.put("countOil", countOil);
        result.put("set", set);
        return result;
    }
    
}