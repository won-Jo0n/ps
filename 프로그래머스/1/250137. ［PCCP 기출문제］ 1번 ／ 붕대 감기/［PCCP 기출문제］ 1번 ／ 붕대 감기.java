class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int time = 0;
        int max_health = health;
        int current_health = health;
        
        int bandage_time = bandage[0];
        int bandage_heal = bandage[1];
        int bandage_bonus = bandage[2];
        
        for(int i = 0; i < attacks.length; i++){
            time = attacks[i][0] - time - 1;
            current_health += time * bandage_heal;
            current_health += time / bandage_time * bandage_bonus;
            if(current_health > max_health){
                
                current_health = max_health;
            }
            time = attacks[i][0];
            current_health -= attacks[i][1];
            if(current_health <= 0) return -1;

        }
        answer = current_health;
        return answer;
    }
}