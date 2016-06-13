
public class NQueen {

	static int N, found;
	
	public static void main(String[] args) {
		
		N = 8;
		int[][] BOARD = new int[N][N];
		
		found = 0;
		traverse(BOARD, 0);
		System.out.println("----------\nFound: "+found);
	}
	
	static boolean traverse(int[][] BOARD, int row) {
		if (row == N) {
			found++;
			//display(BOARD);
			//System.out.println();
		}
		
		for (int col = 0; col < N; col++) {
			
			if (isSafe(BOARD, row, col)) {
				BOARD[row][col] = 1;
				
				if (traverse(BOARD, row+1)) {
					return true;
				}
				
				BOARD[row][col] = 0;
			}
		}
		
		return false;
	}
	
	static boolean isSafe(int[][] BOARD, int row, int col) {
		//check column
		for (int i = 0; i < row; i++) {
			if (BOARD[i][col] == 1) {
				return false;
			}
		}
		
		//check left-up diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (BOARD[i][j] == 1) {
				return false;
			}
		}
		
		//check right-up diagonal
		for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
			if (BOARD[i][j] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	static void display(int[][] BOARD) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(BOARD[i][j] == 1? "Q ":"* ");
			}
			System.out.println();
		}
	}
}
