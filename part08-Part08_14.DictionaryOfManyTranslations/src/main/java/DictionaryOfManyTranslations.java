import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> dic;

    public DictionaryOfManyTranslations() {
        this.dic = new HashMap<>();
    }

    public void add(String word, String translation) {
        this.dic.putIfAbsent(word, new ArrayList<>());

        this.dic.get(word).add(translation);
    }

    public ArrayList<String> translate(String word) {

        if (dic.get(word) == null) {
            return new ArrayList<>();
        }

        return dic.get(word);

    }

    public void remove(String word) {
        dic.remove(word);
    }

}
