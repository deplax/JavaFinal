package tetris3;

import java.util.LinkedList;

public class Mover {
	// 움직여야지 근데 그냥 움직이면 안되고 허락받고 움직여야 해
	// 난 움직여 주는게 아니라 RuleBook을 보고 허락만 해줄꺼야

	Rule rule;
	TetrisBlock tetrisBlock;

	public Mover() throws CloneNotSupportedException {
		tetrisBlock = Repository.tetrisBlock.peek();

		// 테트리스 블럭 하나에 대한 룰 적용이므로
		rule = new Rule(tetrisBlock);
	}

	// 움직일 수 있는지 룰북에 대해 확인한다.
	void moveLeft() throws CloneNotSupportedException {
		tetrisBlock.moveLeft();
		rule.unfold(tetrisBlock);
		if (!(rule.isCollision(tetrisBlock)) && !(rule.isLeftWall(tetrisBlock))) {
			return;
		}
		tetrisBlock.moveRight();
	}

	void moveRight() throws CloneNotSupportedException {
		tetrisBlock.moveRight();
		rule.unfold(tetrisBlock);
		if (!(rule.isCollision(tetrisBlock))
				&& !(rule.isRightWall(tetrisBlock))) {
			return;
		}
		tetrisBlock.moveLeft();
	}

	void moveDown() throws CloneNotSupportedException {
		tetrisBlock.moveDown();
		rule.unfold(tetrisBlock);
		if (!(rule.isCollision(tetrisBlock)) && !(rule.isBottom(tetrisBlock))) {
			return;
		}
		tetrisBlock.moveUp();
		rule.unfold(tetrisBlock);
		tetrisBlock.stack(rule.tempPos);

		//현재블럭 삭제
		Repository.tetrisBlock.remove(0);

		// 이거 메소드로 빼야되는데 시간없음 나중에
		while (rule.isLinefull() >= 0) {
			LinkedList<Block> allBlock = Repository.block;
			int line = rule.isLinefull();
			
			System.out.println("line : " + line);
			for (int j = 0; j < allBlock.size(); j++) {
				int y = allBlock.get(j).pos.getPosY();
				if (y == line) {
					allBlock.remove(j);
					j--;
				}
			}
			for (int i = 0; i < allBlock.size(); i++) {
				if(allBlock.get(i).pos.getPosY() < 20)
				allBlock.get(i).pos.moveDown();
			}
		}
	}

	void moveRotate() throws CloneNotSupportedException {
		tetrisBlock.moveRotate();
		rule.unfold(tetrisBlock);
		if (!(rule.isCollision(tetrisBlock)) && !(rule.isBottom(tetrisBlock))
				&& !(rule.isLeftWall(tetrisBlock))
				&& !(rule.isLeftWall(tetrisBlock))) {
			return;
		}
		tetrisBlock.moveRotateCW();
	}
}
