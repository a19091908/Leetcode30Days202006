package leetCodeJun2020;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII30 {

	public static void main(String[] args) {
//		char[][] board = {
//				  {'o','a','a','n'},
//				  {'e','t','a','e'},
//				  {'i','h','k','r'},
//				  {'i','f','l','v'}
//				};
//		String[] words = {"oath","pea","eat","rain"};
		char[][] board = {
				  {'a','b'}
				};
		String[] words = {"ab"};
		List<String> ansList = new WordSearchII30().findWords(board,words);
		
		printList(ansList);
		

	}

	private List<String> findWords(char[][] board, String[] words) {
		TiresNode root = new TiresNode();
		
		for (String word : words) {
			TiresNode tempNode = root;
			int wordLength = word.length();
			for (int i = 0; i < wordLength; i++) {
				int index = word.charAt(i)-'a';
				if (tempNode.arr[index] == null) {
					tempNode.arr[index] = new TiresNode();
				}
				tempNode = tempNode.arr[index];
			}
			tempNode.word = word;
		}
		
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board,i,j,root,list);
			}
		}
		
		return list;
	}
	
	
	private void dfs(char[][] board, int i, int j, TiresNode node, ArrayList<String> list) {
		char c = board[i][j];
		if (c == '*' || node == null) 
			return;
		int index = c - 'a';
		if (node.arr[index] != null) {
			if (node.arr[index].word != null) {
				list.add(node.arr[index].word);
				node.arr[index].word = null;
			}
			board[i][j] = '*';
			if (0 < i) dfs(board,i-1,j,node.arr[index],list);
			if (0 < j) dfs(board,i,j-1,node.arr[index],list);
			if (i < board.length-1) dfs(board,i+1,j,node.arr[index],list);
			if (j < board[0].length-1) dfs(board,i,j+1,node.arr[index],list);
			board[i][j] = c;
		}
		
	}

	private static void printList(List<String> ansList) {
		int size = ansList.size();
		for (int i=0;i<size;i++) 
			System.out.println(ansList.get(i));
	}

}

class TiresNode{
	String word;
	TiresNode[] arr = new TiresNode[26];
}
