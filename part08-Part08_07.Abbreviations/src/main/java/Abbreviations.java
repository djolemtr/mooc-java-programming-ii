import java.util.HashMap;

public class Abbreviations {
    private HashMap<String, String> abbreviations;

    public Abbreviations() {
        this.abbreviations = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        abbreviations.put(abbreviation, explanation);
    }

    public HashMap<String, String> getAbbreviations() {
        return abbreviations;
    }

    public boolean hasAbbreviation(String abbreviation) {
        String abbr = sanitizedString(abbreviation);

        if (this.abbreviations.containsKey(abbr)) {
            return true;
        }
        return false;

    }

    public String findExplanationFor(String abbreviation) {
        abbreviation = sanitizedString(abbreviation);

        return this.abbreviations.get(abbreviation);
    }

    public static String sanitizedString(String string) {
        if (string == null) {
            return " ";
        }

        string = string.toLowerCase();
        return string.trim();
    }

}
