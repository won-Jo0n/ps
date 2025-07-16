import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        int[] countReport = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++){
            map.put(id_list[i], i);
        }
        
        boolean[][] graph = new boolean[id_list.length][id_list.length];
        
        for(int i=0; i < report.length; i++){
            String[] user = report[i].split(" ");
            int doReportUser = map.get(user[0]);
            int reportedUser = map.get(user[1]);
            graph[doReportUser][reportedUser] = true;
        }
        
        
        for(int i=0; i < graph.length; i++){
            for(int j=0; j <graph[0].length; j++ ){
                if(graph[i][j]){
                    countReport[j]++;
                }
            }
        }
        
        for(int i=0; i< countReport.length; i++){
            if(countReport[i] >= k){
                for(int j=0; j < id_list.length; j++){
                    if(graph[j][i]){
                        answer[j]++;
                        
                    }
                }
            }
        }
        
        return answer;
    }
}