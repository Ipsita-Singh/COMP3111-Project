package comp3111.qsproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.*;
import java.util.stream.Collectors;

public class T22Analysis {
    public ObservableList<QSItem> CountryRegion1List = FXCollections.observableArrayList();
    public ObservableList<QSItem> CountryRegion2List = FXCollections.observableArrayList();
    private String CountryRegion1Name;
    private String CountryRegion2Name;

    T22Analysis(String country_region_1, String country_region_2, List<String> years) {
        List<QSItem> country1 = QSList.list.stream()
                .filter(qsItem -> (qsItem.getCountry().equals(country_region_1) || qsItem.getRegion().equals(country_region_1)) && years.contains(qsItem.getYear()))
                .collect(Collectors.toList());
        List<QSItem> country2 = QSList.list.stream()
                .filter(qsItem -> (qsItem.getCountry().equals(country_region_2) || qsItem.getRegion().equals(country_region_2)) && years.contains(qsItem.getYear()))
                .collect(Collectors.toList());


        if (country_region_1.equals ("All")){
            country1 = QSList.list;
        }

        if (country_region_2.equals("All")){
            country2 = QSList.list;
        }

        country1.sort(Comparator.comparing (QSItem::getYear));
        country2.sort(Comparator.comparing (QSItem::getYear));

        CountryRegion1List = FXCollections.observableArrayList(country1);
        CountryRegion2List = FXCollections.observableArrayList(country2);
        CountryRegion1Name = country_region_1;
        CountryRegion2Name = country_region_2;


        /*
            Your Code Here.
            Collect the QSItem with corresponding years and country/region into two country/region lists.
            Sort country/region lists by the years.
            Hint: QSList.list is a static property.
         */
    }

    public double calculate (ObservableList<QSItem> CountryList , String searchName){
        double sum = 0.0;
        double length = 0.0;

        System.out.println(searchName);
        for (QSItem qsItem: CountryList) {
            String scoreString = "";
            if (searchName.equals("Score")) {
                scoreString = qsItem.getScore();
            }
            else if (searchName.equals("Rank")) {
                scoreString = qsItem.getRank();
            }
            else if (searchName.equals("International Students")){
                scoreString = qsItem.getInternationalStudents();
            }
            else if (searchName.equals("Student Faculty Ratio")){
                scoreString = qsItem.getStudentFacultyRatio();
            }
            else if (searchName.equals("Faculty Count")){
                scoreString = qsItem.getFacultyCount();
            }

            if (scoreString == null){
                continue;
            }
            scoreString = scoreString.replaceAll(",", "");
            scoreString = scoreString.replaceAll("\"", "");

            if (!searchName.equals("Score")){
                scoreString = scoreString.replaceAll("\\.", "");
            }

            double summation;
            try {
                summation = Double.parseDouble(scoreString);

            } catch (NumberFormatException e) {
                summation = 0.0;
            }

            sum += summation;

            length++;
        }
        if (length == 0.0){
            return sum;
        }

        return sum / length;
    }
    XYChart.Series<Double, String> getBarChartData(String searchName) {
        XYChart.Series<Double, String> barData= new XYChart.Series<>();
        System.out.println(searchName);
        double countryAverage1 = calculate (CountryRegion1List, searchName);
        double countryAverage2 = calculate (CountryRegion2List, searchName);


        barData.getData().add(new XYChart.Data<>(countryAverage1, CountryRegion1Name));
        barData.getData().add(new XYChart.Data<>(countryAverage2, CountryRegion2Name));
        /*
            Your Code Here.
            Return the Bar Chart Data.
            Bar Chart shows the Avg. of the selected property.
            For example, when the user chooses "score", which means the searchName will be "score"
            And Return an XYChart.Series with XYChart.Data
            [
              Average score of country/region2, "Country/Region 2"
              Average score of country/region1, "Country/Region 1"
            ]

            There are some "dirty data" in csv.
            For example, the string "3,143" or "3.143" can not transfer to Integer or Double directly.
            Careful process these data.
         */
        return barData;
    }

    List<XYChart.Series<String, Double>> getLineChartData(String searchName) {
        List<XYChart.Series<String, Double>> lineData = new ArrayList<>();
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        XYChart.Series<String, Double> series2 = new XYChart.Series<>();
        series1.setName(CountryRegion1Name);
        series2.setName(CountryRegion2Name);

        for (QSItem qsItem: CountryRegion1List) {
            String year = qsItem.getYear();
            String scoreString = qsItem.getScore();

            if (scoreString == null){
                continue;
            }

            scoreString = scoreString.replaceAll(",", "");
            scoreString = scoreString.replaceAll("\"", "");

            if (!searchName.equals("Score")){
                scoreString = scoreString.replaceAll("\\.", "");
            }


            double score;
            try {
                score = Double.parseDouble(scoreString);
            } catch (NumberFormatException e) {
                score = 0.0; // Default value for invalid scores
            }

            series1.getData().add(new XYChart.Data<>(year, score));
        }

        for (QSItem qsItem2: CountryRegion2List) {
            String year = qsItem2.getYear();
            String scoreString = qsItem2.getScore();

            if (scoreString == null){
                continue;
            }

            scoreString = scoreString.replaceAll(",", "");
            scoreString = scoreString.replaceAll("\"", "");

            if (!searchName.equals("Score")){
                scoreString = scoreString.replaceAll("\\.", "");
            }

            double score;
            try {
                score = Double.parseDouble(scoreString);
            } catch (NumberFormatException e) {
                score = 0.0; // Default value for invalid scores
            }

            series2.getData().add(new XYChart.Data<>(year, score));
        }

        lineData.add(series1);
        lineData.add(series2);

        return lineData;
        /*
            Your Code Here.
            Fill the lineData1 and lineData2.
            Line Chart shows two lines. Each line shows the number of searchName each year.
            In our cases, the searchName will be "score"
            And Return an XYChart.Series with XYChart.Data
            [
              Series[Data<year,score>],
            ]

            There are some "dirty data" in csv.
            For example, the string "3,143" or "3.143" can not transfer to Integer or Double directly.
            Careful process these data.
         */

    }
}
