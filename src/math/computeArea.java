/**
 * Function Instruction: LeetCode 223. Rectangle Area
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Developer：jxwang
 * Date：2016, Mar 6
 */
package math;

public class computeArea {
	public static void main(String[] args){
		System.out.println(computeArea(-5,5,1,1,0,0,5,5));
	}
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C-A)*(D-B)+(G-E)*(H-F);
        if(G <= A || H <= B || E >= C || D <= F ) 
        	return area;
        else
        	return area - (Math.min(C, G) - Math.max(A,E)) * (Math.min(D,H) - Math.max(F, B));
    }
}
