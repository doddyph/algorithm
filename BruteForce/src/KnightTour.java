/*
 * Reference:
 * http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 */
public class KnightTour {
	
	static int N;
	
	public static void main(String[] args) {
		
		double starttime = System.currentTimeMillis();
		
		N = 8;
		int[][] BOARD = new int[N][N];
		boolean[][] VISITED = new boolean[N][N];
		
		if (!traverse(BOARD, VISITED, 0, 0, 0)) {
			System.out.println("Solution does not exist !!");
		}
		
		for (int i = 0; i < BOARD.length; i++) {
			for (int j = 0; j < BOARD[0].length; j++) {
				System.out.print(BOARD[i][j]+" ");
			}
			System.out.println();
		}
		
		double endtime = System.currentTimeMillis();
		System.out.println("Proceed in: "+((endtime-starttime)/1000)+"s");
	}
	
	static boolean traverse(int[][] BOARD, boolean[][] VISITED, int i, int j, int move) {
		if (move == (N * N)) {
			return true;
		}
		
		if (isSafe(BOARD, VISITED, i, j)) {
			VISITED[i][j] = true;
			BOARD[i][j] = move;
			
			if (traverse(BOARD, VISITED, i-2, j+1, move+1)) {
				return true;
			}
			if (traverse(BOARD, VISITED, i-1, j+2, move+1)) {
				return true;
			}
			if (traverse(BOARD, VISITED, i+1, j+2, move+1)) {
				return true;
			}
			if (traverse(BOARD, VISITED, i+2, j+1, move+1)) {
				return true;
			}
			if (traverse(BOARD, VISITED, i+2, j-1, move+1)) {
				return true;
			}
			if (traverse(BOARD, VISITED, i+1, j-2, move+1)) {
				return true;
			}
			if (traverse(BOARD, VISITED, i-1, j-2, move+1)) {
				return true;
			}
			if (traverse(BOARD, VISITED, i-2, j-1, move+1)) {
				return true;
			}
			
			BOARD[i][j] = 0;
			VISITED[i][j] = false;
		}
		
		return false;
	}
	
	static boolean isSafe(int[][] BOARD, boolean[][] VISITED, int i, int j) {
		return (i >= 0 && i < BOARD.length &&
				j >= 0 && j < BOARD[0].length &&
				!VISITED[i][j] && BOARD[i][j] == 0);
	}
}
