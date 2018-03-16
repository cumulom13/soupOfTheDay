package juan.jose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SoupOfTheDayTest {

    @Test
    public void shouldReturnTrue() {
        // Given
        SoupOfTheDay2 soup = new SoupOfTheDay2();
        String message = "Hello yo";
        String letterss = "zdahlcooelxzdahxy";
        char[] letters = { 'z', 'd', 'a', 'h', 'l', 'c', 'o', 'o', 'e', 'l', 'x', 'z', 'd', 'a', 'h', 'x', 'y' };

        // When
        boolean canCreateMessage = soup.canCreateTheString(message, letterss);

        // Then
        assertThat(canCreateMessage, is(true));
    }

//    @Test
//    public void shouldReturnTrueno() {
//        // Given
//        SoupOfTheDay2 soup = new SoupOfTheDay2();
//        String message = "Hello yo";
//        char[] letters = { 'z', 'd', 'a', 'h', 'l', 'c', 'o', 'o', 'e', 'l', 'x', 'z', 'd', 'a', 'h', 'x', 'y' };
//
//        // When
//        boolean canCreateMessage = soup.canCreateTheString(message, letters);
//
//        // Then
//        assertThat(canCreateMessage, is(true));
//    }

}