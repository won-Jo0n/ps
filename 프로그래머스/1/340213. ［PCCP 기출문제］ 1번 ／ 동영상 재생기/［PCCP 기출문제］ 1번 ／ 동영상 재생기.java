class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int video_len_t = time_second(video_len);
        int pos_t = time_second(pos);
        int op_start_t = time_second(op_start);
        int op_end_t = time_second(op_end);
       
        if(pos_t >= op_start_t && pos_t <= op_end_t){
            pos_t = op_end_t;
        }
        
        for(int i = 0; i < commands.length; i++){
            String command = commands[i];
            
            switch(command){
                case "next":
                   if(pos_t + 10<= video_len_t){
                       pos_t += 10;
                   }else{
                       pos_t = video_len_t;
                   }  
                    break;
                case "prev":
                    if(pos_t - 10 >= 0){
                        pos_t -= 10;
                    }else{
                        pos_t = 0;
                    } 
                    break;         
            }
            if(pos_t >= op_start_t && pos_t <= op_end_t){
            pos_t = op_end_t;
         }
        }
        
        if(pos_t >= op_start_t && pos_t <= op_end_t){
            pos_t = op_end_t;
        }
        
        answer = return_time(pos_t);
        
        return answer;
    }
    
    public int time_second(String time){
        int time_m = Integer.parseInt(time.substring(0,2)) * 60;
        int time_s = Integer.parseInt(time.substring(3));
        int run_time = time_m + time_s;
        
        return run_time;
    }
    
    public String return_time(int pos_t){ 
        String time_m = String.valueOf(pos_t / 60);
        String time_s = String.valueOf(pos_t % 60);
        time_m = (Integer.parseInt(time_m) < 10) ? "0" + time_m : time_m;
        time_s = (Integer.parseInt(time_s) < 10) ? "0" + time_s : time_s;
        
        String result = time_m + ":" + time_s;
        return result;
    }
}