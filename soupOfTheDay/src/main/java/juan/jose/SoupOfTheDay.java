package juan.jose;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoupOfTheDay {

    /**
     * Big O analysis of this function is:
     * To create the map of characters for the message the value is: O(m).
     * To create the map for the letters: O(n).
     * To compare the keySet the value is constant O(1) because there is 26 letters in the alphabet so
     * this operation is independent of the length of the message and letters in the bowl.
     * <p>
     * In total: O(n) + O(m) + O(1) = O(m+n)
     *
     * @param message message we want to write
     * @param letters letters in our soup of letters.
     *
     * @return true if possible to create the message, false otherwise.
     */
    public boolean canCreateTheString(String message, String letters) {
        Map<Character, Integer> characterTimes = createCharacterMapTimes(letters);
        Map<Character, Integer> messageCharTimes = createCharacterMapTimes(message.replace(" ", ""));

        if (messageCharTimes.keySet().size() > characterTimes.keySet().size()) {
            return false;
        }

        for (char character : messageCharTimes.keySet()) {
            //if character is not in the charaterTimes map or the number is greater than the one in that map, return false
            if (!characterTimes.containsKey(character)) {
                return false;
            } else if (characterTimes.get(character) < messageCharTimes.get(character)) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> createCharacterMapTimes(String letters) {
        Map<Character, Integer> charTimes = new HashMap();
        for (char character : letters.toLowerCase().toCharArray()) {
            int value = charTimes.getOrDefault(character, 0);
            charTimes.put(character, value + 1);
        }
        return charTimes;
    }
}