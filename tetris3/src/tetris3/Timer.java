package tetris3;

public class Timer implements Runnable {

	@Override
	public void run() {
		Mover mover;
		Draw draw = new Draw();
		BlockFactory blockFactory = new BlockFactory();

		while (true)
			try {
				blockFactory.createBlock();
				Thread.sleep(Repository.SPEED);
				mover = new Mover();
				mover.moveDown();

				draw.boardClear();
				draw.analyzer();
				draw.drawing();

			} catch (CloneNotSupportedException | InterruptedException e) {
				e.printStackTrace();
			}
	}

}
