/*
 * https://www.cs.bu.edu/teaching/alg/maze/
 * http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
 */
public class MazeSolve {
	
	static int iS, jS, iG, jG;
	
	public static void main(String[] args) {
		
		int[][] matrix = {
				{1, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 1},
				{0, 1, 0, 0, 0, 1},
				{0, 1, 0, 0, 0, 1},
				{1, 1, 1, 0, 1, 1},
				{0, 0, 1, 1, 1, 0}
		};
		
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		
		iS = 0;
		jS = 0;
		iG = 4;
		jG = 5;
				
		traverse(matrix, visited, iS, jS);
		
		System.out.println();
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				System.out.print(visited[i][j] == true? "*":" ");
			}
			System.out.println();
		}
		
		traverse(matrix, visited, iS, jS);
	}
	
	static boolean traverse(int[][] matrix, boolean[][] visited, int i, int j) {
		if (i == iG && j == jG) {
			//visited[i][j] = true;
			System.out.print("("+i+","+j+") ");
			return true;
		}
		
		if (isSafe(matrix, visited, i, j)) {
			visited[i][j] = true;
			
			if (traverse(matrix, visited, i-1, j)) {
				System.out.print("("+i+","+j+") ");
				return true;
			}
			if (traverse(matrix, visited, i+1, j)) {
				System.out.print("("+i+","+j+") ");
				return true;
			}
			if (traverse(matrix, visited, i, j-1)) {
				System.out.print("("+i+","+j+") ");
				return true;
			}
			if (traverse(matrix, visited, i, j+1)) {
				System.out.print("("+i+","+j+") ");
				return true;
			}
			
			visited[i][j] = false;
		}
		
		return false;
	}
	
	static boolean isSafe(int[][] matrix, boolean[][] visited, int i, int j) {
		return (i >= 0 && i < matrix.length && 
				j >= 0 && j < matrix[0].length &&
				matrix[i][j] == 1 && !visited[i][j]);
	}
}
