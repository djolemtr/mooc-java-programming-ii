import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> units;

    public StorageFacility() {
        this.units = new HashMap();
    }

    public void add(String unit, String item) {
        this.units.putIfAbsent(unit, new ArrayList<>());

        this.units.get(unit).add(item);

    }

    public ArrayList<String> contents(String storageUnit) {
        return units.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        if (!units.get(storageUnit).isEmpty()) {
            units.get(storageUnit).remove(item);
        }

        if (units.get(storageUnit).isEmpty()) {
            units.remove(storageUnit);
        }

    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> keys = new ArrayList<>();

        for (String key : units.keySet()) {
            if (!units.get(key).isEmpty()) {
                keys.add(key);
            }

        }

        return keys;

    }

}
