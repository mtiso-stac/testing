package edu.stac;

public class BowlingGame {

	public static int maxFrames = 10;
	private int rolls[] = new int[21];
	private int currentRoll = 0;
	private int score = 0;

	public void roll(int numberOfPins) {
		rolls[currentRoll++] = numberOfPins;
	}

	public int score() {
		int score = 0;
		int firstInFrame = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(firstInFrame)) 
			{ 
				score += 10 + rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
				firstInFrame++;
			} 
			else if (isSpare(firstInFrame)) 
			{
				score += 10 + rolls[firstInFrame + 2];
				firstInFrame += 2;
			} 
			else 
			{
				score += rolls[firstInFrame] + rolls[firstInFrame + 1];
				firstInFrame += 2;
			}
		}
		return score;
	}

	private boolean isStrike(int firstInFrame) {
		return rolls[firstInFrame] == 10;
	}

	private boolean isSpare(int firstBallInFrame) {
		return rolls[firstBallInFrame] + rolls[firstBallInFrame + 1] == 10;
	}

}
