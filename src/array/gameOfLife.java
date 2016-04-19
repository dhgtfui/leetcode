/**
 * Function Instruction: LeetCode 289. Game of Life
 * Developer：jxwang
 * Date：2016, Mar 2
 */
package array;

public class gameOfLife {
	public static void main(String[] args){
		int[][] m = {{1,1,1},{1,0,1}};
		isPrint(m);
		System.out.println("My solution: ");
		gameOfLife(m);
		isPrint(m);
		
		System.out.println("Sample solution: ");
		int[][] n = {{1,1,1},{1,0,1}};
		gameOfLife1(n);
		isPrint(n);
	}
	public static void isPrint(int[] [] list){
		for(int i = 0; i < list.length; i++){
			for(int j = 0; j < list[i].length; j++){
				System.out.print(list[i][j]);
			}
			System.out.println();
		}
	}
	final static int DEAD = 0;
	final static int LIVE = 1;
	final static int DEAD_DEAD = 0; //0->0
	final static int DEAD_LIVE = 3; //0->1
	final static int LIVE_DEAD = 2; //1->0
	final static int LIVE_LIVE = 1; //1->1
    
	public static void gameOfLife(int[][] board) {
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				int count = neighbourNum(board, i, j);
				if(board[i][j] == LIVE) {
					if(count >=0 && count <=1)
						board[i][j] = LIVE_DEAD;
					else if(count >=2 && count <=3)
						board[i][j] = LIVE_LIVE;
					else 
						board[i][j] = LIVE_DEAD;
				}
				else{
					board[i][j] = count == 3 ? DEAD_LIVE : DEAD_DEAD;
				}
			}
		}
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				board[i][j] = board[i][j] % 2;
			}
		}
    }
	public static int neighbourNum(int[][] nums, int a, int b){
		int c = 0;
		for(int i = a - 1; i <= a + 1; i++){
			for(int j = b - 1; j <= b + 1; j++){
				if(i == a && j == b) continue;
				if(i >= 0 && j >= 0 && i < nums.length && j < nums[0].length && (nums[i][j] == LIVE_DEAD || nums[i][j] == LIVE_LIVE))
					c++;
			}
		}
		return c;
	}
	
	private static int countLiveNeigh(int[][] board,int row,int col){
        int count =  0;
        for(int i = row-1;i<=row+1;i++){
            for(int j = col-1;j<=col+1;j++){
                if(i==row && j==col)
                    continue;
                if(i>=0 && i<board.length && j>=0 && j<board[0].length && (board[i][j]==1||board[i][j]==2))//最开始状态为1的
                    count++;
            }
        }
        return count;
    }
    public static void gameOfLife1(int[][] board) {
        /*
        * 0:0--->0
          1:1--->1
          2:1--->0
          3:0--->1
        */
        int rowlen = board.length;
        int collen = board[0].length;
        for(int row = 0;row<rowlen;row++){
            for(int col = 0;col<collen;col++){
                int count = countLiveNeigh(board,row,col);
                if(count == 2);
                else if(count == 3){
                    board[row][col] = board[row][col]==0?3:1;
                }else{
                    board[row][col] = board[row][col]==1?2:0;
                }
            }
        }
        for(int row = 0;row<rowlen;row++){
            for(int col = 0;col<collen;col++){
                board[row][col] %= 2;
            }
        }
    }
  
	
}
