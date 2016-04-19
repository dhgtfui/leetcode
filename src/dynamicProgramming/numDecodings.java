/**
 * Function Instruction: LeetCode 91. Decode Ways
 * Description: Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * Developer：jxwang
 * Date：2016, Apr 11
 */
package dynamicProgramming;

public class numDecodings {
	public static void main(String[] args){
		System.out.println(numDecodings("19"));
	}
	public static int numDecodings(String s) {
		//动态规划标记  
        int[] f = new int[s.length()];  
        char[] c = s.toCharArray();  
        //边界情况  
        if(c.length == 0){  
            return 0;  
        }  
        //第一个元素  
        f[0] = c[0] > '0' ? 1:0;  
          
        if(c.length == 1){  
            return f[0];  
        }  
        //f[1]的值是关键，写不好，将会出现各种错误  
        int k = c[0] > '0' && c[1] > '0'? 1:0;  
        f[1] = k + (c[0] == '1' || c[0] == '2' && c[1] <= '6' ? 1:0);  
          
        //从前往后遍历  
        for(int i = 2; i < c.length; i++){  
            if(c[i] > '0'){//第一个元素大于0，添加情况  
                f[i] += f[i-1];  
            }  
            //在10-26之间则添加两个字母组成一个的情况  
            if(c[i-1] == '1' || (c[i-1] == '2' && c[i] <= '6')){  
                f[i] += f[i-2];  
            }  
        }  
          
        return f[c.length-1]; 
    }
}
