package com.bowling.backend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bowling.backend.dto.Game;

@ExtendWith(MockitoExtension.class)
public class GameTest {
	
	    @Test
	    void return_10_when_user_have_two_rolls_of_7_and_3() {
	        Game Game = new Game();
	        Game.rollMulti(7,3);
	        assertThat(Game.getScore()).isEqualTo(10);
	    }

	    @Test
	    void return_12_for_a_spare_and_roll_of_1() {
	        Game Game = new Game();
	        Game.rollMulti(7,3,1);
	        assertThat(Game.getScore()).isEqualTo(12);
	    }

	    @Test
	    void return_20_for_a_spare_and_roll_of_5() {
	        Game Game = new Game();
	        Game.rollMulti(5, 5, 5);

	        assertThat(Game.getScore()).isEqualTo(20);
	    }

	    @Test
	    void return_16_for_a_strike_followed_by_1_and_2() {
	        Game Game = new Game();
	        Game.rollMulti(10,0,1,2);
	        assertThat(Game.getScore()).isEqualTo(16);
	    }


	    @Test
	    void return_53_for_double_strike_followed_by_5_and_4() {
	        Game Game = new Game();
	        Game.rollMulti(10,0, 10,0, 5, 4);
	        assertThat(Game.getScore()).isEqualTo(53);
	    }

	    @Test
	    void return__82_for_triple_strike_followed_by_5_and_4() {
	        Game Game = new Game();
	        Game.rollMulti(10,0, 10,0, 10,0, 5, 4);
	        assertThat(Game.getScore()).isEqualTo(83);
	    }

	    @Test
	    void return_42_for_a_strike_followed_by_1_and_2_and_a_spare_followed_by_1() {
	        Game Game = new Game();
	        Game.rollMulti(5, 1,
	                10, 0,
	                1, 2,
	                7, 1,
	                5, 5,
	                1, 0);

	        // 5+1{10+1+2+1+2}+7+1+( 5+5+1)+1
	        assertThat(Game.getScore()).isEqualTo(42);

	    }

	    @Test
	    void return_181_for_user() {
	        Game Game = new Game();
	        Game.rollMulti(
	                7, 3
	                , 10, 0
	                , 6, 2
	                , 10, 0
	                , 10, 0
	                , 9, 1
	                , 0, 10
	                , 10, 0
	                , 7, 2
	                , 10, 10, 8

	        );
	        // 5+1{10+1+2+1+2}+7+1+( 5+5+1)+1
	        assertThat(Game.getScore()).isEqualTo(181);

	    }

	
	
}
