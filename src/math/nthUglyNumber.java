/**
 * Function Instruction: LeetCode 264. Ugly Number II
 * Description: Write a program to find the n-th ugly number.
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Developer：jxwang
 * Date：2016, Mar 7
 */
package math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class nthUglyNumber {
	public static void main(String[] args){
		
		System.out.print(nthUglyNumber(10));
	}
	public static int nthUglyNumber(int n) {
		int res = 1;
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		l1.add(1);
		l2.add(1);
		l3.add(1);
		for(int i = 0; i < n; i++){
			res = Math.min(Math.min(l1.get(0), l2.get(0)), l3.get(0));
			if(res == l1.get(0)) 
				l1.remove(0);
			if(res == l2.get(0)) 
				l2.remove(0);
			if(res == l3.get(0)) 
				l3.remove(0);
			l1.add(2*res);
			l2.add(3*res);
			l3.add(5*res);
		}
		return res;
    }
}
