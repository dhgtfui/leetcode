/**
 * Function Instruction: LeetCode 6. ZigZag Conversion
 * Developer：jxwang
 * Date：2016, Apr 10
 */
package string;

public class convert {
	public static void main(String[] args){
		String str = "PAYPALISHIRING"; //"PAHNAPLSIIGYIR"
		int rows = 3;
		System.out.print(convert(str,rows));
	}
	public static String convert(String s, int numRows) {
		if(s == null || s.length()==0 || numRows <=0)  
		    return "";  
		if(numRows == 1)  
			 return s;
		StringBuilder res = new StringBuilder();  
		int size = 2*numRows-2;  
		for(int i=0;i<numRows;i++){  
			for(int j=i;j<s.length();j+=size){  
				res.append(s.charAt(j));  
				if(i != 0 && i != numRows - 1){//except the first row and the last row
					int temp = j+size-2*i;
					if(temp<s.length())
						res.append(s.charAt(temp));
			              }
			             }                  
			        }  
		return res.toString(); 
    }
}
