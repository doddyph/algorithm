import java.io.FileInputStream;
import java.util.Scanner;

public class Labirin {

	static int iF, jF;
	static int path, step, minStep;
	
	public static void main(String[] args) throws Exception {
		
		double starttime = System.currentTimeMillis();
		
		Scanner sc = new Scanner(new FileInputStream("res/labirin.txt"));
		
		int T = sc.nextInt();
		int row, col, iS = 0, jS = 0;
		String[][] matrix;
		boolean[][] visited;
		
		for (int t = 1; t <= T; t++) {
			row = sc.nextInt();
			col = sc.nextInt();
			matrix = new String[row][col];
			visited = new boolean[row][col];
			
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					matrix[r][c] = sc.next();
					
					if (matrix[r][c].equals("S")) {
						iS = r;
						jS = c;
						matrix[r][c] = ".";
					}
					else if (matrix[r][c].equals("F")) {
						iF = r;
						jF = c;
						matrix[r][c] = ".";
					}
				}
			}
			
			path = 0;
			step = 0;
			minStep = Integer.MAX_VALUE;
			
			traverse(matrix, visited, iS, jS);
			
			System.out.println("path: "+path);
			System.out.println("shortest: "+minStep);
			System.out.println("----------------------");
			
			
		}
		
		sc.close();
		
		double endtime = System.currentTimeMillis();
		System.out.println("Proceed in: "+((endtime-starttime)/1000)+"s");
	}
	
	static void traverse(String[][] matrix, boolean[][] visited, int i, int j) {
		
		if (i == iF && j == jF) {
			visited[i][j] = true;
			path++;
			System.out.println(path+" "+step);
			minStep = Math.min(step, minStep);
			return;
		}
		
		if (isSafe(matrix, visited, i, j)) {
			visited[i][j] = true;
			step++;
			
			traverse(matrix, visited, i-1, j);
			traverse(matrix, visited, i, j+1);
			traverse(matrix, visited, i+1, j);
			traverse(matrix, visited, i, j-1);
			
			//visited[i][j] = false;
			step--;
		}
	}
	
	static boolean isSafe(String[][] matrix, boolean[][] visited, int i, int j) {
		return (i >= 0 && i < matrix.length &&
				j >= 0 && j < matrix[0].length &&
				matrix[i][j].equals(".") &&
				!visited[i][j]);
	}
	
	static void print(boolean[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				System.out.print(visited[i][j] == true? "*":" ");
			}
			System.out.println();
		}
	}
}
