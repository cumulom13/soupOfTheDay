package juan.jose;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoupOfTheDay2 {

    /**
     * Big O analysis of this function is:
     * Check the length of the strings: O(1).
     * To sort the message the value is: O(m log(m)).
     * To sort the letters: O(n log(n)).
     * To calculate if it is possible to create the message the value is o(m * n)
     *
     * In total: O(1) + O(n log(n)) + O(m log(m)) + O(m*n) = O(m*n)
     *
     *
     * @param message message we want to write
     * @param letters letters in our soup of letters.
     *
     * @return true if possible to create the message, false otherwise.
     */
    public boolean canCreateTheString(String message, String letters) {
        if (message.replace(" ", "").length() > letters.length()) {
            return false;
        }

        String sortedLetters = sortString(letters);
        String sortedMessage = sortString(message);

        for (int i = 0; i < sortedMessage.length(); i++) {
            do {
                if (sortedMessage.charAt(i) < sortedLetters.charAt(0)) {
                    return false;
                } else if (sortedMessage.charAt(i) == sortedLetters.charAt(0)) {
                    sortedLetters = sortedLetters.substring(1);
                    break;
                } else {
                    sortedLetters = sortedLetters.substring(1);
                }
            } while (sortedMessage.charAt(i) > sortedLetters.charAt(0));
        }
        return true;

    }

    private String sortString(String characters) {
        return Stream.of(characters.toLowerCase().split(""))
                .filter(c -> !c.equals(" "))
                .sorted(Collator.getInstance())
                .collect(Collectors.joining());
    }

}
