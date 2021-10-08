package leetCodeJun2020;

public class SurroundedRegions17 {

	public static void main(String[] args) {
		char[][] board = 
			{{'X','X','X','X'},
			 {'X','O','O','X'},
			 {'X','X','O','X'},
			 {'X','O','X','X'}};
		
		printArr(board);
		
		System.out.println();
		
		solve(board);
		
		printArr(board);
	}

	private static void solve(char[][] board) {
		if (board.length == 0) {
			return;
		}
		
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				bfs(board,0,i);
			}
		}
		
		for (int i = 0; i < board[board.length-1].length; i++) {
			if (board[board.length-1][i] == 'O') {
				bfs(board,board.length-1,i);
			}
		}
		
		for (int i = 1; i < board.length-1; i++) {
			if (board[i][0] == 'O') {
				bfs(board,i,0);
			}
		}
		
		for (int i = 1; i < board.length-1; i++) {
			if (board[i][board[0].length-1] == 'O') {
				bfs(board,i,board[0].length-1);
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				
				switch (board[i][j]) {
				case 'O':
					board[i][j] = 'X';
					break;
				case 'P':
					board[i][j] = 'O';
					break;
				default:
					break;
				}
				
			}
		}
	}
	
	private static void bfs(char[][] board, int i, int j) {
		if (board[i][j] == 'O') {
			board[i][j] = 'P';
		}else {
			return;
		}
		
		if (i-1>0) {
			bfs(board,i-1,j);
		}
		
		if (i+1<board.length-1) {
			bfs(board,i+1,j);
		}
		
		if (j-1>0) {
			bfs(board,i,j-1);
		}
		
		if (j+1<board[0].length-1) {
			bfs(board,i,j+1);
		}
		
		
	}

	private static void printArr(char[][] board) {
		for (char[] row: board) {
			for (char c: row) {
				System.out.print(c + ", ");
			}
			System.out.println();
		}
	}

}
