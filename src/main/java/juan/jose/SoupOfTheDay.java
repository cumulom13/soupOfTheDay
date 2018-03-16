package juan.jose;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoupOfTheDay {

    public boolean canCreateTheString(String message, char[] letters) {
        //        Arrays.sort(letters); //O(n log(n))
        //
        //        In total the Big O of the function is O (n log(n))because smaller terms are ignored.
        String sortedMessage = Stream.of(message.toLowerCase().split("")) //O(1)
                .filter(c -> !c.equals(" ")) //O(n)
                .collect(Collectors.joining()); // O(n)

        return isMessagePossible(sortedMessage, letters);
    }

    private boolean isMessagePossible(String sortedMessage, char[] letters) {

        Map<Character, Integer> characterTimes = createCharacterMapTimes(letters);
        Map<Character, Integer> messageCharTimes = createCharacterMapTimes(sortedMessage.toCharArray());

        // Compare keysets

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

    private Map<Character, Integer> createCharacterMapTimes(char[] letters) {
        Map<Character, Integer> charTimes = new HashMap();
        for (char character : letters) { // O(n)
            int value = charTimes.getOrDefault(character, 0); //O(n)
            charTimes.put(character, value + 1);
        }
        return charTimes;
    }

}
