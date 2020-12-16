public class Survivor {

    private String name;
    private int wounds;
    private boolean isAlive;

    public Survivor(String name) {
        this.name = name;
        this.isAlive = true;
        this.wounds = 0;
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
}
