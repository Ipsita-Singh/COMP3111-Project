package comp3111.qsproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecommendItemTest {

    @Test
    void getRecentYear() {
        String[] input = new String[] {"Stanford","2021", "3", "98", "USA", "Palo Alto", "California", "public", "100", "11.3", "8407", "L", "4786"};
        QSItem item = new QSItem(input);
        RecommendItem item1 = new RecommendItem(item);

        String[] input2 = new String[] {"MIT","2019", "1", "100", "USA", "Cambridge", "Massachusetts", "public", "100", "12.7", "9076", "L", "3985"};
        QSItem item_2 = new QSItem(input2);
        RecommendItem item2 = new RecommendItem(item_2);

        String expected = "2021";
        String actual = item1.getRecentYear();
        assertEquals(expected, actual);
        String expected2 = "2019";
        String actual2 = item2.getRecentYear();
        assertEquals(expected2, actual2);

    }

    @Test
    void getName() {
        String[] input = new String[] {"Stanford","2021", "3", "98", "USA", "Palo Alto", "California", "public", "100", "11.3", "8407", "L", "4786"};
        QSItem item = new QSItem(input);
        RecommendItem item1 = new RecommendItem(item);

        String[] input2 = new String[] {"MIT","2019", "1", "100", "USA", "Cambridge", "Massachusetts", "public", "100", "12.7", "9076", "L", "3985"};
        QSItem item_2 = new QSItem(input2);
        RecommendItem item2 = new RecommendItem(item_2);

        String expected = "Stanford";
        String actual = item1.getName();
        assertEquals(expected, actual);
        String expected2 = "MIT";
        String actual2 = item2.getName();
        assertEquals(expected2, actual2);
    }
}