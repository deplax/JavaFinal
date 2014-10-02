package tetris3;

import java.util.Scanner;

public class Tetris implements Runnable {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws CloneNotSupportedException {

		Tetris tetris = new Tetris();
		Timer timer = new Timer();
		Thread drawThread = new Thread(tetris);
		Thread timerThread = new Thread(timer);

		drawThread.start();
		timer.run();
	}

	public void start() throws CloneNotSupportedException {

		BlockFactory blockFactory = new BlockFactory();

		String msg;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("움직일 방향을 입력하세요(w a s d) : ");

		Draw draw = new Draw();
		Mover mover;
		while (true) {
			blockFactory.createBlock();
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
