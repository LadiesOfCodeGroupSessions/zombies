import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    public void checkName() {
        Survivor survivor = new Survivor("Anna");
        String name = survivor.getName();
        assertEquals("Anna", name);
    }

    @Test
    public void checkWound() {
        Survivor survivor = new Survivor("Anna");
        int wounds = survivor.getWounds();
        assertEquals(0, wounds);
    }

    @Test
    public void isAlive_2Wounds_dead() {
        Survivor survivor = new Survivor("Colonel Sanders");
        survivor.addWound(2);
        assertFalse(survivor.isAlive());
    }

    @Test
    public void isAlive_more2Wounds_dead() {
        Survivor survivor = new Survivor("Colonel Sanders");
        survivor.addWound(3);
        assertFalse(survivor.isAlive());
    }

    @Test
    public void isAlive_lessThan2Wounds_alive() {
        Survivor survivor = new Survivor("Colonel Sanders");
        assertTrue(survivor.isAlive());
    }

    @Test
    public void numberOfActions_Default_3ActionsPerTurn() {
        Survivor survivor = new Survivor("Colonel Sanders");
        assertEquals(3, survivor.getActionsPerTurn());
    }

    @Test
    public void numberOfItems_Default_NoItems() {
        Survivor survivor = new Survivor("Colonel Sanders");
        assertEquals(0, survivor.getItems());
    }

    @Test
    public void carryEquipment(){
        Survivor survivor = new Survivor("Andy");

        Equipment baseballBat = new Equipment("Baseball Bat");
        Equipment fryingPan = new Equipment("Frying pan");
        Equipment katana = new Equipment("Katana");
        Equipment pistol = new Equipment("Pistol");
        Equipment bottledWater = new Equipment("Bottled Water");

        survivor.addEquipment(baseballBat);
        survivor.addEquipment(fryingPan);
        survivor.addEquipment(katana);
        survivor.addEquipment(pistol);
        survivor.addEquipment(bottledWater);

        List<Equipment> inHandEquipment = survivor.getEquipmentInHand();
        List<Equipment> inReserveEquipment = survivor.getReservedEquipment();

        assertEquals(2, inHandEquipment.size());
        assertEquals(3, inReserveEquipment.size());

        assertEquals(1, inHandEquipment.stream().filter(x -> x.getName()=="Baseball Bat").size());
    }

}
