import java.io.FileInputStream;
import java.util.Scanner;


public class Sudoku {
	
	static int ROW, COL;

	public static void main(String[] args) throws Exception {
		
		double starttime = System.currentTimeMillis();
		
		Scanner sc = new Scanner(new FileInputStream("res/sudoku.txt"));
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			ROW = sc.nextInt();
			COL = sc.nextInt();
			int[][] GRID = new int[ROW][COL];
			
			for (int r = 0; r < ROW; r++) {
				for (int c = 0; c < COL; c++) {
					GRID[r][c] = sc.nextInt();
				}
			}
			
			if (traverse(GRID)) {
				print(GRID);
			}
			else {
				System.out.println("not possible!");
			}
		}
		
		sc.close();
		
		double endtime = System.currentTimeMillis();
		System.out.println("Proceed in: "+((endtime-starttime)/1000)+"s");
	}
	
	static boolean traverse(int[][] GRID) {
		int zeroR = -1, zeroC = -1;
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				if (GRID[r][c] == 0) {
					zeroR = r;
					zeroC = c;
				}
			}
		}
		if (zeroR == -1 && zeroC == -1) {
			return true;
		}
	
		for (int num = 1; num <= 9; num++) {
			if (isSafeRow(GRID, zeroR, num) &&
					isSafeCol(GRID, zeroC, num) &&
					isSafeBox(GRID, zeroR - zeroR%3, zeroC - zeroC%3, num)) {
				
				GRID[zeroR][zeroC] = num;
				if (traverse(GRID)) {
					return true;
				}
				GRID[zeroR][zeroC] = 0;
			}
		}
		
		return false;
	}
	
	static boolean isSafeRow(int[][] GRID, int r, int num) {
		for (int c = 0; c < COL; c++) {
			if (GRID[r][c] == num) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isSafeCol(int[][] GRID, int c, int num) {
		for (int r = 0; r < ROW; r++) {
			if (GRID[r][c] == num) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isSafeBox(int[][] GRID, int startR, int startC, int num) {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (GRID[startR + r][startC + c] == num) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void print(int[][] GRID) {
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				System.out.print(GRID[r][c]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
