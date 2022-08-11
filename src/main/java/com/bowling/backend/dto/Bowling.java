package com.bowling.backend.dto;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Bowling implements Comparable<Bowling> {

	private String playerName;
	private int totalScore;
	private boolean perfect;

	public Bowling() {
	}

	public Bowling(String playerName, int totalScore, boolean perfect) {
		this.playerName = playerName;
		this.totalScore = totalScore;
		this.perfect = perfect;
	}

	@Override
	public int compareTo(Bowling b) {
		int compareScores = ((Bowling) b).getTotalScore();
		return compareScores - this.totalScore;
	}

}
