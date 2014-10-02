package tetris3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Draw {
	private int x = Repository.BOARD_SIZE_X;
	private int y = Repository.BOARD_SIZE_Y;

	int[][] board;

	public Draw() {
		board = new int[x][y];
	}

	void boardClear() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = 0;
			}
		}
	}

	void drawing() {
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == 0)
					System.out.print("▤");
				else
					System.out.print("▣");
			}
			System.out.println();
		}
		System.out.println();
	}

	// 보드에다가 블럭이 있는 곳은 다 1로 칠한다.
	void analyzer() throws CloneNotSupportedException {
		TetrisBlock tetrisBlock = Repository.tetrisBlock.peek();
		HashSet<Block> blockSet = tetrisBlock.blockSet;
		Position pos = tetrisBlock.pos;
		Iterator<Block> i = blockSet.iterator();
		while (i.hasNext()) {
			Position p = (Position) i.next().pos.clone();
			p.calcPosX(pos.getPosX());
			p.calcPosY(pos.getPosY());
			board[p.getPosX()][p.getPosY()] = 1;
		}

		LinkedList<Block> allBlock = Repository.block;

		for (int j = 0; j < allBlock.size(); j++) {
			int x = allBlock.get(j).pos.getPosX();
			int y = allBlock.get(j).pos.getPosY();
			board[x][y] = 1;
		}
	}

}
