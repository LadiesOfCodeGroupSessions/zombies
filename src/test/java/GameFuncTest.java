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

}
