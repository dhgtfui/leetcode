/**
 * Function Instruction: LeetCode 119. Pascal's Triangle II
 * Developer：jxwang
 * Date：2016, Feb 26
 */
//Given an index k, return the kth row of the Pascal's triangle.
//For example, given k = 3, Return [1,3,3,1].
package array;

import java.util.ArrayList;
import java.util.List;

public class getRow {
	public static void main(String[] args){
		System.out.print(getRow(3));
	}
	public static List<Integer> getRow(int rowIndex) {
		if(rowIndex < 0)
			return null;
		List<List<Integer>> res = new ArrayList<>();
		if(rowIndex >= 0){
			List<Integer> data = new ArrayList<>();
			data.add(1);
			res.add(data);
		}
		if(rowIndex >= 1){
			List<Integer> data = new ArrayList<>();
			data.add(1);
			data.add(1);
			res.add(data);
		}
		if(rowIndex >= 2){
			for(int i = 2; i <= rowIndex; i++){
				List<Integer> data = new ArrayList<>();
				List<Integer> pre = res.get(i-1);
				
				data.add(1);
				//f(i,j)=f(i-1,j-1)+f(i-1,j)
				for(int j = 1;j < i; j++){
					data.add(pre.get(j-1)+pre.get(j));
				}
				data.add(1);
				res.add(data);
			}
		}
		return res.get(rowIndex);	
    }
}
