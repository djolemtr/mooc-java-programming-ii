package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {

    private HashMap<String, String> dictionary;
    private String file;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.file = file;
    }

    public void add(String word, String translation) {
        this.dictionary.putIfAbsent(word, translation);
    }

    public String translate(String word) {

        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        }

        for (String key : this.dictionary.keySet()) {
            if (this.dictionary.get(key).contains(word))
                return key;
        }

        return null;

    }

    public void delete(String word) {

        this.dictionary.remove(word);

        this.dictionary.values().remove(word);

    }

    public boolean load() {

        try (Scanner fileReader = new Scanner(Paths.get(this.file))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");

                this.add(parts[0], parts[1]);

            }
            return true;
        } catch (Exception e) {

            return false;
        }

    }

    public boolean save() {
        try (PrintWriter writer = new PrintWriter(this.file)) {
            for (String key : this.dictionary.keySet()) {
                writer.append(key + ":" + this.dictionary.get(key) + "\n");
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
