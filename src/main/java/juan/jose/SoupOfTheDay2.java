package juan.jose;

import java.text.Collator;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoupOfTheDay2 {

    public boolean canCreateTheString(String message, String letters) {
        Arrays.sort(letters.toCharArray()); //O(n log(n))

        if (message.replace(" ", "").length() > letters.length()) {
            return false;
        }

        String sortedMessage = Stream.of(message.toLowerCase().split("")) //O(1)
                .filter(c -> !c.equals(" "))
                .sorted(Collator.getInstance())//O(n)
                .collect(Collectors.joining()); // O(n)

        for (char c : sortedMessage.toCharArray()) {

        }

        return true;

    }

}
