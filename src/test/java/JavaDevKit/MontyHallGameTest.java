package JavaDevKit;


import JavaDevKit.lesson_6.MontyHallGame;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static JavaDevKit.lesson_6.MontyHallGame.NUM_TESTS;

public class MontyHallGameTest {
    MontyHallGame game;
    Map<Integer, Boolean> results;

    @Before
    public void setUp() {
        this.game = new MontyHallGame();
        this.game.simulateGames();
        this.results = game.getResults();
    }

    @After
    public void tearDown() {
        this.game = null;
    }

    @Test
    public void testSimulateGames() {
        int wins = (int) results.values().stream().filter(Boolean::booleanValue).count();
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + (NUM_TESTS - wins));
    }
}

