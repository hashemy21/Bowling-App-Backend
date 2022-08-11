package com.bowling.backend;


import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.bowling.backend.service.BowlingService;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

	
	@Autowired
	private BowlingService bowlingService;
	

	
	@Test
	public void integration() throws Exception {
		Map<String, byte[]> players = new HashMap<>();
		byte[] scores1 = {1, 2, 7, 2, 6, 3, 8, 1, 0, 4, 6, 2, 4, 4, 5, 3, 2, 1, 0, 4};
		byte[] scores2 = {1, 4, 3, 4, 5, 3, 7, 1, 0, 4, 1, 2, 3, 4, 5, 5, 2, 3, 3, 4};
		byte[] scores3 = {10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10,0};


		players.put("khaled", scores1);
		players.put("hashem", scores2);
		players.put("ahmed", scores3);
		
	
		try {
			System.out.println(bowlingService.getTotalScores(players));
		}catch(Exception err) {
			System.out.println(err.getMessage());
		}
	}
}
