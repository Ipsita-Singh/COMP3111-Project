package comp3111.qsproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecommendItemTest {

    @Test
    void getRecentYear() {
        String[] input = new String[] {"MIT","2021", "1", "100", "USA", "Cambridge", "Massachusetts", "public", "100", "0.9", "79", "L", "96"};
        QSItem item = new QSItem(input);
        RecommendItem item1 = new RecommendItem(item);

        String[] input2 = new String[] {"Harvard","2021", "2", "99", "USA", "Cambridge", "Massachusetts", "public", "100", "0.9", "79", "L", "96"};
        QSItem item_2 = new QSItem(input2);
        RecommendItem item2 = new RecommendItem(item_2);
        String expected = "2021";
        String actual = item1.getRecentYear();
        assertEquals(expected, actual);
        String expected2 = "2021";
        String actual2 = item2.getRecentYear();
        assertEquals(expected2, actual2);
    }

    @Test
    void getName() {
        String[] input = new String[] {"MIT","2021", "1", "100", "USA", "Cambridge", "Massachusetts", "public", "100", "0.9", "79", "L", "96"};
        QSItem item = new QSItem(input);
        RecommendItem item1 = new RecommendItem(item);

        String[] input2 = new String[] {"Harvard","2021", "2", "99", "USA", "Cambridge", "Massachusetts", "public", "100", "0.9", "79", "L", "96"};
        QSItem item_2 = new QSItem(input2);
        RecommendItem item2 = new RecommendItem(item_2);
        String expected = "MIT";
        String actual = item1.getName();
        assertEquals(expected, actual);
        String expected2 = "Harvard";
        String actual2 = item2.getName();
        assertEquals(expected2, actual2);
    }
}