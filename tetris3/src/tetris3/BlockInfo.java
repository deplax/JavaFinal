package tetris3;

import java.util.HashMap;
import java.util.HashSet;

public class BlockInfo {
	// 블륵은 어떻게 생겼는지 알려주는 문서야.
	// 블럭의 각 정보를 저장하고 있는 데이터의 개념.
	public HashMap<Type, HashSet<Position>> shape = new HashMap<Type, HashSet<Position>>();

	public BlockInfo() {
		blockInitial();
	}

	private void blockInitial() {
		HashSet<Position> setSQURE = new HashSet<Position>();
		setSQURE.add(new Position(0, 0));
		setSQURE.add(new Position(0, 1));
		setSQURE.add(new Position(1, 0));
		setSQURE.add(new Position(1, 1));
		shape.put(Type.SQURE, setSQURE);
		// ▦▩
		// ▩▩

		HashSet<Position> setTBLOCK = new HashSet<Position>();
		setTBLOCK.add(new Position(0, 0));
		setTBLOCK.add(new Position(-1, 0));
		setTBLOCK.add(new Position(0, -1));
		setTBLOCK.add(new Position(0, 1));
		shape.put(Type.TBLOCK, setTBLOCK);
		// 　▩
		// ▩▦▩

		HashSet<Position> setSREVERSE = new HashSet<Position>();
		setSREVERSE.add(new Position(0, 0));
		setSREVERSE.add(new Position(1, 0));
		setSREVERSE.add(new Position(0, -1));
		setSREVERSE.add(new Position(1, 1));
		shape.put(Type.SREVERSE, setSREVERSE);
		// ▩▦
		// 　▩▩

		HashSet<Position> setSBLOCK = new HashSet<Position>();
		setSBLOCK.add(new Position(0, 0));
		setSBLOCK.add(new Position(1, 0));
		setSBLOCK.add(new Position(0, 1));
		setSBLOCK.add(new Position(1, -1));
		shape.put(Type.SBLOCK, setSBLOCK);
		// 　▦▩
		// ▩▩

		HashSet<Position> setLBLOCK = new HashSet<Position>();
		setLBLOCK.add(new Position(0, 0));
		setLBLOCK.add(new Position(-1, 0));
		setLBLOCK.add(new Position(1, 0));
		setLBLOCK.add(new Position(1, 1));
		shape.put(Type.LBLOCK, setLBLOCK);
		// ▩
		// ▦
		// ▩▩

		HashSet<Position> setLREVERSE = new HashSet<Position>();
		setLREVERSE.add(new Position(0, 0));
		setLREVERSE.add(new Position(-1, 0));
		setLREVERSE.add(new Position(1, 0));
		setLREVERSE.add(new Position(1, -1));
		shape.put(Type.LREVERSE, setLREVERSE);
		// 　▩
		// 　▦
		// ▩▩

		HashSet<Position> setSTICK = new HashSet<Position>();
		setSTICK.add(new Position(0, 0));
		setSTICK.add(new Position(-1, 0));
		setSTICK.add(new Position(1, 0));
		setSTICK.add(new Position(2, 0));
		shape.put(Type.STICK, setSTICK);
		// ▩
		// ▦　
		// ▩
		// ▩
	}

}

/*
 * public FrameNScore(Score score, int frameNum) { this.frameNum=frameNum;
 * this.score=score; }\
 */