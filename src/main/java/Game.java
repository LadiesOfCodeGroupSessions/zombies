import java.util.HashSet;
import java.util.Set;

public class Game {
    private int numberOfSurvivors = 0;

    Set<String> survivors = new HashSet<>();

    public void addSurvivor(){
        numberOfSurvivors++;
    }

    public Set<String> getSurvivors() {
        return survivors;
    }

    public void setSurvivors(Set<String> survivors) {
        this.survivors = survivors;
    }

    public int getNumberOfSurvivors(){
        return numberOfSurvivors;
    }

    public void addSurvivorToSet(String name) {
        survivors.add(name);
    }
}
