import java.util.ArrayList;
import java.util.List;

public class Survivor {

    private String name;
    private int wounds;
    private boolean isAlive;
    private ArrayList<String> items;
    private List<Equipment> inHandEquipment = new ArrayList<>();
    private List<Equipment> reservedEquipment = new ArrayList<>();


    public Survivor(String name) {
        this.name = name;
        this.isAlive = true;
        this.wounds = 0;
        this.items = new ArrayList<String>();
    }

    public boolean isAlive() {
        if (wounds >= 2) {
            isAlive = false;
        } else {
            isAlive = true;
        }
        return isAlive;
    }

    public String getName() {
        return name;
    }

    public int getWounds() {
        return 0;
    }

    public void addWound(int wound) {
        this.wounds += wound;
    }

    public int getActionsPerTurn() {
        return 3;
    }

    public void addEquipment(Equipment equipment) {
        if((inHandEquipment.size() + reservedEquipment.size()) < 5){
            if(inHandEquipment.size() < 2)
                inHandEquipment.add(equipment);
            else
                reservedEquipment.add(equipment);
        }
    }

    public List<Equipment> getEquipmentInHand() {
        return inHandEquipment;
    }

    public List<Equipment> getReservedEquipment() {
        return reservedEquipment;
    }
}
