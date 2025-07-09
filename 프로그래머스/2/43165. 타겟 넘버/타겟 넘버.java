class Solution {
    
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        this.numbers = numbers;
        this. target = target;
        
        
        return dfs(0, 0);
    }
    
    public int dfs(int idx, int sum){
        if(idx == numbers.length){
            return (sum == target) ? 1 : 0;
        }
        
        return dfs(idx + 1 , sum + numbers[idx]) + dfs(idx +1 , sum - numbers[idx]);
    }
}