package comp3111.qsproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecommendItemTest {

    @Test
    void update() {

    }

    @Test
    void getRecentYear() {
        String[] input = new String[] {"MIT", "2021", "1", "100", "https://www.topuniversities.com/universities/massachusetts-institute-technology-mit",
        "USA", "Cambridge", "Massachusetts","https://www.topuniversities.com/sites/default/files/massachusetts-institute-of-technology-mit_410_small.jpg\n", "public", "100", "0.9", "79", "L", "96"};
        QSItem item = new QSItem(input);
        RecommendItem item1 = new RecommendItem(item);

        String[] input2 = new String[] {"MIT", "2022", "2", "100", "https://www.topuniversities.com/universities/massachusetts-institute-technology-mit",
                "USA", "Cambridge", "Massachusetts","https://www.topuniversities.com/sites/default/files/massachusetts-institute-of-technology-mit_410_small.jpg\n", "public", "100", "0.9", "79", "L", "96"};
        QSItem item_2 = new QSItem(input2);
        RecommendItem item2 = new RecommendItem(item_2);
        item1.update(item_2);
        String expected = "2022";
        String actual = item1.getRecentYear();
        assertEquals(expected, actual);
    }
}