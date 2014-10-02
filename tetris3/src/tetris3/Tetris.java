package tetris3;

import java.util.HashSet;
import java.util.Scanner;

public class Tetris implements Runnable {
	public static void main(String[] args) throws CloneNotSupportedException {

		Tetris tetris = new Tetris();
		// Frame frame = new Frame();
		Thread drawThread = new Thread(tetris);
		// Thread keyThread = new Thread(frame);

		drawThread.start();
		// keyThread.start();
	}

	public void start() throws CloneNotSupportedException {
		BlockFactory blockFactory = new BlockFactory();
		Order order = new Order();

		String msg;
		Scanner scan = new Scanner(System.in);
		System.out.println("움직일 방향을 입력하세요(w a s d) : ");

		Draw draw = new Draw();
		Mover mover;
		while (true) {
		
		if (Repository.tetrisBlock.size() == 0) {
			HashSet<Position> posSet = blockFactory.loadInfo(order.randBlock());
			TetrisBlock tetrisBlock = new TetrisBlock(
					blockFactory.makeBlock(posSet));
			Repository.tetrisBlock.add(tetrisBlock);
			
		}
			mover = new Mover();
		
			draw.boardClear();
			draw.analyzer();
			draw.drawing();

			msg = scan.next();
			switch (msg) {
			case "w":
				mover.moveRotate();
				break;
			case "a":
				mover.moveLeft();
				break;
			case "s":
				mover.moveDown();
				break;
			case "d":
				mover.moveRight();
				break;
			default:
				System.exit(0);
				break;
			}

		}

	}

	@Override
	public void run() {
		try {
			start();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
