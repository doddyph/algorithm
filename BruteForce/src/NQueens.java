import java.io.FileInputStream;
import java.util.Scanner;


public class NQueens {
	
	static int N;
	static int found;

	public static void main(String[] args) throws Exception {
		
		double starttime = System.currentTimeMillis();
		
		Scanner sc = new Scanner(new FileInputStream("res/nqueens.txt"));
		
		int T = sc.nextInt();
		boolean[][] VISITED;
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			found = 0;
			VISITED = new boolean[N][N];
			traverse(VISITED, 0);
			System.out.println("#"+t+" "+found);
		}
		
		sc.close();
		
		double endtime = System.currentTimeMillis();
		System.out.println("Proceed in: "+((endtime-starttime)/1000)+"s");
	}
	
	static boolean traverse(boolean[][] VISITED, int n) {
		if (n == N) {
			found++;
			//print(VISITED);
			//System.out.println();
		}
		
		for (int c = 0; c < N; c++) {
			if (isSafe(VISITED, n, c)) {
				VISITED[n][c] = true;
				
				if (traverse(VISITED, n+1)) {
					return true;
				}
				
				VISITED[n][c] = false;
			}
		}
		
		return false;
	}
	
	static boolean isSafe(boolean[][] VISITED, int row, int col) {
		return (isSafeCol(VISITED, row, col) &&
				isSafeLeftUpDiagonal(VISITED, row, col) &&
				isSafeRightUpDiagonal(VISITED, row, col));
	}
	
	static boolean isSafeCol(boolean[][] VISITED, int row, int col){
		for (int r = row; r > 0; r--) {
			if (VISITED[r-1][col]) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isSafeLeftUpDiagonal(boolean[][] VISITED, int row, int col) {
		for (int r = row; r > 0; r--) {
			if (col-1 >= 0) {
				if (VISITED[r-1][col-1]) {
					return false;
				}
				col--;
			}
		}
		return true;
	}
	
	static boolean isSafeRightUpDiagonal(boolean[][] VISITED, int row, int col) {
		for (int r = row; r > 0; r--) {
			if (col+1 < N) {
				if (VISITED[r-1][col+1]) {
					return false;
				}
				col++;
			}
		}
		return true;
	}
	
	static void print(boolean[][] VISITED) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (VISITED[r][c]) {
					System.out.print("Q ");
				}
				else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}
}
