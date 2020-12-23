import java.util.ArrayList;

public class Survivor {

    private String name;
    private int wounds;
    private boolean isAlive;
    private ArrayList<String> items;

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

    public int getItems(){
        return this.items.size();
    }

    public void addEquipment(Equipment baseballBat) {
    }

    public List<Equipment> getEquipmentInHand() {
    }

    public List<Equipment> getReservedEquipment() {
    }
}
