package tetris3;

import java.util.HashMap;
import java.util.LinkedList;

public class Repository {
	// 테스리스 블럭을 가지고 있는 링크드 리스트
	// 링크드 리스트로 한 이유는 다음 블럭과 다다음 블럭을 볼 수 있게 하려구
	static LinkedList<TetrisBlock> tetrisBlock = new LinkedList<TetrisBlock>();

	// 보드에 쌓여있는 블럭을 가지고 있는 링크드 리스트
	static LinkedList<Block> block = new LinkedList<Block>();
	static HashMap<Integer, Type> intToType = new HashMap<Integer, Type>();

	static final int BOARD_SIZE_X = 10;
	static final int BOARD_SIZE_Y = 18;
	
	static final int SPEED = 1000;
}

// 쌓인 블럭들을 가지고 있을 링크드 리스트

// 블럭 종류
enum Type {
	SQURE, STICK, LBLOCK, LREVERSE, SBLOCK, SREVERSE, TBLOCK;
}