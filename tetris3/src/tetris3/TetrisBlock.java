package tetris3;

import java.util.HashSet;
import java.util.Iterator;

public class TetrisBlock {
	//static final int START_POS_X = 5;
	//static final int START_POS_Y = 2;

	
	static final int START_POS_X = 5;
	static final int START_POS_Y = 16;
	
	
	public HashSet<Block> blockSet;
	public Position pos;

	// 회전 상태를 상수로 넣기
	// 아니 넣지 말고 포지션 변경하는 메소드를 추가

	public TetrisBlock(HashSet<Block> blockSet) {
		this.pos = new Position(START_POS_X, START_POS_Y);
		this.blockSet = blockSet;
	}

	
	
	//실제로 움직이는 곳
	void moveLeft(){
		pos.moveLeft();
	}
	
	void moveRight(){
		pos.moveRight();
	}
	
	void moveDown(){
		pos.moveDown();
	}
	
	void moveUp(){
		pos.moveUp();
	}
	
	void moveRotate(){
		Iterator<Block> i = blockSet.iterator();
		while (i.hasNext()) {
			i.next().pos.moveRotate();
		}
	}
	
	void moveRotateCW(){
		Iterator<Block> i = blockSet.iterator();
		while (i.hasNext()) {
			i.next().pos.moveRotateCW();
		}
	}
	
	void stack(HashSet<Position> absolutePos) throws CloneNotSupportedException{
		Iterator<Position> i = absolutePos.iterator();
		while (i.hasNext()) {
			Position p = (Position) i.next().clone();
			Block block = new Block(p);
			Repository.block.add(block);
		}

	}
}
