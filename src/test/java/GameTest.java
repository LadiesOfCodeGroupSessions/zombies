import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameTest {

    @Test
    public void checkName() {
        Survivor survivor = new Survivor("Anna");
        String name = survivor.getName();
        Assertions.assertEquals("Anna", name);
    }

    @Test
    public void checkWound() {
        Survivor survivor = new Survivor("Anna");
        int wounds = survivor.getWounds();
        Assertions.assertEquals(0, wounds);
    }

    @Test
    public void checkSurvivorIsAlive() {
        Survivor survivor = new Survivor("Colonel Sanders");
        survivor.addWound(2);
        assertFalse(survivor.isAlive());
    }

    @Test
    public void checkSurvivorIsAlive() {
        Survivor survivor = new Survivor("Colonel Sanders");
        survivor.addWound(2);
        assertFalse(survivor.isAlive());
    }


}
