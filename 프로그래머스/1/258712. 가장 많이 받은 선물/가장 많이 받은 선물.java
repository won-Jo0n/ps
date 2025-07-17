import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        int[] friendsIndex = new int[friends.length];
        int[] giftPoints = new int[friends.length];
        
        int[][] countList = new int[friends.length][friends.length];
        
        for(int i=0; i <friends.length; i++){
            map.put(friends[i], i);
        }
        
        for(int i =0; i < gifts.length; i++){
            String[] f = gifts[i].split(" ");
            String f1 = f[0];
            String f2 = f[1];
            countList[map.get(f1)][map.get(f2)]++;
        }
  
        for(int i=0; i < countList.length; i++){
            for(int j=0; j < countList[0].length; j++){
                giftPoints[i] += countList[i][j];
                giftPoints[i] -= countList[j][i];
            }
        }
        
        int idx = 0;
        for(int i =0; i < countList.length; i++){
            for(int j=0; j < idx; j++){
                if(countList[i][j] > countList[j][i]){
                    friendsIndex[i]++;
                }
                if(countList[i][j] < countList[j][i]){
                    friendsIndex[j]++;
                }
                if(countList[i][j] == countList[j][i]){
                    if(giftPoints[i] > giftPoints[j]){
                        friendsIndex[i]++;
                    }else if(giftPoints[j] > giftPoints[i]){
                        friendsIndex[j]++;
                    }
                }
            }
            idx++;
        }
        
        int maxNum = 0;
        for(int i = 0; i < friendsIndex.length; i++){
            if (friendsIndex[i] > maxNum) {
                maxNum = friendsIndex[i];
            }
        }
        
        answer = maxNum;
        return answer;
    }
}