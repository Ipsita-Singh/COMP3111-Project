package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class T22AnalysisTest {

    @Test
    void calculateRegular() {
        QSList.initialize();
        List<String> years = new ArrayList<>();
        years.add("2017");
        years.add("2018");
        years.add("2019");
        String country = "Estonia";
        List<QSItem> country1 = QSList.list.stream()
                .filter(qsItem -> (qsItem.getCountry().equals(country) || qsItem.getRegion().equals(country)) && years.contains(qsItem.getYear()))
                .collect(Collectors.toList());

        ObservableList<QSItem> CountryRegion1List = FXCollections.observableArrayList(country1);
        T22Analysis t22Analysis = new T22Analysis("Estonia", "Estonia", years);
        double expectedScore = (336.0 + 363.0 + 328.0) / 3.0;
        double actualScore = t22Analysis.calculate(CountryRegion1List, "score");
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void calculateInvalidSearch() {
        QSList.initialize();
        List<String> years = new ArrayList<>();
        years.add("2017");
        years.add("2018");
        years.add("2019");
        String country = "Japan";
        List<QSItem> country1 = QSList.list.stream()
                .filter(qsItem -> (qsItem.getCountry().equals(country) || qsItem.getRegion().equals(country)) && years.contains(qsItem.getYear()))
                .collect(Collectors.toList());
        ObservableList<QSItem> CountryRegion1List = FXCollections.observableArrayList(country1);
        T22Analysis t22Analysis = new T22Analysis("Japan", "Estonia", years);
        double actual = t22Analysis.calculate(CountryRegion1List, "random");
        double expected = 0.0;
        assertEquals(actual, expected);
    }

    @Test
    void calculateInvalidList() {
        QSList.initialize();
        List<String> years = new ArrayList<>();
        years.add("2023");
        String country = "Japan";
        List<QSItem> country1 = QSList.list.stream()
                .filter(qsItem -> (qsItem.getCountry().equals(country) || qsItem.getRegion().equals(country)) && years.contains(qsItem.getYear()))
                .collect(Collectors.toList());
        ObservableList<QSItem> CountryRegion1List = FXCollections.observableArrayList(country1);
        T22Analysis t22Analysis = new T22Analysis("Japan", "Estonia", years);
        double actual = t22Analysis.calculate(CountryRegion1List, "random");
        double expected = 0.0;
        assertEquals(actual, expected);
    }


    @Test
    void getBarInvalidCountry() {
        List<String> years = new ArrayList<>();
        years.add("2017");

        String searchName = "score";

        T22Analysis t22Analysis = new T22Analysis("c1", "c2", years);
        XYChart.Series<Double, String> barchart = t22Analysis.getBarChartData(searchName);
        XYChart.Series<Double, String> expected = new XYChart.Series<>();

        expected.getData().add(new XYChart.Data<>(0.0, "c1"));
        expected.getData().add(new XYChart.Data<>(0.0, "c2"));

        assertEquals(expected.getData().size(), barchart.getData().size());
        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = barchart.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue());
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }

    }

    @Test
    void getBarInvalidYear() {
        List<String> years = new ArrayList<>();
        years.add("2025");
        years.add("2023");
        years.add("2024");

        String searchName = "score";

        T22Analysis t22Analysis = new T22Analysis("North America", "Europe", years);
        XYChart.Series<Double, String> barchart = t22Analysis.getBarChartData(searchName);
        XYChart.Series<Double, String> expected = new XYChart.Series<>();

        expected.getData().add(new XYChart.Data<>(0.0, "North America"));
        expected.getData().add(new XYChart.Data<>(0.0, "Europe"));

        assertEquals(expected.getData().size(), barchart.getData().size());
        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = barchart.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue());
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }

    @Test
    void getBarInvalidSearchName() {
        List<String> years = new ArrayList<>();
        years.add("2017");

        String searchName = "wrongSearchName";

        T22Analysis t22Analysis = new T22Analysis("Estonia", "India", years);
        XYChart.Series<Double, String> barchart = t22Analysis.getBarChartData(searchName);
        XYChart.Series<Double, String> expected = new XYChart.Series<>();

        expected.getData().add(new XYChart.Data<>(0.0, "Estonia"));
        expected.getData().add(new XYChart.Data<>(0.0, "India"));

        assertEquals(expected.getData().size(), barchart.getData().size());
        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = barchart.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue());
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }

    @Test
    void getBarChart() {
        double calculatedExcelAll = 6368256.0 / 2393.0;
        double IndiaData = 29460.0 / 41.0;

        List<String> years = new ArrayList<>();
        years.add("2017");
        years.add("2018");
        years.add("2019");
        years.add("2020");
        years.add("2021");
        years.add("2022");

        String searchName = "facultyCount";
        T22Analysis t22Analysis = new T22Analysis("All", "India", years);
        XYChart.Series<Double, String> barchart = t22Analysis.getBarChartData(searchName);
        XYChart.Series<Double, String> expected = new XYChart.Series<>();

        expected.getData().add(new XYChart.Data<>(calculatedExcelAll, "All"));
        expected.getData().add(new XYChart.Data<>(IndiaData, "India"));

        assertEquals(expected.getData().size(), barchart.getData().size());
        for (int i = 0; i < expected.getData().size(); i++) {
            XYChart.Data<Double, String> expectedData = expected.getData().get(i);
            XYChart.Data<Double, String> actualData = barchart.getData().get(i);
            assertEquals(expectedData.getXValue(), actualData.getXValue());
            assertEquals(expectedData.getYValue(), actualData.getYValue());
        }
    }

    @Test
    void getLineChartData() {
        List<String> years = new ArrayList<>();
        years.add("2017");
        years.add("2018");

        double SouthKorea2017 = (821.0 + 779.0 + 67.0 + 628.0 + 615.0 + 605.0 + 506.0 + 392.0 + 345.0 + 343.0 + 309.0) / 11.0;
        double SouthKorea2018 = (815.0 + 804.0 + 694.0 + 655.0 + 623.0 + 615.0 + 532.0 + 406.0 + 377.0 + 347.0 + 306.0) / 11.0;

        double Austria2017 = (533.0 + 488.0 + 369.0) / 3.0;
        double Austria2018 = (533.0 + 495.0 + 385.0) / 3.0;

        String searchName = "score";
        T22Analysis t22Analysis = new T22Analysis("South Korea", "Austria", years);
        List<XYChart.Series<String, Double>> linechart = t22Analysis.getLineChartData(searchName);
        List<XYChart.Series<String, Double>> expectedData = new ArrayList<>();
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        XYChart.Series<String, Double> series2 = new XYChart.Series<>();

        series1.getData().add(new XYChart.Data<>("2017", SouthKorea2017));
        series1.getData().add(new XYChart.Data<>("2018", SouthKorea2018));
        series2.getData().add(new XYChart.Data<>("2017", Austria2017));
        series2.getData().add(new XYChart.Data<>("2018", Austria2018));

        expectedData.add(series1);
        expectedData.add(series2);

        assertEquals(linechart.size(), expectedData.size());

        for (int i = 0; i < linechart.size(); i++) {
            XYChart.Series<String, Double> actualSeries = linechart.get(i);
            XYChart.Series<String, Double> expectedSeries = expectedData.get(i);

            assertEquals(actualSeries.getData().size(), expectedSeries.getData().size());

            for (int j = 0; j < actualSeries.getData().size(); j++) {
                XYChart.Data<String, Double> actualData = actualSeries.getData().get(j);
                XYChart.Data<String, Double> expectedDataPoint = expectedSeries.getData().get(j);

                assertEquals(expectedDataPoint.getXValue(), actualData.getXValue());
                assertEquals(expectedDataPoint.getYValue(), actualData.getYValue());
            }
        }
    }

    @Test
    void getLineInvalidYear1() {
        List<String> years = new ArrayList<>();
        years.add("2023");
        years.add("2024");
        years.add("2025");

        String searchName = "score";
        T22Analysis t22Analysis = new T22Analysis("South Korea", "Austria", years);
        List<XYChart.Series<String, Double>> linechart = t22Analysis.getLineChartData(searchName);
        List<XYChart.Series<String, Double>> expectedData = new ArrayList<>();
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        XYChart.Series<String, Double> series2 = new XYChart.Series<>();

        expectedData.add(series1);
        expectedData.add(series2);

        assertEquals(linechart.size(), expectedData.size());

        for (int i = 0; i < linechart.size(); i++) {
            XYChart.Series<String, Double> actualSeries = linechart.get(i);
            XYChart.Series<String, Double> expectedSeries = expectedData.get(i);

            assertEquals(actualSeries.getData().size(), expectedSeries.getData().size());

            for (int j = 0; j < actualSeries.getData().size(); j++) {
                XYChart.Data<String, Double> actualData = actualSeries.getData().get(j);
                XYChart.Data<String, Double> expectedDataPoint = expectedSeries.getData().get(j);

                assertEquals(expectedDataPoint.getXValue(), actualData.getXValue());
                assertEquals(expectedDataPoint.getYValue(), actualData.getYValue());
            }
        }
    }

    @Test
    void getLineInvalidYear2() {
        List<String> years = new ArrayList<>();
        years.add("2017");
        years.add("2018");
        years.add("2023"); //Added Invalid Year

        double SouthKorea2017 = (821.0 + 779.0 + 67.0 + 628.0 + 615.0 + 605.0 + 506.0 + 392.0 + 345.0 + 343.0 + 309.0) / 11.0;
        double SouthKorea2018 = (815.0 + 804.0 + 694.0 + 655.0 + 623.0 + 615.0 + 532.0 + 406.0 + 377.0 + 347.0 + 306.0) / 11.0;

        double Austria2017 = (533.0 + 488.0 + 369.0) / 3.0;
        double Austria2018 = (533.0 + 495.0 + 385.0) / 3.0;

        String searchName = "score";
        T22Analysis t22Analysis = new T22Analysis("South Korea", "Austria", years);
        List<XYChart.Series<String, Double>> linechart = t22Analysis.getLineChartData(searchName);
        List<XYChart.Series<String, Double>> expectedData = new ArrayList<>();
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        XYChart.Series<String, Double> series2 = new XYChart.Series<>();

        series1.getData().add(new XYChart.Data<>("2017", SouthKorea2017));
        series1.getData().add(new XYChart.Data<>("2018", SouthKorea2018));
        series2.getData().add(new XYChart.Data<>("2017", Austria2017));
        series2.getData().add(new XYChart.Data<>("2018", Austria2018));

        expectedData.add(series1);
        expectedData.add(series2);

        assertEquals(linechart.size(), expectedData.size());

        for (int i = 0; i < linechart.size(); i++) {
            XYChart.Series<String, Double> actualSeries = linechart.get(i);
            XYChart.Series<String, Double> expectedSeries = expectedData.get(i);

            assertEquals(actualSeries.getData().size(), expectedSeries.getData().size());

            for (int j = 0; j < actualSeries.getData().size(); j++) {
                XYChart.Data<String, Double> actualData = actualSeries.getData().get(j);
                XYChart.Data<String, Double> expectedDataPoint = expectedSeries.getData().get(j);

                assertEquals(expectedDataPoint.getXValue(), actualData.getXValue());
                assertEquals(expectedDataPoint.getYValue(), actualData.getYValue());
            }
        }
    }

    @Test
    void getLineInvalidSearchName() {
        List<String> years = new ArrayList<>();
        years.add("2017");
        years.add("2018");
        years.add("2020");


        String searchName = "IncorrectScore";
        T22Analysis t22Analysis = new T22Analysis("India", "All", years);
        List<XYChart.Series<String, Double>> linechart = t22Analysis.getLineChartData(searchName);
        List<XYChart.Series<String, Double>> expectedData = new ArrayList<>();
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        XYChart.Series<String, Double> series2 = new XYChart.Series<>();

        series1.getData().add(new XYChart.Data<>("2017", 0.0));
        series1.getData().add(new XYChart.Data<>("2018", 0.0));
        series1.getData().add(new XYChart.Data<>("2020", 0.0));

        series2.getData().add(new XYChart.Data<>("2017", 0.0));
        series2.getData().add(new XYChart.Data<>("2018", 0.0));
        series2.getData().add(new XYChart.Data<>("2020", 0.0));


        expectedData.add(series1);
        expectedData.add(series2);

        assertEquals(linechart.size(), expectedData.size());

        for (int i = 0; i < linechart.size(); i++) {
            XYChart.Series<String, Double> actualSeries = linechart.get(i);
            XYChart.Series<String, Double> expectedSeries = expectedData.get(i);

            assertEquals(actualSeries.getData().size(), expectedSeries.getData().size());

            for (int j = 0; j < actualSeries.getData().size(); j++) {
                XYChart.Data<String, Double> actualData = actualSeries.getData().get(j);
                XYChart.Data<String, Double> expectedDataPoint = expectedSeries.getData().get(j);

                assertEquals(expectedDataPoint.getXValue(), actualData.getXValue());
                assertEquals(expectedDataPoint.getYValue(), actualData.getYValue());
            }
        }
    }

    @Test
    void getLineInvalidCountries() {
        List<String> years = new ArrayList<>();
        years.add("2017");
        years.add("2018");
        years.add("2020");


        String searchName = "score";
        T22Analysis t22Analysis = new T22Analysis("IncorrectCountry2", "IncorrectCountry1", years);
        List<XYChart.Series<String, Double>> linechart = t22Analysis.getLineChartData(searchName);
        List<XYChart.Series<String, Double>> expectedData = new ArrayList<>();
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        XYChart.Series<String, Double> series2 = new XYChart.Series<>();

        expectedData.add(series1);
        expectedData.add(series2);

        assertEquals(linechart.size(), expectedData.size());

        for (int i = 0; i < linechart.size(); i++) {
            XYChart.Series<String, Double> actualSeries = linechart.get(i);
            XYChart.Series<String, Double> expectedSeries = expectedData.get(i);

            assertEquals(actualSeries.getData().size(), expectedSeries.getData().size());

            for (int j = 0; j < actualSeries.getData().size(); j++) {
                XYChart.Data<String, Double> actualData = actualSeries.getData().get(j);
                XYChart.Data<String, Double> expectedDataPoint = expectedSeries.getData().get(j);

                assertEquals(expectedDataPoint.getXValue(), actualData.getXValue());
                assertEquals(expectedDataPoint.getYValue(), actualData.getYValue());
            }
        }
    }

}


