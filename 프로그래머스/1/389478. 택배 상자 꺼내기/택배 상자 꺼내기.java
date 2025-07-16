import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int startBox = 1;
        boolean flag = true;
        int heightBox = (int)(Math.ceil((double)n / w));
        int[][] boxList = new int[heightBox][w];
        int index = 0;
        
        
        while(index < heightBox && startBox <= n){
            for(int j = 0; j < w; j++){
                if(startBox > n){
                    break;
                }
                boxList[index][j] = startBox;
                startBox++;
            }
            if (startBox > n || ++index >= heightBox) {
                break;
            }
            for(int j= w -1; j >= 0; j--){
                if(startBox > n){
                    break;
                }
                boxList[index][j] = startBox;
                startBox++;
            }
            if (startBox > n || ++index >= heightBox) {
                break;
            }
        }
        
        answer = findBox(boxList, num);
       
        return answer;
    }
    
    private int findBox(int[][]boxList, int num){
        int findBox = 0;
        
        for(int i = 0; i < boxList.length; i++){
            for(int j = 0; j < boxList[0].length; j++){
                if(boxList[i][j] == num){
                    if(boxList[boxList.length -1][j] != 0){
                        findBox = boxList.length - i;
                    }else{
                        findBox = boxList.length - i -1;
                    }
                }
            }
        }
        return findBox;
        
    }
}