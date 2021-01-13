import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameFuncTest {
    @Test
    public void initialNoOfSurvivors(){
        Game game = new Game();

        int numberOfSurvivors = game.getNumberOfSurvivors();

        assertEquals(0, numberOfSurvivors);
    }

    @Test
    public void addSurvivor() {
        Game game = new Game();
        Survivor survivor = new Survivor("Andy");

        game.addSurvivorToSet(survivor.getName());

        assertEquals(1, game.getSurvivors().size());
        assertTrue(game.getSurvivors().contains("Andy"));
    }

}
