package tetris3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Rule {
	// 모든 규칙은 내가 가지고 있을께!

	// 계산의 편의를 위한 임시 절대좌표 세트
	HashSet<Position> tempPos = new HashSet<Position>();

	// Iterator를 따로 빼내는 경우는 나중에 테스트(이거 중복코드임)

	public Rule(TetrisBlock tetrisBlock) throws CloneNotSupportedException {
		unfold(tetrisBlock);
	}

	// 블럭리스트를 가져온다.
	LinkedList<Block> allBlock = Repository.block;

	// 바닥이니?
	public boolean isBottom(TetrisBlock tetrisBlock) {
		Iterator<Position> i = tempPos.iterator();

		while (i.hasNext()) {
			if (i.next().getPosY() >= 20)
				return true;
		}
		return false;

	}

	// 왼쪽 벽에 부딪혔니?
	public boolean isLeftWall(TetrisBlock tetrisBlock) {
		Iterator<Position> i = tempPos.iterator();

		while (i.hasNext()) {
			if (i.next().getPosX() < 0)
				return true;
		}
		return false;
	}

	// 오른쪽 벽에 부딪혔니?
	public boolean isRightWall(TetrisBlock tetrisBlock) {
		Iterator<Position> i = tempPos.iterator();

		while (i.hasNext()) {
			if (i.next().getPosX() >= 10)
				return true;
		}
		return false;
	}

	// 블럭끼리의 충돌 체크
	public boolean isCollision(TetrisBlock tetrisBlock) {
		Iterator<Position> i = tempPos.iterator();

		// 테트리스 블럭 절대좌표 순회
		while (i.hasNext()) {
			Position p = i.next();
			for (int j = 0; j < allBlock.size(); j++) {
				if (isOverlap(p, allBlock.get(j).pos))
					return true;
			}
		}
		return false;
	}

	// 블럭의 포지션 일치 여부 메소드는 따로 분리한다.
	public boolean isOverlap(Position posA, Position posB) {
		if (posA.equals(posB))
			return true;
		return false;
	}

	// 테트리스 블럭을 전개하여 절대 좌표를 부여한다.
	public void unfold(TetrisBlock tetrisBlock)
			throws CloneNotSupportedException {
		// 테트리스 블럭의 블럭세트를 가져온다.

		HashSet<Block> blockSet = tetrisBlock.blockSet;
		// 테트리스 블럭의 절대 포지션을 가져온다.
		Position pos = tetrisBlock.pos;

		Iterator<Block> i = blockSet.iterator();
		// 테트리스 내부 블럭들 순회하며 set에 담기
		tempPos.clear();
		while (i.hasNext()) {
			Position p = (Position) i.next().pos.clone();
			p.calcPosX(pos.getPosX());
			p.calcPosY(pos.getPosY());
			tempPos.add(p);
		}
	}

	// 한줄이 모두 채워졌니?
	public int isLinefull(){
		int[] line = new int[20];
		for (int i = 0; i < line.length; i++) {
			line[i] = 0;
		}
		
		for (int j = 0; j < allBlock.size(); j++) {
			line[allBlock.get(j).pos.getPosY()]++;
		}
		
		for (int i = 0; i < line.length; i++) {
			if(line[i] == 10)
			{
				return i;
			}
		}
		return -1;
	}
}
