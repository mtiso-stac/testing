package edu.stac;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BowlingGameTest {

	BowlingGame g = new BowlingGame();

	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}

	private void rollStrike() {
		g.roll(10);
	}

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++) {
			g.roll(pins);
		}
	}

	@Test
	void gutterGame() throws Exception {
		rollMany(20, 0);
		assertEquals(0, g.score());
	}

	@Test
	void scoreOfOnePinGame() {
		rollMany(1, 1);
		assertEquals(1, g.score());
	}

	@Test
	void oneSpare() throws Exception {
		rollSpare();
		g.roll(3);
		g.roll(4);
		rollMany(16, 0);
		assertEquals(20, g.score());

	}

	@Test
	void oneStrike() throws Exception {
		rollStrike();
		g.roll(3);
		g.roll(4);
		rollMany(18, 0);
		assertEquals(24, g.score());
	}

	@Test
	void perfectGame() throws Exception {
		rollMany(12, 10);
		assertEquals(300, g.score());
	}

}
