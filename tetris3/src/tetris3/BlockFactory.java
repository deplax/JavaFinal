package tetris3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class BlockFactory {
	// 여기는 테트리스 블럭을 찍어내는 공장이야
	// 블럭을 만들 수 있어야 겠지

	// 일단 주문이 들어와야돼
	// 그런데 테스트를 위해 주문은 가정하자

	// 일단 Info를 불러 오는거야
	// 블럭별로 따로 불러오려 했는데 그냥 한번에 불러오는게 성능상 이득일 것 같아

	//private LinkedList<HashSet<Block>> tetrisBlock = new LinkedList<HashSet<Block>>();
	
	
	// 블럭의 정보를 불러오자. 이건 한번이면 되.
	private BlockInfo blockInfo = new BlockInfo();
	
	//불러온 정보로 해당 블럭 위치세트를 제작
	public HashSet<Position> loadInfo(Type type) {
		HashSet<Position> block = new HashSet<Position>();
		block = blockInfo.shape.get(type);
		return block;
	}

	// position set을 가지고 block set으로 제작
	public HashSet<Block> makeBlock(HashSet<Position> block) {
		Iterator<Position> i = block.iterator();
		HashSet<Block> tetrisBlock = new HashSet<Block>();
		while (i.hasNext()) {
			//System.out.println(i);
			//System.out.println(i.next());
			tetrisBlock.add(new Block(i.next()));
		}
		return tetrisBlock;
	}
	
}

class Order {
	// 블럭을 공장이 그냥 찍어버리면 안돼.
	// 누군가 주문을 해서 수주받은 만큼만 발주해야지.
	
	public Order() {
		Repository.intToType.put(0, Type.SQURE);
		Repository.intToType.put(1, Type.STICK);
		Repository.intToType.put(2, Type.LBLOCK);
		Repository.intToType.put(3, Type.LREVERSE);
		Repository.intToType.put(4, Type.SBLOCK);
		Repository.intToType.put(5, Type.SREVERSE);
		Repository.intToType.put(6, Type.TBLOCK);
	}
	Random rand = new Random();
	public int randNum(){
		return rand.nextInt(6);
	}
	
	public Type randBlock(){
		Type type = Repository.intToType.get(randNum());		
		return type;
	}

}