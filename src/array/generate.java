/**
 * Function Instruction: LeetCode 118. Pascal's Triangle
 * Developer：jxwang
 * Date：2016, Feb 26
 */
//Given numRows, generate the first numRows of Pascal's triangle.
package array;

import java.util.ArrayList;
import java.util.List;

public class generate {
	public static void main(String[] args){
		List<List<Integer>> list1 = generate(5);
		System.out.print(list1);
	}
	public static List<List<Integer>> generate(int numRows) {
		if(numRows < 0)
        	return null;
        List<List<Integer>> res = new ArrayList<>();
        if(numRows >= 1){
        	List<Integer> data = new ArrayList<>();
        	data.add(1);
        	res.add(data);
        }
        if(numRows >= 2){
        	List<Integer> data = new ArrayList<>();
        	data.add(1);
        	data.add(1);
        	res.add(data);
        }
        if(numRows >= 3){
        	for(int i = 2; i< numRows; i++){
        		List<Integer> data = new ArrayList<>();
        		List<Integer> pre = res.get(i - 1);
            	data.add(1);
            	//f(i,j)=f(i-1,j-1)+f(i-1,j)
            	for(int j = 1; j< i; j++){
            		data.add(pre.get(j - 1) + pre.get(j));
            	}
            	data.add(1);
            	res.add(data);
        	}
        }
        return res;
    }
}
