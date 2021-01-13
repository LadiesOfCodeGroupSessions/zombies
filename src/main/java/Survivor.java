import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Survivor {

    private String name;
    private int wounds;
    private boolean isAlive;
    private ArrayList<String> items;
    private List<Equipment> inHandEquipment = new ArrayList<>();
    private List<Equipment> reservedEquipment = new ArrayList<>();
    private int sizeOfAllowedInHandEquipment = 2;
    private int sizeOfAllowedReservedEquipment = 3;


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

        if(wound> sizeOfAllowedInHandEquipment) {
        	  sizeOfAllowedInHandEquipment = 0;
        	  sizeOfAllowedReservedEquipment = (wound -2);
        }
        else 
        	sizeOfAllowedInHandEquipment -= wound;
        
        for (int i = 0; i<wound; i++) {

            if(inHandEquipment.size()>0)
            {
                inHandEquipment.remove(0);

            } else {
                if(reservedEquipment.size()>0) {
                    reservedEquipment.remove(0);
                }
            }
        }


    }

    public int getActionsPerTurn() {
        return 3;
    }

    public void addEquipment(Equipment equipment) {
        if((inHandEquipment.size() + reservedEquipment.size()) < 5){
            if(inHandEquipment.size() < sizeOfAllowedInHandEquipment)
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

    public void swapEquipment(Equipment oldEquipment, Equipment newEquipment) {
        List<Equipment> matchingHandList = inHandEquipment.stream()
                .filter(x -> x.getName() == oldEquipment.getName())
                .collect(Collectors.toList());

        List<Equipment> matchingReserveList = reservedEquipment.stream()
                .filter(x -> x.getName() == oldEquipment.getName())
                .collect(Collectors.toList());

        if(matchingHandList.size() > 0) {
            inHandEquipment.remove(matchingHandList.get(0));
            inHandEquipment.add(newEquipment);
        } else if (matchingReserveList.size() > 0){
            reservedEquipment.remove(matchingReserveList.get(0));
            reservedEquipment.add(newEquipment);
        }

    }
}
