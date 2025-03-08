
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        
       int  whiteCount=0;
        int i=0,j=0;
        for(j=0;j<k;j++){
            if(blocks.charAt(j)=='W'){
                whiteCount++;
            }
        }
        int min=whiteCount;
        while(j<n){
           if(blocks.charAt(j)=='W'){
            whiteCount++;
           }
            if(blocks.charAt(i)=='W'){
            whiteCount--;
           }
           min=Math.min(min,whiteCount);
           i++;
           j++;
        }
      
        return min;
    }
}

