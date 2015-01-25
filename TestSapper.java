import static org.junit.Assert.*;

import org.junit.Test;

public class TestSapper {
	Bomb bomb = new Bomb(1, 1);
	Point point = new Point(1, 1);
	PlayingField playingField = new PlayingField();

	@Test
	public void equalsTwoObject() {
		assertEquals(bomb.equals(point), false);

	}

	@Test
	public void SameTwoObject() {
		assertNotSame(point, bomb);

	}

	@Test
	public void chenMethodEqualsPointWithBomb() {
		assertTrue(playingField.equalsPointWithBomb(point, bomb));

	}

}
