import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < survey.length; i++){
            String sur = survey[i];
            String firstSur = sur.substring(0,1);
            String secondSur = sur.substring(1);
            
            if(!map.containsKey(firstSur) && !map.containsKey(secondSur)){
                map.put(firstSur,0);
                map.put(secondSur,0);
            }else if(map.containsKey(firstSur) && !map.containsKey(secondSur)){
                map.put(secondSur,0);
            }else if(!map.containsKey(firstSur) && map.containsKey(secondSur)){
                map.put(firstSur,0);
            }
            setMap(map, choices[i], firstSur, secondSur);
        }
        
        answer = compareMap(map);
        
        return answer;
    }
    private void setMap(Map<String, Integer> map, int choice, String firstSur, String secondSur){
        switch(choice){
            case 1:
                map.put(firstSur, map.get(firstSur) + 3);
                break;
            case 2:
                map.put(firstSur, map.get(firstSur) + 2);
                break;
            case 3:
                map.put(firstSur, map.get(firstSur) + 1);
                break;
            case 4:
                break;
            case 5:
                map.put(secondSur, map.get(secondSur) + 1);
                break;
            case 6:
                map.put(secondSur, map.get(secondSur) + 2);
                break;
            case 7:
                map.put(secondSur, map.get(secondSur) + 3);
                break;
        }
    }
    
    private String compareMap(Map<String, Integer> map){
        String result = "";
        
        if(map.get("R") != null && map.get("T") != null){
            if(map.get("R") > map.get("T")){
                result += "R";
            }else if(map.get("R") < map.get("T")){
                result += "T";
            }else{
                result += "R";
            }
        }else if(map.get("R") == null && map.get("T") != null) {
            result+= "T";
        }else if(map.get("R") != null && map.get("T") == null) {
            result+= "R";
        }else{
            result+= "R";
        }
        
        if(map.get("C") != null && map.get("F") != null){
            if(map.get("C") > map.get("F")){
                result += "C";
            }else if(map.get("C") < map.get("F")){
                result += "F";
            }else{
                result += "C";
            }
        }else if(map.get("C") == null && map.get("F") != null) {
            result+= "F";
        }else if(map.get("C") != null && map.get("F") == null) {
            result+= "C";
        }else{
            result+= "C";
        }
        
        if(map.get("J") != null && map.get("M") != null){
            if(map.get("J") > map.get("M")){
                result += "J";
            }else if(map.get("J") < map.get("M")){
                result += "M";
            }else{
                result += "J";
            }
        }else if(map.get("J") == null && map.get("M") != null) {
            result+= "M";
        }else if(map.get("J") != null && map.get("M") == null) {
            result+= "J";
        }else{
            result+= "J";
        }
        
        if(map.get("A") != null && map.get("N") != null){
            if(map.get("A") > map.get("N")){
                result += "A";
            }else if(map.get("A") < map.get("N")){
                result += "N";
            }else{
                result += "A";
            }
        }else if(map.get("A") == null && map.get("N") != null) {
            result+= "N";
        }else if(map.get("A") != null && map.get("N") == null) {
            result+= "A";
        }else{
            result+= "A";
        }
        return result;
    }
    
}