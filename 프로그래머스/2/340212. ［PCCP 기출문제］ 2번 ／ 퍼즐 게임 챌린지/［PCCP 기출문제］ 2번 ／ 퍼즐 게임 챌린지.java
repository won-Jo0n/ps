class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int min_level = 1;
        int max_level = 1000000;
        
        while(min_level <= max_level){
            int middle = min_level + (max_level - min_level) / 2;
            
            long calc_time = calc_time(diffs, times, middle);
            
            if(calc_time <= limit){
                answer = middle;
                max_level = middle - 1;
            }else{
                min_level = middle + 1;
            }
            
        }
        
        return answer;
    }
    
    private long calc_time(int[] diffs, int[] times, int level){
        long calc_time_result = 0;
        
        for(int i = 0; i < diffs.length; i ++){
            if(diffs[i] <= level){
                calc_time_result += times[i];
            }else if(i != 0) {
                calc_time_result += (diffs[i] - level)* (times[i] + times[i-1]) + times[i];
            }else {
                calc_time_result += (diffs[i] - level) * times[i] + times[i];
            }
            
        }
        
        return calc_time_result;
    }
}