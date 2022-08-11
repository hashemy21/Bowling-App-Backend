package com.bowling.backend.api;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bowling.backend.dto.Bowling;
import com.bowling.backend.service.BowlingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/bowling")
public class BowlingController {

	@Autowired
	private final BowlingService bowlingService;

	@PostMapping(path = "/getTotalScores")
	public ArrayList<Bowling> getTotalScores(@RequestBody Map<String, byte[]> scores) throws Exception {
		return bowlingService.getTotalScores(scores);
	}

}
