package tetris3;

import junit.framework.TestCase;

public class BlockFactoryTest extends TestCase {
	public void testOrder() throws Exception {
		Order order = new Order();
		order.randBlock();
	}
}
