import java.util.*;

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
 
        int startTime = (h1 * 60 * 60) + (m1* 60) + s1;
        int endTime = (h2 * 60 * 60) + (m2 * 60) + s2;
        
        if(startTime % 360 == 0 || startTime % 360 == 12) answer++;
          
        while(startTime < endTime){
            
            double sAngle = (startTime * 6) % 360;
            double mAngle = (startTime /(double)10) % 360;
            double hAngle = (startTime /(double)120)% 360 ;
            
            double sAngleNext = ((startTime+1) * 6) % 360;
            double mAngleNext = ((startTime+1) /(double)10) % 360;
            double hAngleNext = ((startTime+1) /(double)120)% 360 ;
            
            if(sAngleNext == 0) sAngleNext = 360;
            if(mAngleNext == 0) sAngleNext = 360;
            if(hAngleNext == 0) sAngleNext = 360;
            
            if(sAngle < mAngle && sAngleNext >= mAngleNext) answer++;
            if(sAngle < hAngle && sAngleNext >= hAngleNext) answer++;
            if(hAngleNext == mAngleNext) answer--;

            startTime++;
        }
  
        return answer;
    }
}