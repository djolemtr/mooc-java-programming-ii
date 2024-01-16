import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;

    public VehicleRegistry() {
        this.registry = new HashMap<>();

    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (!registry.containsKey(licensePlate)) {
            registry.put(licensePlate, owner);
            return true;
        }
        return false;
    }

    public String get(LicensePlate licensePlate) {
        if (registry.containsKey(licensePlate)) {
            return registry.get(licensePlate);
        }
        return null;
    }

    public boolean remove(LicensePlate licensePlate) {
        if (registry.containsKey(licensePlate)) {
            registry.remove(licensePlate);
            return true;
        }

        return false;
    }

    public void printLicensePlates() {
        for (LicensePlate keys : registry.keySet()) {
            System.out.println(keys);
        }
    }

    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();

        for (LicensePlate keys : registry.keySet()) {
            String o = (registry.get(keys));

            if (!owners.contains(o)) {
                owners.add(o);
            }
        }
        for (String owner : owners) {
            System.out.println(owner);
        }
    }
}
