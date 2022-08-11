package com.bowling.backend.dto;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Game {
	private boolean perfect;
	private byte[] rolls = new byte[21];
	private int roll;

	public Game() {

	}

	public Game(byte[] rolls) {
		this.rolls = rolls;
	}

	public void rollMulti(int... pins) {
		int count = 0;
		for (int p : pins) {
			rolls[count++] = (byte) p;
		}
	}

	public byte[] getRolls() {
		return rolls;
	}

	public int getScore() {
		int score = 0;
		for (int rol = 0; rol < rolls.length - 1; rol = rol + 2) {

			int rolScore = rolls[rol];
			int secondRole = rol + 1;
			int nextFrame1stRol = rol + 2;
			int nextFrame2ndRol = rol + 3;
			int nextToNextFrame1stRoll = rol + 4;
			int frameScore = 0;

			if (secondRole < rolls.length) {
				frameScore = rolScore + rolls[secondRole];
			} else {
				frameScore += rolScore;
			}
			score += frameScore;

			if (rolScore == 10) {

				if (isNextFrameAvailable(nextFrame1stRol)) {
					int strikeBonus = 0;
					if (isNextFrameHasStrike(nextFrame1stRol)) {
						strikeBonus = rolls[nextFrame1stRol] + getNextToNextFrame1stRole(nextToNextFrame1stRoll);
					} else {
						strikeBonus = getRoll(nextFrame1stRol) + getRoll(nextFrame2ndRol);
					}
					score += strikeBonus;
				}
			} else if (frameScore == 10) {
				int spareBonus = rolls[nextFrame1stRol];
				score += spareBonus;
			}
		}

		return score;
	}

	public int getRoll(int nextFrame1stRol) {
		if (nextFrame1stRol >= rolls.length)
			return 0;
		else
			return rolls[nextFrame1stRol];
	}

	public int getNextToNextFrame1stRole(int nextToNextFrame1stRoll) {
		if (nextToNextFrame1stRoll >= rolls.length)
			return 0;
		return rolls[nextToNextFrame1stRoll];
	}

	public boolean isNextFrameAvailable(int roll) {

		return (roll < rolls.length);
	}

	public boolean isNextFrameHasStrike(int index) {
		return rolls[index] == 10;
	}

	public boolean isPerfect(int totalScore) {
		if (totalScore == 300) {
			return true;
		} else {
			return false;
		}
	}

}
