package com.bowling.backend.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bowling.backend.dto.Bowling;
import com.bowling.backend.dto.Game;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BowlingService {
	

	public ArrayList<Bowling> getTotalScores(Map<String, byte[]> scores) throws Exception {
		ArrayList<Bowling> result = new ArrayList<Bowling>();
		for (Map.Entry<String, byte[]> entry : scores.entrySet()) {
			if(entry.getKey().isBlank()) {
				throw new Exception("player name cannot be blank");
			}else {
			Game g = new Game(entry.getValue());
			String name = entry.getKey();
			int totalscore = g.getScore();
			boolean isperfect = g.isPerfect(totalscore);
			result.add(new Bowling(name,totalscore,isperfect));
			}
		}
		Collections.sort(result);
		
		return result;
	}

}
