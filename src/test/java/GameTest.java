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
        assertEquals(0, survivor.getEquipmentInHand().size());
        assertEquals(0, survivor.getReservedEquipment().size());
    }

    @Test
    public void carryEquipment() {
        Survivor survivor = new Survivor("Andy");

        Equipment baseballBat = new Equipment("Baseball Bat");
        Equipment fryingPan = new Equipment("Frying Pan");
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

        assertEquals(1, inHandEquipment.stream().filter(x -> x.getName() == "Baseball Bat").count());
        assertEquals(1, inHandEquipment.stream().filter(x -> x.getName() == "Frying Pan").count());
        assertEquals(1, inReserveEquipment.stream().filter(x -> x.getName() == "Katana").count());
        assertEquals(1, inReserveEquipment.stream().filter(x -> x.getName() == "Pistol").count());
        assertEquals(1, inReserveEquipment.stream().filter(x -> x.getName() == "Bottled Water").count());
    }

    @Test
    public void doNotGoOverMaxEquipmentOf5() {
        Survivor survivor = new Survivor("Andy");

        Equipment baseballBat = new Equipment("Baseball Bat");
        Equipment fryingPan = new Equipment("Frying Pan");
        Equipment katana = new Equipment("Katana");
        Equipment pistol = new Equipment("Pistol");
        Equipment bottledWater = new Equipment("Bottled Water");
        Equipment molotov = new Equipment("Molotov");

        survivor.addEquipment(baseballBat);
        survivor.addEquipment(fryingPan);
        survivor.addEquipment(katana);
        survivor.addEquipment(pistol);
        survivor.addEquipment(bottledWater);
        survivor.addEquipment(molotov);

        List<Equipment> inHandEquipment = survivor.getEquipmentInHand();
        List<Equipment> inReserveEquipment = survivor.getReservedEquipment();

        assertEquals(2, inHandEquipment.size());
        assertEquals(3, inReserveEquipment.size());
    }

    @Test
    public void woundReducesEquipmentSize(){
        Survivor survivor = new Survivor("Sally");
        Equipment baseballBat = new Equipment("Baseball Bat");
        Equipment fryingPan = new Equipment("Frying Pan");
        survivor.addEquipment(baseballBat);
        survivor.addEquipment(fryingPan);

        survivor.addWound(1);

        List<Equipment> inHandEquipment = survivor.getEquipmentInHand();

        assertEquals(1, inHandEquipment.size());
    }

    @Test
    public void woundReducesEquipmentBy3(){
        Survivor survivor = new Survivor("Sally");
        Equipment baseballBat = new Equipment("Baseball Bat");
        Equipment fryingPan = new Equipment("Frying Pan");
        Equipment katana = new Equipment("Katana");
        Equipment pistol = new Equipment("Pistol");
        survivor.addEquipment(baseballBat);
        survivor.addEquipment(fryingPan);
        survivor.addEquipment(katana);
        survivor.addEquipment(pistol);

        survivor.addWound(3);
        
        List<Equipment> inHandEquipment = survivor.getEquipmentInHand();
        assertEquals(0, inHandEquipment.size());
        
        List<Equipment> reservedEquipment =      survivor.getReservedEquipment();
        assertEquals(1, reservedEquipment.size());
    }


}
