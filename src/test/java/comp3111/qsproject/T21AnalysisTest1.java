package comp3111.qsproject;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class T21AnalysisTest1 {

    @Test
    void sortUniversity() {
        List<String> years1 = List.of ("2020", "2018", "2019", "2015", "2014");
        List<String> sortedResult = T21Analysis.SortUniversity(years1);
        List <String> expectedSortedResult = List.of ("2014", "2015", "2018", "2019", "2020");
        assert sortedResult.equals(expectedSortedResult);
    }

    @Test
    void sortUniversity2() {
        List <String> years1 = List.of ("2000", "2005", "2010", "2015", "2020");
        List<String> sortedResult = T21Analysis.SortUniversity(years1);
        List <String> expectedSortedResult = List.of ("2000", "2005", "2010", "2015", "2020");
        assert sortedResult.equals(expectedSortedResult) : "Sorting universities failed";
    }

    @Test
    void sortUniversity3() {
        List <String> years1 = List.of ("");
        List<String> sortedResult = T21Analysis.SortUniversity(years1);
        List <String> expectedSortedResult = List.of ("");
        assert sortedResult.equals(expectedSortedResult) : "Sorting universities failed";
    }
}