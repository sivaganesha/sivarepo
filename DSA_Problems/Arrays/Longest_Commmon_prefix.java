class Solution {
    public String longestCommonPrefix(String[] strs) {

        String prefix=strs[0];
        String ans="";
        
        for(int j=1;j<strs.length;j++)
            {   
            int i=0; 
//Horizontal Scanning			
            while(i<strs[j].length() && i<prefix.length()&& prefix.charAt(i)==strs[j].charAt(i))
                {
                    i++;
                }
                if(i>0){prefix=prefix.substring(0,i);}else {prefix=""; break;}
            }        
    return prefix;    
    }
}